package com.automationpractice.data;

public class LoginPageData extends BaseData {

    private String createAccountEmail;
    private Boolean createAccountButton;
    private String registeredEmail;
    private String password;
    private Boolean loginButton;
    private String loginButtonText;

    public String getCreateAccountEmail() {
        return createAccountEmail;
    }

    public void setCreateAccountEmail(String createAccountEmail) {
        this.createAccountEmail = createAccountEmail;
    }

    public Boolean getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(Boolean createAccountButton) {
        this.createAccountButton = createAccountButton;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Boolean loginButton) {
        this.loginButton = loginButton;
    }

    public String getLoginButtonText() {
        return loginButtonText;
    }

    public void setLoginButtonText(String loginButtonText) {
        this.loginButtonText = loginButtonText;
    }
}
