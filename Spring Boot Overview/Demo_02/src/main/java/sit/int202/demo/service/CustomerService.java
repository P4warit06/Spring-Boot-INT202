package sit.int202.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sit.int202.demo.entities.Customer;
import sit.int202.demo.entities.Office;
import sit.int202.demo.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomer() {
        return  customerRepository.findAll();
    }
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
//    public Customer AddCustomer(Customer customer) {
//        if(customer.getId()== null || customerRepository.)
//        return customerRepository.save(customer);
//    }
//    public Customer deleteCustomerById(int id) {
//        Office deleteCustomerID = getCustomerById(customer.getId()){
//            customerRepository.deleteById(id);
//        }
//        if(deleteCustomerID == null ){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND
//                    , "Customer not found");
//        }
//
//        customerRepository.delete(deleteCustomerID)
//        return deleteCustomerID
//    }
    public Customer UpdateCustomer(Customer customer) {
        Customer existcustomer   = getCustomerById(customer.getId());
        if (existcustomer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Can 't Office id '%s' does not exists", customer.getId()));
        }
        return customerRepository.save(customer);
    }

//    public Customer saveCustomer(Customer customer) {}





}
