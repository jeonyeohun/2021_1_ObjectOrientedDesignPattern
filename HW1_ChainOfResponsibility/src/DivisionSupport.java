public class DivisionSupport extends Support {
    public DivisionSupport(String supportName) {
        super(supportName);
    }

    protected boolean resolve(CalculationSource calculationSource) {
        if (calculationSource.getOperator().compareTo("div") == 0) {

            System.out.println("Division Server Working ...");

            int lhs = calculationSource.getOperandLeft();
            int rhs = calculationSource.getOperandRight();
            int result = 0;

            if (rhs == 0) {
                System.out.println("Calculation Error. Zero division occur. (numerator: " + lhs + ", Denominator: " + rhs + ")");
                return true;
            }

            result = lhs / rhs;
            System.out.println(lhs + " / " + rhs + " = " + result);

            return true;
        }
        return false;
    }
}
