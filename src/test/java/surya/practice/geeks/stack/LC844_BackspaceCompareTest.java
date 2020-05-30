package surya.practice.geeks.stack;

import org.junit.jupiter.api.Test;

class LC844_BackspaceCompareTest {

  LC844_BackspaceCompare compare = new LC844_BackspaceCompare();

  @Test
  void backspaceCompareWithStack1() {
    boolean res = compare.backspaceCompareWithStack("ab#c", "ad#c");
    assert res;
  }

  @Test
  void backspaceCompareWithStack2() {
    boolean res = compare.backspaceCompareWithStack("ab##", "c#d#");
    assert res;
  }

  @Test
  void backspaceCompareWithStack3() {
    boolean res = compare.backspaceCompareWithStack("a##c", "#a#c");
    assert res;
  }

  @Test
  void backspaceCompareWithStack4() {
    boolean res = compare.backspaceCompareWithStack("a#c", "b");
    assert !res;
  }

  @Test
  void backspaceCompareWithWith2Pointer1() {
    boolean res = compare.backspaceCompareWithWith2Pointer("ab#c", "ad#c");
    assert res;
  }

  @Test
  void backspaceCompareWithWith2Pointer2() {
    boolean res = compare.backspaceCompareWithWith2Pointer("ab##", "c#d#");
    assert res;
  }

  @Test
  void backspaceCompareWithWith2Pointer3() {
    boolean res = compare.backspaceCompareWithWith2Pointer("a##c", "#a#c");
    assert res;
  }

  @Test
  void backspaceCompareWithWith2Pointer4() {
    boolean res = compare.backspaceCompareWithWith2Pointer("a#c", "b");
    assert !res;
  }
}