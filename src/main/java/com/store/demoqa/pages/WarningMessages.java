package com.store.demoqa.pages;

public enum WarningMessages {

    INVALID_SEARCH("Sorry, but nothing matched your search criteria. Please try again with some different keywords.")

    ;

    String warningMessages;

    WarningMessages(String warningMessages) {
        this.warningMessages = warningMessages;
    }

    public String getWarningMessages() {
        return warningMessages;
    }


}
