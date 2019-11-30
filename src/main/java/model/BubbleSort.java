package model;

import java.util.Comparator;

public class BubbleSort<T> {

    public Object[] doBubbleSort(T[] personRepos, Comparator<T> comparator) {
        for (int i = 0; i < personRepos.length - 1; i++) {
            for (int j = 0; j < personRepos.length - i - 1; j++) {
                if (comparator.compare(personRepos[j], personRepos[j + 1]) > 0) {
                    T temp = (T) personRepos[j];
                    personRepos[j] = personRepos[j + 1];
                    personRepos[j + 1] = temp;
                }
            }
        }
        return personRepos;
    }
}
