package controllers;

import java.awt.Point;

import boundaries.HuarongDaoApp;
import entities.Puzzle;
import entities.Tile;

public class PuzzleController {

	Puzzle puzzle;
	HuarongDaoApp app;
	char[][] topLeftPos;
	
	public PuzzleController(Puzzle puzzle, HuarongDaoApp app)
	{
		this.puzzle = puzzle;
		this.app = app;
	}
	
	public void selectTile(Point point)
	{
		puzzle.deselectAll();
		for(Tile tile: puzzle.getTiles())
		{			
			if ((point.getX() > (tile.getXPos()*app.getBoard().getPOSITION_TO_PIXELS()) + app.getBoard().getINTERTILE_GAP_POSITION_OFFSET())
					&& (point.getX() < ((tile.getXPos()*app.getBoard().getPOSITION_TO_PIXELS()) - app.getBoard().getINTERTILE_GAP_POSITION_OFFSET()) + (tile.getWidth()*app.getBoard().getSIZE_TO_PIXELS()))
					&& (point.getY() > (tile.getYPos()*app.getBoard().getPOSITION_TO_PIXELS()) + app.getBoard().getINTERTILE_GAP_POSITION_OFFSET())
					&& (point.getY() < (tile.getYPos()*app.getBoard().getPOSITION_TO_PIXELS()) + (tile.getHeight()*app.getBoard().getSIZE_TO_PIXELS() - app.getBoard().getINTERTILE_GAP_POSITION_OFFSET())))
			{
				tile.select();
				break;
			}
		}
		app.getBoard().repaint();
	}
}
