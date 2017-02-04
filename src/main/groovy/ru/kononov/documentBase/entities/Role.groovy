package ru.kononov.documentBase.entities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.security.core.GrantedAuthority

import javax.persistence.Column
import javax.persistence.Entity
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
@Table(name = "ROLE")
class Role implements Serializable, GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    Long id
    @Column(name = "NAME")
    String name
    @Column(name = "DESCRIPTION")
    String description
    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    List<User> users

    @Override
    String getAuthority() {
        return name
    }
}
