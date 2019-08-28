import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LargeStraightTests extends ScoreSheetTest {

  public LargeStraightTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {1, 2, 3, 4, 5}, 0},
            {new int[] {2, 3, 4, 5, 6}, 20},
            {new int[] {3, 6, 4, 5, 2}, 0}
        });
  }

  @Test
  public void sumOfLargeStraight() {
    Assert.assertEquals(expectedResult, scoreSheet.largeStraight());
  }
}
