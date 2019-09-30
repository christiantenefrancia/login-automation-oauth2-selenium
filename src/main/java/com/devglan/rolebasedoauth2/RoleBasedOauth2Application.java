package com.devglan.rolebasedoauth2;

import com.devglan.rolebasedoauth2.controller.SiteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RoleBasedOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedOauth2Application.class, args);
		/*ApplicationContext applicationContext = SpringApplication.run(RoleBasedOauth2Application.class, args);
		SiteController siteController = applicationContext.getBean(SiteController.class);
		siteController.loadMain();*/
	}

}

