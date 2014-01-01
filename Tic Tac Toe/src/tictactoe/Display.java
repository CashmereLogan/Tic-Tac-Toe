/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author cal
 */
public class Display {

	String[] grid = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	
	public void grid() {
		for(int i = 0; i<50; i++) System.out.println("");
		System.out.println("     |     |     ");
		System.out.println("__"+grid[0]+"__|__"+grid[1]+"__|__"+grid[2]+"__");
		System.out.println("     |     |     ");
		System.out.println("  "+grid[3]+"  |  "+grid[4]+"  |  "+grid[5]+"  ");
		System.out.println("_____|_____|_____");
		System.out.println("  "+grid[6]+"  |  "+grid[7]+"  |  "+grid[8]+"  ");
		System.out.println("     |     |     ");
	}

	public void setGridSpace(int space, String value){
		grid[space] = value;
	}
	
	public boolean getSpace(int space){
		if(grid[space]==" "){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkWinner(String noName){
		if(grid[0].equals(noName) && grid[1].equals(noName) && grid[2].equals(noName)){
			return true;
		}else if(grid[3].equals(noName) && grid[4].equals(noName) && grid[5].equals(noName)){
			return true;
		}else if(grid[6].equals(noName) && grid[7].equals(noName) && grid[8].equals(noName)){
			return true;
		}else if(grid[0].equals(noName) && grid[3].equals(noName) && grid[6].equals(noName)){
			return true;
		}else if(grid[1].equals(noName) && grid[4].equals(noName) && grid[7].equals(noName)){
			return true;
		}else if(grid[2].equals(noName) && grid[5].equals(noName) && grid[8].equals(noName)){
			return true;
		}else if(grid[0].equals(noName) && grid[4].equals(noName) && grid[8].equals(noName)){
			return true;
		}else if(grid[2].equals(noName) && grid[4].equals(noName) && grid[6].equals(noName)){
			return true;
		}else{
			return false;
		}
		
	}
	
}
