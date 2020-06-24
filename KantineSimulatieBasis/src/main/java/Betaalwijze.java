public abstract class Betaalwijze {
    /**
     * fields
     */
    protected double saldo;

    /**
     * METHODS
     */

    /**
     * Method to initiialise credit
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Method to handle a payment
     *
     * @param tebetalen
     * @throws TeWeinigGeldException
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;
}
