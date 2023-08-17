package code;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
      System.out.println("Enter amount of obstacles (10-20): ");
      Scanner myObj = new Scanner(System.in);
      int maxObs = myObj.nextInt();
      Grid grid = new Grid(maxObs);
      grid.display();
      grid.AStarPathFinder();
      
      myObj.close();
  }
}
