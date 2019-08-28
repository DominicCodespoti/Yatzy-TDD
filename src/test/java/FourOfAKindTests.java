import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FourOfAKindTests extends ScoreSheetTest {

  public FourOfAKindTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {2, 2, 2, 2, 3}, 8},
            {new int[] {1, 1, 2, 3, 3}, 0},
            {new int[] {2, 2, 2, 2, 2}, 8},
            {new int[] {2, 2, 2, 2, 5}, 8},
            {new int[] {2, 2, 2, 5, 5}, 0},
            {new int[] {2, 2, 2, 2, 2}, 8}
        });
  }

  @Test
  public void sumOfFourOfAKind() {
    Assert.assertEquals(expectedResult, scoreSheet.sumOfFourOfAKind());
  }
}
