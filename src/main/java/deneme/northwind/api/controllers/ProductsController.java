package deneme.northwind.api.controllers;


import deneme.northwind.business.abstracts.ProductService;
import deneme.northwind.core.utilities.results.DataResult;
import deneme.northwind.core.utilities.results.Result;
import deneme.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameOrCategory(productName, categoryId);
    }

    // To do: tekrar bak
    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories) {
        return productService.getByCategoryIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo - 1, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {
        return productService.getAllSorted();
    }


    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }


}
