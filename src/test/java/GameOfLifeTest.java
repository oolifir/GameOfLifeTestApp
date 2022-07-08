import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GameOfLifeTest {
  GameOfLife gameOfLife = new GameOfLife();

  @Test
  public void testTrick() {
    boolean[][] universe = new boolean[][]{
        {false, false, false, false, false},
        {false, false, true,  false, false},
        {false, false, false, true,  false},
        {false, true,  true,  true,  false},
        {false, false, false, false, false},
    };
    gameOfLife.setUniverse(universe);
    gameOfLife.doTrick();

    boolean[][] expected = new boolean[][]{
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, true,  false, true,  false},
        {false, false, true,  true,  false},
        {false, false, true,  false, false},
    };
    Assert.assertTrue(Arrays.deepEquals(gameOfLife.getUniverse(), expected));
  }
}