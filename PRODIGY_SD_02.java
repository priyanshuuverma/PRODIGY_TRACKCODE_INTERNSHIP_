import java.util.Scanner;
 class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Conversion Program");
        System.out.println("-------------------------------");

        System.out.print("Enter a temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the original unit of measurement (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        String unit = scanner.next().toUpperCase();

        switch (unit) {
            case "C":
                double fahrenheit = celsiusToFahrenheit(temperature);
                double kelvin = celsiusToKelvin(temperature);
                System.out.println(temperature + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit and " + kelvin + " Kelvin.");
                break;
            case "F":
                double celsius = fahrenheitToCelsius(temperature);
                kelvin = fahrenheitToKelvin(temperature);
                System.out.println(temperature + " degrees Fahrenheit is equal to " + celsius + " degrees Celsius and " + kelvin + " Kelvin.");
                break;
            case "K":
                celsius = kelvinToCelsius(temperature);
                fahrenheit = kelvinToFahrenheit(temperature);
                System.out.println(temperature + " Kelvin is equal to " + celsius + " degrees Celsius and " + fahrenheit + " degrees Fahrenheit.");
                break;
            default:
                System.out.println("Invalid unit. Please enter C for Celsius, F for Fahrenheit, or K for Kelvin.");
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}