public abstract class Support {
    private Support next;
    private final String supportName;

    public Support(String name) {
        this.supportName = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(CalculationSource calculationSource) {
        if (resolve(calculationSource)) {
            done(calculationSource);
        } else if (next != null) {
            moveNext(calculationSource);
            next.support(calculationSource);
        } else {
            fail(calculationSource);
        }
    }

    protected abstract boolean resolve(CalculationSource calculationSource);

    protected void done(CalculationSource calculationSource) {
        System.out.println(calculationSource.getOperatorFullName() + " Provided");
    }

    protected void fail(CalculationSource calculationSource) {
        System.out.println(calculationSource.getOperatorFullName() + " cannot be resolved.");
    }

    protected void moveNext(CalculationSource calculationSource) {
        System.out.println(this.toString() + " Server passing " + calculationSource.getOperator() + " operator to the next server.");
    }

    public String toString() {
        return supportName;
    }

}
