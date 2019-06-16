package com.brushbasics.evs;

import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.ReaderListener;
import io.swagger.models.Swagger;
//import io.swagger.util.

@SwaggerDefinition()
public class SwaggerBasePathModifier implements ReaderListener {

	@Override
	public void afterScan(Reader arg0, Swagger arg1) {
		System.out.println("testing after");

	}

	@Override
	public void beforeScan(Reader arg0, Swagger arg1) {
		System.out.println("testing before");

	}
}
