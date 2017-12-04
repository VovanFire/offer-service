package com.fire.offer.offerservice.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericDao<T> {
    T create (T entity);
    void update(T entity);
    void delete(T entity);
    T getOne(int id);
    List<T> getAll();
    List<T> getAll(int page);
    int count();
    Page<T> getAll(Pageable pageable);
}
