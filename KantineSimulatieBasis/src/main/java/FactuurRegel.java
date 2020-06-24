import java.io.Serializable;

public class FactuurRegel implements Serializable {
    private Long id;
    private Factuur factuur;
    private Artikel artikel;

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }
}