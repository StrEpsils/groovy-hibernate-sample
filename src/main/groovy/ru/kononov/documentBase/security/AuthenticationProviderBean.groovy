package ru.kononov.documentBase.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.kononov.documentBase.entities.Role
import ru.kononov.documentBase.entities.User
import ru.kononov.documentBase.service.UserService

/**
 * Created by admin on 15.01.2017.
 * получение идентификационных данных пользователя для авторизованного запроса
 */
@Service
class AuthenticationProviderBean implements AuthenticationProvider {

    @Autowired
    UserService userService

    @Override
    Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.name
        String password = authentication.credentials.toString()
        User user = userService.findUserByNameAndPassword(name, password)
        if (user){
            List<GrantedAuthority> authorities = new ArrayList<>()
            for (Role role : user.roles)
                authorities.add role
            new UsernamePasswordAuthenticationToken(name, password, authorities)
        }

        else
            throw new UsernameNotFoundException("User with name = $name not found")
    }

    @Override
    boolean supports(Class<?> authentication) {
        authentication == UsernamePasswordAuthenticationToken.class
    }
}
