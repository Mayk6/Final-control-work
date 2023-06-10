package Services;

public class PetCounter implements AutoCloseable {

    private int counter;

    public int getCounter() {
        return counter;
    }

    public void add() {
        counter++;
    }

    @Override
    public void close() {
        System.out.println("Counter close");
    }
}
