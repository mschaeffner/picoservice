package org.mschaeffner.picoservice.context;

import static org.mschaeffner.picoservice.enums.LogLevel.INFO;
import static org.mschaeffner.picoservice.enums.PersistenceType.MONGODB;
import static org.mschaeffner.picoservice.enums.ResponseFormat.JSON;

public class MainTest {

	
	public static void main(String[] args) {

		new Picoservice.Builder(User.class) //
				.responseFormat(JSON) //
				.persistenceType(MONGODB) //
				.logLevel(INFO) //
				.build(); //
		
	}

}
