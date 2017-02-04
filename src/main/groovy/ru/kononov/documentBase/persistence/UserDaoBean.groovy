package ru.kononov.documentBase.persistence

import org.springframework.stereotype.Repository
import ru.kononov.documentBase.entities.User

/**
 * Created by admin on 15.01.2017.
 */
@Repository("userDao")
class UserDaoBean extends BaseEntityDaoBean<User> implements UserDao{

    @Override
    User findUserByNameAndPassword(String name, String password) {
        return (User)currentSession().createQuery(" from User as user where name = '$name' and password = '$password'").singleResult
    }

    @Override
    User findUserByName(String name) {
        return (User)currentSession().createQuery(" from User as user inner join Role as role where user.name = '$name'").singleResult
    }

    @Override
    Class<User> getClassName() {
        return User.class
    }
}