package ru.kononov.documentBase.persistence

import ru.kononov.documentBase.entities.Role

/**
 * Created by admin on 15.01.2017.
 */
interface RoleDao extends BaseEntityDao<Role>{

    List<Role> findRolesByUserId(Long userId)

}