/**
 * Abstrakte Oberklasse von Buch, CD, Elektronisches Medium, Zeitschrift
 * Beinhaltet abstrakte Methode calculateRepresentation
 * <p>
 * @author: Karen Witt | 19462
 * Umgebung: JDK2021.1.3
 * Erstellt: 22.09.2021
 * Letzte Änderung: 30.9.2021
 */

public abstract class Medium
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
}
