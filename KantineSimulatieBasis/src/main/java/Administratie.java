public class Administratie {

    private int[] ArtikelenPerDag;
    private double[] omzetPerDag;

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public double berekenGemiddeldAantal(int[] aantal) {
        double gemiddelde;
        int optelling = 0;
        for (int art : aantal) {
            optelling += art;
        }
        gemiddelde = optelling % aantal.length;
        return gemiddelde;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public double berekenGemiddeldeOmzet(double[] omzet) {
        double gemiddelde;
        double optelling = 0;
        for (double geld : omzet) {
            optelling += geld;
        }
        gemiddelde = optelling % omzet.length;
        return gemiddelde;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {
            

            int j = 0;
            while (  ) {
                temp[i] += omzet[i + 7 * j];

                // omitted
            }
        }
        return temp;
    }
}
