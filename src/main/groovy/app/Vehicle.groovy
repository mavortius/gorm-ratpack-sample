package app

import grails.gorm.annotation.Entity

import groovy.transform.ToString

import org.grails.datastore.gorm.GormEntity

@ToString
@Entity
class Vehicle implements GormEntity<Vehicle> {

    String name

    Integer year

    static belongsTo = [manufacturer: Manufacturer]

    static constraints = {
        name nullable: false, blank: false
    }
}
