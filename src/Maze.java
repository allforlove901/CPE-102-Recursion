public class Maze {
	
	private char[][] maze;
	private int[][] hasBeen;
	
	private int xDir = 0;
	private int yDir = -1;
	private String direction = "up";
	
	public Maze (char[][] m){
		maze = m;
		hasBeen = new int[maze.length][maze[0].length];
		for(int[] ar : hasBeen){
			for(int i : ar){
				ar[i] = 0;
			}//close for
		}//close for
	}//close constructor
	
	public boolean escape(int xStart, int yStart){
		if(xStart == 0 || xStart == maze.length - 1 || yStart == 0 || yStart == maze[0].length - 1){
			return true;
		}else if(hasBeen[xStart][yStart] >= 4){
			return false;
		}else if(maze[xStart+yDir][yStart+xDir] == ' '){
			hasBeen[xStart][yStart] += 1;
			return escape(xStart+yDir,yStart+xDir);
		}else if(maze[xStart+xDir][yStart+yDir] == ' '){
			hasBeen[xStart][yStart] += 1;
			return escape(xStart+xDir,yStart+yDir);
		}else{
			turn();
			return escape(xStart,yStart);
		}
			
	}//close escape
	
	public void turn(){
		if(direction.equals("up")){
			direction = "right";
			xDir = 1;
			yDir = 0;
		}else if(direction.equals("right")){
			direction = "down";
			xDir = 0;
			yDir = 1;
		}else if(direction.equals("down")){
			direction = "left";
			xDir = -1;
			yDir = 0;
		}else if(direction.equals("left")){
			direction = "up";
			xDir = 0;
			yDir = -1;
		}//close else
	}//close turn

}