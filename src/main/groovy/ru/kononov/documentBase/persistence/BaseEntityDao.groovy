package ru.kononov.documentBase.persistence

/**
 * Created by admin on 15.10.2016.
 */
interface BaseEntityDao<T> {

    Long save(T entity)
    T update(T entity)
    void delete(T entity)
    T get(Long id)
    List<T> findAll()

}