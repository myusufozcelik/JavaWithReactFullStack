package deneme.northwind.business.concretes;

import deneme.northwind.business.abstracts.ProductService;
import deneme.northwind.core.utilities.results.DataResult;
import deneme.northwind.core.utilities.results.Result;
import deneme.northwind.core.utilities.results.SuccessDataResult;
import deneme.northwind.core.utilities.results.SuccessResult;
import deneme.northwind.dataAccess.abstracts.ProductDao;
import deneme.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());

    }

    @Override
    public DataResult<List<Product>> getAllSorted() {

        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Başarılı");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data Listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories), "Kategoriler Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName), "Ürün adı Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName), "Ürün/Ürünler Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryId), "Kategoriler Listelendi");
    }

}
