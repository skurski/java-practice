package com.skurski.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

//import java.util.Collections;
//import java.util.Comparator;

public class StrategyPatternDemo {
	
	public static void main(String[] args) {
		Client john = new Client("John", Gender.MALE);
		Client richard = new Client("Richard", Gender.MALE);
		Client laura = new Client("Laura", Gender.FEMALE);
		
		Bank bank = new Bank();
		bank.addClient(john);
		bank.addClient(richard);
		bank.addClient(laura);
		
		List<Client> clientsList = new ArrayList<Client>(bank.getClients());
		
//		Collections.sort(clientsList, new Comparator<Client>() {
//			public int compare(Client client1, Client client2) {
//				return -(client1.getName().compareTo(client2.getName()));
//			}
//		});
//		
//		for(Client client : clientsList) {
//            System.out.println(client.getName());
//        }
		
		
		List<Client> resultList = ClientFinder.findClients(clientsList, new Strategy() {

			@Override
			public boolean acceptClient(Client client) {
				return client.getName().startsWith("L");
			}
			
		});
		
		
		for(Client client : resultList) {
			System.out.print(client.getName() + ", ");
        }
		
		System.out.println();
		
		resultList = ClientFinder.findClients(clientsList, new Strategy() {

			@Override
			public boolean acceptClient(Client client) {
				return client.getGender().equals(Gender.MALE);
			}
			
		});
		
		
		for(Client client : resultList) {
			System.out.print(client.getName() + ", ");
        }
	}

}

