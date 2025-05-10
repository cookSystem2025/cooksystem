package org.cooksystem.service;

import org.cooksystem.models.Invoice;

import java.util.HashMap;
import java.util.Map;

public class InvoiceService {

    public Invoice generateInvoice(String mealName, Map<String, String> selectedIngredients, double totalPrice) {
        Map<String, Object> invoiceDetails = new HashMap<>();
        invoiceDetails.put("meal", mealName);
        invoiceDetails.put("ingredients", selectedIngredients);
        invoiceDetails.put("total", totalPrice);

        return new Invoice(invoiceDetails);
    }
}
