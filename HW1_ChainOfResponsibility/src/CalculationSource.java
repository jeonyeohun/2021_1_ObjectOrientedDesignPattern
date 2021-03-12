public class CalculationSource {
    private final int operandLeft;
    private final int operandRight;
    private final String operator;

    public CalculationSource(String operator, int operandLeft, int operandRight) {
        this.operator = operator;
        this.operandLeft = operandLeft;
        this.operandRight = operandRight;
    }

    public int getOperandRight() {
        return this.operandRight;
    }

    public int getOperandLeft() {
        return this.operandLeft;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getOperatorFullName() {
        if (this.operator.compareTo("add") == 0) return "Addition";
        else if (this.operator.compareTo("sub") == 0) return "Subtraction";
        else if (this.operator.compareTo("mult") == 0) return "Multiplication";
        else return "Division";
    }
}
