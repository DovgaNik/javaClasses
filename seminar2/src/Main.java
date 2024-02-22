import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("How many entries do you want to do?: ");
        int n = Integer.parseInt(reader.nextLine());

        Vehicle[] Vehicles =new Vehicle[n];

        for (int i = 0; i < Vehicles.length; i++) {
            Vehicles[i]=new Vehicle();
            Vehicles[i].setter();
        }

        for (int i = 0; i < Vehicles.length; i++){
            Vehicles[i].info();
        }
    }
}