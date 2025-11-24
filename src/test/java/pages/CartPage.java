package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By inventoryItemName = By.cssSelector(".inventory_item_name");

    @Step("Берем список товаров из корзины")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(inventoryItemName);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }
}
