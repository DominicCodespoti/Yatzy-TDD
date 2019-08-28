import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ThreeOfAKindTests extends ScoreSheetTest {

  public ThreeOfAKindTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {2, 2, 2, 3, 3}, 6},
            {new int[] {1, 1, 2, 3, 3}, 0},
            {new int[] {2, 2, 2, 2, 2}, 6},
            {new int[] {3, 3, 3, 4, 5}, 9},
            {new int[] {3, 3, 4, 5, 6}, 0},
            {new int[] {3, 3, 3, 3, 1}, 9}
        });
  }

  @Test
  public void sumOfThreeOfAKind() {
    Assert.assertEquals(expectedResult, scoreSheet.sumOfThreeOfAKind());
  }
}
