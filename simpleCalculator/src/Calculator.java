public class Calculator {
    
    private double firstNumber;
    private double secondNumber;
    
    public Calculator(double firstNumber, double secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    
    public double getFirstNumber(){
        return this.firstNumber;
    }
    
    public double getSecondNumber(){
        return this.secondNumber;
    }
    
    public void setFirstNumber(double firstNumber){
        this.firstNumber = firstNumber;
    }
    
    public void setSecondNumber(double secondNumber){
        this.secondNumber = secondNumber;
    }
    
    public double plus(){
        return this.firstNumber + this.secondNumber;
    }
    public double minus(){
        return this.firstNumber - this.secondNumber;
    }
    public double multiplication(){
        return this.firstNumber * this.secondNumber;
    }
    public double division() {        
        return this.firstNumber / this.secondNumber;
    }

    public double pow () {
        return Math.pow(firstNumber, this.secondNumber);
    }
}
