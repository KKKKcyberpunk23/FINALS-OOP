package MainAndClasses;

// SUBCLASS / CHILD CLASS
public class Custom extends Vehicle{ // INHERITS THE VEHICLE CLASS (SUPER CLASS)
     
    String vehicle;
    double price;
    static int numOfUniqueVehicles; // STATIC VARIABLE

    // OVERLOADED CONSTRUCTORS
    Custom(String brand, String color, double price, String vehicle, String serviceChoices){
        super(brand, color, serviceChoices);
        this.price = price;
        this.vehicle = vehicle;

        numOfUniqueVehicles++;
    }

    // GETTERS
    double getPrice(){
        return price;
    }

    // STATIC METHODS
    static int getTotalUniqueVehicles(){
        return numOfUniqueVehicles;
    }


    // OVERRIDING THE ABSTRACT METHOD IN VEHICLE CLASS
    @Override
    void displaySummary(){
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %-13s | %-15s | %-15s | %-22s | $%-7.2f |\n", vehicle.toUpperCase(), getBrand().toUpperCase(), getColor().toUpperCase(), getService(), this.price);
        System.out.println("----------------------------------------------------------------------------------------");
    }

}
