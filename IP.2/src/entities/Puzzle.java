package entities;

import java.util.ArrayList;

public class Puzzle
{
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	protected Tile selectedTile;
	
	public Puzzle()
	{
		
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
	
	
	//getters and setters
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	public void setTiles(ArrayList<Tile> t)
	{
		tiles = t;
	}
	/*
	public Tile getSelected()
	{
		return selectedTile;
	}*/
	
	public void setSelected(Tile t)
	{
		selectedTile = t;
		t.isSelected = true;
	}
}
