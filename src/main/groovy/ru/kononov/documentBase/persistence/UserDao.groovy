package ru.kononov.documentBase.persistence

import ru.kononov.documentBase.entities.User

/**
 * Created by admin on 15.01.2017.
 */
interface UserDao extends BaseEntityDao<User>{

    User findUserByNameAndPassword(String name, String password)
    User findUserByName(String name)

}