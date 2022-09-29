package com.pms.ldap.repository;

import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = {"top", "groupOfUniqueNames"})
public class Group {

	 @Id
	    private Name dn;

	    @Attribute(name="cn")
	    @DnAttribute("cn")
	    private String name;

	    @Attribute(name="uniqueMember")
	    private Set<String> members;
	
	    @Override
	    public String toString() {
	        return "Group{" +
	                "dn=" + dn +
	                ", name='" + name + '\'' +
	                ", members=" + members +
	                '}';
	    }
}
