package gui;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Controller;

public class Graphics extends JFrame {
	private Controller controller;
	private final String FRAME_TITLE = "FileSqueezer";
	private final String BTN_ENCODE_TEXT = "RUN";
	//	private final String BTN_DECODE_TEXT = "Decode";
	/**
	 * Creates graphics. Takes in controller for reference.
	 * @param Controller
	 */
	public Graphics(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(2, 1));
		this.add(container);
		JButton btnEncode = new JButton(BTN_ENCODE_TEXT);
		container.add(new JLabel());
		container.add(btnEncode);
		btnEncode.addActionListener(e -> {
			try {
				encode();
			} catch (IOException e1) {
			}
		});
		this.setResizable(false);
		this.setTitle(FRAME_TITLE);
		this.setSize(400, 200);
		this.setVisible(true);
	}
	/**
	 * Opens JFileChooser. Sends selected file to the controller for encoding. 
	 * @throws IOException
	 */
	private void encode() throws IOException {
		controller.run(getFile());
	}
	/**
	 * Returns filepath of a selected file. If no file selected returns null
	 * @return String filepath. If no file is selected then returns null
	 */
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
