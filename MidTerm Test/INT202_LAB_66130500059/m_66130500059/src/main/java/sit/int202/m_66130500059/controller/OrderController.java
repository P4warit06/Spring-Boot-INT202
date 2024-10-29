package sit.int202.m_66130500059.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sit.int202.m_66130500059.services.OrderService;


@Controller
@RequestMapping("/66130500059")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) {
        this.service = service;
    }
    @GetMapping("/customers/orders")
    public String getAllOrders(Model model) {
        model.addAttribute("products", service.findAll());
        return "order_list";
    }




}
