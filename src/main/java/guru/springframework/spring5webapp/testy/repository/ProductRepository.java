package guru.springframework.spring5webapp.testy.repository;

import guru.springframework.spring5webapp.testy.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
