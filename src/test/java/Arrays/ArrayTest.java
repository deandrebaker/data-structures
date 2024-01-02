package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayTest {
    @Test
    void lookup() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Array<String> array = new Array<>(Arrays.stream(new String[]{str1, str2}).toList());

        String result1 = array.lookup(0);
        String result2 = array.lookup(1);

        assert array.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }

    @Test
    void search() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Array<String> array = new Array<>(Arrays.stream(new String[]{str1, str2}).toList());

        int result1 = array.search(str2);

        assert result1 == 1;
    }

    @Test
    void append() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Array<String> array = new Array<>(2);
        array.append(str1);
        array.append(str2);

        String result1 = array.lookup(0);
        String result2 = array.lookup(1);

        assert array.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }

    @Test
    void insert() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Array<String> array = new Array<>(2);
        array.append(str2);

        array.insert(0, str1);
        String result1 = array.lookup(0);
        String result2 = array.lookup(1);

        assert array.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }

    @Test
    void delete() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        Array<String> array = new Array<>(Arrays.stream(new String[]{str1, str2}).toList());

        array.delete(0);
        String result1 = array.lookup(0);

        assert array.getSize() == 1;
        assert result1.equals(str2);
    }


}