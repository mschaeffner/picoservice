package org.mschaeffner.picoservice.context;

public class Context {

	private final String collectionUrl;
	
	private final String itemUrl;
	
	private final Class<?> domainClass;
	
	public Context(String collectionUrl, String itemUrl, Class<?> domainClass) {
		this.collectionUrl = collectionUrl;
		this.itemUrl = itemUrl;
		this.domainClass = domainClass;
	}

	public String getCollectionUrl() {
		return collectionUrl;
	}
	
	public String getItemUrl() {
		return itemUrl;
	}
	
	public Class<?> getDomainClass() {
		return domainClass;
	}

}
