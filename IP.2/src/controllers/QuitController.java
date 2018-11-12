package controllers;

import javax.swing.JOptionPane;

import boundaries.HuarongDaoApp;


//Controller for the quitting of the game

public class QuitController 
{
	HuarongDaoApp app;
	
	public QuitController(HuarongDaoApp app)
	{
		this.app = app;
	}
	
	public void quit()
	{
		int c = JOptionPane.showConfirmDialog(app, "Are you sure you want to quit?  You will lose all progress!");
		if (c == JOptionPane.OK_OPTION)
		{
			app.setVisible(false);
			app.dispose();
		}
	}
}
