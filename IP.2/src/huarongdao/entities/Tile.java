package huarongdao.entities;

public class Tile
{
	@SuppressWarnings("unused")
	private int height;
	@SuppressWarnings("unused")
	private int width;
	
	//xPos and yPos represent the current x and y position of the top-left corner of the tile
	protected int xPos;
	protected int yPos;
	
	protected boolean isWinPiece;
	protected boolean isSelected;
	
	public Tile(int height, int width, int xPos, int yPos)
	{
		this.height = height;
		this.width = width;
		this.xPos = xPos;
		this.yPos = yPos;
		this.isWinPiece = (width == 2 && height == 2);
	}
	
	//Getters and Setters
	public int getXPos()
	{
		return xPos;
	}
	
	public void setXPos(int i)
	{
		xPos = i;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public void setYPos(int i)
	{
		yPos = i;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public boolean isWinPiece()
	{
		return isWinPiece;
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}
	
	public void select()
	{
		isSelected = true;
	}
	
	public void deselect()
	{
		isSelected = false;
	}
}
