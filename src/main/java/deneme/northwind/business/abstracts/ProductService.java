package deneme.northwind.business.abstracts;

import deneme.northwind.core.utilities.results.DataResult;
import deneme.northwind.core.utilities.results.Result;
import deneme.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    Result add(Product product);
}
