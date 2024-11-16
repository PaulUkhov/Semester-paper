public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean isClosed = false;

    public void add() {
        if (isClosed) {
            throw new IllegalStateException("Ресурс уже закрыт!");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        if (isClosed) {
            throw new IllegalStateException("Ресурс уже был закрыт!");
        }
        isClosed = true;
        System.out.println("Счетчик закрыт. Количество заведенных животных: " + count);
    }
}



