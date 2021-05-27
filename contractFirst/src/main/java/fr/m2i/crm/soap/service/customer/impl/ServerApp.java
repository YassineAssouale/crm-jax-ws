package fr.m2i.crm.soap.service.customer.impl;

import javax.xml.ws.Endpoint;

public class ServerApp {
	public static void main(String[] args) {
        Endpoint.publish("http://localhost:9990/CustomerService", new CustomerServiceImpl());
 
        System.out.println("CustomerService Started!");
    }
}
