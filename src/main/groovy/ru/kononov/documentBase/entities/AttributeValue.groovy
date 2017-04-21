package ru.kononov.documentBase.entities

import com.fasterxml.jackson.annotation.JsonFilter

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by admin on 15.10.2016.
 */
@Entity
@Table(name = "ATTRIBUTE_VALUE")
@JsonFilter("AttributeValue")
class AttributeValue implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATTRIBUTE_VALUE_ID")
    Long id

    @Column(name = "VALUE")
    String value

    @ManyToOne
    @JoinColumn(name = "ATTRIBUTE_ID")
    Attribute attribute

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    Document document

}
