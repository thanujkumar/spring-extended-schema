package org.tk.custom.ns.ex1;

public class CountryService {

	private CountryRegistry countryRegistry = new CountryRegistry();

	/**
	 * registry name like asiaRegion, euroRegion, africanRegion
	 */
	private String registryName;

	public String getRegistryName() {
		return registryName;
	}

	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}

	public CountryRegistry getCountryRegistry() {
		return countryRegistry;
	}

	public void setCountryRegistry(CountryRegistry countryRegistry) {
		this.countryRegistry = countryRegistry;
	}

//	/**
//	 * Example here is country name as key and values as places in country
//	 * 
//	 * @param name
//	 * @param ds
//	 */
//	public static void setCountryRegistry(String name, PlacesInCountry ds) {
//		countryRegistry.getRegistry().put(name, ds);
//	}

}
