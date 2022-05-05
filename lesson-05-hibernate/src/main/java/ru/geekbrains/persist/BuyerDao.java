package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class BuyerDao {
    private final EntityManagerFactory emFactory;

    public BuyerDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Buyer> findAll() {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        List<Buyer> buyers = em.createQuery("SELECT i FROM products i", Buyer.class).getResultList();
        em.getTransaction().commit();
        em.close();
        emFactory.close();
        return buyers;
    }

    public Optional<Buyer> findById(Long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Buyer buyerFromDB = em.find(Buyer.class, id);
        System.out.println(buyerFromDB.toString());
        em.getTransaction().commit();
        em.close();
        emFactory.close();
        return Optional.of(buyerFromDB);
    }

    public Buyer save(Buyer buyer) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(buyer);
        System.out.println(buyer.toString() + " saved!");
        em.getTransaction().commit();
        em.close();
        emFactory.close();
        return buyer;
    }

    public void delete(long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Buyer buyer = em.find(Buyer.class, id);
        em.remove(buyer);
        em.getTransaction().commit();
        em.close();
        emFactory.close();
    }
}
