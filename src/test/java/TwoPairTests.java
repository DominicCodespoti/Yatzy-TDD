import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TwoPairTests {

  private ScoreSheet scoreSheet;
  private int expectedResult;

  public TwoPairTests(int[] diceValues, int expectedResult) {
    scoreSheet = new ScoreSheet(diceValues);
    this.expectedResult = expectedResult; //todo: add to other tests
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {2, 2, 2, 3, 3}, 10},
            {new int[] {1, 1, 2, 3, 3}, 8},
            {new int[] {1, 2, 2, 1, 3}, 6},
            {new int[] {1, 2, 2, 2, 2}, 0},
            {new int[] {1, 1, 2, 3, 4}, 0},
            {new int[] {1, 1, 2, 2, 2}, 6},
            {new int[] {1, 1, 2, 3, 3}, 8}
        });
  }

  @Test
  public void sumOfTwoPair() {
    Assert.assertEquals(expectedResult, scoreSheet.sumOfTwoPairs());
  }
}
