/**
 * Erstellt ein Medium vom Typ ElektronischesMedium
 * Bildet String mit allen Attributen
 *
 * @author: Karen Witt | Ana María Gómez Quitral
 * Matrikelnummer: 20761
 * Letzte Änderung: 12.11.2023
 */

import java.net.URL;

public class ElektronischesMedium extends Medium
{
  private String url;

  //Konstruktor
  public ElektronischesMedium(String _titel, String _url)
  {
    //Titel wird aus Superklasse Medium geerbt
    super(_titel);
    setUrl(_url);
  }

  //Prüfroutine für die URL. Wird im Setter aufgerufen
  public static boolean checkURL(String urlString)
  {
    try
    {
      URL url = new URL(urlString);
      url.toURI();
      return true;
    }
    catch (Exception exception)
    {
      return false;
    }
  }

  //Methode, um einen String mitsamt aller bibliographischen Angaben zurückzugeben.
  @Override
  public String calculateRepresentation()
  {
    StringBuilder repraesentation = new StringBuilder();
    repraesentation.append("Titel: ").append(getTitel()).append("\n");
    repraesentation.append("URL: ").append(getUrl());

    return repraesentation.toString();
  }

  //Getter und Setter
  public String getUrl()
  {
    return url;
  }

  public void setUrl(String _url)
  {
    if (checkURL(_url) == true)
    {
      url = _url;
    } else
    {
      System.out.println("Die eingegebene URL ist nicht korrekt.");
    }
  }
  public MTyp getMediaType(){
    return MTyp.ELEKTRONISCHESMEDIUM;}
}
