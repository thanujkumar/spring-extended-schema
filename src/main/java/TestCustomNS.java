import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tk.custom.ns.ex1.CountryRegistry;
import org.tk.custom.ns.ex1.CountryService;
import org.tk.custom.ns.ex1.PlacesInCountry;

public class TestCustomNS {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationCtx = new ClassPathXmlApplicationContext("spring-custom-schema.xml");
		
		CountryService regionService = (CountryService) applicationCtx.getBean("regionService1");
		CountryRegistry countryRegistry = regionService.getCountryRegistry();
		Map<String, PlacesInCountry> placesInCountry = countryRegistry.getRegistry();
		
		for (String key: placesInCountry.keySet()) {
			System.out.println(key + "->" + placesInCountry.get(key).getPlaces());
		}
		
		
		/////////////////////////
		
		CountryService cusRegionService = (CountryService) applicationCtx.getBean("asiaRegion");
	    CountryRegistry cusCountryRegistry = cusRegionService.getCountryRegistry();
	    Map<String, PlacesInCountry> cusPlacesInCountry = cusCountryRegistry.getRegistry();
	    for (String key: cusPlacesInCountry.keySet()) {
			System.out.println(key + "->" + cusPlacesInCountry.get(key).getPlaces());
		}
	    
	    applicationCtx.close();
	}

}
