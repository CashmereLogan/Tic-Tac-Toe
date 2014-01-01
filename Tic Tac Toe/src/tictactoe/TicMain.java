/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author cal
 */
public class TicMain {

	public static void main(String[] args) {

		Random r = new Random();
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe.");  //  Prompt Message
		System.out.println("Choose    x    or    o");
		String playerValue = s.nextLine();
		String computerValue = "";
		if (playerValue.equals("x")) {            //Assigns "x" and "o" to player and computer.
			computerValue = "o";
		} else {
			computerValue = "x";
		}

		boolean start = true;                  //Decides who will go first.
		int firstTurn = r.nextInt(2);
		if (firstTurn == 1) {
			System.out.println("You will go first.");
			start = true;
		} else {
			System.out.println("The computer will go first.");
			start = false;
		}

		Display change = new Display();        
		int row = 0;
		int winnerNumber = 0;
		if (start) {
			while (row != 3) {
				System.out.println("Enter the number of the desired space: "); //   Player Turn
				int space1 = s.nextInt();
				while (!change.getSpace(space1)) {
					System.out.println("That space is taken. Choose another.");
					space1 = s.nextInt();
				}
				change.setGridSpace(space1, playerValue);
				change.grid();

				if (change.checkWinner(playerValue) == true) {     // Checking for Winner
					row = 3;
					winnerNumber = 1;
				}else if(change.checkWinner(computerValue) == true){
					row = 3;
					winnerNumber = 2;
				}
				
				int space2 = r.nextInt(9);      // Computer Turn
				while (!change.getSpace(space2)) {
					space2 = r.nextInt(9);
				}
				System.out.println("The computer will place an " + computerValue + " in grid " + space2);
				change.setGridSpace(space2, computerValue);
				try {                  // 1 Second Delay
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Logger.getLogger(TicMain.class.getName()).log(Level.SEVERE, null, ex);
				}
				change.grid();

				if (change.checkWinner(playerValue) == true) {     // Checking for Winner
					row = 3;
					winnerNumber = 1;
				}else if(change.checkWinner(computerValue) == true){
					row = 3;
					winnerNumber = 2;
				}
			}
			if(winnerNumber == 1){                     //Either the bitch you lost or damn you won part.
				System.out.println("Congratulations! You win!");
			}else if(winnerNumber == 2){
				System.out.println("I'm sorry, you lost.");
			}
		}
	}

}
