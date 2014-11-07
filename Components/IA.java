package Components;

import java.util.Vector;
import java.util.Random;


public class IA {

	//Board de la IA, donde tiene sus barquitos
  private Board mBoard[][];
  //Vector que tiene los aciertos de la IA anteriores, si no esta vacio es que dio a un barco nuestro por lo que tiene q disparar alrededor de ese punto
  private Vector<Integer> previousHitsX;
  private Vector<Integer> previousHitsY;
  //Vector que tiene los disparos de la IA, si no esta vacio es que dio a un barco nuestro por lo que tiene q disparar alrededor de ese punto
  private Vector<Integer> previousShotsX;
  private Vector<Integer> previousShotsY;
  //Ultimos numeros randoms generados
  private int randomX, randomY;
  
  public IA()
  {
	  mBoard = new Board[BoardGenerator.BoardWidth][BoardGenerator.BoardHeight];
	  
	  previousHitsX = new Vector<Integer>();
	  previousHitsY = new Vector<Integer>();
	  previousShotsX = new Vector<Integer>();
	  previousShotsY = new Vector<Integer>();
	  
	  randomX = randomY = -1;
  }

  public void doMovement(Player mPlayer) {
	  
	  //Si no ha hecho hits anteriormente generar un numero aleatorio en todo el mapa
	  if(previousHitsX.isEmpty())
	  {
		  calculateRandomPosition();
	  }
	  else //Si ha dado a un barco antes
	  {
		  calculateRandomPosition_inRange();
	  }
	  
	 if(mPlayer.setAttackFromIA(randomX, randomY))
	 {
		 //Hubo un hit asi que añadirlo
		 previousHitsX.add(randomX);
		 previousHitsY.add(randomY);
	 }
	 //Añadir los disparos realizados
	 previousShotsX.add(randomX);
	 previousShotsY.add(randomY);
	  
	  
  }

  private void calculateRandomPosition() {
	  Random rand = new Random();
	  
	  randomX = rand.nextInt(BoardGenerator.BoardWidth);
	  while(previousShotsX.contains(randomX))
	  {
		  randomX = rand.nextInt(BoardGenerator.BoardWidth);
	  }
	  
	  randomY = rand.nextInt(BoardGenerator.BoardHeight);
	  while(previousShotsY.contains(randomY))
	  {
		  randomY = rand.nextInt(BoardGenerator.BoardHeight);
	  }
  }

  private void calculateRandomPosition_inRange() {
	  
	  Random rand = new Random();
	  
	  while(previousShotsX.indexOf(randomX) != -1)
	  {
		  randomX = rand.nextInt(BoardGenerator.BoardWidth - previousHitsX.lastElement()) + previousHitsX.lastElement();
	  }
	  
	  while(previousShotsX.indexOf(randomY) != -1)
	  {
		  randomY = rand.nextInt(BoardGenerator.BoardHeight - previousHitsY.lastElement()) + previousHitsY.lastElement();
	  }
  }
  
  public void setShotFromPlayer(int x, int y)
  {
	  BoardGenerator.setShotToBoard(mBoard, x, y);
  }
}