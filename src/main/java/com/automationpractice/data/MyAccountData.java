package com.automationpractice.data;

public class MyAccountData extends BaseData {

    private String pageHeading;
    private Boolean signOut;
    private String searchQuery;
    private Boolean submitSearch;

    public String getPageHeading() {
        return pageHeading;
    }

    public void setPageHeading(String pageHeading) {
        this.pageHeading = pageHeading;
    }

    public Boolean getSignOut() {
        return signOut;
    }

    public void setSignOut(Boolean signOut) {
        this.signOut = signOut;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public Boolean getSubmitSearch() {
        return submitSearch;
    }

    public void setSubmitSearch(Boolean submitSearch) {
        this.submitSearch = submitSearch;
    }
}
