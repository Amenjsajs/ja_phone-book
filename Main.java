package phonebook;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        String directoryPath = "D:/projects/java/directory.txt";
        String findPath = "D:/projects/java/find.txt";

        String[] directory = Helpers.loadData(directoryPath);
        String[] elementsToFind = Helpers.loadData(findPath);

        System.out.println("Start searching (linear search)...");
        SearchInterface linearSearch = SearchFactory.getSearch(SearchFactory.SearchType.LINEAR_SEARCH);
        linearSearch.search(directory, elementsToFind);

        System.out.printf("Found %d / %d entries. Time taken: %s\n\n", linearSearch.getFoundNumber(), linearSearch.getElementsSize(), Helpers.getTaskTime(linearSearch.getEnd()));

        System.out.println("Start searching (bubble sort + jump search)...");

        //Start Bubble sort
        SortInterface bubbleSort = SortFactory.getSort(SortFactory.SortType.BUBBLE_SORT, linearSearch.getEnd());
        bubbleSort.sort(directory);
        //End Bubble sort

        SearchInterface search;
        if (!((BubbleSort) bubbleSort).isCompleteSorting()) {
            search = linearSearch;
            search.search(directory, elementsToFind);
        } else {
            //Start Jump Search
            search = SearchFactory.getSearch(SearchFactory.SearchType.JUMP_SEARCH);
            search.search(directory, elementsToFind);
            //End Jump Search
        }

        System.out.printf("Found %d / %d entries. Time taken: %s\n", search.getFoundNumber(), search.getElementsSize(), Helpers.getTaskTime(bubbleSort.getEnd() + search.getEnd()));
        if (!((BubbleSort) bubbleSort).isCompleteSorting()) {
            System.out.printf("Sorting time: %s - STOPPED, moved to linear search\n", Helpers.getTaskTime(bubbleSort.getEnd()));
        } else {
            System.out.printf("Sorting time: %s\n", Helpers.getTaskTime(bubbleSort.getEnd()));
        }
        System.out.printf("Searching time: %s\n\n", Helpers.getTaskTime(search.getEnd()));

        System.out.println("Start searching (quick sort + binary search)...");
        SortInterface quickSort = SortFactory.getSort(SortFactory.SortType.QUICK_SORT, 0);
        quickSort.sort(directory);

        SearchInterface binarySearch = SearchFactory.getSearch(SearchFactory.SearchType.BINARY_SEARCH);
        binarySearch.search(directory, elementsToFind);

        System.out.printf("Found %d / %d entries. Time taken: %s\n", binarySearch.getFoundNumber(), binarySearch.getElementsSize(), Helpers.getTaskTime(quickSort.getEnd() + binarySearch.getEnd()));
        System.out.printf("Sorting time: %s.\n", Helpers.getTaskTime(quickSort.getEnd()));
        System.out.printf("Searching time: %s\n\n", Helpers.getTaskTime(binarySearch.getEnd()));

        System.out.println("Start searching (hash table)...");
        long start = System.currentTimeMillis();
        HashMap<String, String> hashMap = Helpers.createHashTable(directory);
        long diffCreatingHashTable = System.currentTimeMillis() - start;

        int nb = 0;
        start = System.currentTimeMillis();
        for (String elm : elementsToFind) {
            if (hashMap.containsKey(elm)) {
                nb++;
            }
        }
        long diffSearchInHahTable = System.currentTimeMillis() - start;
        System.out.printf("Found %d / %d entries. Time taken: %s\n", nb, elementsToFind.length, Helpers.getTaskTime(diffCreatingHashTable + diffSearchInHahTable));
        System.out.printf("Creating time: %s.\n", Helpers.getTaskTime(diffCreatingHashTable));
        System.out.printf("Searching time: %s\n", Helpers.getTaskTime(diffSearchInHahTable));
    }
}
