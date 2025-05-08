package test;

import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import org.cooksystem.models.Invoice;
import org.cooksystem.service.InvoiceService;

public class CustomerInvoiceSteps {

    private InvoiceService invoiceService = new InvoiceService();
    private Invoice invoice;
    private String meal;
    private String ingredients;
    private double total;

    @Given("the customer places an order for {string} with ingredients {string} and total cost {double}")
    public void the_customer_places_an_order(String meal, String ingredients, Double total) {
        this.meal = meal;
        this.ingredients = ingredients;
        this.total = total;
    }

    @When("the system generates the invoice")
    public void the_system_generates_the_invoice() {
        invoice = invoiceService.generateInvoice(meal, ingredients, total);
    }

    @Then("the invoice should include the meal {string}")
    public void the_invoice_should_include_the_meal(String expectedMeal) {
        assertEquals(expectedMeal, invoice.getMeal());
    }

    @Then("the invoice should list the ingredients {string}")
    public void the_invoice_should_list_the_ingredients(String expectedIngredients) {
        assertEquals(expectedIngredients, invoice.getIngredients());
    }

    @Then("the invoice should show the total cost as {double}")
    public void the_invoice_should_show_the_total_cost_as(Double expectedTotal) {
        assertEquals(expectedTotal, invoice.getTotal(), 0.01);
    }
}
