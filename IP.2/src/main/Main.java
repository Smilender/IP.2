package main;

import boundaries.HuarongDaoApp;
import entities.Model;
import entities.Puzzle;

public class Main
{
	public static void main(String[] args)
	{
		Model model = new Model();
		model.initDefault();
		Puzzle puzzle = model.getPuzzle();
		HuarongDaoApp app = new HuarongDaoApp(puzzle, model);
		
		app.setVisible(true);
	}
}
