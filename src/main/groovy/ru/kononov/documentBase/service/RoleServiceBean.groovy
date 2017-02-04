package ru.kononov.documentBase.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.kononov.documentBase.entities.Role
import ru.kononov.documentBase.persistence.RoleDao

/**
 * Created by admin on 15.01.2017.
 */
@Service("roleService")
class RoleServiceBean implements RoleService{

    @Autowired
    RoleDao roleDao

    @Override
    @Transactional
    List<Role> findRolesByUserId(Long userId) {
        return roleDao.findRolesByUserId(userId)
    }
}
