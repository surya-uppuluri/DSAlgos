package surya.practice.geeks.backtracking;

import java.util.List;
import org.junit.jupiter.api.Test;

class GenerateParenthesisTest {

  GenerateParenthesis generateParenthesis = new GenerateParenthesis();

  @Test
  void generateParenthesisBruteForce() {
    List<String> strings = generateParenthesis.generateParenthesisBruteForce(3);
    System.out.println("Generated parentheses: " + strings.toString());
  }

  @Test
  void generateParenthesisBackTracking() {
    List<String> strings = generateParenthesis.generateParenthesisBackTracking(3);
    System.out.println("Generated parentheses: " + strings.toString());
  }


}