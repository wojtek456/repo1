package pl.straszewski.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pl.straszewski.api.IPizza;


@Component
@Qualifier("Kebs")
public class Kebab implements IPizza {
	private int price;
	private String name;
	
	
	public Kebab(@Value("15") int price, @Value("KebabPizza") String name) {
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
