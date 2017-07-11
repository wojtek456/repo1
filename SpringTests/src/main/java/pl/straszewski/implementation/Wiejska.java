package pl.straszewski.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.straszewski.api.IPizza;

@Component
@Qualifier("wiocha")
public class Wiejska implements IPizza {
	private int price;
	private String name;
	
	
	public Wiejska(@Value("17") int price, @Value("Wiejska") String name) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		
		return price;
	}

	public String getName() {
		
		return name;
	}

}
