package ru.kononov.groovyHibernateSample.persistence

/**
 * Created by admin on 15.10.2016.
 */
interface BaseEntityDao<T> {

    def save(T entity)
    void delete(T entity)
    T get(Long id)
    List<T> findAll()

}