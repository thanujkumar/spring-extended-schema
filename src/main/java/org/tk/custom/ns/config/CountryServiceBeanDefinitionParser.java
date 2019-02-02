package org.tk.custom.ns.config;

import java.util.Arrays;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.tk.custom.ns.ex1.CountryRegistry;
import org.tk.custom.ns.ex1.CountryService;
import org.tk.custom.ns.ex1.PlacesInCountryImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CountryServiceBeanDefinitionParser implements BeanDefinitionParser {

	public BeanDefinition parse(Element element, ParserContext parserContext) {
		
		//element received is regionService
		BeanDefinitionBuilder regionBeanBuilder = BeanDefinitionBuilder.genericBeanDefinition(CountryService.class);
		//set registry name which also bean id
		String beanId = element.getAttribute("name");
		regionBeanBuilder.addPropertyValue("registryName", beanId);
		
		BeanDefinitionBuilder countryRegistry = BeanDefinitionBuilder.genericBeanDefinition(CountryRegistry.class);
		ManagedMap<Object, Object> map = new ManagedMap<Object, Object>();
		
		//get all countries 
		if (element.hasChildNodes()) {
			//Country places - child nodes country
			NodeList countryNodes = element.getChildNodes();
			for (int i = 0; i < countryNodes.getLength() ; i++) {
				Node node = countryNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					//Then it is a country element extract the details
					//Create PlacesInCountry object
					PlacesInCountryImpl pImpl = new PlacesInCountryImpl();
					NamedNodeMap nodeAttr = node.getAttributes();
					pImpl.setPlaces(Arrays.asList(nodeAttr.getNamedItem("places").getNodeValue().split(",")));
					map.put(nodeAttr.getNamedItem("name").getNodeValue(), pImpl);
					//nodeAttr.getNamedItem("key");
				}
			}
		}
		
		countryRegistry.addPropertyValue("registry", map);
		
		regionBeanBuilder.addPropertyValue("countryRegistry", countryRegistry.getBeanDefinition());
		parserContext.getRegistry().registerBeanDefinition(beanId, regionBeanBuilder.getBeanDefinition());
		//return regionBeanBuilder.getBeanDefinition();
		return null;
	}

	

}
