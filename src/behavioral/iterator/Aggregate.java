package behavioral.iterator;

public interface Aggregate {

    Iterator iterator(int type);
    int getLength();
}
