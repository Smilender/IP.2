package huarongdao.controllers;

import javax.swing.JOptionPane;

import huarongdao.boundaries.HuarongDaoApp;

public class HelpController
{
	HuarongDaoApp app;
	
	public HelpController(HuarongDaoApp app)
	{
		this.app = app;
	}
	
	public void help()
	{
		JOptionPane.showMessageDialog(app, "<html>Welcome to Huarong Dao!  This is a very old game of uncertain origin, known in English as \"Klotski\", in French as \"L'âne Rouge\",\n"
											+ "and in Japanese as \"Hakoiri Musume\".  It is a simple game, with a simple objective: to remove the red two-by-two tile from the board by sliding\n"
											+ "it out of the centre of the bottom of the board.  You can do this by clicking on a tile to select it, and then clicking on the arrow buttons in\n"
											+ "the bottom-left-hand corner of the screen to move each block the appropriate direction", 
											"Help", 
											JOptionPane.INFORMATION_MESSAGE);
	}
}