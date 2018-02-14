package app

import grails.gorm.transactions.Transactional

import groovy.transform.CompileStatic

import org.grails.orm.hibernate.HibernateDatastore

import ratpack.exec.Blocking
import ratpack.service.Service
import ratpack.service.StartEvent

@CompileStatic
class BootStrapService implements Service {

    @Override
    void onStart(StartEvent event) throws Exception {
        event.registry.get(HibernateDatastore)
        Blocking.exec {
            populateWithSampleData()
        }
    }

    @Transactional
    void populateWithSampleData() {
        Manufacturer audi = new Manufacturer(name: 'audi')
        audi.addToVehicles(new Vehicle(name: 'A3', year: 1996))
        audi.addToVehicles(new Vehicle(name: 'A4', year: 1994))
        audi.save()

        Manufacturer ford = new Manufacturer(name: 'ford')
        ford.addToVehicles(new Vehicle(name: 'Ford KA', year: 1996))
        ford.save()
    }
}
