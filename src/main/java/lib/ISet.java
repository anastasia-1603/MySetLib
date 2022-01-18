package lib;

public interface ISet<E>{
    void add(E e);

    void clear();

    boolean contains(E e);

    boolean isEmpty();

    void remove(E e);

    int size();
}
