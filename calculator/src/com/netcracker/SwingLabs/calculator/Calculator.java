package com.netcracker.SwingLabs.calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Calculator extends JFrame{
	private JPanel buttonPanel;
	private JLabel display;
	private String operation;
	private JButton dot;
	private JButton sum;
	private JButton sub;
	private JButton mult;
	private JButton divide;
	private JButton calc;
	private JButton reboot;
	private ButtonGroup buttonGroup;
	private double firstOperand;
	private double result;
	private String s;
	private int valueLaF;
	private JRadioButton metal;
	private JRadioButton motif;
	private JRadioButton window;
	private boolean dotSetted=false;
	private int numberCounter=0;
	private boolean operationSetted=false;
	
	public Calculator(int width, int height) {
	
		this.setSize(width, height);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		display=new JLabel(" ");
		display.setFont(new Font("Arial", 0, 20));
		this.add(display,BorderLayout.PAGE_START);
		buttonPanel = new JPanel(new GridLayout(5,4));
		this.add(buttonPanel);
		NumberButtonListener inputNumberButtonListener=new NumberButtonListener();
		OperationButtonListener inputOperationButtonListener=new OperationButtonListener();
		for (int i=1; i<10; i++){
			addNumberButton(String.valueOf(i),inputNumberButtonListener);
		}
		addNumberButton("0",inputNumberButtonListener);
		
		dot=new JButton(".");
		dot.addActionListener(inputNumberButtonListener);
		buttonPanel.add(dot);
		reboot=new JButton("C");
		reboot.addActionListener(inputOperationButtonListener);
		buttonPanel.add(reboot);
		sum=new JButton("+");
		sum.addActionListener(inputOperationButtonListener);
		buttonPanel.add(sum);
		sub=new JButton("-");
		sub.addActionListener(inputOperationButtonListener);
		buttonPanel.add(sub);
		mult=new JButton("*");
		mult.addActionListener(inputOperationButtonListener);
		buttonPanel.add(mult);
		divide=new JButton("/");
		divide.addActionListener(inputOperationButtonListener);
		buttonPanel.add(divide);
		calc=new JButton("=");
		calc.addActionListener(new CalcListener());
		buttonPanel.add(calc);
		
		buttonGroup = new ButtonGroup();
		metal = new JRadioButton("metal");
		buttonPanel.add(metal);
		metal.addActionListener(new StyleChecherListener());
		motif = new JRadioButton("motif");
		buttonPanel.add(motif);
		motif.addActionListener(new StyleChecherListener());
		window = new JRadioButton("window");
		buttonPanel.add(window);
		window.addActionListener(new StyleChecherListener());
		window.setSelected(true);
		
		buttonGroup.add(metal);
		buttonGroup.add(motif);
		buttonGroup.add(window);
		
		
	
		
	}
	private void addNumberButton(String name, ActionListener listener){
		JButton numberButton=new JButton(name);
		numberButton.addActionListener(listener);
		buttonPanel.add(numberButton);
	}
	
	private void setLaF(int valueLaF){
		String s;
		switch (valueLaF) {
		case 0: s = "javax.swing.plaf.metal.MetalLookAndFeel";
		break;
		case 1: s = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		break;
		case 2: s = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		break;
		default: s = UIManager.getSystemLookAndFeelClassName();
		}
		try {
			UIManager.setLookAndFeel(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(getContentPane());
	}
	
	private class NumberButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if ( operationSetted==false&&numberCounter==0){
				display.setText(" ");
			}
			
			
		
				String inputNumber=e.getActionCommand();
				display.setText(display.getText()+inputNumber);
				numberCounter++;
				
				if(e.getSource().equals(dot)){
					dotSetted=true;
					
				}
			}
				
		}
		
	
	
	private class OperationButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (operationSetted==true){
				firstOperand=firstOperand;
			}
			else{
				firstOperand=Double.valueOf(display.getText());
			}
			
			if (e.getSource().equals(sum)){
				operation="+";

			}
			if (e.getSource().equals(sub)){
				operation="-";

			}
			if (e.getSource().equals(mult)){
				operation="*";

			}
			if (e.getSource().equals(divide)){
				operation="/";

			}
			if (e.getSource().equals(reboot)){
				display.setText(" ");

			}
			display.setText(" ");
			
			operationSetted=true;
		}
		
	}
	private class CalcListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (operation=="+"){
				result=firstOperand+Double.valueOf(display.getText());
				display.setText(String.valueOf(result));
			}
			if (operation=="-"){
				result=firstOperand-Double.valueOf(display.getText());
				display.setText(String.valueOf(result));
			}
			if (operation=="*"){
				result=firstOperand*Double.valueOf(display.getText());
				display.setText(String.valueOf(result));
			}
			if (operation=="/"){
				result=firstOperand/Double.valueOf(display.getText());
				display.setText(String.valueOf(result));
			}
			operationSetted=false;
			numberCounter=0;
		}
	}
	class StyleChecherListener implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (metal.isSelected()) {
               setLaF(0);
            } else {
                if (motif.isSelected()) {
                	 setLaF(1);
                } else {
                    if (window.isSelected()) {
                    	 setLaF(2);
                    }
                }
            }              
        }
	}
}
