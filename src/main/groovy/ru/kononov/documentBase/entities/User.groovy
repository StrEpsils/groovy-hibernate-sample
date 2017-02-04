package ru.kononov.documentBase.entities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

/**
 * Created by admin on 15.01.2017.
 */
@Entity
@Table(name = "USER")
class User implements Serializable {
    
    static final Logger LOGGER = LogManager.getLogger(User.class)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    Long id
    @Column(name = "NAME")
    String name
    @Column(name = "PASSWORD")
    String password
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    List<Role> roles
}
