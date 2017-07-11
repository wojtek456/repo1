package pl.straszewski.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.straszewski.api.IOrder;
import pl.straszewski.api.IPizza;

@Component
public class Order implements IOrder {

	IPizza pizza;
	
	public Order(@Qualifier("wiocha") IPizza pizza){
		this.pizza = pizza;
	}
	public void printOrder() {
		System.out.println("Zamówienie: " + pizza.getName() + " cena: " + pizza.getPrice() + " po rabacie: " + pizza.getPrice()*0.8);

	}

}
