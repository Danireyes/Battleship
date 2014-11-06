package Components;

public class Player {

	//La primera es la del usuario, la segunda es una negra en la que se marcan los disparos, aciertos, etc
  private Board mBoard[][];
  private Board mShotsBoard[][];
  
  public Player(int width, int height)
  {
	 //Creamos las boards
	  mBoard = new Board[width][height];
	  mShotsBoard = new Board[width][height];
  }

  public void doMovement(int x, int y) {
  }
}