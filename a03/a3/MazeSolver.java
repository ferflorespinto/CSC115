/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Name: Jorge Fernando Flores Pinto
 * ID: V00880059
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

public class MazeSolver {
	public static String findPath(Maze maze) {
    	String result = "";
    	//Creates an 2D boolean array of the maze, where '*' (walls) have the value of true,
    	//and whitespaces have the value of false.
    	boolean[][] path = new boolean[maze.getNumRows()][maze.getNumCols()];
    	for(int i = 0; i < maze.getNumRows(); i++) {
    		for(int j = 0; j < maze.getNumCols(); j++) {
    			path[i][j] = maze.isWall(i, j);
    		}
    	}
    	//Creates a stack of the path to follow to finish the maze, but starts from the end to the beginning.
    	StackRefBased<MazeLocation> map = new StackRefBased<MazeLocation>();
    	map.push(maze.getEntry());
    	//curpos lets us keep track of where we are and where we come from.
    	MazeLocation curpos = maze.getEntry();

    	//Looks for possible paths to take until the stack is empty or the maze is finished.
    	while ((map.isEmpty() == false) && (!curpos.equals(maze.getExit()))) {
    		curpos = map.top.data;
    		path[curpos.getRow()][curpos.getCol()] = true;

    		//Should we go down?
    		if (curpos.getRow() + 1 < maze.getNumRows() && path[curpos.getRow() + 1][curpos.getCol()] == false) {
    			curpos = new MazeLocation(curpos.getRow() + 1, curpos.getCol());
    			path[curpos.getRow()][curpos.getCol()] = true;
    			map.push(curpos);
    		}
    		//Should we go right?
    		else if (curpos.getCol() + 1 < maze.getNumCols() && path[curpos.getRow()][curpos.getCol() + 1] == false) {
    			curpos = new MazeLocation(curpos.getRow(), curpos.getCol() + 1);
    			path[curpos.getRow()][curpos.getCol()] = true;
    			map.push(curpos);
    		}
    		//Should we go up?
    		else if (curpos.getRow() - 1 > 0 && path[curpos.getRow() - 1][curpos.getCol()] == false) {
    			curpos = new MazeLocation(curpos.getRow() - 1, curpos.getCol());
    			path[curpos.getRow()][curpos.getCol()] = true;
    			map.push(curpos);
    		}
    		//Should we go left?
    		else if (curpos.getCol() - 1 > 0 && path[curpos.getRow()][curpos.getCol() - 1] == false) {
    			curpos = new MazeLocation(curpos.getRow(), curpos.getCol() - 1);
    			path[curpos.getRow()][curpos.getCol()] = true;
    			map.push(curpos);
    		}
    		//Looks like we've got nowhere else to go...
    		else {
    			if (!map.isEmpty()) { 
    				try {
    					//We delete the last recorded position until we find another possible way.
    					map.pop();
    				} catch (StackEmptyException e) {}

    			}
    		}    		
    	}
    	//This stack inverts the path given by map to properly show the path from beginning to end.
    	StackRefBased<MazeLocation> mapRev = reverseStack(map);
    	result = mapRev.toString();

        return result;
    }
    //Lets us reverse the stack
    public static StackRefBased<MazeLocation> reverseStack(StackRefBased<MazeLocation> stack) {
    	StackRefBased<MazeLocation> newStack = new StackRefBased<MazeLocation>();
    	while (stack.isEmpty() == false) {
    		try {
    			newStack.push(stack.pop());
    		} catch(StackEmptyException e) {}

    	}
    	return newStack;
    }
    /*public static void main(String[] args) {
    	Maze m = new Maze("tests/maze01.txt");
    	boolean[][] path = new boolean[m.getNumRows()][m.getNumCols()];
    	for(int i = 0; i < m.getNumRows(); i++) {
    		for(int j = 0; j < m.getNumCols(); j++) {
    			path[i][j] = m.isWall(i, j);
    			System.out.print(path[i][j] + " ");
    		}
    		System.out.println();
    	}
    }*/

}
