public class Contant extends Betaalwijze {
    /**
     * METHODS
     */

    /**
     * Method to handle payments
     * 
     * @throws TeWeinigGeldException
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (saldo - tebetalen < 0) {
            throw new TeWeinigGeldException("someone did not have enough credit");
        } else {
            saldo -= tebetalen;
        }
    }
}
