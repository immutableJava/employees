package pro.sky.java.course2.myowncollection;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] storage;
    private int size = 0;

    public StringListImpl() {
        storage = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        size++;
        storage = Arrays.copyOf(storage, size);
        storage[size - 1] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        String[] strings = new String[size];
        for (int i = 0, j = 0; i < strings.length && j < strings.length; i++, j++) {
            if (i != index) {
                strings[i] = Arrays.copyOf(storage, size)[j];
            } else {
                strings[i] = item;
                j--;
            }
        }
        storage = strings;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(item)) {
                size--;
                storage[i] = null;
                String[] strings = new String[size];
                for (int j = 0, k = 0; j < storage.length && k < storage.length; j++, k++) {
                    if (storage[j] != null) {
                        strings[k] = storage[j];
                    } else {
                        k--;
                    }
                }
                storage = strings;
                return item;
            }
        }
        throw new ElementNotFoundException();
    }

    @Override
    public String remove(int index) {

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String result = storage[index];
        size--;
        storage[index] = null;
        String[] strings = new String[size];
        for (int i = 0, j = 0; i < storage.length && j < storage.length; i++, j++) {
            if (storage[i] != null) {
                strings[j] = storage[i];
            } else {
                j--;
            }
        }
        storage = strings;
        return result;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (String current : storage) {
            if (current.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
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
    public String get(int index) {
        if (index < storage.length)
            return storage[index];
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(StringList otherList) {

        if (otherList == null) {
            throw new NullPointerException();
        }
        if (storage.length != otherList.size()) {
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
        return storage.length;
    }

    @Override
    public boolean isEmpty() {
        return storage.length == 0;
    }

    @Override
    public void clear() {
        storage = new String[0];
    }

    @Override
    public String[] toArray() {
        return storage;
    }
}
