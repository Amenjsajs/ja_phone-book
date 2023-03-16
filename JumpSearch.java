package phonebook;

public class JumpSearch extends AbstractSearch {

    public JumpSearch() {
    }

    public void search(String[] list, String... elementsToSearch) {
        elementsSize = elementsToSearch.length;
        start = System.currentTimeMillis();
        foundNumber = 0;
        for (String item : elementsToSearch) {
            if (search2(list, item) != -1) {
                foundNumber++;
            }
        }
        end = System.currentTimeMillis() - start;
    }

    private int search(String[] list, String needed) {
        if (list.length == 0) {
            return -1;
        }

        int curr = 0;
        int prev = 0;
        int last = list.length - 1;
        int step = (int) Math.floor(Math.sqrt(last));

        while (Helpers.getFullName(list[curr]).compareTo(needed) < 0) {
            if (curr == last) {
                return -1;
            }

            prev = curr;
            curr = Math.min(curr + step, last);
        }

        while (Helpers.getFullName(list[curr]).compareTo(needed) > 0) {
            curr = curr - 1;
            if (curr <= prev) {
                return -1;
            }
        }

        if (Helpers.getFullName(list[curr]).equals(needed)) {
            return curr;
        }

        return -1;
    }

    private int search2(String[] list, String needed) {
        int prev = 0;
        int n = list.length;
        int step = (int) Math.floor(Math.sqrt(n));

        //loop until current element is less than the given search element
        while (Helpers.getFullName(list[Math.min(step, n) - 1]).compareTo(needed) < 0) {
            prev = step;
            step += step;
            if (prev >= n) return -1;
        }

        //perform linear search prev index element to given element
        while (Helpers.getFullName(list[prev]).compareTo(needed) < 0) {
            prev++;
            if (prev == Math.min(step, n)) return -1;
        }

        // Return index if element is found
        if (Helpers.getFullName(list[prev]).equals(needed)) return prev;

        return -1;
    }
}
