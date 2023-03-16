package phonebook;

public abstract class AbstractSearch implements SearchInterface{
    protected long start;
    protected long end;
    protected int foundNumber = 0;
    protected int elementsSize = 0;

    public int getFoundNumber(){
        return foundNumber;
    }
    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int getElementsSize() {
        return elementsSize;
    }
}
