package DynamicArrays;

import Lists.List;
import Lists.ListTest;
import org.junit.jupiter.api.Test;

class DynamicArrayTest extends ListTest {
    @Override
    protected List<String> getList() {
        return new DynamicArray<>();
    }

    @Override
    protected List<String> getList(Iterable<String> initialItems) {
        return new DynamicArray<>(initialItems);
    }

    @Test
    void resize() {
        String str1 = "Hello world!";
        String str2 = "Goodbye!";
        DynamicArray<String> array = new DynamicArray<>(1);
        array.append(str1);
        array.append(str2);

        String result1 = array.lookup(0);
        String result2 = array.lookup(1);

        assert array.getSize() == 2;
        assert result1.equals(str1);
        assert result2.equals(str2);
    }
}