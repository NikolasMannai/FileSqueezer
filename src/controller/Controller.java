package controller;

import gui.Graphics;

public class Controller {
	Controller controller; 
	public static void main(String[] args) {
		Controller controller = new Controller();
	}
	
	Controller() {
		this.controller = this;
		Graphics mainFrame = new Graphics(this);
		mainFrame.setVisible(true);
	}
	
	public void controllerEncode() {
		
	}
	
	public void controllerDecode() {
		
	}
}
