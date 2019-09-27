package com.devglan.rolebasedoauth2.model;

import javax.persistence.*;

@Entity
@Table(name = "CREDENTIALS")
public class Credentials {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CREDENTIALSID")
    private long credentialsId;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SITEID")
    private Integer siteId;

    public long getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(long credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
