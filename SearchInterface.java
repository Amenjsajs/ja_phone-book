package phonebook;

public interface SearchInterface {
    void search(String[] list, String ...elementsToSearch);
    long getStart();

    long getEnd();

    int getElementsSize();

    int getFoundNumber();
}
