package MainAndClasses;

// SUPER CLASS/ PARENT CLASS 
public abstract class Vehicle{ 
    // PROTECTED VARIABLES (ENCAPSULATION)
    protected String brand;
    protected String color;
    protected String serviceChoices;

    
    // OVERLOADED CONSTRUCTORS
    Vehicle(String brand, String color, String serviceChoices){
        this.brand = brand;
        this.color = color;
        this.serviceChoices = serviceChoices;
    }

    // ABSTRACT METHOD 
    abstract void displaySummary();

    // GETTERS
    String getBrand(){
        return this.brand;
    }

    String getColor(){
        return this.color;
    }

    String getService(){
        switch(serviceChoices){
            case "1" : return "REGULAR CARWASH";
            case "2" : return "CARWASH W/ BUFFING WAX";
            case "3" : return "ENGINE WASH";
            default  : return "INVALID SERVICE";
        }
    }

    // SETTERS
    void setBrand(String brand){
        this.brand = brand;
    }

    void setColor(String color){
        this.color = color;
    }

    void setService(String serviceChoices){
        this.serviceChoices = serviceChoices;
    }
    

}

