package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.User

/**
 * Created by admin on 15.01.2017.
 */
interface UserService {

    User findUserByNameAndPassword(String name, String password)
    User findUserByName(String name)

}
