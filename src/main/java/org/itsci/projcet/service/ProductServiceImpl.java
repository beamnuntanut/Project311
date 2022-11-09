package org.itsci.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
    @Override
    @Transactional
    public Product getProduct(int productId) {
        return productDao.getProduct(productId);
    }
    @Override
    @Transactional
    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }
    @Override
    @Transactional
    public void updateProduct(Product productEntity, Product product) {
        productEntity.fill(product);
        productDao.saveProduct(productEntity);
    }
}