package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {

    private By loginInput = By.id("user-name");
    private By passInput = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void authorization(User user) {
        login(user.getEmail());
        password(user.getPassword());
        loginButton();
    }

    public void login(String userName) {
        driver.findElement(loginInput).sendKeys(userName);
    }

    public void password(String password) {
        driver.findElement(passInput).sendKeys(password);
    }

    public void loginButton() {
        driver.findElement(loginBtn).click();
    }

    public String checkErrorMsg () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));

        return driver.findElement(errorMsg).getText();
        }
    }
