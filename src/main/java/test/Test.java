package test;

import javax.swing.UIManager;

import view.QLHHView;



public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLHHView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
