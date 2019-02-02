package org.tk.custom.ns.ex1;

import java.util.Map;

public class CountryRegistry {

	private Map<String, PlacesInCountry> registry;

	public Map<String, PlacesInCountry> getRegistry() {
		return registry;
	}

	public void setRegistry(Map<String, PlacesInCountry> registry) {
		this.registry = registry;
	}

}
