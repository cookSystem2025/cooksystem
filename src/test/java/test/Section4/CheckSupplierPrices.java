package test.Section4;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import org.cooksystem.models.*;
import test.StepContext;

public class CheckSupplierPrices {

    private PurchaseOrder generatedOrder;
    private double fetchedPrice;

    @Given("the supplier offers {string} at price {double}")
    public void the_supplier_offers_price(String name, double price) {
        StepContext.supplier.setPrice(name, price);
    }

    @When("the kitchen manager requests the price of {string}")
    public void the_kitchen_manager_requests_price(String name) {
        fetchedPrice = StepContext.supplier.getPrice(name);
    }

    @When("the system checks stock for {string}")
    public void the_system_checks_stock(String name) {
        generatedOrder = StepContext.inventoryManager.generatePurchaseOrder(name, StepContext.supplier);
    }

    @Then("the system should return the price as {double}")
    public void the_system_should_return_price(double expected) {
        assertEquals(expected, fetchedPrice, 0.01);
    }

    @Then("the system should generate a purchase order for {string} with quantity {int} at unit price {double}")
    public void the_system_should_generate_order(String name, int expectedQty, double expectedPrice) {
        assertNotNull("Expected a purchase order", generatedOrder);
        assertEquals(name, generatedOrder.getIngredientName());
        assertEquals(expectedQty, generatedOrder.getQuantity());
        assertEquals(expectedPrice, generatedOrder.getUnitPrice(), 0.01);
    }
}
