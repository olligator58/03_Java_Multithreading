package Task50160.car;

public class Truck extends Car {

    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
