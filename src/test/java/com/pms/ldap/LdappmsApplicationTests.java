package com.pms.ldap;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;

import com.pms.ldap.repository.Group;
import com.pms.ldap.repository.User;
import com.pms.ldap.service.UserService;

@SpringBootTest
class LdappmsApplicationTests {

	@Autowired
	UserService service;
	
	@Autowired
	LdapTemplate ldapTemplate;
	
	@Test
	void contextLoads() {
		String nome ="Marcelo";
		
		
		
		
		List<User> users = ldapTemplate.find(LdapQueryBuilder.query().where("cn").like(nome +"*"), User.class);
		
		
		Iterator<User> ituser = users.iterator();
		
		while (ituser.hasNext()) {
			System.out.println(ituser.next().getUsername());
		}
		
		
		List<String> nomes = service.search(nome);
		
		System.out.println("lista busca por nome: " + nomes.size());
		
		Iterator<String> it = nomes.iterator();
		it.forEachRemaining(System.out::println);
		
		
		List<User> userall = ldapTemplate.findAll(User.class);
		System.out.println("lista total usuarios: " + userall.size());
			
	
		//AndFilter filter = new AndFilter();
		//filter.and(new EqualsFilter("objectclass", "organizationalPerson")).and(new EqualsFilter("sAMAccountName", "mescobar"));
		//List<Person> persons = ldapTemplate.search("", filter.encode(), new PersonContextMapper());
		//persons.iterator().forEachRemaining(System.out::println);
		
		User user = service.findByLogin("mescobar");
		System.out.println(user);
		
	}
	
	
	@Test
	void testGroup() {
		
		List<Group> groups = ldapTemplate.findAll(Group.class);
		
		System.out.println(groups.size());
		
		
	}

}

/*
 * class PersonContextMapper extends AbstractContextMapper<Person> {
 * 
 * @Override protected Person doMapFromContext(DirContextOperations ctx) { //
 * TODO Auto-generated method stub Person p = new Person();
 * p.setNome(ctx.getStringAttribute("cn"));
 * 
 * Object[] groups = ctx.getObjectAttributes("memberOf");
 * 
 * 
 * return p; }
 * 
 * }
 * 
 * class Person { private String nome;
 * 
 * public String getNome() { return nome; }
 * 
 * public void setNome(String nome) { this.nome = nome; }
 * 
 * 
 * }
 */
