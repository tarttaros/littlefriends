package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import proyecto.entidades.Category;
import proyecto.entidades.Product;
import proyecto.entidades.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query("select p.nameProduct as name,sum(pd.units) as units,sum(pd.price*pd.units) as totalPrice,p.quantityProduct as available from Product p join PurchaseDetail pd on p.id=pd.product.id order by p.nameProduct")
    List<Object[]> getReportProduct();



    @Query("select pi from ProductImage pi where pi.product.id=:id")
    List<ProductImage> getProductImageByIdProduct(Integer id);

    @Query("select p from Product p where p.description = ?1")
    Product getProductByDescription(String desc);

    @Query("select pc.category from ProductCategory pc where pc.product.id=:id")
    List<Category> getCategoryByIdProduct(Integer id);

}
