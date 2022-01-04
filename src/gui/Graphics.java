package gui;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class Graphics extends JFrame {
	private Controller controller;
	private final String FRAME_TITLE = "FileSqueezer";
	private final String BTN_ENCODE_TEXT = "Encode";
	private final String BTN_DECODE_TEXT = "Decode";

	public Graphics(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(2, 2));
		this.add(container);
		JLabel emptyFrame1 = new JLabel();
		JLabel emptyFrame2 = new JLabel();
		JButton btnEncode = new JButton(BTN_ENCODE_TEXT);
		JButton btnDecode = new JButton(BTN_DECODE_TEXT);
		container.add(emptyFrame1);
		container.add(emptyFrame2);
		container.add(btnEncode);
		container.add(btnDecode);
		btnEncode.addActionListener(e -> encode());
		btnDecode.addActionListener(e -> decode());
		this.setResizable(false);
		this.setTitle(FRAME_TITLE);
		this.setSize(400, 200);
		this.setVisible(true);
	}

	private void encode() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		int response = fileChooser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			//TODO
		}
	}

	private void decode() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		int response = fileChooser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			//TODO
		}
	}
}