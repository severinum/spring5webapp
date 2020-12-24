package guru.springframework.spring5webapp.testy.repository;

import guru.springframework.spring5webapp.testy.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
