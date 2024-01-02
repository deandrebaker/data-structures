package Lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

abstract public class ListTest {
    abstract protected List<String> getList();

    abstract protected List<String> getList(Iterable<String> initialItems);

    @Test
    void lookup() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        List<String> list = getList(Arrays.stream(new String[]{str1, str2}).toList());

        String result1 = list.lookup(0);
        String result2 = list.lookup(1);

        assert list.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }

    @Test
    void search() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        List<String> list = getList(Arrays.stream(new String[]{str1, str2}).toList());

        int result1 = list.search(str2);

        assert result1 == 1;
    }

    @Test
    void append() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        List<String> list = getList();
        list.append(str1);
        list.append(str2);

        String result1 = list.lookup(0);
        String result2 = list.lookup(1);

        assert list.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }

    @Test
    void insert() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        String str3 = "foobar";
        List<String> list = getList();
        list.append(str2);

        list.insert(0, str1);
        String result1 = list.lookup(0);
        String result2 = list.lookup(1);

        assert list.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);

        list.insert(3, str3);
        String result3 = list.lookup(2);
        String result4 = list.lookup(3);

        assert list.getSize() == 4;
        assert result3 == null;
        assert result4.equals(str3);
    }

    @Test
    void delete() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        List<String> list = getList(Arrays.stream(new String[]{str1, str2}).toList());

        list.delete(0);
        String result1 = list.lookup(0);

        assert list.getSize() == 1;
        assert result1.equals(str2);
    }
}