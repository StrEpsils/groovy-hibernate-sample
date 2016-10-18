package ru.kononov.groovyHibernateSample.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by admin on 17.10.2016.
 */

@Entity
@Table(name = "DOCUMENT_TYPE_ATTRIBUTE")
class DocumentTypeAttribute implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "DOCUMENT_TYPE_ATTRIBUTE_ID")
    Long id
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    DocumentType documentType
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTE_ID")
    Attribute attribute

}
