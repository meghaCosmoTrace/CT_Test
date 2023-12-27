package com.automationpractice.pages;

import com.automationpractice.data.BaseData;
import com.automationpractice.data.HomePageData;
import com.automationpractice.elements.Button;
import com.automationpractice.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	//	private TextBoxElement searchBox = new TextBoxElement(By.name("search_query"));
//	private Button searchButton = new Button(By.name("submit_search"));
//	private BaseElements productList = new BaseElements(By.xpath(".//div[@class='right-block']/h5/a[@class='product-name']"));
//	private BaseElements subCategory = new BaseElements(By.className("cat-title"));
	private Button signIn_Link = new Button(By.partialLinkText("Sign in"));

//	public TextBoxElement getSearchBox() {
//		return searchBox;
//	}
//
//	public Button getSearchButton() {
//		return searchButton;
//	}
//
//	public BaseElements getProductList() {
//		return productList;
//	}
//
//	public BaseElements getSubCategory() {
//		return subCategory;
//	}

	public Button getSignIn_Link() {
		return signIn_Link;
	}

	public boolean productMatches(String searchKey) {
//		int productCount = getProductList().size();
//		System.out.println("Number of Product Listed: "+productCount);
//		String product = null;
//		for(int i=0; i<productCount; i++) {
//			product = getProductList().get(i).getText().toLowerCase();
//			System.out.println(product);
//			if(! product.contains(searchKey)) {
//				return false;
//			}
//		}
		return true;
	}

	public void selectCategory(String category, WebDriver driver) {
		Log.info("Selecting Category " + category);
		driver.findElement(By.linkText(category.toUpperCase())).click();
	}

	public void selectSubCategory(String subCategory, WebDriver driver) {
		Log.info("Selecting Sub-Category " + subCategory);
		driver.findElement(By.linkText(subCategory.toUpperCase())).click();
	}

//	public String validateSubCategory() {
//		return getSubCategory().getText().trim();
//	}

	public LoginPage clickOnSignInLink() {
		getSignIn_Link().click();
		return new LoginPage();
	}

	@Override
	void fillout(BaseData bData) {
		HomePageData data = (HomePageData) bData;
//		getSearchBox().set(data.getSearchBox());
//		getSearchButton().set(data.getSearchButton());

		if (data.getProductList() != null)
			productMatches(data.getSearchBox());

	}

	@Override
	void verify(BaseData bData) {

	}
}
