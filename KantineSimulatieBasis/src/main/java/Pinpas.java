public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     * 
     * @throws TeWeinigGeldException
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if ((saldo - tebetalen) < kredietlimiet)
            throw new TeWeinigGeldException("someone did not have enough credit");

        else {
            saldo -= tebetalen;
        }
    }
}
