import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ChanceTests extends ScoreSheetTest {

  public ChanceTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {1, 2, 3, 4, 5}, 15},
            {new int[] {1, 1, 1, 1, 1}, 5},
            {new int[] {2, 2, 2, 2, 2}, 10},
            {new int[] {1, 1, 3, 3, 6}, 14},
            {new int[] {4, 5, 5, 6, 1}, 21}
        });
  }

  @Test
  public void sumOfFourOfAKind() {
    Assert.assertEquals(expectedResult, scoreSheet.sumOfChance());
  }
}
