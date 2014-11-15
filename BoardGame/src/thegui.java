import java.awt.*;
import javax.swing.*;

public class thegui extends JFrame{
	private Board board;
	private JFrame frame;
	private JPanel[][] squares;

	public thegui (Board b, JFrame f) {

	
		
		board = b;
		frame = f;
		squares = new JPanel[7][7];
		
	}
	
	public void initSquares () {
		for(int i = 0; i<squares.length; i++)
			for(int j = 0; j<squares[i].length; j++)
			{
				squares[i][j] = new JPanel();
				squares[i][j].setBackground(Color.BLACK);

			}
	}
	
	public void updateSquares(int[][] colors) {
		for(int i = 0; i<colors.length; i++)
			for(int j = 0; j<colors[i].length; j++)
			{
				if(colors[i][j] == 0)
					squares[i][j].setBackground(Color.WHITE);
				else if(colors[i][j] == 1)
					squares[i][j].setBackground(Color.RED);
				else if(colors[i][j] == 2)
					squares[i][j].setBackground(Color.GREEN);
			}
	}
	
	public void initFrame(){
				
		frame.setSize(700,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBackground(Color.PINK);

		JButton restart = new JButton("Restart");
		restart.setLocation(275, 650);
		restart.setBorderPainted(true);
		restart.setBackground(Color.BLUE);
		restart.setSize(new Dimension(150, 30));
		restart.setForeground(Color.BLACK);
		frame.getContentPane().add(restart);
		
		JButton[] columns = new JButton[7];
		ImageIcon arrow = new ImageIcon("C:/Users/Claire/Desktop/arrow.jpg");
		
		for(int j = 0; j<squares.length; j++)
		{
			columns[j] = new JButton(arrow);
			columns[j].setSize(new Dimension(40,48));
			columns[j].setLocation(170+52*j,120);
			frame.getContentPane().add(columns[j]);
			
			for(int i = 0; i<squares[j].length; i++)
			{
				squares[i][j].setSize(new Dimension(50,50));
				squares[i][j].setLocation(165+52*i, 170+52*j);
				frame.getContentPane().add(squares[i][j]);
			}
		}
		
		ImageIcon rightArrow = new ImageIcon("C:/Users/Claire/Desktop/clockwise.jpg");
		JButton clockwise = new JButton (rightArrow);
		clockwise.setSize(new Dimension(120, 96));
		clockwise.setLocation(412, 620);
		
	
		
	}


	
	

}
