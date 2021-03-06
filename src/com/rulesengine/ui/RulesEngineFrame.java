package com.rulesengine.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.rulesengine.controller.RulesEngine;
import com.rulesengine.loader.CSVLoader;
import com.rulesengine.loader.JSONLoader;
import com.rulesengine.loader.Loader;
import com.rulesengine.model.Person;
import com.rulesengine.model.Product;
import com.rulesengine.model.Rule;

public class RulesEngineFrame extends JFrame {
	
	private JPanel locationPanel = new JPanel();	
	private JLabel locationLabel = new JLabel("Location: ");
	private JTextField locationTextField = new JTextField();
	private JButton browseButton = new JButton();
	private JFileChooser fileChooser = new JFileChooser();
	private JButton runButton = new JButton("Run");
	private JTextArea resultArea = new JTextArea();
	
	private RulesEngine rulesEngine = new RulesEngine();
	private ArrayList<Rule> ruleList;
		
	public RulesEngineFrame() {
		
		setSize(500, 500);		
		setLayout(new BorderLayout());
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);				
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

		});
		
		add(locationPanel, BorderLayout.NORTH);
		locationPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		locationPanel.setLayout(new FlowLayout());
		locationPanel.add(locationLabel);
		locationPanel.add(locationTextField);
		locationTextField.setColumns(18);
		locationTextField.setEditable(false);
		locationPanel.add(browseButton);
		browseButton.setText("...");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int returnValue = fileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					
					File file = fileChooser.getSelectedFile();
					String path = file.getAbsolutePath();
					locationTextField.setText(path);
					
					ruleList = loadRules(file);
					
					runButton.setEnabled(true);
					
				}
				
			}
			
		});
		
		locationPanel.add(runButton);
		runButton.setEnabled(false);
		runButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				resultArea.setText("");
				
				Person person = new Person(720, "Florida");
				Product product = new Product("7-1 ARM", 5.0, false);
				
				resultArea.append("Inputs\n");
				resultArea.append("=====\n");
				resultArea.append(person.toString() + "\n");
				resultArea.append(product.toString() + "\n");				
				resultArea.append("\n");
				
				rulesEngine.runRules(person, product, ruleList);
				
				resultArea.append("Output\n");
				resultArea.append("======\n");
				resultArea.append(person.toString() + "\n");
				resultArea.append(product.toString() + "\n");
				
			}
			
		});		
		add(resultArea, BorderLayout.CENTER);
				
	}
	
	private ArrayList<Rule> loadRules(File file) {
		
		try {
			
			if (file.getName().endsWith(".csv")) {
				
				Loader loader = new CSVLoader();
				return loader.load(file);
				
			}
			else if (file.getName().endsWith(".json")) {
				
				Loader loader = new JSONLoader();
				return loader.load(file);
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Rule>();
		
	}

	public static void main(String[] args) {

		RulesEngineFrame rulesEngine = new RulesEngineFrame();
		rulesEngine.setVisible(true);

	}

}
