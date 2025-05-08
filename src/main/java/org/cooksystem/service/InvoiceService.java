package org.cooksystem.service;

import org.cooksystem.models.Invoice;

public class InvoiceService {
    public Invoice generateInvoice(String meal, String ingredients, double total) {
        return new Invoice(meal, ingredients, total);
    }
}
