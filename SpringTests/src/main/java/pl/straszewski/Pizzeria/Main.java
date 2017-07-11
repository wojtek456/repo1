package pl.straszewski.Pizzeria;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.straszewski.api.IOrder;
import pl.straszewski.config.AutoConfig;
import pl.straszewski.config.Config;
import pl.straszewski.implementation.Order;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
		IOrder order = context.getBean(Order.class);
		order.printOrder();
	}

}
