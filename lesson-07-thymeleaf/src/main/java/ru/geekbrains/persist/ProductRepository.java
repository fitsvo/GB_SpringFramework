package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("select p " +
            " from Product p " +
            "where (p.title like concat('%', :title, '%') or :title is null) and " +
            "      (p.price like concat('%', :price, '%') or :price is null)")
    List<Product> findUserByFilter(@Param("title") String title,
                                @Param("price") String price);
//
//    private final EntityManagerFactory emFactory;
//
//    public ProductRepository(EntityManagerFactory emFactory) {
//        this.emFactory = emFactory;
//    }
//
//    public List<Product> findAll() {
//        EntityManager em = emFactory.createEntityManager();
//        em.getTransaction().begin();
//        List<Product> products = em.createQuery("SELECT i FROM products i", Product.class).getResultList();
//        em.getTransaction().commit();
//        em.close();
//        emFactory.close();
//        return products;
//    }
//
//    public Optional<Product> findById(Long id) {
//        EntityManager em = emFactory.createEntityManager();
//        em.getTransaction().begin();
//        Product productFromDB = em.find(Product.class, id);
//        System.out.println(productFromDB.toString());
//        em.getTransaction().commit();
//        em.close();
//        emFactory.close();
//        return Optional.of(productFromDB);
//    }
//
//    public Product save(Product product) {
//        EntityManager em = emFactory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(product);
//        System.out.println(product.toString() + " saved!");
//        em.getTransaction().commit();
//        em.close();
//        emFactory.close();
//        return product;
//    }
//
//    public void delete(long id) {
//        EntityManager em = emFactory.createEntityManager();
//        em.getTransaction().begin();
//        Product product = em.find(Product.class, id);
//        em.remove(product);
//        em.getTransaction().commit();
//        em.close();
//        emFactory.close();
//    }

}
