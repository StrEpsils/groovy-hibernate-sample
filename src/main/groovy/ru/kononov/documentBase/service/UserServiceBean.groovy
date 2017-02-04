package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.kononov.documentBase.entities.User
import ru.kononov.documentBase.persistence.UserDao

/**
 * Created by admin on 15.01.2017.
 */
@Service("userService")
class UserServiceBean implements UserService{

    @Autowired
    UserDao userDao

    @Override
    @Transactional
    User findUserByNameAndPassword(String name, String password) {
        return userDao.findUserByNameAndPassword(name, password)
    }

    @Override
    @Transactional
    User findUserByName(String name) {
        return userDao.findUserByName(name)
    }
}
