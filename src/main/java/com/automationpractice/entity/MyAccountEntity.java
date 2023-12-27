package com.automationpractice.entity;

import com.automationpractice.data.MyAccountData;
import com.automationpractice.pages.MyAccountPage;

public class MyAccountEntity extends BaseEntity {

    MyAccountData data;

    public MyAccountEntity(MyAccountData data) {
        this.data = data;
    }

    public MyAccountPage navigation() { //TODO: Add navigation path
        return myAccountPageModule();
    }

    public void create() {
        navigation().fillout(data);  //TODO: Add navigation path and access the fillout method of the pages
    }

    public void verify() {
        navigation().verify(data); //TODO: Add navigation path and access the verify method of the pages
    }
}
