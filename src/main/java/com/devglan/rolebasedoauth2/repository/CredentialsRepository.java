package com.devglan.rolebasedoauth2.repository;

import com.devglan.rolebasedoauth2.model.Credentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

}
