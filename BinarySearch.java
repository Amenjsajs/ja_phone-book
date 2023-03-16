package phonebook;

public class BinarySearch extends AbstractSearch {
    @Override
    public void search(String[] list, String... elementsToSearch) {
        elementsSize = elementsToSearch.length;
        start = System.currentTimeMillis();
        foundNumber = 0;
        for (String item : elementsToSearch) {
            if (search(list, item) != -1) {
                foundNumber++;
            }
        }
        end = System.currentTimeMillis() - start;
    }

    private int search(String[] list, String needed) {
        int left = 0;
        int right = list.length - 1;
        int middle;

        String fullName;

        while (left <= right) {
            middle = (left + right) / 2;
            fullName = Helpers.getFullName(list[middle]);

            if (fullName.equals(needed)) {
                return middle;
            } else if (fullName.compareTo(needed) > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
