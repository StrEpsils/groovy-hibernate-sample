package ru.kononov.documentBase.service

import ru.kononov.documentBase.entities.Role

/**
 * Created by admin on 15.01.2017.
 */
interface RoleService {

    List<Role> findRolesByUserId(Long userId)

}