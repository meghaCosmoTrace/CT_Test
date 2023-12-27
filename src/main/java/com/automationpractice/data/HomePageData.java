package com.automationpractice.data;

public class HomePageData extends BaseData {

    private String searchBox;
    private Boolean searchButton;
    private String productList;
    private String subCategory;
    private Boolean signIn_Link;

    public String getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(String searchBox) {
        this.searchBox = searchBox;
    }

    public Boolean getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Boolean searchButton) {
        this.searchButton = searchButton;
    }

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Boolean getSignIn_Link() {
        return signIn_Link;
    }

    public void setSignIn_Link(Boolean signIn_Link) {
        this.signIn_Link = signIn_Link;
    }
}
