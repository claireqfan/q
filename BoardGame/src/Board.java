public class Board {
	//fields
	private int[][] grid;
	private Tile[] tileAt;
	private final int HOR;
	private final int VERT;
	private boolean gravity;
	private Direction fallDirection;

	//constructors
	/**
	 * Default constructor creates a Board sized 4x4
	 * @param g
	 */
	public Board(boolean g)
	{
		this(4,4, g);
	}
	
	/**
	 * Constructor creates Board v by h
	 * @param v
	 * @param h
	 * @param g
	 */
	public Board(int v, int h, boolean g)
	{
		grid  = new int[VERT = v][HOR = h];
		tileAt = new Tile[VERT * HOR];
		gravity = g;
		fallDirection = Direction.SOUTH;
		int count = 0;
		for (int i = 0; i < VERT; i++)
		{
			for (int j = 0; j < HOR; j++)
			{
				tileAt[grid[i][j] = count++] = new Tile(i,j,0);
			}
		}
	}

	//accessors
	public String toString()
	{
		String out = "";
		switch (fallDirection)
		{
		case SOUTH:
			for (int i = 0; i < VERT; i++)
			{
				for (int j = 0; j < HOR; j++)
				{
					out += tileAt(i,j);
				}
				out += "\n";
			}
			break;
		case NORTH:
			for (int i = 0; i < VERT; i++)
			{
				for (int j = 0; j < HOR; j++)
				{
					out += tileAt(VERT - i - 1,HOR - 1 - j);
				}
				out += "\n";
			}
			break;
		case EAST:
			for (int j = 0; j < HOR; j++)
			{
				for (int i = 0; i < VERT; i++)
				{
					out += tileAt(VERT - 1 - i,j);
				}
				out += "\n";
			}
			break;
		case WEST:
			for (int j = 0; j < HOR; j++)
			{
				for (int i = 0; i < VERT; i++)
				{
					out += tileAt(i,HOR - 1 - j);
				}
				out += "\n";
			}
		}
		return out;
	}
	public boolean getGravity()
	{
		return gravity;
	}
	public Direction getFallDirection()
	{
		return fallDirection;
	}
	public int getHor()
	{
		return HOR;
	}
	public int getVert()
	{
		return VERT;
	}
	public Tile tileAt(int row, int col)
	{
		return tileAt[grid[row][col]];
	}
	public int valAt(int row, int col)
	{
		return tileAt(row,col).getVal();
	}
	public int getWinner(int numToWin)
	{
		int winner = -1;
		//horizontal
		for (int i = 0; i < VERT; i++)
		{
			int count = 1;
			int compare = valAt(i,0);
			for (int j = 1; j < HOR; j++)
			{
				if (compare == 0) compare = valAt(i,j);
				else if (valAt(i,j) == compare)
				{
					count++;
					if (count == numToWin)
					{
						if (winner != compare && winner != -1) return 0;
						winner = compare;
					}
				}
				else
				{
					compare = valAt(i,j);
					count = 1;
				}
			}
		}
		//vertical
		for (int j = 0; j < HOR; j++)
		{
			int count = 1;
			int compare = valAt(0,j);
			for (int i = 1; i < VERT; i++)
			{
				if (compare == 0) compare = valAt(i,j);
				else if (valAt(i,j) == compare)
				{
					count++;
					if (count == numToWin)
					{
						if (winner != compare && winner != -1) return 0;
						winner = compare;
					}
				}
				else
				{
					compare = valAt(i,j);
					count = 1;
				}
			}
		}
		//forward diagonal
		for (int i = numToWin - 1; i < VERT; i++)
		{
			int count = 1;
			int compare = valAt(i,0);
			for (int j = 1; j <= i && j < HOR; j++)
			{
				if (compare == 0) compare = valAt(i - j, j);
				else if (valAt(i - j, j) == compare)
				{
					count++;
					if (count == numToWin)
					{
						if (winner != compare && winner != -1) return 0;
						winner = compare;
					}
				}
				else
				{
					compare = valAt(i - j, j);
					count = 1;
				}
			}
		}
		for (int startJ = 1; startJ <= HOR - numToWin; startJ++)
		{
			int count = 1;
			int compare = valAt(VERT - 1,startJ);
			for (int j = startJ + 1; j < HOR && j - startJ < VERT; j++)
			{
				if (compare == 0) compare = valAt(VERT - 1 - j + startJ, j);
				else if (valAt(VERT - 1 - j + startJ, j) == compare)
				{
					count++;
					if (count == numToWin)
					{
						if (winner != compare && winner != -1) return 0;
						winner = compare;
					}
				}
				else
				{
					compare = valAt(VERT - 1 - j + startJ, j);
					count = 1;
				}
			}
		}
		//backward diagonal
		for (int i = 0; i <= VERT - numToWin; i++)
		{
			int count = 1;
			int compare = valAt(i,0);
			for (int j = 1; i + j < VERT && j < HOR; j++)
			{
				if (compare == 0) compare = valAt(i + j, j);
				else if (valAt(i + j, j) == compare)
				{
					count++;
					if (count == numToWin)
					{
						if (winner != compare && winner != -1) return 0;
						winner = compare;
					}
				}
				else
				{
					compare = valAt(i + j, j);
					count = 1;
				}
			}
		}
		for (int startJ = 1; startJ <= HOR - numToWin; startJ++)
		{
			int count = 1;
			int compare = valAt(0, startJ);
			for (int j = startJ + 1; j < HOR && j - startJ < VERT; j++)
			{
				if (compare == 0) compare = valAt(j - startJ, j);
				else if (valAt(j - startJ, j) == compare)
				{
					count++;
					if (count == numToWin)
					{
						if (winner != compare && winner != -1) return 0;
						winner = compare;
					}
				}
				else
				{
					compare = valAt(j - startJ, j);
					count = 1;
				}
			}
		}
		return winner;
	}

	//helper methods
	private void swap(int row1, int col1, int row2, int col2)
	{
		int temp = grid[row1][col1];
		grid[row1][col1] = grid[row2][col2];
		grid[row2][col2] = temp;
	}
	private void fall()
	{
		if (!gravity) return;
		switch (fallDirection)
		{
		case SOUTH:
			for (int j = 0; j < HOR; j++)
			{
				for (int i = VERT - 2; i >= 0; i--)
				{
					for (int a = 1; a < VERT - i && !tileAt(i + a, j).exists(); a++)
					{
						swap(i + a - 1, j, i + a, j);
					}
				}
			}
			break;
		case NORTH:
			for (int j = 0; j < HOR; j++)
			{
				for (int i = 1; i < VERT; i++)
				{
					for (int a = 1; a <= i && !tileAt(i - a,j).exists(); a++)
					{
						swap(i - a + 1, j, i - a, j);
					}
				}
			}
			break;
		case EAST:
			for (int i = 0; i < VERT; i++)
			{
				for (int j = HOR - 2; j >= 0; j--)
				{
					for (int a = 1; a < HOR - j && !tileAt(i, j + a).exists(); a++)
					{
						swap(i, j + a - 1, i, j + a);
					}
				}
			}
			break;
		case WEST:
			for (int i = 0; i < VERT; i++)
			{
				for (int j = 1; j < HOR; j++)
				{
					for (int a = 1; a <= j && !tileAt(i, j - a).exists(); a++)
					{
						swap(i, j - a + 1, i, j - a);
					}
				}
			}
		}
	}
	private void callTiles()
	{
		for (int i = 0; i < VERT; i++)
		{
			for (int j = 0; j < HOR; j++)
			{
				if (tileAt(i, j).getRow() != i || tileAt(i, j).getCol() != j)
					tileAt(i, j).move(i, j);
			}
		}
	}
	private void endStep()
	{
		if (gravity) fall();
		callTiles();	
	}

	//modifiers  All should end with endStep() !!!!
	public void toggleGravity()
	{
		gravity = !gravity;
		endStep();
	}
	
	public void setFallDirection(Direction d)
	{
		fallDirection = d;
		endStep();
	}
	public boolean insert(int val, int col)
	{
		switch (fallDirection)
		{
		case SOUTH:
		case NORTH:
			return insert(val, 0, col)||insert(val, VERT - 1, col);
		case EAST:
			return insert(val, VERT - col - 1, 0);
		default: return insert(val, col, HOR - 1);
		}
	}
	public boolean insert(int val, int row, int column)
	{
		if (tileAt(row, column).exists()) return false;
		tileAt(row, column).setVal(val);
		endStep();
		return true;
	}
	public void reverseLine(boolean isHor, int index)
	{
		if (isHor)
		{
			for (int j = 0; j < HOR/2; j++)
			{
				int temp = grid[index][j];
				grid[index][j] = grid[index][HOR - j - 1];
				grid[index][HOR - j - 1] = temp;
			}
		}
		else
		{
			for (int i = 0; i < VERT/2; i++)
			{
				int temp = grid[i][index];
				grid[i][index] = grid[VERT - i - 1][index];
				grid[VERT - i - 1][index] = temp;
			}
		}
		callTiles(); //so user can witness the flip
		endStep();
	}
}
