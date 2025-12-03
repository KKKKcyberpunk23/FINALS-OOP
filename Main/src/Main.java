package MainAndClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
// FOR FILE HANDLING
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;

import java.time.LocalDate;

public class Main {
    public static void main(String[]args){
    
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Vehicle>> dailyRecords = new HashMap<>();
        String today = LocalDate.now().toString();
        dailyRecords.putIfAbsent(today, FileHandler.loadTransactions(today));

        boolean is_running = true;

        while(is_running){

            System.out.println("******************************************************************************");
            System.out.println("\t\t\tCARWASH MANAGEMENT SYSTEM  ");
            System.out.println("******************************************************************************");
            System.out.println("  \t\t\t1 - Add Customer Vehicle ");
            System.out.println("  \t\t\t2 - Edit Customer Vehicle ");
            System.out.println("  \t\t\t3 - Show Transactions");
            System.out.println("  \t\t\t4 - Daily Data and Summary");
            System.out.println("  \t\t\t5 - Prices Info");
            System.out.println("  \t\t\t6 - Exit   ");
            System.out.print(" \t\t\tEnter Choice: ");
            String choice = scanner.nextLine();

            switch(choice){
                case "1" ->{
                    String vehicleChoice;

                    while (true){
                        System.out.println("\n******************************************************************************");
                        System.out.println("         \t\t     WHAT VEHICLE? ");
                        System.out.println("       \t\t\t1 - Car");
                        System.out.println("       \t\t\t2 - Motorcycle");
                        System.out.println("       \t\t\t3 - Van");
                        System.out.println("       \t\t\t4 - Custom");
                        System.out.print("\t\t\tEnter choice: ");
                        vehicleChoice = scanner.nextLine();

                        if (vehicleChoice.equals("1") || vehicleChoice.equals("2") || 
                            vehicleChoice.equals("3") || vehicleChoice.equals("4")) {
                            break;
                        } else {
                            System.out.println("\n\t\t   Invalid choice! Please Try Again.");
                        }
                    } 
                   


                    
                    String serviceChoices;

                    while (true){
                        System.out.println("\n******************************************************************************");
                        System.out.println("\t\t\t   CHOOSE SERVICES: ");

                        if (vehicleChoice.equals("2")){
                            System.out.println("\t\t\t1 - Regular CarWash");
                            System.out.println("\t\t\t2 - w/ Buffing Wax");
                        }
                        else {
                            System.out.println("\t\t\t1 - Regular CarWash");
                            System.out.println("\t\t\t2 - w/ Buffing Wax");
                            System.out.println("\t\t\t3 - Engine Wash");
                        }
    
                        System.out.print("\t\t\tEnter choice: ");
                        serviceChoices = scanner.nextLine();

                        if ((vehicleChoice.equals("2") && (serviceChoices.equals("1") || serviceChoices.equals("2"))) ||
                            (!vehicleChoice.equals("2") && (serviceChoices.equals("1") || serviceChoices.equals("2") || serviceChoices.equals("3")))) {
                            break;
                        } else {
                            System.out.println("\n\t\t   Invalid Choice! Please Try Again.");
                        }
                    }
                    
                    
                    Vehicle vehicles; // POLYMORPHISM
                    dailyRecords.putIfAbsent(today, new ArrayList<>());

                    switch(vehicleChoice){
                        case "1" ->{ 
                            System.out.println("\n******************************************************************************");
                            System.out.print("\t\t   Enter Car's Brand: ");
                            String brand = scanner.nextLine();

                            System.out.print("\t\t   Enter Car's Color: ");
                            String color = scanner.nextLine();

                            String size;

                            while (true){
                                System.out.print("\t\t   Enter Car's Size (SML/MED/LRGE): ");
                                size = scanner.nextLine();

                                if (size.equalsIgnoreCase("SML") || size.equalsIgnoreCase("MED") || size.equalsIgnoreCase("LRGE")){
                                    break;
                                }
                                else{
                                    System.out.println("\n\t\t   Invalid choice! Please Try Again.\n");
                                }
                            }

                            

                            vehicles = new Car(brand, color, size, serviceChoices); // RUNTIME POLYMORPHISM

                            dailyRecords.get(today).add(vehicles);
                            vehicles.displaySummary();
                    
                            System.out.println("\n\t            Transaction Successfully Saved!\n");
                        }

                        case "2" ->{
                            System.out.println("\n******************************************************************************");
                            System.out.print("\t\t   Enter Motorcycle Brand: ");
                            String brand = scanner.nextLine();

                            System.out.print("\t\t   Enter Motorcycle Color: ");
                            String color = scanner.nextLine();


                            boolean hasSideCars;

                            while (true){
                                System.out.print("\t\tDoes Motorcycle Have Side Car? (true/false): ");
                                String input = scanner.nextLine();

                                if (input.equalsIgnoreCase("true")){
                                    hasSideCars = true;
                                    break;
                                }
                                else if(input.equalsIgnoreCase("false")){
                                    hasSideCars = false;
                                    break;
                                }   
                                else{
                                    System.out.println("\n\t\t   Invalid Input! Please Try Again.\n");
                                }
                            }

                            vehicles = new Motorcycle(brand, color, hasSideCars, serviceChoices); // RUNTIME POLYMORPHISM

                            dailyRecords.get(today).add(vehicles);
                            vehicles.displaySummary();

                            System.out.println("\n\t            Transaction Successfully Saved!\n");

                        }

                        case "3" ->{
                            System.out.println("\n******************************************************************************");
                            System.out.print("\t\t\tEnter Van's Brand: ");
                            String brand = scanner.nextLine();

                            System.out.print("\t\t\tEnter Van's Color: ");
                            String color = scanner.nextLine();

                            vehicles = new Van(brand, color, serviceChoices); // RUNTIME POLYMORPHISM

                            dailyRecords.get(today).add(vehicles);
                            vehicles.displaySummary();

                            System.out.println("\n\t            Transaction Successfully Saved!\n");
                        }

                        case "4" ->{
                            System.out.println("\n******************************************************************************");
                            System.out.print("\t\t   Enter the unique vehicle: ");
                            String uniqueVehicle  = scanner.nextLine();

                            System.out.printf("\t\t   Enter %s brand: ", uniqueVehicle);
                            String brand = scanner.nextLine();

                            System.out.printf("\t\t   Enter %s color: ", uniqueVehicle);
                            String color = scanner.nextLine();

                            System.out.print("\t\t   Enter negotiation/ recommended price: ");
                            double price = scanner.nextDouble();
                            scanner.nextLine();

                            vehicles = new Custom(brand, color, price, uniqueVehicle, serviceChoices); // RUNTIME POLYMORPHISM
                            dailyRecords.get(today).add(vehicles);

                            vehicles.displaySummary();

                            
                            System.out.println("\n\t             Transaction Successfully Saved!\n");

                        }

                        default ->{
                            System.out.println("\n\t\t    Invalid choice! Please Try Again.\n");
                        }

                    }
                    // File sender loc
                    FileHandler.saveTransactions(dailyRecords.get(today));
                    FileHandler.saveDailySummary(dailyRecords.get(today));
                }

                case "2" -> {
                    ArrayList<Vehicle> list = dailyRecords.get(today);

                    if (list == null || list.isEmpty()) {
                        System.out.println("\n\t\t\tNo transactions to edit\n");
                        break;
                    }


                    System.out.println("\n******************************************************************************");
                    System.out.println("\t\t\t     TRANSACTION LISTS");
                    System.out.println("******************************************************************************");

                    for (int i = 0; i < list.size(); i++) {
                        System.out.printf("[%d]", i + 1);
                        list.get(i).displaySummary();
                    }



                    int index;
                    while (true) {
                        try {
                            System.out.print("\n\t\t     Enter the transaction number to edit: ");
                            index = Integer.parseInt(scanner.nextLine()) - 1;

                            if (index < 0 || index >= list.size()) {
                                System.out.println("\n\t\t        Invalid Choice! Please Try Again.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("\n\t\t      Invalid input! Please enter a number.");
                        }
                    }

                    Vehicle selectedVehicle = list.get(index);

                    System.out.println("\n******************************************************************************");
                    System.out.print("\n\t\t Enter new brand (press ENTER to keep current): ");
                    String newBrand = scanner.nextLine();
                    if (!newBrand.isBlank()) {
                        selectedVehicle.setBrand(newBrand);
                    }

                    System.out.print("\t\t Enter new color (press ENTER to keep current): ");
                    String newColor = scanner.nextLine();
                    if (!newColor.isBlank()) {
                        selectedVehicle.setColor(newColor);
                    }

                    System.out.println("\n\t\t Current Service: " + selectedVehicle.getService());
                    String changeService;
                    while (true){
                        System.out.print("\n\t\t Change Service? (y/n): ");
                        changeService = scanner.nextLine();

                        if (changeService.equalsIgnoreCase("y")) {
                            String newServiceChoice;
                            while (true) {
                                System.out.print("\n******************************************************************************");
                                System.out.println("\n\t\t\t      CHOOSE SERVICE:");
                                if (selectedVehicle instanceof Motorcycle) {
                                    System.out.println("\t\t\t   1 - Regular CarWash");
                                    System.out.println("\t\t\t   2 - w/ Buffing Wax");
                                } else {
                                    System.out.println("\t\t\t   1 - Regular CarWash");
                                    System.out.println("\t\t\t   2 - w/ Buffing Wax");
                                    System.out.println("\t\t\t   3 - Engine Wash");
                                }

                                System.out.print("\t\t\t  Enter choice: ");
                                newServiceChoice = scanner.nextLine();

                                if ((selectedVehicle instanceof Motorcycle && (newServiceChoice.equals("1") || newServiceChoice.equals("2"))) ||
                                    (!(selectedVehicle instanceof Motorcycle) && (newServiceChoice.equals("1") || newServiceChoice.equals("2") || newServiceChoice.equals("3")))) {
                                    break;
                                } else {
                                    System.out.println("\n\t\t   Invalid Choice! Please Try Again.");
                                }
                            }

                            selectedVehicle.setService(newServiceChoice);

                            // USING INSTANCE OF (POLYMORPHISM)
                            if (selectedVehicle instanceof Car car) {
                                car.setPrice();
                            } else if (selectedVehicle instanceof Motorcycle motorcycle) {
                                motorcycle.setPrice();
                            } else if (selectedVehicle instanceof Van van) {
                                van.setPrice();
                            }

                            System.out.print("\n******************************************************************************");
                            System.out.println("\n\t\t\t  Updated Transaction:");
                            selectedVehicle.displaySummary();
                            System.out.println("\n\t\t   Transaction Updated Successfully!\n");
                            break;
                        }
                        else if(changeService.equalsIgnoreCase("n")){
                            System.out.print("\n******************************************************************************");
                            System.out.println("\n\t\t\t  Updated Transaction:");
                            selectedVehicle.displaySummary();
                            System.out.println("\n\t\t   Transaction Updated Successfully!\n");
                            break;
                        }
                        else{
                            System.out.println("\n\t\t     Invalid Choice! Please Try Again.");
                        }
                    }
                    FileHandler.saveTransactions(dailyRecords.get(today));
                    FileHandler.saveDailySummary(dailyRecords.get(today));
                }

                case "3" ->{

                    ArrayList<Vehicle> list = dailyRecords.get(today);

                    if (list == null || list.isEmpty()) {
                        System.out.println("\n\t\t\tNo transactions to see\n");
                        break;
                    }

                    
                    // SAVING DATA FILE (KAW NA BAHALA JUSTIN)
                    // String filePath = ""; (lalagay mo dito ay yung filePath ng transactions.txt)
                    // try(FileReader saveTransactions = new FileReader(filePath)){

                    // } catch(FileNotFoundException e){
                    //     System.out.println("File Not Found!");
                    // } catch (IOException e){
                    //     System.out.println("Something Went Wrong!");
                    // }

                    System.out.println("\n******************************************************************************");
                    System.out.print("\t\t\t       ALL TRANSACTIONS");
                    System.out.println("\n******************************************************************************");
                    System.out.printf("\t\t\t\t[%s]\n", today);
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.printf("| %-13s | %-15s | %-15s | %-22s | %-7s |\n", "VEHICLE", "BRAND", "COLOR", "SERVICE", "PRICE");
                    
                    for (Vehicle vehicle : list){
                        vehicle.displaySummary();
                    }
                    FileHandler.saveTransactions(list);


                    System.out.println();
                }

                case "4" ->{

                    ArrayList<Vehicle> list = dailyRecords.get(today);

                    if (list == null || list.isEmpty()) {
                        System.out.println("\n\t\t\t   No summary to see\n");
                        break;
                    }

                    // // SAVING DATA SUMMARY (KAW NA BAHALA JUSTIN)
                    // String filePath = "" (dito mo ilalagay filePath ng dataSummary.txt)
                    // try(FileReader saveDataSummary = new FileReader(filePath)){

                    // }
                    // catch(FileNotFoundException e){
                    //     System.out.println("File Not Found!");
                    // }
                    // catch (IOException e){
                    //     System.out.println("Something Went Wrong!");
                    // }
                        
                    int totalRegCarWash = 0;
                    int totalBuffingWax = 0;
                    int totalEngineWash = 0;
                    double totalRevenue = 0.0;

                    for (Vehicle vehicle : list){
                        switch(vehicle.getService()){
                            case "REGULAR CARWASH" -> totalRegCarWash++;
                            case "CARWASH W/ BUFFING WAX" -> totalBuffingWax++;
                            case "ENGINE WASH" -> totalEngineWash++;
                        }

                        if (vehicle instanceof Car car){
                            totalRevenue += car.getPrice();
                        }
                        else if(vehicle instanceof Motorcycle motorcycle){
                            totalRevenue += motorcycle.getPrice();
                        }
                        else if(vehicle instanceof Van van){
                            totalRevenue += van.getPrice();
                        }
                        else if(vehicle instanceof Custom custom){
                            totalRevenue += custom.getPrice();
                        }
                    }


                    

                    System.out.println("\n******************************************************************************");
                    System.out.print("\t\t\t   DAILY SUMMARY EVERYDAY");
                    System.out.println("\n******************************************************************************");
                    System.out.printf("\t\t\t\t[%s]\n", today);
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.printf(" \t\t\tTOTAL TRANSACTION/S: %d\n", list.size());
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.printf("| %-36s | %-35s |\n", "Vehicle Count", "Services Count");
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.printf("| %-35s%d | %-34s%d |\n","Car:", Car.getTotalCar(), "Regular CarWash:", totalRegCarWash);
                    System.out.printf("| %-35s%d | %-34s%d |\n", "Motorcycle/Tricycle:", Motorcycle.getTotalMotorcycles(), "Carwash w/ Buffing Wax:", totalBuffingWax);
                    System.out.printf("| %-35s%d | %-34s%d |\n", "Van:",Van.getTotalVan(), "Engine Wash:", totalEngineWash);
                    System.out.printf("| %-35s%d |                                     |\n", "Custom:",Custom.getTotalUniqueVehicles());
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.printf("\t\t\t  TOTAL REVENUE: $%.2f                              \n", totalRevenue);
                    System.out.println("------------------------------------------------------------------------------");

                    System.out.println("");
                    FileHandler.saveDailySummary(list);


                }

                case "5" ->{
                    // kaw nadin mag gawa justin, akoy wala na sa mood HAHAAH 
                    // listahan lang to ng mga prices ng cars (sml, med, lrge), motorcycle/tricycle, van at custom vehicles with services
                    // naka table sya para maganda, pero kung may naiisip kapang mas maganda dun edi g
                        PriceInfo.displayPrices();
                        scanner.nextLine(); // pause until ENTER


                }

                case "6" ->{
                    System.out.println("\n******************************************************************************");
                    System.out.println("\t\tTHANK YOU FOR USING THE CARWASH MANAGEMENT SYSTEM!");
                    System.out.println("******************************************************************************");                    
                    is_running = false;
                }
            }
        }

        scanner.close();

    } 
} 



