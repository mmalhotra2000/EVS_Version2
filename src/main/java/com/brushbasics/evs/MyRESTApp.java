package com.brushbasics.evs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("eventmgmtsystemv2")
public class MyRESTApp extends Application {
    public MyRESTApp() {
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        // api end points
        // swagger related
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        classes.add(SwaggerBasePathModifier.class);//<-- This does the trick

        return classes;
    }
}