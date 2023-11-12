/**
 * Erstellt ein Medium vom Typ CD
 * Bildet String mit allen Attributen
 *
 * @author: Karen Witt | Erweitet von Ana María Gómez Quitral
 * Letzte Änderung: 12.11.2023
 */

public class CD extends Medium
{
  private String label;
  private String kuenster;

  //Konstruktor

  public CD(String _titel, String _label, String _kuenstler)
  {
    //Titel wird aus Superklasse Medium geerbt
    super(_titel);
    setLabel(_label);
    setKuenster(_kuenstler);
  }

  //Methode, um einen String mitsamt aller bibliographischen Angaben zurückzugeben.
  @Override
  public String calculateRepresentation()
  {
    StringBuilder repraesentation = new StringBuilder();
    repraesentation.append("Titel: ").append(getTitel()).append("\n");
    repraesentation.append("Label: ").append(getLabel()).append("\n");
    repraesentation.append("Kuenstler:in: ").append(getKuenster()).append("\n");

    return repraesentation.toString();
  }


  //Getter und Setter
  public String getLabel()
  {
    return label;
  }

  public void setLabel(String _label)
  {
    label = _label;
  }

  public String getKuenster()
  {
    return kuenster;
  }

  public void setKuenster(String _kuenster)
  {
    kuenster = _kuenster;
  }

  public MTyp getMediaType() {
    return MTyp.CD;
  }
}
