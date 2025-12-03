package MainAndClasses;

public class PriceInfo {

    public static void displayPrices() {

        System.out.println("\n******************************************************************************");
        System.out.println("\t\t\t        PRICE LIST INFORMATION");
        System.out.println("******************************************************************************");

        // CAR PRICES
        System.out.println("\nCAR PRICES:");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-8s | %-8s | %-8s |\n", "SERVICE", "SMALL", "MED", "LARGE");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-8s | %-8s | %-8s |\n", "Regular Carwash", "150", "200", "250");
        System.out.printf("| %-30s | %-8s | %-8s | %-8s |\n", "Carwash w/ Buffing Wax", "250", "300", "350");
        System.out.printf("| %-30s | %-8s | %-8s | %-8s |\n", "Engine Wash", "500", "550", "600");
        System.out.println("-------------------------------------------------------------------------------");

        // MOTORCYCLE
        System.out.println("\nMOTORCYCLE PRICES:");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %-35s | %-10s |\n", "Regular Carwash", "120");
        System.out.printf("| %-35s | %-10s |\n", "Carwash w/ Buffing Wax", "220");
        System.out.println("--------------------------------------------------------------");

        // TRICYCLE
        System.out.println("\nTRICYCLE PRICES:");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %-35s | %-10s |\n", "Regular Carwash", "180");
        System.out.printf("| %-35s | %-10s |\n", "Carwash w/ Buffing Wax", "280");
        System.out.println("--------------------------------------------------------------");

        // VAN
        System.out.println("\nVAN PRICES:");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-10s |\n", "Regular Carwash", "300");
        System.out.printf("| %-30s | %-10s |\n", "Carwash w/ Buffing Wax", "400");
        System.out.printf("| %-30s | %-10s |\n", "Engine Wash", "650");
        System.out.println("-------------------------------------------------------------------------------");

        // CUSTOM VEHICLE
        System.out.println("\nCUSTOM VEHICLE:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("| CARWASH                 | NEGOTIATED PRICE (customer decides) |");
        System.out.println("| Carwash w/ Buffing Wax | NEGOTIATED PRICE (customer decides) |");
        System.out.println("| Engine Wash            | NEGOTIATED PRICE (customer decides) |");
        System.out.println("--------------------------------------------------------------");

        System.out.println("\n\t\tPress ENTER to return to menu...");
    }
}
