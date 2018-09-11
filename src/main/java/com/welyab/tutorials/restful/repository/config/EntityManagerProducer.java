package com.welyab.tutorials.restful.repository.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class EntityManagerProducer {

    @Inject
    private EntityManagerFactoryHolder entityManagerFactoryHolder;

    @Produces
    @RequestScoped
    public EntityManager createEntitymanager() {
	return entityManagerFactoryHolder.crateEntityManager();
    }
}
