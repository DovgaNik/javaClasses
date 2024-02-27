import java.util.Scanner;

public class CalculatorUI {

    public static Scanner reader = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        CalculatorUI ui = new CalculatorUI();
        Calculator calculator = ui.readCalculator();
        
        String[] options = {"Change First Number", "Change Second Number","+","-","*","/","Exit"};
        
        while (true){
            try {
                int choice = ui.menu(options);
                ui.runChoice(calculator, choice);
            } catch (Exception e) {
                System.out.println("An error " + e.getLocalizedMessage() + " has occured, please retry...");
            }
        }                      
    }


    public void runChoice(Calculator calculator, int choice) {
        switch (choice){
            case 1 ->{
                System.out.println("Please enter the new value for the first number: ");
                double firstNumber = Double.parseDouble(reader.nextLine());
                calculator.setFirstNumber(firstNumber);
                System.out.println("First number changed successfully");                
            }
            case 2 ->{ 
                System.out.println("Please enter the new value for the second number: ");
                double secondNumber = Double.parseDouble(reader.nextLine());
                calculator.setSecondNumber(secondNumber);
                System.out.println("Second number changed successfully");
            }
            case 3 ->{
                double result = calculator.plus();
                System.out.println(calculator.getFirstNumber() + " + " + calculator.getSecondNumber() + "= " + result);
            
            }
            case 4 ->{
                double result = calculator.minus();
                System.out.println(calculator.getFirstNumber() + " - " + calculator.getSecondNumber() + "= " + result);
            
            }
            case 5 ->{
                double result = calculator.multiplication();
                System.out.println(calculator.getFirstNumber() + " * " + calculator.getSecondNumber() + "= " + result);
            
            }
            case 6 ->{
                double result = calculator.division();
                System.out.println(calculator.getFirstNumber() + " / " + calculator.getSecondNumber() + "= " + result);
            
            }
            case 7 -> System.exit(0);
        
        }
        
    }

    public int choiceValidator(int choice) throws Exception {

        if (choice >= 1 && choice <= 7)
            return choice;
        else
            throw new Exception("Invalid choice input");

    }

    public int menu(String[] options ) throws Exception {
        displayMenu(options);
        System.out.println("Please enter your choice: ");
        int choice = choiceValidator(Integer.parseInt(reader.nextLine()));

        return choice;
    
    }
    
    
    public void displayMenu(String[] options){
        System.out.println("-------------------");
        for (int i=0;i<options.length;i++)
            System.out.println((i+1)+". "+options[i]);                           
        System.out.println("-------------------");
    }


    public Calculator readCalculator(){
        while (true){
            try{
                System.out.println("Please enter the first number: ");
                double firstNumber = Double.parseDouble(reader.nextLine());
                System.out.println("Please enter the second number: ");
                double secondNumber = Double.parseDouble(reader.nextLine());
                return new Calculator(firstNumber, secondNumber);
            } catch (NumberFormatException e)
            {
                System.out.println("Please input valid numbers!");

            }
        }    
    }
}
