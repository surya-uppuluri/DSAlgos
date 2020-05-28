package surya.practice.geeks.stack;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC1441_BuildAnArrayWithStackOperationsTest {

  LC1441_BuildAnArrayWithStackOperations withStackOperations = new LC1441_BuildAnArrayWithStackOperations();

  @Test
  void buildArrayWithoutStack1() {
    List<String> res = withStackOperations.buildArrayWithoutStack(new int[]{1, 3}, 3);
    Assertions.assertEquals("[Push, Push, Pop, Push]", res.toString());
  }

  @Test
  void buildArrayWithoutStack2() {
    List<String> res = withStackOperations.buildArrayWithoutStack(new int[]{1, 2, 3}, 3);
    Assertions.assertEquals("[Push, Push, Push]", res.toString());
  }

  @Test
  void buildArrayWithoutStack3() {
    List<String> res = withStackOperations.buildArrayWithoutStack(new int[]{1, 2}, 4);
    Assertions.assertEquals("[Push, Push]", res.toString());
  }

  @Test
  void buildArrayWithoutStack4() {
    List<String> res = withStackOperations.buildArrayWithoutStack(new int[]{2, 3, 4}, 4);
    Assertions.assertEquals("[Push, Pop, Push, Push, Push]", res.toString());
  }

  @Test
  void buildArrayWithStack1() {
    List<String> res = withStackOperations.buildArrayWithStack(new int[]{1, 3}, 3);
    Assertions.assertEquals("[Push, Push, Pop, Push]", res.toString());
  }

  @Test
  void buildArrayWithStack2() {
    List<String> res = withStackOperations.buildArrayWithStack(new int[]{1, 2, 3}, 3);
    Assertions.assertEquals("[Push, Push, Push]", res.toString());
  }

  @Test
  void buildArrayWithStack3() {
    List<String> res = withStackOperations.buildArrayWithStack(new int[]{1, 2}, 4);
    Assertions.assertEquals("[Push, Push]", res.toString());
  }

  @Test
  void buildArrayWithStack4() {
    List<String> res = withStackOperations.buildArrayWithStack(new int[]{2, 3, 4}, 4);
    Assertions.assertEquals("[Push, Pop, Push, Push, Push]", res.toString());
  }
}