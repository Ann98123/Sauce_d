package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class FirstClass extends BaseTest{

    @Test
    public void authPositive() {
        loginPage.open();
        loginPage.login("standard_user");
        Assert.assertTrue(browser.findElement(By.cssSelector(".title")).isDisplayed());
    }

    @Test
    public void authNegative() {
        loginPage.open();
        loginPage.login("standard");
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.checkErrorMsg());
    }
}
