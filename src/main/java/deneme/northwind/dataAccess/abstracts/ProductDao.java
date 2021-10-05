package deneme.northwind.dataAccess.abstracts;

import deneme.northwind.entities.concretes.Product;
import deneme.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);
    // select *form product where category_id in(1,2,3,4)

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    // biz yazarsak;
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    // constructora göre query yazılır
    @Query("Select new deneme.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) from Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

    // select p.productId, p.productName, c.categoryName  category c inner join product p on c.categoryId = p.categoryId


}
