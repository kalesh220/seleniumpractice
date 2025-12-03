package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utility.Base;

import java.sql.Driver;

public class TestCase_Login extends Base {

    @Test
    public void verifyLoginWithValidCredentials(){
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccountButton();
            homePage.clickLoginButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setInputEmailAddress(prop.getProperty("email"));
            loginPage.setInputPassword(prop.getProperty("password"));
            loginPage.clickLoginButton();

            MyAccountPage mccPage = new MyAccountPage(driver);

            Assert.assertTrue(mccPage.isTextMyAccountVisible());

        } catch (RuntimeException e) {
            Assert.fail();
            System.out.println("Exception with : " + e.getMessage());
        }
    }
}
