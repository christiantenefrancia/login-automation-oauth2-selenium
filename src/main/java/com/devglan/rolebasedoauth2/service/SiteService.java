package com.devglan.rolebasedoauth2.service;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public interface SiteService {

    boolean checkBrowserInstance(WebDriver driver);

    String getTabCount(WebDriver driver);

}
