package pl.straszewski.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.straszewski.api.IOrder;
import pl.straszewski.api.IPizza;
import pl.straszewski.implementation.Kebab;
import pl.straszewski.implementation.Order;
import pl.straszewski.implementation.Wiejska;

//@Configuration
public class Config {
	@Bean
	public IPizza pizza(){
		return new Kebab(16, "Kebab pizza");
	}
	
//	@Bean
//	public IOrder order(IPizza pizza){
//		return new Order(pizza);
//	}
}
