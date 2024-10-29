package sit.int202.m_66130500059.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sit.int202.m_66130500059.services.CustomerService;


@Controller
@RequestMapping("/66130500059")
public class CustomerController {
        public CustomerService CustomerService ;
        public CustomerController(CustomerService CustomerService, CustomerService customerService){
            this.CustomerService = CustomerService;
        }
    @GetMapping("/customers")
    public String getAllCustomer(Model model) {
        var customers = CustomerService.getAllCustomer();
        model.addAttribute("customers",customers);
        return "customer_list";
    }


}
