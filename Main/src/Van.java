package MainAndClasses;

// SUBCLASS / CHILD CLASS
public class Van extends Vehicle{ // INHERITS THE VEHICLE CLASS (SUPER CLASS)

    private double price; // PRIVATE (ENCAPSULATION)
    static int numOfVan; // STATIC VARIABLE

    // OVERLOADED CONSTRUCTORS
    Van (String brand, String color, String serviceChoices){
        super(brand, color, serviceChoices);
        setPrice();
        numOfVan++;
    }

    // GETTERS
    double getPrice(){
        return price;
    }

    // SETTERS
    void setPrice() {
        switch(getService()) {
            case "REGULAR CARWASH" ->{
                price = 300;
                break;
            }
            case "CARWASH W/ BUFFING WAX" ->{
                price = 400;
                break;
            }
            case "ENGINE WASH" ->{
                price = 650;
                break;
            }
            default->{
                price = 300;
            }
        }
    }

    // STATIC METHOD
    static int getTotalVan(){
        return numOfVan;
    }


    // OVERRIDING THE ABSTRACT METHOD IN VEHICLE CLASS
    @Override
    void displaySummary(){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %-13s | %-15s | %-15s | %-22s | $%-7.2f |\n", "VAN", getBrand().toUpperCase(), getColor().toUpperCase(), getService(), this.price);
        System.out.println("----------------------------------------------------------------------------------------");
    }

}