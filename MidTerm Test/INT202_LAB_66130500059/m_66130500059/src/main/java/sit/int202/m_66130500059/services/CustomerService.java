package sit.int202.m_66130500059.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int202.m_66130500059.entities.Customer;
import sit.int202.m_66130500059.repositorie.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository ;
    public  List<Customer> getAllCustomer(){
            return customerRepository.findAll();
    }
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public void createCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id already exist");
        }
        customerRepository.save(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer deleteCustomer(int id) {
        var customer = customerRepository.findById(id).orElse(null);
        if (!customerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id is not exist");
        }
        customerRepository.delete(customer);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id is not exist");
        }
        customerRepository.save(customer);
    }





}
