package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {

    @Test
    public void checkAddingGoods() {
        System.out.println("Products Tests are running in thread: " + Thread.currentThread().getId());
        final String itemsName = "Test.allTheThings() T-Shirt (Red)";
        loginPage.open();
        loginPage.authorization(withAdminPermission());
        productsPage.isPageOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(itemsName);
        productsPage.switchToCart();
        assertEquals("2", productsPage.getGoodsCounter());
        assertTrue(cartPage.getProductsNames().contains(itemsName));
        assertEquals(2, cartPage.getProductsNames().size());
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
