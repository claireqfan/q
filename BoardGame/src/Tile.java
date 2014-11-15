
public class Tile {
	private int val;
	private int row;
	private int col;
	
    public Tile(int r, int c)
    {
        this(r, c, 0);
    }
    
    public Tile(int r, int c, int v)
    {
        val = v;
        row = r;
        col = c;
    }
    
    public boolean exists()
    {
        return val != 0;
    }
    
    public void setVal(int c)
    {
        val = c;
    }
    
    public int getVal()
    {
        return val;
    }
    
    public int getRow()
    {
    	return row;
    }
    public int getCol()
    {
    	return col;
    }
    
    public void move(int r, int c) //will modify
    {
    	row = r;
    	col = c;
    }
    
    public String toString()
    {
        return "" + val;
    }
}
