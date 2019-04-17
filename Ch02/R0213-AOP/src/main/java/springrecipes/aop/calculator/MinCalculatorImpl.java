package springrecipes.aop.calculator;

public class MinCalculatorImpl implements MinCalculator {
    @Override
    public double min(double a, double b) {
        double result = (a <= b) ? a : b;
        System.out.println(String.format("min(%f, %f) = %f", a, b, result));
        return result;
    }
}
