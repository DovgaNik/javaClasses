import java.util.*;
public class Main {
    public static void main(String[] args) {

        Person person = new Person("John", 10);
        Car car = new Car("Dacia", 120);

        System.out.println(person.getName() + " will take " + person.travel(20) + " hours");
        System.out.println(car.getMake() + " will take " + car.travel(200) + " hours");

        List<Traveller> travellers = new ArrayList<>();
        travellers.add(person);
        travellers.add(car);

        for (Traveller traveller : travellers) {
            System.out.println(traveller.travel(100));
        }
    }


}
