package tests;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void authCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user");
        loginPage.password("secret_sauce");
        loginPage.loginButton();
        assertTrue(productsPage.getTitle());
        assertEquals("Products", productsPage.getTitleText());
    }

    @Test
    public void authIncorrectLogin() {
        loginPage.open();
        loginPage.login("standard");
        loginPage.password("secret_sauce");
        loginPage.loginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.checkErrorMsg());
    }

    @Test
    public void authIncorrectPassword() {
        loginPage.open();
        loginPage.login("standard_user");
        loginPage.password("flowers");
        loginPage.loginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.checkErrorMsg());
    }

    @Test
    public void authLockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user");
        loginPage.password("secret_sauce");
        loginPage.loginButton();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.checkErrorMsg());
    }

    @Test
    public void authEmptyUser() {
        loginPage.open();
        loginPage.login("");
        loginPage.password("secret_sauce");
        loginPage.loginButton();
        assertEquals("Epic sadface: Username is required", loginPage.checkErrorMsg());
    }

    @Test
    public void authEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user");
        loginPage.password("");
        loginPage.loginButton();
        assertEquals("Epic sadface: Password is required", loginPage.checkErrorMsg());
    }

    @Test
    public void authEmptyPasswordAndLogin() {
        loginPage.open();
        loginPage.login("");
        loginPage.password("");
        loginPage.loginButton();
        assertEquals("Epic sadface: Username is required", loginPage.checkErrorMsg());
    }

    @Test
    public void checkGoodsName() {
        loginPage.open();
        loginPage.authorization("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        assertEquals("1", productsPage.getGoodsCounter());
    }
}
