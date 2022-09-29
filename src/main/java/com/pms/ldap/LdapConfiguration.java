package com.pms.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {

	@Value("${ldap.urls}")
    private String ldapUrls;

    @Value("${ldap.base.dn}")
    private String ldapBaseDn;

    @Value("${ldap.username}")
    private String ldapSecurityPrincipal;

    @Value("${ldap.password}")
    private String ldapPrincipalPassword;
    
 
    
	  @Bean
	    public LdapContextSource contextSource() {
	        LdapContextSource contextSource = new LdapContextSource();
	        contextSource.setUrl(ldapUrls);
	        contextSource.setBase(ldapBaseDn);
	        contextSource.setUserDn(ldapSecurityPrincipal);
	        contextSource.setPassword(ldapPrincipalPassword);
	        contextSource.setReferral("follow");
	        
	        return contextSource;
	    }
	  
	  @Bean
	    public LdapTemplate ldapTemplate() {
	        return new LdapTemplate(contextSource());
	    }

}
