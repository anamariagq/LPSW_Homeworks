/**
 * Abstrakte Oberklasse von Buch, CD, Elektronisches Medium, Zeitschrift
 * Beinhaltet abstrakte Methode calculateRepresentation
 * <p>
 * @author: Karen Witt | Erweitet von Ana María Gómez Quitral
 * Letzte Änderung: 12.11.2023
 */

import java.io.Serializable;

public abstract class Medium implements Comparable<Medium>
{
  private String titel;

  //Spezieller Konstruktor für Titel
  public Medium(String _titel)
  {
    setTitel(_titel);
  }

  //Getter und Setter
  public String getTitel()
  {
    return titel;
  }

  public void setTitel(String _titel)
  {
    titel = _titel;
  }

  //Abstrakte Methode wird in den Unterklassen definiert.
  public abstract String calculateRepresentation();

  public abstract MTyp getMediaType();

  @Override
  public int compareTo(Medium medium){
    int compareTitleResult = this.getTitel().compareTo(medium.getTitel());
    if(compareTitleResult == 0){
      return this.getClass().getName().compareTo(medium.getClass().getName());
    }else{
      return compareTitleResult;
    }
  }
  public int compareTo(MTyp o){return this.titel.compareToIgnoreCase(String.valueOf(o.getClass()));}
}
