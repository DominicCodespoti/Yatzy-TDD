import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class YatzyTests extends ScoreSheetTest {

  public YatzyTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {1, 1, 1, 1, 2}, 0},
            {new int[] {1, 1, 1, 1, 1}, 50},
            {new int[] {5, 5, 5, 5, 5}, 50}
        });
  }

  @Test
  public void scoreOfYatzy() {
    Assert.assertEquals(expectedResult, scoreSheet.Yatzy());
  }
}
