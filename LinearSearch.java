package phonebook;

public class LinearSearch extends AbstractSearch {
    @Override
    public void search(String[] list, String... elementsToSearch) {
        elementsSize = elementsToSearch.length;
        start = System.currentTimeMillis();
        foundNumber = 0;
        for (String element : elementsToSearch) {
            for (String item : list) {
                if (element.equals(Helpers.getFullName(item))) {
                    foundNumber++;
                    break;
                }
            }
        }
        end = System.currentTimeMillis() - start;
    }
}
