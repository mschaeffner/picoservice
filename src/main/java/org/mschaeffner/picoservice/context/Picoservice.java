package org.mschaeffner.picoservice.context;


import org.mschaeffner.picoservice.controller.ListController;
import org.mschaeffner.picoservice.controller.ShowController;
import org.mschaeffner.picoservice.enums.LogLevel;
import org.mschaeffner.picoservice.enums.PersistenceType;
import org.mschaeffner.picoservice.enums.ResponseFormat;

public class Picoservice {

	private Picoservice(Builder builder) {

		String collectionUrl = '/' + builder.domainClass.getSimpleName().toLowerCase();
		if (!collectionUrl.endsWith("s")) {
			collectionUrl += 's';
		}

		String itemUrl = collectionUrl + "/:id";

		
		Context context = new Context(collectionUrl, itemUrl, builder.domainClass);
		
		new ShowController(context);
		new ListController(context);

	}

	public static class Builder {

		private final Class<?> domainClass;

		private ResponseFormat responseFormat = ResponseFormat.JSON;

		private PersistenceType persistenceType = PersistenceType.MONGODB;

		private LogLevel logLevel = LogLevel.INFO;

		public Builder(Class<?> domainClass) {
			this.domainClass = domainClass;
		}

		public Builder responseFormat(ResponseFormat responseFormat) {
			this.responseFormat = responseFormat;
			return this;
		}

		public Builder persistenceType(PersistenceType persistenceType) {
			this.persistenceType = persistenceType;
			return this;
		}

		public Builder logLevel(LogLevel logLevel) {
			this.logLevel = logLevel;
			return this;
		}

		public Picoservice build() {
			return new Picoservice(this);
		}

	}

}
