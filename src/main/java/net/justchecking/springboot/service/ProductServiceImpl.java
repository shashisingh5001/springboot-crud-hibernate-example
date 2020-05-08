package net.justchecking.springboot.service;

import net.justchecking.springboot.exception.ResourceNotFoundException;
import net.justchecking.springboot.model.Product;
import net.justchecking.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {

        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

        Optional<Product> productDb = this.repository.findById(product.getId());

        if (productDb.isPresent()) {

            Product productUpdate = productDb.get();

            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            repository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record Not Found with Id" + product.getId());
        }

    }

    @Override
    public List<Product> getAllProduct() {
        return this.getAllProduct();
    }

    @Override
    public Product getProductById(long ProductId) {

        Optional<Product> productDb = this.repository.findById(ProductId);

        if (productDb.isPresent()) {

            return productDb.get();
        } else {

            throw new ResourceNotFoundException("Record Not Found with Id" + ProductId);

        }
    }

    @Override
    public void deleteProduct(long ProductId) {

        Optional<Product> productDb = this.repository.findById(ProductId);

        if (productDb.isPresent()) {

            this.repository.delete(productDb.get());
        } else {

            throw new ResourceNotFoundException("Record Not Found with Id" + ProductId);

        }
    }
}
