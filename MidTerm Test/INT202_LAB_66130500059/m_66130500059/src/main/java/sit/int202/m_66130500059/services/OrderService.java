package sit.int202.m_66130500059.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int202.m_66130500059.entities.Order;
import sit.int202.m_66130500059.repositorie.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final  OrderRepository repository;
    public OrderService(OrderRepository repository) {
       this.repository = repository;
   }
    public List<Order> findAll(){
        return repository.findAll();
    }

}
