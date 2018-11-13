package huarongdao.controllers;

import java.awt.Point;

import javax.swing.JOptionPane;

import huarongdao.boundaries.HuarongDaoApp;
import huarongdao.entities.Model;
import huarongdao.entities.Puzzle;
import huarongdao.entities.Tile;

public class PuzzleController {

	protected Puzzle puzzle;
	protected HuarongDaoApp app;
	
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
	
	//takes a Tile and a direction (a char of 'u', 'l', 'd', or 'r'), checks if there is a Tile occupying the space that
	//	the input tile would occupy if moved in that direction.  If there is nothing, the Tile moves position to that new
	//	location, else; nothing happens.
	public void moveTile(Tile tile, char direction)
	{
		puzzle.parseTileLocations();
		boolean canMove = false;
		switch(direction)
		{
			//direction up
			case 'u':
				if (tile.getYPos() == 0)
				{
					canMove = false;
				}
				else
				{
					for(int i = 0; i < tile.getWidth(); i++)
					{
						if (puzzle.getTileLocations()[tile.getXPos() + i][tile.getYPos() - 1] == '*')
						{
							canMove = false;
							break; //could maybe cause problems
						}
						else
						{
							canMove = true;
						}
					}
				}
				if(canMove)
				{
					tile.setYPos(tile.getYPos() - 1);
					puzzle.setNumMoves(puzzle.getNumMoves() + 1);
					System.out.println(puzzle.getNumMoves());
				}
				break;
			//direction left
			case 'l':
				if (tile.getXPos() == 0)
				{
					canMove = false;
				}
				else
				{
					for(int i = 0; i < tile.getHeight(); i++)
					{
						if (puzzle.getTileLocations()[tile.getXPos() - 1][tile.getYPos() + i] == '*')
						{
							canMove = false;
							break; //could maybe cause problems
						}
						else
						{
							canMove = true;
						}
					}
				}
				if(canMove)
				{
					tile.setXPos(tile.getXPos() - 1);
					puzzle.setNumMoves(puzzle.getNumMoves() + 1);
					System.out.println(puzzle.getNumMoves());
				}
				break;
			//direction down
			case 'd':
				//win condition
				if (tile.isWinPiece() && tile.getXPos() == 1 && tile.getYPos() == 3)
				{
					JOptionPane.showMessageDialog(app, "You did it in " + String.valueOf(puzzle.getNumMoves()) + " moves!  Congratulations!",
							"You win!", 
							JOptionPane.INFORMATION_MESSAGE);
					
				} else if ((tile.getYPos() + tile.getHeight() - 1) >= 4) //minus 1 to account for the difference between height starting at 1, and yPos starting at 0.  4 is maximum index for yPos on a 4x5 board.
				{
					canMove = false;
				}
				else
				{
					for(int i = 0; i < tile.getWidth(); i++)
					{
						if (puzzle.getTileLocations()[tile.getXPos() + i][tile.getYPos() + tile.getHeight()] == '*')
						{
							canMove = false;
							break; //could maybe cause problems
						}
						else
						{
							canMove = true;
						}
					}
				}
				if(canMove)
				{
					tile.setYPos(tile.getYPos() + 1);
					puzzle.setNumMoves(puzzle.getNumMoves() + 1);
					System.out.println(puzzle.getNumMoves());
				}
				break;
			//direction right
			case 'r':
				if ((tile.getXPos() + tile.getWidth() - 1) >= 3) //minus 1 to account for the difference between height starting at 1, and yPos starting at 0.  3 is the maximum index for xPos on a 4x5 board.
				{
					canMove = false;
				}
				else
				{
					for(int i = 0; i < tile.getHeight(); i++)
					{
						if (puzzle.getTileLocations()[tile.getXPos() + tile.getWidth()][tile.getYPos() + i] == '*')
						{
							canMove = false;
							break; //could maybe cause problems
						}
						else
						{
							canMove = true;
						}
					}
				}
				if(canMove)
				{
					tile.setXPos(tile.getXPos() + 1);
					puzzle.setNumMoves(puzzle.getNumMoves() + 1);
					System.out.println(puzzle.getNumMoves());
				}
				break;
			default:
				System.out.println("moveTile(Tile tile, char direction); invalid direction!");
				break;
		}
	}
	
	//clears the board, and puts each tile in it's default location, based on the input model
	public void resetPuzzle(Model model)
	{
		puzzle.setNumMoves(0);
		puzzle.getTiles().clear();
		model.initDefault();
	}
	
	//getters and setters
	public Puzzle getPuzzle()
	{
		return puzzle;
	}
	
	public void setPuzzle(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
}
