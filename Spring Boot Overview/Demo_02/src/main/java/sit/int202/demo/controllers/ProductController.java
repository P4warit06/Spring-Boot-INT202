package sit.int202.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sit.int202.demo.entities.Product;
import sit.int202.demo.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("")
    public String getAllcustomers(Model model) {
        model.addAttribute("products", service.findAll());
        return "product_list";
    }
    @GetMapping("/search")
    public String searchByContent(@RequestParam String searchParam, Model model) {
        model.addAttribute("product",service.findByAnyContentUsingNameQuery(searchParam));
        return "product_list";
    }
    @GetMapping("/searchByPrice")
    public String searchByPrice(@RequestParam (defaultValue = "10.0") Double  lower , @RequestParam (defaultValue = "9999.99") Double upper, Model model) {
        model.addAttribute("products"
                ,service.filterProductByPrice(Double.valueOf(lower) ,Double.valueOf(upper)));
        return "product_list";
    }


}
