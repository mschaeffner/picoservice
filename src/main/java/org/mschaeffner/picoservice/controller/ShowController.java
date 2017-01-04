package org.mschaeffner.picoservice.controller;

import org.mschaeffner.picoservice.context.Context;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class ShowController implements Route {

	private final Context context;
	
	public ShowController(Context context) {
		this.context = context;
		Spark.get(context.getItemUrl(), this);
	}
	
	@Override
	public Object handle(Request req, Response res) throws InstantiationException, IllegalAccessException {
		Object result = context.getDomainClass().newInstance();
		return result;
	}

}
