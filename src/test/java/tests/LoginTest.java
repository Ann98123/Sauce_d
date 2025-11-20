package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {UserFactory.withIncorrectUserPermission(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withIncorrectPasswordPermission(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withEmptyUserPermission(), "Epic sadface: Username is required"},
                {UserFactory.withEmptyPasswordPermission(), "Epic sadface: Password is required"},
                {UserFactory.withEmptyUserAndPasswordPermission(), "Epic sadface: Username is required"},
        };
    }

    @Test
    public void authCorrect() {
        System.out.println("CorrectLogin Tests are running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.authorization(UserFactory.withAdminPermission());
        assertTrue(productsPage.isPageOpen());
        assertEquals("Products", productsPage.getTitleText());
    }

    @Test(dataProvider = "loginData")
    public void authIncorrect(User user, String errorMsg) {
        System.out.println("IncorrectLogin Tests are running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.authorization(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
