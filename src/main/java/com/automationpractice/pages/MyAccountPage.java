package com.automationpractice.pages;

import com.automationpractice.data.BaseData;
import com.automationpractice.data.MyAccountData;
import com.automationpractice.elements.BaseElements;
import com.automationpractice.elements.Button;
import com.automationpractice.elements.TextBox;
import com.automationpractice.utility.AssertUtility;
import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {

    private Button signOut = new Button(By.linkText("Sign out"));
    private TextBox searchQuery = new TextBox(By.name("search_query"));
    private BaseElements submitSearch = new BaseElements(By.name("submit_search"));

    public BaseElements getSignOut() {
        return signOut;
    }

    public TextBox getSearchQuery() {
        return searchQuery;
    }

    public BaseElements getSubmitSearch() {
        return submitSearch;
    }

    @Override
    public void fillout(BaseData bData) {
        MyAccountData data = (MyAccountData) bData;
        getSearchQuery().set(data.getSearchQuery());
        getSubmitSearch().set(data.getSubmitSearch());
        getSignOut().set(data.getSignOut());
    }

    @Override
    public void verify(BaseData bData) {
        MyAccountData data = (MyAccountData) bData;
        AssertUtility.assertContains(pageTitle, data.getPageHeading(), "title");
    }
}
