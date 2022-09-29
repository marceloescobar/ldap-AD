package com.pms.ldap;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

@Component
public class ActiveDirectoryGrantedAuthoritiesMapper implements GrantedAuthoritiesMapper {

	@Override
	public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Set<RCIAuthority> roles = EnumSet.noneOf(RCIAuthority.class);
		
		for (GrantedAuthority authority : authorities) {

			if (RCIAuthority.ROLE_SUPORTE.getAuthority().equals(authority.getAuthority())) {
				roles.add(RCIAuthority.ROLE_SUPORTE);

			} else if (RCIAuthority.ROLE_SEGURANCA.getAuthority().equals(authority.getAuthority())) {
				roles.add(RCIAuthority.ROLE_SEGURANCA);

			} else if (RCIAuthority.ROLE_INFRA.getAuthority().equals(authority.getAuthority())) {
				roles.add(RCIAuthority.ROLE_INFRA);
			}

		}
		
	return roles;	
	}

}
