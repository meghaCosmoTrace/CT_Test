package com.automationpractice.pages;

import com.automationpractice.data.BaseData;
import com.automationpractice.data.CreateAccountData;
import com.automationpractice.elements.Button;
import com.automationpractice.elements.TextBox;
import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {

	TextBox firstName = new TextBox(By.id("customer_firstname"));
	TextBox lastName = new TextBox(By.id("customer_lastname"));
	TextBox password = new TextBox(By.id("passwd"));
	Button registerButton = new Button(By.id("submitAccount"));

	public TextBox getFirstName() {
		return firstName;
	}

	public TextBox getLastName() {
		return lastName;
	}

	public TextBox getPassword() {
		return password;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	@Override
	public void fillout(BaseData bData) {
		CreateAccountData data = (CreateAccountData) bData;
		getFirstName().set(data.getFirstName());
		getLastName().set(data.getLastName());
		getPassword().set(data.getPassword());
		getRegisterButton().set(data.getRegisterButton()); //TODO: add flash message verification
	}

	@Override
	public void verify(BaseData bData) {

	}
}
