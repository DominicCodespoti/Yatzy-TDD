import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameNumberTests {

  private static ScoreSheet scoreSheet;

  @Before
  public void initializeNewScoreSheet() {
    scoreSheet = new ScoreSheet(new int[] {1, 2, 3, 4, 4});
  }

  @Test
  public void testScoreSheetHoldsDiceValues() {
    Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 4}, scoreSheet.getDiceValues());
  }

  @Test
  public void testSumOfAllOnes() {
    Assert.assertEquals(1, scoreSheet.sumOfAllOnes());
  }

  @Test
  public void testSumOfAllTwos() {
    Assert.assertEquals(2, scoreSheet.sumOfAllTwos());
  }

  @Test
  public void testSumOfAllThrees() {
    Assert.assertEquals(3, scoreSheet.sumOfAllThrees());
  }

  @Test
  public void testSumOfTwoFoursIsEight() {
    Assert.assertEquals(8, scoreSheet.sumOfAllFours());
  }

  @Test
  public void testSumOfAllFivesWithNoSixesReturnsZero() {
    Assert.assertEquals(0, scoreSheet.sumOfAllFives());
  }

  @Test
  public void testSumOfAllSixesWithNoSixesReturnsZero() {
    Assert.assertEquals(0, scoreSheet.sumOfAllSixes());
  }
}

