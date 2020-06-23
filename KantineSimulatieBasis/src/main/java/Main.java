


public class Main {

    private static KantineSimulatie_1 sim1 = new KantineSimulatie_1();
    private static KantineSimulatie_2 sim2 = new KantineSimulatie_2();
    public static final int DAGEN = 31;

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        /*
         * int dagen;
         * 
         * if (args.length == 0) { dagen = DAGEN; } else { dagen =
         * Integer.parseInt(args[0]); }
         * 
         * System.out.println("simulatie start");
         * 
         */

        sim2.simuleer(DAGEN);
    }


}