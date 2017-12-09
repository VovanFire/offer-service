package com.fire.offer.offerservice.dao.impl;

import com.fire.offer.offerservice.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T>{
    final SessionFactory sessionFactory;

    AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T create(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
            return entity;
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }
    }

    @Override
    public T getOne(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(getEntityType(), id);
        }
    }

    @Override
    public List<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<T> query = session.createQuery(
                    "from " + getEntityType().getSimpleName(),
                    getEntityType());
            return query.getResultList();
        }
    }

    @Override
    public List<T> getAll(int page) {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<T> query = session.createQuery(
                    "from " + getEntityType().getSimpleName(),
                    getEntityType())
                    .setFirstResult((page - 1) * 10)
                    .setMaxResults(10);
            return query.getResultList();
        }
    }

    @Override
    public int count() {
        try (Session session = sessionFactory.openSession()) {
            return ((Long) session.createQuery(
                    "select count(*) from " + getEntityType().getSimpleName())
                    .uniqueResult()).intValue();
        }
    }

    @Override
    public Page<T> getAll(Pageable pageable) {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<T> query = session.createQuery(
                    "from " + getEntityType().getSimpleName(), getEntityType())
                    .setFirstResult(pageable.getOffset())
                    .setMaxResults(10);
            List<T> entities = query.getResultList();
            int count = count();
            return new PageImpl<>(entities, pageable, count);
        }
    }

    protected abstract Class<T> getEntityType();
}

