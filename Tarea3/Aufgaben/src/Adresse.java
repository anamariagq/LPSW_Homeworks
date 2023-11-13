/**
 * @autor: Ana María Gómez Q
 * Matrikelnummer: 20761
 * Letzte Änderung: 12.11.2023
 */

import java.io.Serializable;


public class Adresse implements Serializable {
    private String strasse;
    private String ort;
    public String getStrasse() { return this.strasse; }
    public void setStrasse(String strasse) { this.strasse = strasse; }
    public String getOrt() { return ort; }
    public void setOrt(String ort) { this.ort = ort; }
    public String toString() {
        return new StringBuilder().append(strasse).append(", ").append(ort).toString();}
}
/*otorga una String con atributos determinados
al referenciar la clase*/
