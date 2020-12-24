package guru.springframework.spring5webapp.testy.repository;

import guru.springframework.spring5webapp.testy.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
