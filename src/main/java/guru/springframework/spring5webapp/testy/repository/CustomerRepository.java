package guru.springframework.spring5webapp.testy.repository;

import guru.springframework.spring5webapp.testy.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
