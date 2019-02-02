

[creating-custom-spring-namepsace](http://cscarioni.blogspot.com/2012/04/creating-custom-spring-3-xml-namespace.html)

BeanDefinitionParser (CountryServiceBeanDefinitionParser.java)

* Implements the **parse** method, which provides you with the **org.w3c.dom.Element** object for the regionService element and the **ParserContext**. 
*  **ParserContext** provides you access to the BeanDefinitionRegistry, which, we will use to register our beans. 
*  **BeanDefinitionBuilder.genericBeanDefinition(Someclass)** , creates a new beandefinition for the provided class. 
* You can set property to a value using **addPropertyValue** on the builder. The first param would be the property name and the second param would be the actual value. Values can be of any type. 
* If you want to set a property to a reference bean, then use **RuntimeBeanReference**.
* If your value is a list that has one or more references, then use **org.springframework.beans.factory.support.ManagedList** to define the list. 
* If your value is a map that has one or more references, then use **org.springframework.beans.factory.support.ManagedMap** to define the map. 
* You can set property to another bean using **addPropertyReference**. The first param would be the property name and the second param would be the name of the referenced bean. 
* Once the bean is defined, it can be registered through the **parserContext.getRegistry().registerBeanDefinition** method. It takes the id of the bean as the first parameter and BeanDefinition as the second.