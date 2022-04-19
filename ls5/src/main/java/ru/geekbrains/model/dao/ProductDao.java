package ru.geekbrains.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.model.entity.Product;

import java.util.*;


public class ProductDao{
    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();
    Session session = null;
   /* {
        Product product = new Product();
        product.setId((long) (db.size() + 1));
        product.setTitle("Egg");
        product.setPrice(90);
        db.put(product.getId(), product);
    }
    {
        Product product = new Product();
        product.setId((long) (db.size() + 1));
        product.setTitle("Milk");
        product.setPrice(70);
        db.put(product.getId(), product);
    }
    {
        Product product = new Product();
        product.setId((long) (db.size() + 1));
        product.setTitle("Bread");
        product.setPrice(50);
        db.put(product.getId(), product);
    }*/

    public Product getById(Long id){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, id);
        System.out.println(productFromDB.toString());
        session.getTransaction().commit();
        sessionFactory.close();
        return productFromDB;
    }

    public void deleteById(Long id){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, id);
        session.delete(productFromDB);
        System.out.println(productFromDB.toString() + " removed!");
        session.getTransaction().commit();
        sessionFactory.close();
    }

    public List<Product> getAll(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = (List<Product>) session.createQuery("SELECT i FROM products i", Product.class).getResultList();
        session.getTransaction().commit();
        sessionFactory.close();
        return products;
    }

    public void save(Product product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        System.out.println(product.toString() + " saved!");
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
