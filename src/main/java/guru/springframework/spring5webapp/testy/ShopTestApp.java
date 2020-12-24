package guru.springframework.spring5webapp.testy;

import guru.springframework.spring5webapp.testy.repository.CustomerRepository;
import guru.springframework.spring5webapp.testy.repository.OrderItemRepository;
import guru.springframework.spring5webapp.testy.repository.OrderRepository;
import guru.springframework.spring5webapp.testy.repository.ProductRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ShopTestApp implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;

    public ShopTestApp(ProductRepository productRepository,
                       OrderRepository orderRepository,
                       CustomerRepository customerRepository,
                       OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("Milk" , 1.99);
        Product product2 = new Product("Bread", 2.99);
        Product product3 = new Product("Buttoer", 1.99);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        productRepository.saveAll(products);

        System.out.println("\t\t ---------- PRODUCTS in the datbasase .... : " + productRepository.count());
        for (Product p: productRepository.findAll()){
            System.out.println("\t\t\t###### : " + p.toString());
        }


        Customer customer1 = new Customer("Adam Kowalksi");
        Customer customer2 = new Customer("Michael McAllister");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        System.out.println("\t\t ---------- CUSTOMERS in the datbasase .... : " + customerRepository.count());
        for (Customer c: customerRepository.findAll()){
            System.out.println("\t\t\t###### : " + c.toString());
        }


        // Order Items
        OrderItem orderItem1 = new OrderItem().buildOrderItem(product1, 1);
        OrderItem orderItem2 = new OrderItem().buildOrderItem(product2, 10);

        Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);

        Order order1 = new Order();
        order1.setItems(orderItems);
        order1.setCustomer(customer1);

        customer1.getOrders().add(order1);

        orderItem1.setOrder(order1);
        orderItem2.setOrder(order1);

        orderRepository.save(order1);
        customerRepository.save(customer1);
        orderItemRepository.saveAll(orderItems);


        System.out.println("Customer 1 orders count : " + customer1.getOrders().size());



    }
}
