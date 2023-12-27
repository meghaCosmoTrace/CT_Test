package com.automationpractice.pages;

import com.automationpractice.data.BaseData;
import com.automationpractice.data.LoginPageData;
import com.automationpractice.elements.Button;
import com.automationpractice.elements.TextBox;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private TextBox createAccountEmail = new TextBox(By.name("email_create"));
    private Button createAccountButton = new Button(By.name("SubmitCreate"));
    private TextBox registeredEmail = new TextBox(By.name("email"));
    private TextBox password = new TextBox(By.name("passwd"));
    private Button loginButton = new Button(By.xpath("//button[@name='SubmitLogin']"));

    public TextBox getCreateAccountEmail() {
        return createAccountEmail;
    }

    public Button getCreateAccountButton() {
        return createAccountButton;
    }

    public TextBox getRegisteredEmail() {
        return registeredEmail;
    }

    public TextBox getPassword() {
        return password;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    @Override
    public void fillout(BaseData bData) {
        LoginPageData data = (LoginPageData) bData;
        getCreateAccountEmail().set(data.getCreateAccountEmail());
        getCreateAccountButton().set(data.getCreateAccountButton());
        getRegisteredEmail().set(data.getRegisteredEmail());
        getPassword().set(data.getPassword());
        getLoginButton().set(data.getLoginButton());
    }

    @Override
    public void verify(BaseData bData) {
        LoginPageData data = (LoginPageData) bData;
        getLoginButton().verify(data.getLoginButtonText());
    }
}
