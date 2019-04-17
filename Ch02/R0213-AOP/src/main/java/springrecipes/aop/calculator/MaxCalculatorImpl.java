package springrecipes.aop.calculator;

public class MaxCalculatorImpl implements MaxCalculator {
    @Override
    public double max(double a, double b) {
        double result = (a > b) ? a : b;
        System.out.println(String.format("max(%f, %f) = %f", a, b, result));
        return result;
    }
}
