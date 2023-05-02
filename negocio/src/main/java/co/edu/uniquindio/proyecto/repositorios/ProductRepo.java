package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Category;
import co.edu.uniquindio.proyecto.entidades.Product;
import co.edu.uniquindio.proyecto.entidades.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query("select p.nameProduct as name,sum(pd.units) as units,sum(pd.price*pd.units) as totalPrice,p.quantityProduct as available from Product p join PurchaseDetail pd on p.id=pd.product.id order by p.nameProduct")
    List<Object[]> getReportProduct();

    //@Query("select new co.edu.uniquindio.proyecto.dto.ReportProductDto(name,units,totalPrice,available) from (")
    //List<ReportProductDto> ;

    @Query("select pi from ProductImage pi where pi.product.id=:id")
    List<ProductImage> getProductImageByIdProduct(Integer id);

    @Query("select pc.category from ProductCategory pc where pc.product.id=:id")
    List<Category> getCategoryByIdProduct(Integer id);
}
