package ru.kononov.documentBase.entities

import com.fasterxml.jackson.annotation.JsonFilter

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

/**
 * Created by admin on 15.10.2016.
 */
@Entity
@Table(name = "ATTRIBUTE")
@JsonFilter("Attribute")
class Attribute implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "ATTRIBUTE_ID")
    Long id
    @Column(name = "NAME")
    String name
    @ManyToMany
    @JoinTable(name = "DOCUMENT_TYPE_ATTRIBUTE",
            joinColumns = @JoinColumn(name = "ATTRIBUTE_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOCUMENT_TYPE_ID"))
    List<DocumentType> documentTypes

}
