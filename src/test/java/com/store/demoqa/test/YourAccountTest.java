package com.store.demoqa.test;

import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.store.demoqa.BaseTest;
import com.store.demoqa.data.DataUsers;
import com.store.demoqa.model.User;
import com.store.demoqa.pages.ToolsQALoggedOutPage;
import com.store.demoqa.pages.YourAccountPage;
import com.store.demoqa.utils.ScreenShotOnFailListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static com.store.demoqa.utils.DefaultData.DEFAULT_LOGIN;
import static com.store.demoqa.utils.DefaultData.DEFAULT_PASS;
import static org.hamcrest.MatcherAssert.assertThat;

@Listeners({ScreenShotOnFailListener.class, TextReport.class})
@Report
public class YourAccountTest extends BaseTest {

    private YourAccountPage yourAccountPage;
    private ToolsQALoggedOutPage toolsQALoggedOutPage;

    @BeforeMethod
    void setUp() {
        yourAccountPage = new YourAccountPage();
        toolsQALoggedOutPage = new ToolsQALoggedOutPage();
        open("/");
    }


    @Test
    void verifySuccessfulAuthorization() {
        yourAccountPage.goToYourAccountPage().
                loginAs(DEFAULT_LOGIN, DEFAULT_PASS)
                .logout();
        assertThat("The authorization page is displayed", toolsQALoggedOutPage.isPageLoaded());
    }


    @Test(dataProvider = "objectDataEventTemplates", dataProviderClass = DataUsers.class)
    void verifyUnsuccessfulAuthorization(ArrayList<User> users) {
        yourAccountPage.goToYourAccountPage().
                noLogin(users.get(0));
    }


}
