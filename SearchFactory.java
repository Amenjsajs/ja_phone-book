package phonebook;

public class SearchFactory {
    public static SearchInterface getSearch(SearchType type) {
        if (SearchType.LINEAR_SEARCH.equals(type)) {
            return new LinearSearch();
        } else if (SearchType.BINARY_SEARCH.equals(type)) {
            return new BinarySearch();
        } else if (SearchType.JUMP_SEARCH.equals(type)) {
            return new JumpSearch();
        }
        return null;
    }

    public enum SearchType {
        LINEAR_SEARCH, BINARY_SEARCH, JUMP_SEARCH;
    }
}
