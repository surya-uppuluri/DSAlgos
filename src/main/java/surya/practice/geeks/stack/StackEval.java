package surya.practice.geeks.stack;

import java.util.Stack;

public class StackEval {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        stack.push(5);
        stack.push(6);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Search for 5: " + stack.search(5));
        System.out.println("Search for 99: " + stack.search(99));

    }
}
