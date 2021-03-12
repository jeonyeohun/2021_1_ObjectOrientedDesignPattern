public class AdditionSupport extends Support {

    public AdditionSupport(String supportName) {
        super(supportName);
    }

    protected boolean resolve(CalculationSource calculationSource) {
        if (calculationSource.getOperator().compareTo("add") == 0) {
            System.out.println("Addition Server Working ...");

            int lhs = calculationSource.getOperandLeft();
            int rhs = calculationSource.getOperandRight();

            if ((long) lhs + (long) rhs > Integer.MAX_VALUE) {
                System.out.println("The addition result overflows integer range. The calculation result will not show accurate result.");
            }

            int result = lhs + rhs;
            System.out.println(lhs + " + " + rhs + " = " + result);
            return true;
        }

        return false;
    }
}
