package ru.ivmiit.servlets.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.ivmiit.servlets.entity.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private SessionFactory factory;

    private void setSessionFactory() {
        this.factory= HibernateConfiguration.getFactory();
    }

    public ProductServiceImpl() {
        setSessionFactory();
    }

    public void addProduct(Product product) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(product);

        transaction.commit();
        session.close();
    }

    public void updateProduct(Product product) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(product);

        transaction.commit();
        session.close();
    }

    public Product getByName(String name) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = criteriaBuilder.createQuery(Product.class);
        Root<Product> productDataSetRoot = criteria.from(Product.class);

        criteria.select(productDataSetRoot).where(criteriaBuilder.equal(productDataSetRoot.get("name"), name));
        Query<Product> q = session.createQuery(criteria);
        List<Product> result = q.getResultList();
        transaction.commit();
        session.close();

        Product res = null;
        if (!result.isEmpty()){
            res = result.get(0);
        }

        return res;
    }

    public List<Product> getAll() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = criteriaBuilder.createQuery(Product.class);
        Root<Product> productDataSetRoot = criteria.from(Product.class);

        criteria.select(productDataSetRoot);
        Query<Product> q = session.createQuery(criteria);
        List<Product> result = q.getResultList();
        transaction.commit();
        session.close();

        if (!result.isEmpty()){
            return result;
        }
        return null;
    }
}
