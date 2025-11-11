package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";

    private By goodsC0unter = By.cssSelector("a span");
    private By title = By.cssSelector(".title");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean getTitle() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public String getGoodsCounter() {
        return driver.findElement(goodsC0unter).getText();
    }
}
