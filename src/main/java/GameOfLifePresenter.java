import java.util.Scanner;

public class GameOfLifePresenter {

  public static void main(String[] args) {

    int width = 25;
    int height = 25;
    int generationsCount;
    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Welcome to the Game of Life. Please enter a size of the Universe (default is 25x25):");
      String sizeOfUniverse = input.nextLine();
      if (!sizeOfUniverse.isEmpty()) {
        String[] sizes = sizeOfUniverse.split("x");
        width = Integer.parseInt(sizes[0]);
        height = Integer.parseInt(sizes[1]);
      }
      System.out.println("Please enter amount of generations:");
      String generations = input.nextLine();
      generationsCount = generations.isEmpty() ? 0 : Integer.parseInt(generations);
    }

    GameOfLife gameOfLife = new GameOfLife();
    gameOfLife.createUniverse(height, width);
    gameOfLife.loadPattern(Pattern.GLIDER);
    gameOfLife.printUniverse();

    while (generationsCount > 0) {
      gameOfLife.doTrick();
      gameOfLife.printUniverse();
      generationsCount--;
    }
  }
}