package ru.kononov.documentBase.persistence

import org.springframework.stereotype.Repository
import ru.kononov.documentBase.entities.Role

/**
 * Created by admin on 15.01.2017.
 */
@Repository("roleDao")
class RoleDaoBean extends BaseEntityDaoBean<Role> implements RoleDao{

    @Override
    List<Role> findRolesByUserId(Long userId) {
        return (List<Role>)currentSession().createQuery("from Role as role inner join User as user where user.id = $userId").list()
    }

    @Override
    Class<Role> getClassName() {
        return Role.class
    }
}
