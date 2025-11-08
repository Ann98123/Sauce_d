package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver browser;
    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("h3");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void login(String userName) {
        browser.findElement(USER_NAME).sendKeys(userName);
        browser.findElement(PASSWORD).sendKeys("secret_sauce");
        browser.findElement(LOGIN_BUTTON).click();
    }

    public String checkErrorMsg () {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        return browser.findElement(ERROR_MESSAGE).getText();
        }
    }
