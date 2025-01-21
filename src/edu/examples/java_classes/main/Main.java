package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ADD\ntitle=Книга\nсоntent=Пушкин. Записки Белкина";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ADD\ntitle=Книга\nсоntent=Лермонтов. Поэзия";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ADD\ntitle=Книга\nсоntent=Marvel. Комиксы";
		response = controller.doAction(request);
		System.out.println(response);

		request = "UPDATE\nid=2\ntitle=Книга\ncontent=Пушкин. Записки Белкина\ndate=2025-01-08";
		response = controller.doAction(request);
		System.out.println(response);
/*
		request = "FINDBYDATE\ndate=2025-01-08";
		response = controller.doAction(request);
		System.out.println(response);


		request = "FINDBYID\nid=2";
		response = controller.doAction(request);
		System.out.println(response);
*/
		request = "FINDBYContent\nid=2";
		response = controller.doAction(request);
		System.out.println(response);


	}

}
