package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";

    private By goodsCounter = By.cssSelector("a span");
    private By title = By.cssSelector(".title");
    private By addToCartButton = By.xpath("//*[text()='Add to cart']");
    private By basketIcon = By.cssSelector(".shopping_cart_link");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(final int index) {
        driver.findElements(addToCartButton).get(index).click();
    }

    public String getGoodsCounter() {
        return driver.findElement(goodsCounter).getText();
    }

    public void switchToCart() {
        driver.findElement(basketIcon).click();
    }
}
