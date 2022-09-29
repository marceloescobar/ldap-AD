package com.pms.ldap.repository;

import java.util.ArrayList;

import javax.naming.Name;

import org.springframework.data.annotation.Transient;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

//@Entry(objectClasses = { "person", "inetOrgPerson", "top" })
//@Entry(objectClasses = { "inetOrgPerson", "organizationalPerson", "person" })
//@Entry(objectClasses = {"inetOrgPerson", "organizationalPerson", "person", "top"})
//@Entry(objectClasses = {"organizationalPerson", "person", "top"})
//@Entry(objectClasses = { "person", "top" })
@Entry(objectClasses = { "top", "person", "organizationalPerson", "user" })
//@Entry(objectClasses = { "user, Person", "top", "organizationalPerson" })
public class User {

	
	@Id
    private Name dn;

	
    
    private @Attribute(name = "cn")
    String username;
    
    

    @Attribute(name = "sn")
    private String ultimoNome;
    
    
    @Attribute(name = "givenName")
	private String primeiroNome;
    
    
    @Attribute(name = "sAMAccountName")
    private String login;
    
    
    @Attribute(name ="memberOf")
    private ArrayList<String> groups;


    @Attribute(name = "mail")    
    private String email;
    
    @Attribute(name = "physicalDeliveryOfficeName")
    private String lotacao;

    @Attribute(name = "department")  
    private String departamento;


    @Attribute(name = "company")
    private String secretaria;

    @Attribute(name = "description")
    private String cargoOrigem;

    @Attribute(name = "title")    
    private String cargo;

    
    @Attribute(name = "mailNickname")   
    private String mailNickname;
    
    
    
    public String getUltimoNome() {
		return ultimoNome;
	}


	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}


	public String getPrimeiroNome() {
		return primeiroNome;
	}


	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}


	public User() {
    }


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

@Override
public String toString() {
	return this.username;
}


public Name getDn() {
	return dn;
}


public void setDn(Name dn) {
	this.dn = dn;
}


public ArrayList<String> getGroups() {
	return groups;
}


public void setGroups(ArrayList<String> groups) {
	this.groups = groups;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getLotacao() {
	return lotacao;
}


public void setLotacao(String lotacao) {
	this.lotacao = lotacao;
}


public String getDepartamento() {
	return departamento;
}


public void setDepartamento(String departamento) {
	this.departamento = departamento;
}


public String getSecretaria() {
	return secretaria;
}


public void setSecretaria(String secretaria) {
	this.secretaria = secretaria;
}


public String getCargoOrigem() {
	return cargoOrigem;
}


public void setCargoOrigem(String cargoOrigem) {
	this.cargoOrigem = cargoOrigem;
}


public String getCargo() {
	return cargo;
}


public void setCargo(String cargo) {
	this.cargo = cargo;
}


public String getMailNickname() {
	return mailNickname;
}


public void setMailNickname(String mailNickname) {
	this.mailNickname = mailNickname;
}


   


    
}
