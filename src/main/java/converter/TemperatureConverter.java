package converter;

import enums.TempUnit;
import model.Temperature;

public class TemperatureConverter {

    public static Temperature convertTemperature(Temperature toConvert, TempUnit targetUnit) {
        if (toConvert.getUnit().equals(targetUnit)) return new Temperature(toConvert);

        return switch (targetUnit) {
            case CELSIUS -> toCelsius(toConvert);
            case FAHRENHEIT -> toFahrenheit(toConvert);
            case KELVIN -> toKelvin(toConvert);
        };
    }

    private static Temperature toCelsius(Temperature toConvert) {
        if (toConvert.getUnit().equals(TempUnit.CELSIUS)) return new Temperature(toConvert);
        double newAmount = 0;
        if (toConvert.getUnit().equals(TempUnit.KELVIN)) {
            newAmount = toConvert.getAmount() - 273.15;
        }
        if (toConvert.getUnit().equals(TempUnit.FAHRENHEIT)) {
            newAmount = (toConvert.getAmount() - 32) * 5. / 9.;
        }
        return new Temperature(newAmount, TempUnit.CELSIUS);
    }

    private static Temperature toFahrenheit(Temperature toConvert) {
        if (toConvert.getUnit().equals(TempUnit.FAHRENHEIT)) return new Temperature(toConvert);
        double newAmount = 0;
        if (toConvert.getUnit().equals(TempUnit.CELSIUS)) {
            newAmount = toConvert.getAmount() * 9. / 5. + 32;
        }
        if (toConvert.getUnit().equals(TempUnit.KELVIN)) {
            newAmount = (toConvert.getAmount() - 273.15) * 9. / 5. + 32;
        }
        return new Temperature(newAmount, TempUnit.FAHRENHEIT);
    }

    private static Temperature toKelvin(Temperature toConvert) {
        if (toConvert.getUnit().equals(TempUnit.KELVIN)) return new Temperature(toConvert);
        double newAmount = 0;
        if (toConvert.getUnit().equals(TempUnit.CELSIUS)) {
            newAmount = toConvert.getAmount() + 273.15;
        }
        if (toConvert.getUnit().equals(TempUnit.FAHRENHEIT)) {
            newAmount = (toConvert.getAmount() - 32) * 5. / 9. + 273.15;
        }
        return new Temperature(newAmount, TempUnit.KELVIN);
    }
}
