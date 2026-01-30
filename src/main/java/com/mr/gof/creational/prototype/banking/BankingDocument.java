package com.mr.gof.creational.prototype.banking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mr.gof.Logger.log;

/**
 * Represents a banking portfolio or customer profile.
 *
 * The BankingTool adds cloned products to this document.
 * Provides safe, read‑only access to stored products.
 */
public class BankingDocument {

    private final List<BankingProduct> products = new ArrayList<>();

    public void addProduct(BankingProduct p) {
        products.add(p);
        log("Added product:");
        p.display();
    }

    public List<BankingProduct> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
