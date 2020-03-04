package app;

import java.util.Random;
import java.util.Scanner;

public class Player {
	
	private char marker;
	private boolean isHuman;
	
	//Constructors
	
	//Initializes the marker to X and isHuman to true;
	Player(){
		marker = 'X';
		isHuman = true;
	}
	
	//Initializes isHuman to inIsHuman and if inIsHuman is true, marker to X, otherwise marker to O
	Player(boolean inIsHuman){
		isHuman = inIsHuman;
		if(isHuman == true) {
			marker = 'X';
		}
		else {
			marker = 'O';
		}
	}
	
	//Initializes isHuman to inIsHuman and marker to X if inMarker is X or x, otherwise marker to O
	Player(boolean inIsHuman, char inMarker){
		isHuman = inIsHuman;
		if(inMarker == 'X' || inMarker == 'x') {
			marker = 'X';
		}
		else {
			marker = 'O';
		}
	}
	
	//----Access----//


	//Returns the player's marker 
	public char getMarker() {
		return marker;
	}
	
	//Returns whether the player is human or not
	public boolean isHuman() {
		return isHuman;
	}
	
	//Returns the move from the player (either from human or computer)
	public String getPlayerMove() {
		return "HELLO";
	}
	
	//Prompts the user for a move, retrieves input from the keyboard, and returns it
	public String getHumanMove() {
		Scanner scan = new Scanner(System.in);
        System.out.print("Player Move (X): ");
        String humanMove= scan.next();
        scan.close();
		return humanMove;
	}
	
	//Returns a move randomly generated
	public String generateComputerMove() {
		//create an array of possible moves
		String[] possibleMoves = {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
		//select an index on the array randomly
		Random rand = new Random();
		int randomIndex = rand.nextInt(9);
		//get the string in the array using the random index
		String computerMove = possibleMoves[randomIndex];
		return computerMove;
	}
	
}
