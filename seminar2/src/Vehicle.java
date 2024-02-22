import java.util.Objects;
import java.util.Scanner;

public class Vehicle {
    private String name;
    private int yearOfConstruction;
    private String placeOfConstruction;
    private Boolean madeToCarryPassengers;
    private int cargoCapacity;
    private int maximumSpeed;


    public void info(){

        System.out.println("The vehicle " + name + " was constructed in " + yearOfConstruction + " in " + placeOfConstruction + " it is carrying passengers " + madeToCarryPassengers + " and it holds " + cargoCapacity + " units of payload at the maximum speed of " + maximumSpeed);

    }

    public void setter(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Name of vehicle: ");
        name = reader.nextLine();

        System.out.print("Year of construction: ");
        yearOfConstruction = Integer.parseInt(reader.nextLine());

        System.out.print("Place of construction: ");
        placeOfConstruction = reader.nextLine();

        System.out.print("Is it made to carry people (yes/no): ");
        String temp = reader.nextLine();
        if (Objects.equals(temp, "yes")){
            madeToCarryPassengers = true;
        } else {
            madeToCarryPassengers = false;
        }

        System.out.print("Cargo capacity: ");
        cargoCapacity = Integer.parseInt(reader.nextLine());

        System.out.print("Maximum speed: ");
        maximumSpeed = Integer.parseInt(reader.nextLine());


    }
}
