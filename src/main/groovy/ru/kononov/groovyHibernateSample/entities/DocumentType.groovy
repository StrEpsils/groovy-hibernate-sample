package ru.kononov.groovyHibernateSample.entities

import com.fasterxml.jackson.annotation.JsonFilter

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * Created by admin on 15.10.2016.
 */
@Entity
@Table(name = "DOCUMENT_TYPE")
@JsonFilter("DocumentType")
class DocumentType implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "DOCUMENT_TYPE_ID")
    Long id
    @Column(name = "NAME")
    String name
    @Column(name = "CODE")
    String code
    @ManyToMany
    @JoinTable(name = "DOCUMENT_TYPE_ATTRIBUTE",
            joinColumns = @JoinColumn(name = "DOCUMENT_TYPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID"))
    List<Attribute> attributes
    @OneToMany(mappedBy = "documentType", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    List<Document> documents

}
