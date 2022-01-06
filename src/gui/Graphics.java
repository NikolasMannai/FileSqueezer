package gui;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		JButton btnEncode = new JButton(BTN_ENCODE_TEXT);
		JButton btnDecode = new JButton(BTN_DECODE_TEXT);
		container.add(new JLabel());
		container.add(new JLabel());
		container.add(btnEncode);
		container.add(btnDecode);
		btnEncode.addActionListener(e -> {
			try {
				encode();
			} catch (IOException e1) {
			}
		});
		btnDecode.addActionListener(e -> decode());
		this.setResizable(false);
		this.setTitle(FRAME_TITLE);
		this.setSize(400, 200);
		this.setVisible(true);
	}

	private void encode() throws IOException {
		controller.encode(getFile());
	}

	private void decode() {
		controller.decode(getFile());
	}

	private String getFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		int response = fileChooser.showOpenDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			if (response == JFileChooser.APPROVE_OPTION) {
				return fileChooser.getSelectedFile().getAbsolutePath().toString();
			}
		}
		return null;
	}
}
