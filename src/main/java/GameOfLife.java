import java.util.Arrays;

public class GameOfLife {

  private final int[] directions = { 0, 1, -1 };
  private boolean[][] universe;

  protected void doTrick() {
    int height = universe.length;
    int width = universe[0].length;
    boolean[][] nextTrick = new boolean[height][width];

    for (int row = 0; row < universe.length; row++) {
      for (int col = 0; col < universe[0].length; col++) {
        int liveCellsCount = 0;

        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            if (!(directions[i] == 0 && directions[j] == 0)) {
              int r = row + directions[i];
              int c = col + directions[j];
              if (r >= 0 && c >= 0 && r < height && c < width && universe[r][c])
                liveCellsCount++;
            }
          }
        }

        if (universe[row][col]) {
          if (liveCellsCount == 2 || liveCellsCount == 3)
            nextTrick[row][col] = true;
        } else {
          if (liveCellsCount == 3)
            nextTrick[row][col] = true;
        }
      }
    }

    universe = Arrays.stream(nextTrick).map(boolean[]::clone).toArray(boolean[][]::new);
  }

  protected void createUniverse(int height, int width) {
    universe = new boolean[height][width];
  }

  protected void loadPattern(boolean[][] pattern) {
    int x0 = (universe[0].length - pattern[0].length) / 2;
    int y0 = (universe.length - pattern.length) / 2;
    for (int y = 0; y < pattern.length; y++)
      System.arraycopy(pattern[y], 0, universe[y0 + y], x0, pattern[y].length);
  }

  protected void printUniverse() {
    for (int row = 0; row < universe.length; row++) {
      for (int col = 0; col < universe[0].length; col++) {
        if (universe[row][col])
          System.out.print("⬛");
        else
          System.out.print("⬜");
      }
      System.out.println();
    }
    System.out.println();
  }

  public boolean[][] getUniverse() {
    return universe;
  }

  public void setUniverse(boolean[][] universe) {
    this.universe = universe;
  }
}