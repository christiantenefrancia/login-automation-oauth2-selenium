package com.devglan.rolebasedoauth2.repository;

import com.devglan.rolebasedoauth2.model.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends CrudRepository<Site, Long> {

}
