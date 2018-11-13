package test.huarongdao.entities;

import huarongdao.entities.Tile;
import junit.framework.TestCase;

public class TileTest extends TestCase
{
	protected final int HEIGHT = 2;
	protected final int WIDTH = 1;
	protected final int X_POS = 2;
	protected final int Y_POS = 1;
	public void testTileConstructor()
	{
		Tile tile = new Tile(HEIGHT, WIDTH, X_POS, Y_POS);
		Tile tile2 = new Tile(2, 2, 3, 2);
		Tile tile3 = new Tile(3, 2, 3, 2);
		
		assertEquals(HEIGHT, tile.getHeight());
		assertEquals(WIDTH, tile.getWidth());
		assertEquals(X_POS, tile.getXPos());
		assertEquals(Y_POS, tile.getYPos());
		
		assertFalse(tile.isWinPiece());
		assertTrue(tile2.isWinPiece());	
		assertFalse(tile3.isWinPiece());
		
		tile.select();
		assertTrue(tile.isSelected());
	}
}
