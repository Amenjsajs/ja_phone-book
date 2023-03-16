package phonebook;

public abstract class AbstractSort implements SortInterface{
    protected long start;
    protected long end;

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
}
