package main;

import huarongdao.boundaries.HuarongDaoApp;
import huarongdao.entities.Model;
import huarongdao.entities.Puzzle;

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
