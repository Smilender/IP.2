package huarongdao.entities;

import java.util.ArrayList;

public class Puzzle
{
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	protected Tile selectedTile;
	protected char[][] tileLocations;
	protected int numMoves;
	
	public Puzzle()
	{
		tileLocations = new char[4][5];
		numMoves = 0;
	}
	
	
	//takes in an instantiated Tile object, checks if it can fit in the board as the existing pieces are currently situated,
	//	and adds the new Tile to the Puzzle's board
	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	
	//returns true if there exists a selectedTile (selectedTile is not null), false otherwise
	public boolean hasSelectedTile()
	{
		return (selectedTile != null);
	}
	
	public void deselectAll()
	{
		selectedTile = null;
		for (Tile tile: tiles)
		{
			tile.deselect();
		}
	}
	
	public void parseTileLocations()
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				tileLocations[i][j] = ' ';
			}
		}
		for (Tile tile: tiles)
		{
			for (int i = tile.getXPos(); i < tile.getXPos() + tile.getWidth(); i++)
			{
				for (int j = tile.getYPos(); j < tile.getYPos() + tile.getHeight(); j++)
				{
					tileLocations[i][j] = '*';
				}
			}
		}
	}
	
	//getters and setters
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	public void setTiles(ArrayList<Tile> t)
	{
		tiles = t;
	}
	
	public char[][] getTileLocations()
	{
		return tileLocations;
	}

	
	public void setSelected(Tile t)
	{
		selectedTile = t;
		t.isSelected = true;
	}
	
	public Tile getSelected()
	{
		Tile selectedTile = null;
		for(Tile tile: tiles)
		{
			if(tile.isSelected())
			{
				selectedTile = tile;
			}
		}
		return selectedTile;
	}
	
	public int getNumMoves()
	{
		return numMoves;
	}
	
	public void setNumMoves(int i)
	{
		numMoves = i;
	}
}
