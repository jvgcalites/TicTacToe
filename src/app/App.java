package app;

public class App {
	
    public static void main(String[] args) throws Exception {
    	
    	Board board = new Board();
    	board.printBoard();
    	board.submitMove("A1",'X');
    	board.submitMove("B2",'X');
    	board.submitMove("C3",'X');
    	board.printBoard();
    	
    }
}
