package MainAndClasses;

// SUBCLASS / CHILD CLASS
public class Motorcycle extends Vehicle{ // INHERITS TO VEHICLE CLASS (SUPER CLASS)

    boolean hasSideCars;
    private double price; // PRIVATE (ENCAPSULATION)
    static int numOfMotorcycles; // STATIC VARIABLE

    // OVERLOADED CONSTRUCTORS
    Motorcycle(String brand, String color, boolean hasSideCars, String serviceChoices){
        super(brand, color, serviceChoices);
        this.hasSideCars = hasSideCars;
        setPrice();
        numOfMotorcycles++;
    }

    // GETTERS
    double getPrice(){
        return price;
    }

    // SETTERS
    void setPrice() {
        switch (getService()) {
            case "REGULAR CARWASH":
                price = hasSideCars ? 180 : 120;
                break;
            case "CARWASH W/ BUFFING WAX":
                price = hasSideCars ? 280 : 220;
                break;
            default:
                price = hasSideCars ? 300 : 250; 
        }
    }


    // STATIC METHOD
    static int getTotalMotorcycles(){
        return numOfMotorcycles;
    }  

    // OVERRIDING THE ABSTRACT METHOD IN VEHICLE CLASS
    @Override
    void displaySummary(){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %-13s | %-15s | %-15s | %-22s | $%-7.2f |\n", hasSideCars ? "TRICYCLE" : "MOTORCYCLE", getBrand().toUpperCase(), getColor().toUpperCase(), getService(), this.price);
        System.out.println("----------------------------------------------------------------------------------------");
    }

}

