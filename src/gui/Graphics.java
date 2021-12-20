package gui;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controller.Controller;

public class Graphics extends JFrame{
	private Controller controller;
	public Graphics(Controller controller) {
		this.controller = controller; 
		initComponents();
	}
	
	private void initComponents() {
		JButton btnEncode = new JButton();
		JButton btnDecode = new JButton(); 
		
		this.add(btnEncode);
		this.add(btnDecode);
		
		btnEncode.addActionListener(e -> encode());
		btnDecode.addActionListener(e -> decode());
	}
	
	private void encode() {
		
	}
	
	private void decode() {
		
	}
}
