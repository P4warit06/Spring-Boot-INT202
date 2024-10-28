package sit.int202.demo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sit.int202.demo.entities.Product;
import sit.int202.demo.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public List<Product> findAll() {
        return repository.findAll();
    }
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Product findById(String productCode) {
        return repository.findById(productCode).orElse(null);
    }

    public List<Product> findProductByText(String searchParam) {
//        String keyword = "%"+ searchParam +"%";
//        return repository.findAllProductsByKeyword(keyword, keyword, keyword);
        String keyword = searchParam;
        return repository.findProductsByProductNameContainingIgnoreCaseOrProductVendorContainingIgnoreCaseOrProductLine_ProductLine(keyword, keyword, keyword);
    }

    public List<Product> filterProductByPrice(Double lower, Double upper) {
        if(lower>upper) {
            double temp = lower;
            lower = upper;
            upper = temp;
        }
        return repository. findAllProductsByBuyPriceBetweenOrderByBuyPriceDesc(BigDecimal.valueOf(lower), BigDecimal.valueOf(upper));
    }
    public List<Product> findByAnyContent(String anyContent) {
        return  repository.findProductsByProductNameContainingIgnoreCaseOrProductVendorContainingIgnoreCaseOrProductLine_ProductLine(anyContent, anyContent, anyContent);
    }
    public List<Product> findByAnyContentUsingNameQuery(String anyContent){
        return repository.findByAnyContents("%"+anyContent+"%");
    }
    public List<Product> findByPriceBetween(BigDecimal lower, BigDecimal upper) {
        if(lower.compareTo(upper)>0) {
            BigDecimal temp = lower;
            lower = upper;
            upper = lower   ;
        }
    return repository.findProductByBuyPriceOrOrderByBuyPriceDesc(lower, upper);
    }
}
