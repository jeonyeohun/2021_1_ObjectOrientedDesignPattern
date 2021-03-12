public class MultiplicationSupport extends Support {
    public MultiplicationSupport(String supportName) {
        super(supportName);
    }

    protected boolean resolve(CalculationSource calculationSource) {
        if (calculationSource.getOperator().compareTo("mult") == 0) {
            System.out.println("Multiplication Server Working ...");

            int lhs = calculationSource.getOperandLeft();
            int rhs = calculationSource.getOperandRight();

            if ((long) lhs * (long) rhs > Integer.MAX_VALUE) {
                System.out.println("The multiplication result overflows integer range. The calculation result will not show accurate result.");
            }

            int result = lhs * rhs;
            System.out.println(lhs + " * " + rhs + " = " + result);
            return true;
        }

        return false;
    }
}
