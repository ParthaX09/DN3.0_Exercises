public class FinancialForecast {

    // Recursive method to predict future value
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        // Base case: if no years left, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Recursive case: calculate the value for the next year
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Initial investment value
        double annualGrowthRate = 0.05; // 5% annual growth rate
        int years = 10; // Number of years to forecast

        double futureValue = predictFutureValue(currentValue, annualGrowthRate, years);
        System.out.println("Predicted Future Value: $" + futureValue);
    }
}
