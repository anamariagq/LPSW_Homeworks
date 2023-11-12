/**
 * Beinhaltet main-Methode
 * Nimmt bibliogr. Eingaben über die Konsole entgegen
 * Erzeugt aus den Daten ein neues Objekt (Buch, CD, Zeitschrift oder elektr. Medium)
 * Gibt die bibliogr. Daten auf der Konsole aus
 * <p>
 *
 * @author: Karen Witt | Erweitet von Ana María Gómez Quitral
 * Letzte Änderung: 12.11.2023
 */

import java.util.ArrayList;
import java.util.Scanner;


public class Bibliothek {
  public static void main(String[] args) {
      Zettelkasten zettelkasten = new Zettelkasten();

      try {
          zettelkasten.addMedium(new CD("Live At Wembley", "Queen", "Parlophone (EMI)"));
          zettelkasten.addMedium(new Zeitschrift("Insula", "0020-4536",1, 907));// ... und hier noch 3 weitere Statements
          zettelkasten.addMedium(new Buch("1Q84", 2009, "Tusquets", "9783832195878", "Haruki Murakami"));
          zettelkasten.addMedium(new Buch("Rayuela", 1963, "Sudamericana", "9788466331906", "Julio Cortázar"));
          zettelkasten.addMedium(new ElektronischesMedium("Hochschule Stralsund", "http://www.hochschule-stralsund.de"));
          zettelkasten.addMedium(new Buch("Hochschule Stralsund", 2021, "Beck", "3-257-06958-7", "Die Chefetage"));
      }catch (IllegalArgumentException e){
          System.err.println(e);
      }
      zettelkasten.sort("Up"); // für Aufgabe C.5
      for (Medium medium : zettelkasten) {
          System.out.println(medium.calculateRepresentation());
      }
  }
}

/*
//dentro de main
 //Eingabeaufforderung und Einlesen des Eingabestrings
    String input;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bitte geben Sie die bibliographischen Daten im BibText-Format ein:");
    input = scanner.nextLine();

      //Ausgabe bei erfolgreichem Erstellen des Mediums
      System.out.println("\nEin Medium mit den folgenden Angaben wurde hinzugefügt: \n" + parseBibTex(input).calculateRepresentation());
    }


  //Methode, um mit geparsten String ein neues Medium zu erstellen
  public static Medium parseBibTex(String _input)
  {
      //neues Medium-Array erstellen, in dem das neu zu erstellende Medium gespeichert und ausgegeben werden kann
      Medium[] ausgabeArray = new Medium[1];

      //Fallunterscheidung, um Typ des Mediums herauszufinden

      //Fall 1: Das Medium ist ein Buch
      if (_input.startsWith("book", 1))
      {
        String[] bookArray = stringparser(_input);

        //Das Erscheinungsjahr muss vom String in ein int geparst werden. Dafür müssen Leerezeichen entfernt werden
        bookArray[4] = bookArray[4].replace(" ", "");

        //Neues Objekt vom Typ Buch erstellen und mit den Attributen füllen
        Buch neuesBuch = new Buch(bookArray[1], Integer.parseInt(bookArray[4]), bookArray[2], bookArray[5], bookArray[0]);

        ausgabeArray[0] = neuesBuch;

        //Fall 2
        // Das Medium ist eine Zeitscrift
      } else if (_input.startsWith("journal", 1))
      {
        String[] journalArray = stringparser(_input);
        //"Volume" und "number müssen vom String in ein int geparst werden. Dafür müssen Leerezeichen entfernt werden
        journalArray[2] = journalArray[2].replace(" ", "");
        journalArray[3] = journalArray[3].replace(" ", "");

        //Neues Objekt vom Typ Zeitschrift erstellen und mit den Attributen füllen
        Zeitschrift neueZeitschrift = new Zeitschrift(journalArray[0], journalArray[1], Integer.parseInt(journalArray[2]), Integer.parseInt(journalArray[3]));

        ausgabeArray[0] = neueZeitschrift;
        String a = "@book{author = {-}, title = {Duden 01. Die deutsche Rechtschreibung}, publisher = {Bibliogr\n" +
            "aphisches Institut, Mannheim}, year = 2004, isbn = {3-411-04013-0}}";


        //Fall 3
        // Das Medium ist eine CD
      } else if (_input.startsWith("cd", 1))
      {
        String[] cdArray = stringparser(_input);

        //Neues Objekt vom Typ CD erstellen und mit den Attributen füllen
        CD neueCD = new CD(cdArray[0], cdArray[1], cdArray[2]);
        ausgabeArray[0] = neueCD;

        //Fall 4
        // Das Medium ist ein elektr. Medium
      } else if (_input.startsWith("elMed", 1))
      {
        String[] elMedArray = stringparser(_input);

        //Neues Objekt vom Typ elektronisches Medium erstellen und mit den Attributen füllen
        ElektronischesMedium neuesElMed = new ElektronischesMedium(elMedArray[0], elMedArray[1]);
        ausgabeArray[0] = neuesElMed;
      }
      else {
        System.out.println("Der Medientyp konnte leider nicht erkannt werden.");
      }
      return ausgabeArray[0];
      }


  public static String[] stringparser(String _input)
  {
//Der String wird entlang aller Kommas aufgetrennt

      String[] arrOfInputString = _input.split("\\,");

      //Bezeichner wie title, isbn, label usw werden aussortiert, indem der Index der 1. { gelesen wird
      int positionOfBraces;
      for (int i = 0; i < arrOfInputString.length; i++)
      {
        //Für den Eintrag an der Stelle 0 im Array wird der fromindex für { auf 9 gesetzt
        if (i == 0)
        {
          positionOfBraces = arrOfInputString[i].indexOf("{", 9);
        } else
        {
          positionOfBraces = arrOfInputString[i].indexOf("{");
        }
        arrOfInputString[i] = arrOfInputString[i].substring(positionOfBraces + 1).replace("}", "");
        arrOfInputString[i] = arrOfInputString[i].replace("year = ", "");
        arrOfInputString[i] = arrOfInputString[i].replace("volume = ", "");
        arrOfInputString[i] = arrOfInputString[i].replace("number = ", "");
      }
      return arrOfInputString;
  */