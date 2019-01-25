package ru.kogut.enterprise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kogut.enterprise.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
