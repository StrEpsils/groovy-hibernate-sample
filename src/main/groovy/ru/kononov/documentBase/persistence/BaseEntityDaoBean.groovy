package ru.kononov.documentBase.persistence

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by admin on 15.10.2016.
 */
abstract class BaseEntityDaoBean<T extends Serializable> implements BaseEntityDao<T>{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.currentSession;
    }

    @Override
    Long save(T entity) {
        return currentSession().save(entity)
    }

    @Override
    T update(T entity) {
        return currentSession().update(entity)
    }

    @Override
    void delete(T entity) {
        currentSession().delete(entity)
    }

    @Override
    T get(Long id) {
        return currentSession().get(getClassName(), id)
    }

    @Override
    List<T> findAll(){}

    List<T> findAll(String entityClassName){
        return (List<T>)currentSession().createQuery("from $entityClassName entity").list()
    }

    abstract Class<T> getClassName()
}
