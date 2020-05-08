package net.justchecking.springboot.service;

import net.justchecking.springboot.model.Product;

import java.util.List;

public interface ProductService {
   Product createProduct(Product product);
   Product updateProduct(Product product);
   List<Product> getAllProduct();
   Product getProductById(long ProductId);
   void deleteProduct(long id);
}
