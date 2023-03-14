import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        String fileName = "countries.csv";
        try {
            Map<String, Country> countryMap = readFile(fileName);
            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
            String code = scanner.nextLine();
            printInfo(code, countryMap);
        } catch (IOException e) {
            System.out.println("Brak pliku " + fileName + ".");
        }
    }

    private Map<String, Country> readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Map<String, Country> countryMap = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(";");
            String code = split[0];
            String name = split[1];
            int population = Integer.parseInt(split[2]);
            countryMap.put(code, new Country(code, name, population));
        }
        return countryMap;
    }

    private void printInfo(String code, Map<String, Country> countryMap) {
        if (countryMap.containsKey(code)) {
            Country country = countryMap.get(code);
            System.out.println(country);
        } else {
            System.out.println("Kod kraju " + code + " nie został znaleziony.");
        }
    }
}
