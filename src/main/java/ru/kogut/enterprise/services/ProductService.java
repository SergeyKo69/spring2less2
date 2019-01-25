package ru.kogut.enterprise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.models.Product;
import ru.kogut.enterprise.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product){
        if (product == null) return;
        productRepository.save(product);
    }

    public Product getProductById(String id){
        if (id.isEmpty() || id == null) return null;
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.get();
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public void updateProduct(Product product){
        saveProduct(product);
    }

    public void deleteProduct(Product product){
        if (product == null) return;
        productRepository.delete(product);
    }
}
