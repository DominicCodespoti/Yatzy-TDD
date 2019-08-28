import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
abstract public class ScoreSheetTest {

  ScoreSheet scoreSheet;
  private int[] diceValues;
  int expectedResult;

  ScoreSheetTest(int[] diceValues, int expectedResult) {
    super();
    this.diceValues = diceValues;
    this.expectedResult = expectedResult;
  }

  @Before
  public void initialize() {
    scoreSheet = new ScoreSheet(diceValues);
  }
}

