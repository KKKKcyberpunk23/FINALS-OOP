package MainAndClasses;

// SUBCLASS / CHILD CLASS
public class Car extends Vehicle{ // INHERITS TO VEHICLE CLASS (SUPER CLASS)
    String size;
    private double price; //PRIVATE (ENCAPSULATION)
    static int numOfCar; // STATIC VARIABLE

    // OVERLOADED CONSTRUCTORS
    Car(String brand, String color, String size, String serviceChoices){
        super(brand, color, serviceChoices);
        this.size = size;
        setPrice(); 
        numOfCar++;
    }

    // GETTERS
    double getPrice(){
        return price;
    }

    // SETTERS
    void setPrice() {
        switch (getService()) {
            case "REGULAR CARWASH" -> {
                if(size.equalsIgnoreCase("SML")){
                    this.price = 150;
                } 
                else if(size.equalsIgnoreCase("MED")){
                    this.price = 200;
                } 
                else{
                    price = 250;
                } 
            }
            case "CARWASH W/ BUFFING WAX" -> {
                if(size.equalsIgnoreCase("SML")){
                    this.price = 250;
                }
                else if(size.equalsIgnoreCase("MED")){
                    this.price = 300;
                }
                else{
                    price = 350;
                }
            }
            case "ENGINE WASH" -> {
                if(size.equalsIgnoreCase("SML")){
                    this.price = 500;
                } 
                else if(size.equalsIgnoreCase("MED")){
                    this.price = 550;
                } 
                else{
                    this.price = 600;
                } 
            }
        }
    }

    // STATIC METHOD
    static int getTotalCar(){
        return numOfCar;
    }

    // OVERRIDING THE ABSTRACT METHOD IN VEHICLE CLASS
    @Override
    void displaySummary(){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %-13s | %-15s | %-15s | %-22s | $%-7.2f |\n", "Car (" + size.toUpperCase() + ")", getBrand().toUpperCase(), getColor().toUpperCase(), getService(), this.price);
        System.out.println("----------------------------------------------------------------------------------------");
    }

}