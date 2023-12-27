package com.automationpractice.entity;

import com.automationpractice.data.CreateAccountData;
import com.automationpractice.pages.CreateAccountPage;

public class CreateAccountEntity extends BaseEntity {

    CreateAccountData data;

    public CreateAccountEntity(CreateAccountData data) {
        this.data = data;
    }

    public CreateAccountPage navigation() { //TODO: Add navigation path
        return createAccountPageModule();
    }

    public void create() {
        navigation().fillout(data);  //TODO: Add navigation path and access the fillout method of the pages
    }

    public void verify() {
        navigation(); //TODO: Add navigation path and access the verify method of the pages
    }
}
