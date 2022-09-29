package com.pms.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
public class LDAPSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${ldap.urls}")
    private String ldapUrls;

    @Value("${ldap.base.dn}")
    private String ldapBaseDn;

    @Value("${ldap.username}")
    private String ldapSecurityPrincipal;

    @Value("${ldap.password}")
    private String ldapPrincipalPassword;

    @Value("${ldap.user.dn.pattern}")
    private String ldapUserDnPattern;
    
    @Autowired
    private ActiveDirectoryGrantedAuthoritiesMapper authoritiesMapper;
    
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
    	//String customSearchFilter = "(&(objectClass=organizationalPerson)(sAMAccountName={0}))";
    	String customSearchFilter ="userPrincipalName={0}";
    	
      ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider = 
        new ActiveDirectoryLdapAuthenticationProvider( "prefeitura.local", ldapUrls);
      
      // to parse AD failed credentails error message due to account - expiry,lock, credentialis - expiry,lock
      activeDirectoryLdapAuthenticationProvider.setConvertSubErrorCodesToExceptions(true); 
      activeDirectoryLdapAuthenticationProvider.setUseAuthenticationRequestCredentials(true);
      
      activeDirectoryLdapAuthenticationProvider.setSearchFilter(customSearchFilter);
      
      activeDirectoryLdapAuthenticationProvider.setAuthoritiesMapper(authoritiesMapper);
      
      return activeDirectoryLdapAuthenticationProvider;
     }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//
    	auth
    	.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
    	
    	 auth
         .ldapAuthentication()
         .contextSource()
         .url(ldapUrls)
         .managerDn(ldapSecurityPrincipal)
         .managerPassword(ldapPrincipalPassword)
         .and()
         .userDnPatterns(ldapUserDnPattern);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        .antMatchers("/login**").anonymous()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/assets/**").permitAll()
        .antMatchers("/").authenticated()
        .antMatchers("/home").authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .csrf()
        .disable();
    }
}
