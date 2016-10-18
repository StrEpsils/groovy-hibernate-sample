package ru.kononov.groovyHibernateSample.entities

import com.fasterxml.jackson.annotation.JsonFilter

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

/**
 * Created by admin on 15.10.2016.
 */
@Entity
@Table(name = "ATTRIBUTE_VALUE")
@JsonFilter("AttributeValue")
class AttributeValue implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "ATTRIBUTE_VALUE_ID")
    Long id
    @Column(name = "VALUE")
    String value
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTE_ID")
    Attribute attribute
    @OneToOne
    @JoinColumn(name = "DOCUMENT_ID")
    Document document

}
