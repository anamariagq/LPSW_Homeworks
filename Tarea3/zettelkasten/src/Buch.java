/**
 * Erstellt ein Medium vom Typ Buch
 * Bildet String mit allen Attributen
 *
 * @author: Karen Witt | Ana María Gómez Quitral
 * Matrikelnummer: 20761
 * Letzte Änderung: 12.11.2023
 */

public class Buch extends Medium
{
  private int erscheinungsjahr;
  private String verlag;
  private String isbn;
  private String verfasser;

  //Konstruktor
  public Buch(String _titel, int _erscheinungsjahr, String _verlag, String _isbn, String _verfasser)
  {
    //Titel wird aus Superklasse Medium geerbt
    super(_titel);
    setErscheinungsjahr(_erscheinungsjahr);
    setVerlag(_verlag);
    setIsbn(_isbn);
    setVerfasser(_verfasser);
  }

  //Methode, um einen String mitsamt aller bibliographischen Angaben zurückzugeben.
  @Override
  public String calculateRepresentation()
  {
    StringBuilder repraesentation = new StringBuilder().append("\n");

    repraesentation.append("Titel: ").append(getTitel()).append("\n");
    repraesentation.append("Erscheinungsjahr: ").append(getErscheinungsjahr()).append("\n");
    repraesentation.append("Verlag: ").append(getVerlag()).append("\n");
    repraesentation.append("ISBN: ").append(getIsbn()).append("\n");
    repraesentation.append("Verfasser:in: ").append(getVerfasser()).append("\n");

    return repraesentation.toString();
  }


  //Getter und Setter
  public int getErscheinungsjahr()
  {
    return erscheinungsjahr;
  }

  public void setErscheinungsjahr(int _erscheinungsjahr)
  {
    erscheinungsjahr = _erscheinungsjahr;
  }

  public String getVerlag()
  {
    return verlag;
  }

  public void setVerlag(String _verlag)
  {
    verlag = _verlag;
  }

  public String getIsbn()
  {
    return isbn;
  }

  public void setIsbn(String _isbn)
  {
    //Mögliche Bindestriche müssen aus der ISBN entfernt werden
    _isbn = _isbn.replace("-", "");

    //Unterscheidung nach Länge der ISBN
    //Fall 1: 10-stellige ISBN
    if (_isbn.length() == 10)
    {
      //isbn-String wird in int Array konvertiert.
      int[] isbnArray = new int[10];
      for (int i = 0; i < _isbn.length(); i++)
      {
        isbnArray[i] = Integer.parseInt(String.valueOf(isbnArray[i]));
      }
      //Prüfroutine für 10-stellige ISBN wird aufgerufen
      if (checkISBN10(isbnArray) == true)
      {
        isbn = _isbn;
      } else
      {
        System.out.println("Die eingetragene ISBN ist leider nicht korrekt.");
      }

      //Fall 2: 13-stellige ISBN
    } else if (_isbn.length() == 13)
    {
      //isbn-String wird in int Array konvertiert.
      int[] isbnArray = new int[13];
      for (int i = 0; i < _isbn.length(); i++)
      {
        isbnArray[i] = Integer.parseInt(String.valueOf(isbnArray[i]));
      }
      //Prüfroutine für 13-stellige ISBN wird aufgerufen
      if (checkISBN13(isbnArray) == true)
      {
        isbn = _isbn;
      } else
      {
        System.out.println("Die eingetragene ISBN ist leider nicht korrekt.");
      }
    }
    //Fall 3: weder 10 noch 13 Stellen.
    else
    {
      System.out.println("Die eingetragene ISBN ist leider nicht korrekt.");
    }
  }


  public String getVerfasser()
  {
    return verfasser;
  }

  public void setVerfasser(String _verfasser)
  {
    verfasser = _verfasser;
  }


  //Prüfroutine für ISBN10
  //Wird in setIsbn aufgerufen

  public static boolean checkISBN10(int[] isbnArray)
  {
    int sum = 0;
    for (int i = 1; i <= isbnArray.length; i++)
    {
      sum += i * isbnArray[i - 1];
    }
    if (sum % 11 == 0)
    {
      return true;
    } else
    {
      return false;
    }
  }

  //Prüfroutine für ISBN13
  public static boolean checkISBN13(int[] isbn)
  {
    int sum = 0;
    for (int i = 1; i < isbn.length; i++)
    {
      if (i % 2 == 0)
      {
        sum += isbn[i - 1] * 3;
      } else
      {
        sum += isbn[i - 1];
      }
    }
    int lastDigit = sum % 10;
    int check = (10 - lastDigit) % 10;
    if (isbn[isbn.length - 1] == check)
    {
      return true;
    } else
    {
      return false;
    }
  }
  public MTyp getMediaType() {
    return MTyp.BUCH;
  }
}
