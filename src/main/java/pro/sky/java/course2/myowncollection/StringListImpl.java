package pro.sky.java.course2.myowncollection;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] storage;
    private int size;

    public StringListImpl() {
        storage = new String[size()];
        size = size();
    }

    public static void validateItem(String item) {
        if (item == null) {
            throw new NullInputParameterException();
        }
    }

    @Override
    public String add(String item) {
        if (size == storage.length) {
            storage = Arrays.copyOf(storage, size * 2);
        }
        validateItem(item);
        storage[size - 1] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (size == storage.length) {
            storage = Arrays.copyOf(storage, size * 2);
        }
        validateItem(item);
        validateIndex(index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(item)) {
                break;
            }
            if (i == storage.length - 1) {
                throw new ElementNotFoundException();
            }
        }
        System.arraycopy(storage, indexOf(item) + 1, storage, indexOf(item), storage.length - indexOf(item) - 1);
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(storage[index])) {
                break;
            }
            if (i == storage.length - 1) {
                throw new ElementNotFoundException();
            }
        }
        String item = storage[index];
        System.arraycopy(storage, index + 1, storage, index, storage.length - index - 1);
        return item;
    }

    @Override
    public boolean contains(String item) {
        validateItem(item);
        return indexOf(item) != -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = storage.length - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        if (otherList == null) {
            throw new NullInputParameterException();
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < storage.length; i++) {
            if (!storage[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    public void validateIndex(int index) {
        if (index > size || index < 0) {
            throw new BeyondTheSizeException();
        }
    }
}
