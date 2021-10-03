package deneme.northwind.business.abstracts;

import deneme.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
