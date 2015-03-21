
public class Wall {
	public final static int Horizon = 1;
	public final static int Vertical = -1;
	public int x;
	public int y;
	public int wallType;
	
	public Wall(int x, int y, int wallType){
		this.x = x;
		this.y = y;
		this.wallType = wallType;
	}
}
