package boundaries;

import javax.swing.JPanel;

import entities.Puzzle;
import entities.Tile;

import java.awt.Color;
import java.awt.Graphics;

public class BoardBoundary extends JPanel
{
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.\
	 */
	
	protected static int SIZE_TO_PIXELS = 120; //converts to 120px squares, which is the required size for a coordinate 5x4 system at 480x600px
	protected static int POSITION_TO_PIXELS = 120; //converts position to be based on 120px
	protected static int INTERTILE_GAP_SIZE_OFFSET = 10; //modifies the actual size of each tile such that there can be a 10 pixel gap between each piece
	protected static int INTERTILE_GAP_POSITION_OFFSET = 5; //modifies the actual position of each tile such that the gap in between pieces is even on every side.

	Puzzle puzzle;
	
	
	public BoardBoundary(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}
	
	
	//parse through Puzzle's Tiles, and do the following:
	//	get height and width, use constants to convert those into the size of the rectangle to construct
	//	get xPos and yPos, use constants to convert those into the position of the top-left corner of the rectangle to construct
	//	get the selected status of each tile, and determine the color it should be painted accordingly
	//construct a rectangle for each instance in Tiles, using those Tile attributes, to be printed to the screen.
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(Tile tile: puzzle.getTiles())
		{
			if (tile.isWinPiece())
			{
				if (tile.isSelected())
				{
					g.setColor(Color.orange);
				} else
				{
				g.setColor(Color.red);
				}
			} else
			{
				if (tile.isSelected())
				{
					g.setColor(Color.lightGray);
				} else
				{
					g.setColor(Color.darkGray);
				}
			}
			g.fillRect((tile.getXPos()*POSITION_TO_PIXELS) + INTERTILE_GAP_POSITION_OFFSET, 
						(tile.getYPos()*POSITION_TO_PIXELS) + INTERTILE_GAP_POSITION_OFFSET,
						(tile.getWidth()*SIZE_TO_PIXELS) - INTERTILE_GAP_SIZE_OFFSET,
						(tile.getHeight()*SIZE_TO_PIXELS) - INTERTILE_GAP_SIZE_OFFSET);
		}
	}
	
	//getters.  no setters, as these are supposed to be constants
	public int getSIZE_TO_PIXELS()
	{
		return SIZE_TO_PIXELS;
	}
	
	public int getPOSITION_TO_PIXELS()
	{
		return POSITION_TO_PIXELS;
	}
	
	public int getINTERTILE_GAP_SIZE_OFFSET()
	{
		return INTERTILE_GAP_SIZE_OFFSET;
	}
	
	public int getINTERTILE_GAP_POSITION_OFFSET()
	{
		return INTERTILE_GAP_POSITION_OFFSET;
	}
}
