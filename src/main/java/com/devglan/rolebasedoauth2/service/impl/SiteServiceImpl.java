package com.devglan.rolebasedoauth2.service.impl;

import com.devglan.rolebasedoauth2.service.SiteService;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service(value = "siteService")
public class SiteServiceImpl implements SiteService {

    @Override
    public boolean checkBrowserInstance(WebDriver driver) {

        return (driver == null || driver.getWindowHandles().isEmpty());

    }

    @Override
    public String getTabCount(WebDriver driver) {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        return tabs.get(driver.getWindowHandles().size() - 1);
    }

}
