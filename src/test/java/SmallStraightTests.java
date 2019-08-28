import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SmallStraightTests extends ScoreSheetTest {

  public SmallStraightTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {1, 2, 3, 4, 5}, 15},
            {new int[] {5, 4, 3, 2, 1}, 0},
            {new int[] {1, 5, 2, 3, 4}, 0}
        });
  }

  @Test
  public void sumOfSmallStraight() {
    Assert.assertEquals(expectedResult, scoreSheet.smallStraight());
  }
}
