package sit.int202.m_66130500059.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int202.m_66130500059.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query("select c.customerNumber , c.customerName from customers where c.customerNumber  not in (select customerNumber from orders")



}