package test.huarondao.controllers;

import java.awt.Point;

import huarongdao.boundaries.HuarongDaoApp;
import huarongdao.controllers.PuzzleController;
import huarongdao.entities.Model;
import huarongdao.entities.Puzzle;
import huarongdao.entities.Tile;
import junit.framework.TestCase;

public class PuzzleControllerTest extends TestCase
{
	Point point;
	Model model;
	Puzzle puzzle;
	HuarongDaoApp app;
	PuzzleController puzzleControl;
	
	char[][] postValidLeftMovePositions = {{'*', '*', '*', '*', '*'},
											{'*', '*', '*', '*', '*'},
											{'*', '*', '*', '*', ' '},
											{'*', '*', '*', '*', ' '}};
	
	char[][] defaultTilePositions = {{'*', '*', '*', '*', ' '},
											{'*', '*', '*', '*', '*'},
											{'*', '*', '*', '*', '*'},
											{'*', '*', '*', '*', ' '}};
	char[][] postValidDownMovePositions = {{'*', '*', ' ', '*', '*'},
											{'*', '*', '*', '*', '*'},
											{'*', '*', '*', '*', '*'},
											{'*', '*', '*', '*', ' '}};
	
	public void testInit()
	{
		point = new Point();
		point.setLocation(199, 96);
		model = new Model();
		puzzle = new Puzzle();
		app = new HuarongDaoApp(puzzle, model);
		puzzleControl = new PuzzleController(puzzle, app);
		
		puzzle.addTile(new Tile(2, 1, 0, 0));
		puzzle.addTile(new Tile(2, 1, 0, 2)); //tile for correct up/down move testing
		puzzle.addTile(new Tile(2, 2, 1, 0));
		puzzle.addTile(new Tile(1, 1, 1, 2));
		puzzle.addTile(new Tile(1, 1, 1, 3));
		puzzle.addTile(new Tile(1, 2, 1, 4)); //tile for correct left/right move testing
		puzzle.addTile(new Tile(1, 1, 2, 2));
		puzzle.addTile(new Tile(1, 1, 2, 3));
		puzzle.addTile(new Tile(2, 1, 3, 0));
		puzzle.addTile(new Tile(2, 1, 3, 2));
	}
	public void testPieceSelection()
	{
		testInit();
		
		puzzleControl.selectTile(point);
		assertTrue(puzzleControl.getPuzzle().hasSelectedTile());
		
	}
	
	public void testMoveTile()
	{
		testInit();
		//valid left move
		puzzleControl.moveTile(puzzle.getTiles().get(5), 'l');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(postValidLeftMovePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//invalid left moves
		puzzleControl.moveTile(puzzle.getTiles().get(5), 'l');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(postValidLeftMovePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		puzzleControl.moveTile(puzzle.getTiles().get(2), 'l');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(postValidLeftMovePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//valid right move
		puzzleControl.moveTile(puzzle.getTiles().get(5), 'r');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(defaultTilePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//invalid right moves
		puzzleControl.moveTile(puzzle.getTiles().get(8), 'r');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(defaultTilePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		puzzleControl.moveTile(puzzle.getTiles().get(0), 'r');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(defaultTilePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//valid down move
		puzzleControl.moveTile(puzzle.getTiles().get(1), 'd');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(postValidDownMovePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//invalid down moves
		puzzleControl.moveTile(puzzle.getTiles().get(1), 'd');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(postValidDownMovePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		puzzleControl.moveTile(puzzle.getTiles().get(2), 'd');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(postValidDownMovePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//valid up move
		puzzleControl.moveTile(puzzle.getTiles().get(1), 'u');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(defaultTilePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		//invalid up moves
		puzzleControl.moveTile(puzzle.getTiles().get(1), 'u');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(defaultTilePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
		puzzleControl.moveTile(puzzle.getTiles().get(0), 'u');
		puzzleControl.getPuzzle().parseTileLocations();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				assertEquals(defaultTilePositions[i][j], puzzleControl.getPuzzle().getTileLocations()[i][j]);
			}
		}
	}
}
