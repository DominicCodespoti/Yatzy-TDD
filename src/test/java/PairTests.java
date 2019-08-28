import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PairTests extends ScoreSheetTest {

  public PairTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {2, 2, 2, 3, 3}, 6},
            {new int[] {1, 1, 2, 3, 3}, 6},//issue, finding actual of 2
            {new int[] {2, 2, 2, 2, 2}, 4},
            {new int[] {3, 3, 3, 4, 4}, 8},
            {new int[] {1, 1, 6, 2, 6}, 12},
            {new int[] {3, 3, 3, 4, 1}, 6},
            {new int[] {3, 3, 3, 3, 1}, 6}
        });
  }

  @Test
  public void sumOfPairs() {
    Assert.assertEquals(expectedResult, scoreSheet.sumOfPair());
  }
}
