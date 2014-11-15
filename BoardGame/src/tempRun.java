import javax.swing.*;

public class tempRun {

	public static void main(String[] args) {
		
		Board b = new Board(true);
		JFrame f = new JFrame();
		int[][] colors = new int[7][7];
		for(int i=0; i<7;i++)
			for(int j=0; j<7; j++)
				colors[i][j] = 0;
		
		thegui gui = new thegui(b, f);
		gui.initSquares();
		gui.initFrame();
		
		

	}

}
