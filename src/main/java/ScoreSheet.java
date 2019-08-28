import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreSheet {

  private int[] diceValues;

  public ScoreSheet(int[] diceValues) {
    this.diceValues = diceValues;
  }

  public int[] getDiceValues() {
    return diceValues.clone();
  }

  public int sumOfAllOnes() {
    return sumOfSameNumbers(1);
  }

  public int sumOfAllTwos() {
    return sumOfSameNumbers(2);
  }

  public int sumOfAllThrees() {
    return sumOfSameNumbers(3);
  }

  public int sumOfAllFours() {
    return sumOfSameNumbers(4);
  }

  public int sumOfAllFives() {
    return sumOfSameNumbers(5);
  }

  public int sumOfAllSixes() {
    return sumOfSameNumbers(6);
  }

  public int sumOfPair() {
    int selectedNumber = numberFinder(diceValues, 2);
    return sumOfNumberPairings(selectedNumber, 2);
  }

  public int sumOfTwoPairs() {
    int[] test = numberFinder(diceValues, 2, 2);

    int firstPair = sumOfNumberPairings(test[0], 2);
    int secondPair = sumOfNumberPairings(test[1], 2);

    return firstPair > 0 && secondPair > 0 ? firstPair + secondPair : 0;
  }

  public int sumOfThreeOfAKind() {
    int selectedNumber = numberFinder(diceValues, 3);
    return sumOfNumberPairings(selectedNumber, 3);
  }

  public int sumOfFourOfAKind() {
    int selectedNumber = numberFinder(diceValues, 4);
    return sumOfNumberPairings(selectedNumber, 4);
  }

  public int sumOfFullHouse() {
    int[] test = numberFinder(diceValues, 2, 3);

    int pair = sumOfNumberPairings(test[0], 2);
    int threeOfAKind = sumOfNumberPairings(test[1], 3);
    for (int i = 0; i < 2; i++) {
      if (pair > 0 && threeOfAKind > 0) {
        return pair + threeOfAKind;
      }
      pair = sumOfNumberPairings(test[1], 3);
      threeOfAKind = sumOfNumberPairings(test[0], 2);
    }
    return 0;
  }

  public int smallStraight() {
    return diceValues[0] == 1
        && diceValues[1] == 2
        && diceValues[2] == 3
        && diceValues[3] == 4
        && diceValues[4] == 5
        ? 15
        : 0;
  }

  public int largeStraight() {
    return diceValues[0] == 2
        && diceValues[1] == 3
        && diceValues[2] == 4
        && diceValues[3] == 5
        && diceValues[4] == 6
        ? 20
        : 0;
  }

  public int sumOfChance() {
    return Arrays.stream(diceValues).sum();
  }

  public int Yatzy() {
    return numberFinder(diceValues, 5) != 0 ? 50 : 0;
  }

  private int sumOfNumberPairings(int selectedNumber, int duplicateAmount) {
    int test = (int) Arrays.stream(diceValues).filter(x -> x == selectedNumber).count();
    return test >= duplicateAmount ? duplicateAmount * selectedNumber : 0;
  }

  private int sumOfSameNumbers(int selectedNumber) {
    return (int) Arrays.stream(diceValues).filter(x -> x == selectedNumber).count()
        * selectedNumber;
  }

  private int numberFinder(int[] diceArray, int duplicateAmount) {
    List<Integer> diceArrayAsList = Arrays.stream(diceArray).boxed().collect(Collectors.toList());
    return diceArrayAsList.stream()
        .mapToInt(i -> i)
        .filter(i -> Collections.frequency(diceArrayAsList, i) >= duplicateAmount).max().orElse(0);
  }

  private int[] numberFinder(int[] diceArray, int duplicateAmount, int duplicateAmountTwo) {
    List<Integer> diceArrayAsList = Arrays.stream(diceArray).boxed().collect(Collectors.toList());
    int pair = diceArrayAsList.stream()
        .mapToInt(i -> i)
        .filter(i -> Collections.frequency(diceArrayAsList, i) == duplicateAmount).max().orElse(0);
    int threeOfAKind = diceArrayAsList.stream()
        .mapToInt(i -> i)
        .filter(i -> Collections.frequency(diceArrayAsList, i) >= duplicateAmountTwo && i != pair)
        .findFirst().orElse(0);
    return new int[] {pair, threeOfAKind};
  }
}
