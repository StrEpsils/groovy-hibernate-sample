package ru.kononov.documentBase.entities

import com.fasterxml.jackson.annotation.JsonFilter

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table


/**
 * Created by admin on 15.10.2016.
 */
@Entity
@Table(name = "DOCUMENT")
@JsonFilter("Document")
class Document implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DOCUMENT_ID_SEQ")
//    @SequenceGenerator(name="DOCUMENT_ID_SEQ", sequenceName="DOCUMENT_ID_SEQ", allocationSize=1)
    @Column(name = "DOCUMENT_ID")
    Long id
    @Column(name = "NAME")
    String name
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    DocumentType documentType
    @OneToMany(mappedBy = "document", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    List<AttributeValue> attributeValues

    String toString(){
        return "DOCUMENT_ID = $id, NAME = $name, DOCUMENT_TYPE_NAME = $documentType.name"
    }

}
