import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public static <E extends Comparable<E>> void bubbleSort(List<E> list) {
        int iterationSize = list.size();
        int unchanged = 0;
        while (iterationSize > 0 || unchanged <= iterationSize) {
            for (int i = 0; i < (iterationSize - 1); i++) {
                E currE = list.get(i);
                E nextE = list.get(i + 1);
                if (currE.compareTo(nextE) > 0) {
                    list.set(i, nextE);
                    list.set(i + 1, currE);
                } else {
                    unchanged++;
                }
            }
            unchanged = 0;
            iterationSize--;
        }
    }

    // boolean inOrder = false;
    // while(!inOrder) {
    // for (int i = 0; i < list.size() i++) {
    // E a = list.get(i);
    // E b = list.get(i + 1);
    // }

    public static <E extends Comparable<E>> void selectionSort(List<E> list) {
        int iterationSize = list.size() - 1;
        for (int i = 0; i < (iterationSize - 1); i++) {
            int lowestIndex = i;
            E lowestJ = list.get(i);
            for (int j = (i + 1); j <= iterationSize; j++) {
                E compareJ = list.get(j);
                if (lowestJ.compareTo(compareJ) > 0) {
                    lowestJ = compareJ;
                    lowestIndex = (j);
                }
            }
            list.remove(lowestIndex);
            list.add(i, lowestJ);
        }
    }

    public static <E extends Comparable<E>> void insertionSort(List<E> list) {
        int iterationSize = list.size() - 1;
        for (int i = 0; i < iterationSize; i++) {
            int currLoc = i;
            E currE = list.get(i);
            E nextE = list.get(i + 1);
            while (currE.compareTo(nextE) > 0 && currLoc >= 0) {
                currE = list.get(currLoc - 1);
                currLoc--;
            }
            if (currLoc != i) {
                list.add(currLoc + 1, list.remove(i+1));
            }
        }
    }

    public static <E extends Comparable<E>> void mergeSort(List<E> list) {
        List<E> tempList = mergeSortRecurse(list);
        list.clear();
        list.addAll(tempList);
    }
    
    private static <E extends Comparable<E>> List<E> mergeSortRecurse(List<E> list) {
        if (list.size() <= 1) {
            return list;
        } else {
            List<E> listA = new ArrayList<E>();
            List<E> listB = new ArrayList<E>();
            for (int i = 0; i < list.size(); i++) {
                if (i%2 == 0) {
                    listA.add(list.get(i));
                } else {
                    listB.add(list.get(i));
                }
            }
            return merge(mergeSortRecurse(listA), mergeSortRecurse(listB));
        }
    }
    
    private static <E extends Comparable<E>> List<E> merge(List<E> listA, List<E> listB) {
        List<E> listMerge;
        listMerge = new ArrayList<E>();
        while (listA.size() > 0 && listB.size() > 0) {
            E compareA = listA.get(0);
            E compareB = listB.get(0);
            if (compareA.compareTo(compareB) > 0) {
                listMerge.add(listB.remove(0));
            } else {
                listMerge.add(listA.remove(0));
            }
        }
        if (listA.size() > 0) {
            while (listA.size() > 0) {
                listMerge.add(listA.remove(0));
            }
        } else if (listB.size() > 0) {
            while (listB.size() > 0) {
                listMerge.add(listB.remove(0));
            }
        }
        return listMerge;
    }
    
    public static <E extends Comparable<E>> void quickSort(List<E> list) {
        List<E> tempList = mergeSortRecurse(list);
        list.clear();
        list.addAll(tempList);
    }

    // private static <E extends Comparable<E>> List<E> quickSortRecurse(List<E> list) {
        // pivot not wise idea to throw privot into the list
        // it needs to be left out to get a size of 1 and not recursive infinitely
        // base case
        // split
        // merge
    // }
    // public static <E extends Comparable<E>> void bucketSort(List<E> list)
    
}

