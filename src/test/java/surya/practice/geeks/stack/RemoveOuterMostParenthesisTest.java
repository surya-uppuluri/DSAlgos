package surya.practice.geeks.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RemoveOuterMostParenthesisTest {

    RemoveOuterMostParenthesis removeOuterMostParenthesis = new RemoveOuterMostParenthesis();

    @Test
    void removeOuterParenthesesTest1() {

        String out = (removeOuterMostParenthesis.removeOuterParentheses("(()())(())"));

        assertEquals("()()()", out);
    }

    @Test
    void removeOuterParenthesesTest2() {


        String out = (removeOuterMostParenthesis.removeOuterParentheses("(()())(())(()(()))"));

        assertEquals("()()()()(())", out);
    }
}