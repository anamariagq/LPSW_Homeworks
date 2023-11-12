/**
 * Erstellt ein Medium vom Typ Zeitschrift
 * Bildet String mit allen Attributen einer Zeitschrift
 * <p>
 * @author: Karen Witt | Erweitet von Ana María Gómez Quitral
 * Letzte Änderung: 12.11.2023
 */

public class Zeitschrift extends Medium
{
  private String issn;
  private int volume;
  private int nummer;

  //Konstruktor
  public Zeitschrift(String _titel, String _issn, int _volume, int _nummer)
  {
    //Titel wird aus Superklasse Medium geerbt
    super(_titel);
    setIssn(_issn);
    setVolume(_volume);
    setNummer(_nummer);
  }

  //Methode, um einen String mitsamt aller bibliographischen Angaben zurückzugeben.
  @Override
  public String calculateRepresentation()
  {
    StringBuilder repraesentation = new StringBuilder();
    repraesentation.append("Titel: ").append(getTitel()).append("\n");
    repraesentation.append("Volume: ").append(getVolume()).append("\n");
    repraesentation.append("Nummer: ").append(getNummer()).append("\n");
    ;
    return repraesentation.toString();
  }

  //Getter und Setter
  public String getIssn()
  {
    return issn;
  }

  public void setIssn(String _issn)
  {
    issn = _issn;
  }

  public int getVolume()
  {
    return volume;
  }

  public void setVolume(int _volume)
  {
    volume = _volume;
  }

  public int getNummer()
  {
    return nummer;
  }

  public void setNummer(int _nummer)
  {
    nummer = _nummer;
  }
  public MTyp getMediaType(){
    return  MTyp.ZEITSCHRIFT;
  }
}
