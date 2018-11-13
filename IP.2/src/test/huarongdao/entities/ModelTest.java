package test.huarongdao.entities;

import huarongdao.entities.Model;
import junit.framework.TestCase;

public class ModelTest extends TestCase
{
	public void testModelDefInit()
	{
		Model model = new Model();
		
		model.initDefault();
		
		assertEquals(model.getPuzzle().getTiles().size(), 10);
	}
	
	public void testModelWinCondInit()
	{
		Model model = new Model();
		
		model.initWinState();
		
		assertEquals(model.getPuzzle().getTiles().size(), 10);
	}
}
