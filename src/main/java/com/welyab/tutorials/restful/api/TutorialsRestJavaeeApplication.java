package com.welyab.tutorials.restful.api;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.common.collect.ImmutableSet;

@ApplicationPath("api")
public class TutorialsRestJavaeeApplication extends Application {

    private static final ImmutableSet<Class<?>> CLASSES = ImmutableSet.of(
	    CustomerResource.class,
	    IllegalArgumentExceptionMapper.class
    );

    @Override
    public Set<Class<?>> getClasses() {
	return CLASSES;
    }
}
