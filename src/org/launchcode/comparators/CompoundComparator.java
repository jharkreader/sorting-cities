package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {

    List<Comparator<City>> comparators = new ArrayList<>();

    public void add(Comparator<City> aComparator) {
        comparators.add(aComparator);
    }

    @Override
    public int compare(City o1, City o2) {


        int compHolder = 0;
        int resultHolder = 0;

        while (compHolder < comparators.size()) {

            Comparator activeComp = comparators.get(compHolder);
            resultHolder = activeComp.compare(o1, o2);
            if (resultHolder != 0) {
                return resultHolder;
            }
            else {
                compHolder++;
                if (compHolder == comparators.size()) {
                    return resultHolder;
                }
            }
        }




//        Comparator firstComp = comparators.get(0);
//        Comparator secondComp = comparators.get(1);
//
//        int comparison = firstComp.compare(o1, o2);
//        if (comparison == 0) {
//            return secondComp.compare(o1, o2);
//        }
//        else {
//            return comparison;
//        }

        return resultHolder;
    }
}
