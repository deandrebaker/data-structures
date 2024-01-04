package Queues;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QueueTest {

    @Test
    void enqueue() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Queue<String> queue = new Queue<>();

        queue.enqueue(str1);
        queue.enqueue(str2);

        assert queue.getSize() == 2;
        String result1 = queue.peak();
        assert result1.equals(str1);
        queue.dequeue();
        String result2 = queue.peak();
        assert result2.equals(str2);
    }

    @Test
    void dequeue() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Queue<String> queue = new Queue<>(Arrays.stream(new String[]{str1, str2}).toList());

        String result1 = queue.dequeue();
        String result2 = queue.dequeue();

        assert queue.getSize() == 0;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }
}