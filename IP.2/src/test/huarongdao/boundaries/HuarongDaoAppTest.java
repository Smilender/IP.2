package test.huarongdao.boundaries;

import java.util.concurrent.TimeUnit;

import huarongdao.boundaries.HuarongDaoApp;
import huarongdao.entities.Model;
import huarongdao.entities.Puzzle;
import junit.framework.TestCase;


public class HuarongDaoAppTest extends TestCase
{	
	//if it doesn't crash, that's a successful test
	public void testPrintScreen()
	{
		Model model = new Model();
		Puzzle puzzle = new Puzzle();
		HuarongDaoApp app = new HuarongDaoApp(puzzle, model);
		app.setVisible(true);
		app.getBoard();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
	}
	
	//public void 
}
