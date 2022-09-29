package com.pms.ldap.repository;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends LdapRepository<Group> {

}
