public class Car implements Traveller{
    private String make;
    private double speed;

    public Car (String make, double speed) {
        this.make = make;
        this.speed = speed;
    }

    public String getMake() {
        return make;
    }

    public double getSpeed() {
        return speed;
    }

    public double travel(double distance) {
        return distance / speed;
    }
}
