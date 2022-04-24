package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("select p " +
            " from Product p " +
            "where (p.title like concat('%', :title, '%') or :title is null) and " +
            "      (p.price like concat('%', :price, '%') or :price is null)")
    List<Product> findProductByFilter(@Param("title") String title,
                                      @Param("price") BigDecimal price);

}