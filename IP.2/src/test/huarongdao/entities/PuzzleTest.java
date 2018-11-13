package test.huarongdao.entities;

import huarongdao.entities.Puzzle;
import huarongdao.entities.Tile;
import junit.framework.TestCase;

public class PuzzleTest extends TestCase
{
	char[][] knownTileLocations = {{'*', '*', '*', '*', ' '},
									{'*', '*', '*', '*', '*'},
									{'*', '*', '*', '*', '*'},
									{'*', '*', '*', '*', ' '}};
	
	public void testPuzzleConstructor()
	{
		Puzzle puzzle = new Puzzle();
		puzzle.addTile(new Tile(2, 1, 0, 0));
		puzzle.addTile(new Tile(2, 1, 0, 2));
		puzzle.addTile(new Tile(2, 2, 1, 0));
		puzzle.addTile(new Tile(1, 1, 1, 2));
		puzzle.addTile(new Tile(1, 1, 1, 3));
		puzzle.addTile(new Tile(1, 2, 1, 4));
		puzzle.addTile(new Tile(1, 1, 2, 2));
		puzzle.addTile(new Tile(1, 1, 2, 3));
		puzzle.addTile(new Tile(2, 1, 3, 0));
		puzzle.addTile(new Tile(2, 1, 3, 2));
		
		puzzle.parseTileLocations();
		
		assertEquals(0, puzzle.getNumMoves());
		assertEquals(knownTileLocations.length, puzzle.getTileLocations().length);
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(knownTileLocations[i][j], puzzle.getTileLocations()[i][j]);
			}
		}
	}
	
	public void testSelected()
	{
		Puzzle puzzle = new Puzzle();
		puzzle.addTile(new Tile(2, 1, 0, 0));
		puzzle.addTile(new Tile(2, 1, 0, 2));
		
		assertFalse(puzzle.hasSelectedTile());
		
		puzzle.setSelected(puzzle.getTiles().get(1));
		
		assertTrue(puzzle.hasSelectedTile());
		assertEquals(puzzle.getSelected(), puzzle.getTiles().get(1));
		
		puzzle.deselectAll();
		
		assertFalse(puzzle.hasSelectedTile());
	}
	
	public void testNumMoves()
	{
		
	}
}
