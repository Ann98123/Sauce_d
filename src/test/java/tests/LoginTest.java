package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {"standard", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "flowers", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
        };
    }

    @Test
    public void authCorrect() {
        loginPage.open();
        loginPage.authorization("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpen());
        assertEquals("Products", productsPage.getTitleText());
    }

    @Test(dataProvider = "loginData")
    public void authIncorrect(String userName, String password, String errorMsg) {
        loginPage.open();
        loginPage.authorization(userName, password);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
