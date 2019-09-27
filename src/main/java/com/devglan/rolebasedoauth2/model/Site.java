package com.devglan.rolebasedoauth2.model;

import javax.persistence.*;

@Entity
@Table(name = "SITE")
public class Site {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SITEID")
    private long siteId;

    @Column(name = "SITENAME")
    private String siteName;

    @Column(name = "LOGINURL")
    private String loginUrl;

    @Column(name = "USERNAMETAG")
    private String usernameTag;

    @Column(name = "PASSWORDTAG")
    private String passwordTag;

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getUsernameTag() {
        return usernameTag;
    }

    public void setUsernameTag(String usernameTag) {
        this.usernameTag = usernameTag;
    }

    public String getPasswordTag() {
        return passwordTag;
    }

    public void setPasswordTag(String passwordTag) {
        this.passwordTag = passwordTag;
    }
}
