package Components;

import java.util.Vector;

public class IA {

	//Board de la IA, donde tiene sus barquitos
  private Board mBoard[][];
  //Vector que tiene los aciertos de la IA anteriores, si no esta vacio es que dio a un barco nuestro por lo que tiene q disparar alrededor de ese punto
  public Vector<Integer> previousHits;
  
  public IA(int width, int height)
  {
	  mBoard = new Board[width][height];
  }

  public void doMovement() {
  }

  private void calculateRandomPosition(int x, int y) {
  }

  private void calculateRandomPosition_inRange(int x_in, int y_in, int x_out, int y_out) {
  }
}