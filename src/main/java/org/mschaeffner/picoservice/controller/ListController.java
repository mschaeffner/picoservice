package org.mschaeffner.picoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.mschaeffner.picoservice.context.Context;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class ListController implements Route {

	private final Context context;

	public ListController(Context context) {
		this.context = context;
		Spark.get(context.getCollectionUrl(), this);
	}

	@Override
	public Object handle(Request req, Response res) throws InstantiationException, IllegalAccessException {
		List<Object> result = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Object item = context.getDomainClass().newInstance();
			result.add(item);
		}

		return result;
	}

}
