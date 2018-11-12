package boundaries;

import javax.swing.JFrame;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.PuzzleController;
import entities.Puzzle;

@SuppressWarnings({ "serial", "unused" })
public class HuarongDaoApp extends JFrame{

	public static int BOARD_X_POS = 501;
	public static int BOARD_Y_POS = 12;
	public static int BOARD_X_SIZE = 480;
	public static int BOARD_Y_SIZE = 600;
	
	protected PuzzleController puzzleControl;
	public JFrame frame;
	protected BoardBoundary board;
	protected int numMoves;
	Puzzle puzzle;
	private JPanel contents;
	
	
	//Constructor
	public HuarongDaoApp(Puzzle puzzle)
	{
		this.puzzle = puzzle;
		this.board = new BoardBoundary(puzzle);
		this.puzzleControl = new PuzzleController(puzzle, this);
		numMoves = 0; //need to actually get this number from the puzzle object
		
		// initialize everything that is drawn to the screen
		setBounds(200, 200, 1280, 720);
		setTitle("Huarong Dao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contents = new JPanel();
		contents.setBorder(new EmptyBorder(5, 5, 5, 5));
		contents.setLayout(null);
		setContentPane(contents);
		
		JButton resetButton = new JButton("Reset Puzzle");
		resetButton.setBounds(12, 12, 200, 70);
		contents.add(resetButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.setBounds(12, 101, 200, 70);
		contents.add(helpButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(12, 186, 200, 70);
		contents.add(quitButton);
		
		JLabel numMovesTitle = new JLabel("Number of Moves:");
		numMovesTitle.setBounds(12, 280, 140, 70);
		contents.add(numMovesTitle);
		
		
		JLabel numMovesVarPrint = new JLabel("0"); //need to actually use the numMoves variable from above
		numMovesVarPrint.setBounds(156, 280, 56, 70);
		contents.add(numMovesVarPrint);
		
		JButton upButton = new JButton("^");
		upButton.setBounds(87, 505, 70, 70);
		upButton.addActionListener(new ActionListener()
									{
										@Override
										public void actionPerformed(ActionEvent e) {
											puzzleControl.moveTile(puzzle.getSelected(), 'u');
											board.repaint();
										}
									});
		contents.add(upButton);
		
		JButton leftButton = new JButton("<");
		leftButton.setBounds(12, 580, 70, 70);
		leftButton.addActionListener(new ActionListener()
										{
											@Override
											public void actionPerformed(ActionEvent e) {
												puzzleControl.moveTile(puzzle.getSelected(), 'l');
												board.repaint();
											}
										});
		contents.add(leftButton);
		
		JButton downButton = new JButton("v");
		downButton.setBounds(87, 580, 70, 70);
		downButton.addActionListener(new ActionListener()
									{
										@Override
										public void actionPerformed(ActionEvent e) {
											puzzleControl.moveTile(puzzle.getSelected(), 'd');
											board.repaint();
										}
									});
		contents.add(downButton);
		
		JButton rightButton = new JButton(">");
		rightButton.setBounds(162, 580, 70, 70);
		rightButton.addActionListener(new ActionListener()
									{
										@Override
										public void actionPerformed(ActionEvent e) {
											puzzleControl.moveTile(puzzle.getSelected(), 'r');
											board.repaint();
										}
									});
		contents.add(rightButton);
		
		board.setBounds(BOARD_X_POS, BOARD_Y_POS, BOARD_X_SIZE, BOARD_Y_SIZE);
		contents.add(board);
		
		board.addMouseListener(new MouseAdapter()
									{
										@Override
										public void mouseClicked(MouseEvent mouse)
										{
											puzzleControl.selectTile(mouse.getPoint());
										}
									});
	}
	
	public BoardBoundary getBoard()
	{
		return board;
	}
}
