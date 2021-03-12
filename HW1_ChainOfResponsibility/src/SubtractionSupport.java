public class SubtractionSupport extends Support {
    public SubtractionSupport(String supportName) {
        super(supportName);
    }

    protected boolean resolve(CalculationSource calculationSource) {
        if (calculationSource.getOperator().compareTo("sub") == 0) {
            System.out.println("Subtraction Server Working ...");

            int lhs = calculationSource.getOperandLeft();
            int rhs = calculationSource.getOperandRight();

            if (lhs - rhs > Integer.MAX_VALUE) {
                System.out.println("The subtraction result overflows integer range. The calculation result will not show accurate result");
            }

            int result = lhs - rhs;
            System.out.println(lhs + " - " + rhs + " = " + result);
            return true;
        }

        return false;
    }
}
