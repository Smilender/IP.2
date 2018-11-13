package huarongdao.entities;

public class Model
{
	Puzzle puzzle;
	
	public Model()
	{
		puzzle = new Puzzle();
	}
	
	public void initDefault()
	{
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
	}
	
	public void initWinState()
	{
		puzzle.addTile(new Tile(2, 1, 0, 0));
		puzzle.addTile(new Tile(2, 1, 0, 2));
		puzzle.addTile(new Tile(1, 1, 0, 4));
		puzzle.addTile(new Tile(1, 1, 1, 1));
		puzzle.addTile(new Tile(1, 2, 1, 2));
		puzzle.addTile(new Tile(2, 2, 1, 3));
		puzzle.addTile(new Tile(1, 1, 2, 1));
		puzzle.addTile(new Tile(2, 1, 3, 0));
		puzzle.addTile(new Tile(2, 1, 3, 2));
		puzzle.addTile(new Tile(1, 1, 3, 4));
	}
	
	public Puzzle getPuzzle()
	{
		return puzzle;
	}
	
}



//Tile(int height, int width, int xPos, int yPos)
