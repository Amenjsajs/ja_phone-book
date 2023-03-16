package phonebook;

public class BubbleSort extends AbstractSort {

    private long stopValue;
    private boolean completeSorting = false;

    public BubbleSort(long stopValue) {
        this.stopValue = stopValue * 10;
    }

    @Override
    public void sort(String[] list) {
        start = System.currentTimeMillis();
        String lineTmp;
        int len = list.length;
        boolean swapNeeded = true;
        for (int i = 0; i < len; i++) {
            swapNeeded = false;
            for (int j = 1; j < (len - i); j++) {
                if (Helpers.getFullName(list[j - 1]).compareTo(Helpers.getFullName(list[j])) > 0) {
                    lineTmp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = lineTmp;
                    swapNeeded = true;
                }

                if ((System.currentTimeMillis() - start) >= stopValue) {
                    completeSorting = false;
                    end = System.currentTimeMillis() - start;
                    return;
                }
            }
            if(!swapNeeded) {
                break;
            }
        }
        completeSorting = true;
        end = System.currentTimeMillis() - start;
    }

    public boolean isCompleteSorting() {
        return completeSorting;
    }

    public void setStopValue(long stopValue) {
        this.stopValue = stopValue;
    }
}
