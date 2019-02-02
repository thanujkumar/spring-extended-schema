package org.tk.custom.ns.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class CountryServiceNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("regionService", new CountryServiceBeanDefinitionParser());
	}

}
