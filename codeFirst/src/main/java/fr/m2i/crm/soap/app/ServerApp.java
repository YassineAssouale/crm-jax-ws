package fr.m2i.crm.soap.app;

import javax.xml.ws.Endpoint;

import fr.m2i.crm.soap.service.order.impl.OrderServiceImpl;


public class ServerApp {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9980/OrderService", new OrderServiceImpl());
		System.out.println("OrderService Started!");
	}
}
