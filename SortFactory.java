package phonebook;

public class SortFactory {

    public static SortInterface getSort(SortType type, long stopValue) {
        if (SortType.BUBBLE_SORT.equals(type)) {
            return new BubbleSort(stopValue);
        } else if (SortType.QUICK_SORT.equals(type)) {
            return new QuickSort();
        }
        return null;
    }

    public enum SortType {
        BUBBLE_SORT, QUICK_SORT;
    }
}
