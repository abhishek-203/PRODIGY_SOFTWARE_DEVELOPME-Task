import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }

    public static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");

        System.out.print("Enter your choice (1-6): ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= 6) {
            System.out.print("Enter the temperature: ");
            double temperature = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println(temperature + " Celsius is equal to " + celsiusToFahrenheit(temperature) + " Fahrenheit.");
                    break;
                case 2:
                    System.out.println(temperature + " Fahrenheit is equal to " + fahrenheitToCelsius(temperature) + " Celsius.");
                    break;
                case 3:
                    System.out.println(temperature + " Celsius is equal to " + celsiusToKelvin(temperature) + " Kelvin.");
                    break;
                case 4:
                    System.out.println(temperature + " Kelvin is equal to " + kelvinToCelsius(temperature) + " Celsius.");
                    break;
                case 5:
                    System.out.println(temperature + " Fahrenheit is equal to " + fahrenheitToKelvin(temperature) + " Kelvin.");
                    break;
                case 6:
                    System.out.println(temperature + " Kelvin is equal to " + kelvinToFahrenheit(temperature) + " Fahrenheit.");
                    break;
            }
        } else {
            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
        }

        scanner.close();
    }
}
