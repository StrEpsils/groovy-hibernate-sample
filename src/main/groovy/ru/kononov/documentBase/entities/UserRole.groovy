package ru.kononov.documentBase.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by admin on 15.01.2017.
 */
@Entity
@Table(name = "USER_ROLE")
class UserRole implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ROLE_ID")
    Long id
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    User user
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    Role role
}
