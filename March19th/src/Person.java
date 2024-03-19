public class Person {
    private String name;
    private double speed;

    public Person(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double travel(double distance) {
        return distance / speed;
    }
}
