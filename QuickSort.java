package phonebook;

public class QuickSort extends AbstractSort {
    @Override
    public void sort(String[] list) {
        start = System.currentTimeMillis();
        sort(list, 0, list.length - 1);
        end = System.currentTimeMillis() - start;
    }

    private void sort(String[] list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);

            sort(list, low, partitionIndex - 1);
            sort(list, partitionIndex + 1, high);
        }
    }

//    private int partition(String[] list, int lower, int high) {
//        String pivot = list[high];
//        String tmp;
//        int k = lower - 1;
//        for (int i = lower, len = high - 1; i < len; i++) {
//            if (list[i].compareTo(pivot) <= 0) {
//                k++;
//                tmp = list[i];
//                list[i] = list[k];
//                list[k] = tmp;
//            }
//        }
//        k++;
//        tmp = list[list.length - 1];
//        list[list.length - 1] = list[k];
//        list[k] = tmp;
//        return k;
//    }

    private int partition(String[] list, int low, int high) {
        String pivot = list[high];

        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (Helpers.getFullName(list[j]).compareTo(Helpers.getFullName(pivot)) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(String[] list, int i, int j) {
        String tmp = list[j];
        list[j] = list[i];
        list[i] = tmp;
    }
}
