package com.automationpractice.entity;

import com.automationpractice.data.LoginPageData;
import com.automationpractice.pages.LoginPage;

public class LoginPageEntity extends BaseEntity {

    LoginPageData data;

    public LoginPageEntity(LoginPageData data) {
        this.data = data;
    }

    public LoginPage navigation() { //TODO: Add navigation path
        return loginPageModule();
    }

    public void create() {
        navigation().fillout(data);  //TODO: Add navigation path and access the fillout method of the pages
    }

    public void verify() {
        navigation().verify(data); //TODO: Add navigation path and access the verify method of the pages
    }
}
