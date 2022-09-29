package com.pms.ldap;

import org.springframework.security.core.GrantedAuthority;

public enum RCIAuthority implements GrantedAuthority {
	
	ROLE_SUPORTE("Suporte"), ROLE_SEGURANCA("Seguranca"), ROLE_INFRA("G Infra");
	
	private RCIAuthority(String label) {
		this.label = label;
	}

	private String label;
	
	
	@Override
	public String getAuthority() {
		return label;
	}

}
