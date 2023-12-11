package it.unibo.collections.design.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;

public class WarehouseImpl implements Warehouse{

    private Set<Product> set = new LinkedHashSet<>();

    @Override
    public void addProduct(Product p) {
        this.set.add(p);
    }

    @Override
    public Set<String> allNames() {
        Set<String> names = new LinkedHashSet<>();
        for (var string : this.set) {
            names.add(string.getName());
        }
        return names;
    }

    @Override
    public Set<Product> allProducts() {
        return new LinkedHashSet<>(this.set);
    }

    @Override
    public boolean containsProduct(Product p) {
        return set.contains(p);
    }

    @Override
    public double getQuantity(String name) {
        for (var product : this.set) {
            if (product.getName().equals(name)) {
                return product.getQuantity();
            }
        }
        return -1;
    }
    
}
