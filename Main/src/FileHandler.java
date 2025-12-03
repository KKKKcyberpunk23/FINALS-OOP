package MainAndClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private static final String FOLDER_PATH = "C:\\Users\\mabuc\\Desktop\\BSU\\Main\\src\\CarwashRecords";

    // Ensure folder exists
    static {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    // Save all transactions to file
    public static void saveTransactions(ArrayList<Vehicle> list) {
        if (list == null || list.isEmpty()) return;
        String today = java.time.LocalDate.now().toString();
        File file = new File(FOLDER_PATH + "\\" + today + "_transactions.txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Vehicle v : list) {
                String vehicleType = getVehicleType(v);
                double price = getPrice(v);
                pw.printf("%s,%s,%s,%s,%.2f%n",
                        v.getBrand(),
                        v.getColor(),
                        vehicleType,
                        v.getService(),
                        price);
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }

    // Save daily summary to file
    public static void saveDailySummary(ArrayList<Vehicle> list) {
        if (list == null || list.isEmpty()) return;
        String today = java.time.LocalDate.now().toString();
        File file = new File(FOLDER_PATH + "\\" + today + "_summary.txt");

        int totalRegCarWash = 0;
        int totalBuffingWax = 0;
        int totalEngineWash = 0;
        double totalRevenue = 0;

        for (Vehicle v : list) {
            switch (v.getService()) {
                case "REGULAR CARWASH" -> totalRegCarWash++;
                case "CARWASH W/ BUFFING WAX" -> totalBuffingWax++;
                case "ENGINE WASH" -> totalEngineWash++;
            }
            totalRevenue += getPrice(v);
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println("DAILY SUMMARY");
            pw.println("-------------------------------");
            pw.printf("Total Transactions: %d%n", list.size());
            pw.printf("Regular CarWash: %d%n", totalRegCarWash);
            pw.printf("CarWash w/ Buffing Wax: %d%n", totalBuffingWax);
            pw.printf("Engine Wash: %d%n", totalEngineWash);
            pw.printf("Total Revenue: %.2f%n", totalRevenue);
        } catch (IOException e) {
            System.out.println("Error saving daily summary: " + e.getMessage());
        }
    }

    // Load previous transactions
    public static ArrayList<Vehicle> loadTransactions(String date) {
        ArrayList<Vehicle> list = new ArrayList<>();
        File file = new File(FOLDER_PATH + "\\" + date + "_transactions.txt");

        if (!file.exists()) return list;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String brand = parts[0];
                String color = parts[1];
                String type = parts[2];
                String service = parts[3];
                double price = Double.parseDouble(parts[4]);

                Vehicle v;
                switch (type.toUpperCase()) {
                    case "CAR" -> v = new Car(brand, color, "MED", service); // Default size MED
                    case "MOTORCYCLE" -> v = new Motorcycle(brand, color, false, service); // Default no sidecar
                    case "TRICYCLE" -> v = new Motorcycle(brand, color, true, service); // Sidecar
                    case "VAN" -> v = new Van(brand, color, service);
                    default -> v = new Custom(brand, color, price, type, service);
                }
                list.add(v);
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }

        return list;
    }

    // Helper: get vehicle type as String
    private static String getVehicleType(Vehicle v) {
        if (v instanceof Car car) return "Car";
        else if (v instanceof Motorcycle m) return m.hasSideCars ? "Tricycle" : "Motorcycle";
        else if (v instanceof Van) return "Van";
        else if (v instanceof Custom c) return c.vehicle;
        return "Unknown";
    }

    // Helper: get price
    private static double getPrice(Vehicle v) {
        if (v instanceof Car car) return car.getPrice();
        else if (v instanceof Motorcycle m) return m.getPrice();
        else if (v instanceof Van van) return van.getPrice();
        else if (v instanceof Custom c) return c.getPrice();
        return 0;
    }
}
