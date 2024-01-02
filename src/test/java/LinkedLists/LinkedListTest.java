package LinkedLists;

import Lists.List;
import Lists.ListTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LinkedListTest extends ListTest {

    @Override
    protected List<String> getList() {
        return new LinkedList<>();
    }

    @Override
    protected List<String> getList(Iterable<String> initialItems) {
        return new LinkedList<>(initialItems);
    }

    @Test
    void getHeadAndGetTail() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        LinkedList<String> linkedList = new LinkedList<>(Arrays.stream(new String[]{str1, str2}).toList());


        String result1 = linkedList.getHead();
        String result2 = linkedList.getTail();

        assert linkedList.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }
}
