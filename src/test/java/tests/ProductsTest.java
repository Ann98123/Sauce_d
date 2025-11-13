package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
public class ProductsTest extends BaseTest {
    @Test
    public void checkAddingGoods() {
        loginPage.open();
        loginPage.authorization("standard_user", "secret_sauce");
        productsPage.isPageOpen();
        productsPage.addToCart(0);
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.switchToCart();
        assertEquals("2", productsPage.getGoodsCounter());
        assertTrue(cartPage.getProductsNames().contains("Test.allTheThings() T-Shirt (Red)"));
        assertEquals(2, cartPage.getProductsNames().size());
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
