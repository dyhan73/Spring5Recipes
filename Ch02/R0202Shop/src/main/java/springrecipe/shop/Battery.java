package springrecipe.shop;

public class Battery extends Product {
    private boolean rechargable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public boolean isRechargable() {
        return rechargable;
    }

    public void setRechargable(boolean rechargable) {
        this.rechargable = rechargable;
    }
}
