import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FullHouseTests extends ScoreSheetTest {

  public FullHouseTests(int[] diceValues, int expectedResult) {
    super(diceValues, expectedResult);
  }

  @Parameterized.Parameters
  public static Collection input() {
    return Arrays
        .asList(new Object[][] {
            {new int[] {2, 2, 3, 3, 3}, 13},
            {new int[] {3, 3, 3, 2, 2}, 13},
            {new int[] {2, 3, 2, 3, 2}, 12},
            {new int[] {2, 2, 2, 3, 1}, 0},
            {new int[] {1, 1, 2, 2, 2}, 8},
            {new int[] {2, 2, 3, 3, 4}, 0},
            {new int[] {4, 4, 4, 4, 4}, 0}
        });
  }

  @Test
  public void sumOfFullHouse() {
    Assert.assertEquals(expectedResult, scoreSheet.sumOfFullHouse());
  }
}
