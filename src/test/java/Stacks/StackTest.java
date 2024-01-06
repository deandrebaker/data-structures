package Stacks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StackTest {

    @Test
    void enqueue() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Stack<String> stack = new Stack<>();

        stack.push(str1);
        stack.push(str2);

        assert stack.getSize() == 2;
        String result1 = stack.peak();
        assert result1.equals(str2);
        stack.pop();
        String result2 = stack.peak();
        assert result2.equals(str1);
    }

    @Test
    void dequeue() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Stack<String> stack = new Stack<>(Arrays.stream(new String[]{str1, str2}).toList());

        String result1 = stack.pop();
        String result2 = stack.pop();

        assert stack.getSize() == 0;
        assert result1.equals(str2);
        assert result2.equals(str1);
    }
}