package ru.kononov.groovyHibernateSample.persistence

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

/**
 * Created by admin on 15.10.2016.
 */
@Transactional
abstract class BaseEntityDaoBean<T> implements BaseEntityDao<T>{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.currentSession;
    }

    @Override
    @Transactional
    def save(T entity) {
        return currentSession().saveOrUpdate(entity)
    }

    @Override
    @Transactional
    void delete(T entity) {
        currentSession().delete(entity)
    }

    @Override
    @Transactional(readOnly = true)
    T get(Long id) {
        return currentSession().get(getClassName(), id)
    }

    @Override
    List<T> findAll(){}

    List<T> findAll(String entityClassName){
        return (List<T>)currentSession().createQuery("from $entityClassName entity").list()
    }

    abstract Class<T> getClassName();
}
