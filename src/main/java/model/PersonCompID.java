package model;


import java.util.Comparator;

public class PersonCompID<T> implements Comparator<T> {
    @Override

    public int compare( T item1, T item2) {
        int id1 = ((Person) item1).getId();
        int id2 = ((Person) item2).getId();
        if (id1 > id2) {
            return 1;
        } else if (id1 < id2)
            return -1;
        else
            return 0;
    }
}
