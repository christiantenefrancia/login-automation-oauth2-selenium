package com.devglan.rolebasedoauth2.controller;

import com.devglan.rolebasedoauth2.service.SiteService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/site")
public class SiteController {

    private WebDriver driver;
    private ChromeOptions options;

    @Autowired
    SiteService siteService;

    public SiteController() {

        // Set the chrome path
        System.setProperty("webdriver.chrome.driver", "C:/Users/ctenefrancia/Documents/selenium/chromedriver.exe");

        // Create object of ChromeOption class
        options = new ChromeOptions();

        // remove popup "Chrome is being controlled ny automated test software"
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // add parameter which will disable the extension
        options.setExperimentalOption("useAutomationExtension", false);

        //remove popup "save password"
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = null;
       // options.addArguments("headless");

    }

    @GetMapping(value = "/stackoverflow")
    public void loadStackOverflow(){

        if(siteService.checkBrowserInstance(driver)) {
            // Start the chrome session
            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.get("https://stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f");
            driver.findElement(By.id("email")).sendKeys("ctenefrancia@aeoncredit.com.ph");
            driver.findElement(By.id("password")).sendKeys("choi1994", Keys.ENTER);

        } else {
            ((JavascriptExecutor)driver).executeScript("window.open()");
            driver.switchTo().window(siteService.getTabCount(driver));
            driver.manage().window().maximize();
            driver.get("https://stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f");
            driver.findElement(By.id("email")).sendKeys("ctenefrancia@aeoncredit.com.ph");
            driver.findElement(By.id("password")).sendKeys("choi1994", Keys.ENTER);
        }

    }

    @GetMapping(value = "/github")
    public void gitHub(){

        Security.setProperty("crypto.policy", "unlimited");
        BytesEncryptor encryptor = Encryptors.stronger("password", "5c0744940b5c369b");
        try {

            byte[] result = encryptor.encrypt("text".getBytes("UTF-8"));
            System.out.println("Encrypted Password : " + result);
            System.out.println("Decrypted Password : " + encryptor.decrypt(result));


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*if(siteService.checkBrowserInstance(driver)) {
            // Start the chrome session
            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.get("https://github.com/login");
            driver.findElement(By.id("login_field")).sendKeys("tenefrancia.cj@gmail.com");
            driver.findElement(By.id("password")).sendKeys("christian#1994", Keys.ENTER);

        } else {
            ((JavascriptExecutor)driver).executeScript("window.open()");
            driver.switchTo().window(siteService.getTabCount(driver));
            driver.manage().window().maximize();
            driver.get("https://github.com/login");
            driver.findElement(By.id("login_field")).sendKeys("tenefrancia.cj@gmail.com");
            driver.findElement(By.id("password")).sendKeys("christian#1994", Keys.ENTER);
        }*/

    }

}
