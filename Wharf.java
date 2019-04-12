public class Wharf {
    private boolean empty;
    private int warehouse;

    public Wharf() {
        super();
        this.empty = true;
        this.warehouse = 0;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }


}
