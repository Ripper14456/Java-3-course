package org.example.lab3;

import java.util.Comparator;
import java.util.List;

public class ChainComparator implements Comparator<Person> {
    private List<Comparator<Person>> comparators;

    public ChainComparator(List<Comparator<Person>> comparators) {
        this.comparators = comparators;
    }

    @Override
    public int compare(Person o1, Person o2) {
        int res;
        for(Comparator<Person> comparator : comparators) {
            if ((res = comparator.compare(o1, o2)) != 0) {
                return res;
            }
        }
        return 0;
    }
}
