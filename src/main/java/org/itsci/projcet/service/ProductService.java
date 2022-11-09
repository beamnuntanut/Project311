package org.itsci.project.service;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    public void saveProduct(Product product);
    Product getProduct(int productId);
    void deleteProduct(int productId);
    void updateProduct(Product productEntity, Product product);
}
