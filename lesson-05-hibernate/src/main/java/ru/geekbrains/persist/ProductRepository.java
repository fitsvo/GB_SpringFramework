package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final EntityManagerFactory emFactory;

    public ProductRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Product> findAll() {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        List<Product> products = em.createQuery("SELECT i FROM products i", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        emFactory.close();
        return products;
    }

    public Optional<Product> findById(Long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product productFromDB = em.find(Product.class, id);
        System.out.println(productFromDB.toString());
        em.getTransaction().commit();
        em.close();
        emFactory.close();
        return Optional.of(productFromDB);
    }

    public Product save(Product product) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        System.out.println(product.toString() + " saved!");
        em.getTransaction().commit();
        em.close();
        emFactory.close();
        return product;
    }

    public void delete(long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.remove(product);
        em.getTransaction().commit();
        em.close();
        emFactory.close();
    }

}
