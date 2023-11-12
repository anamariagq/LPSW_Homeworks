/**
 * Erstellt eine neue ArrayList <Medium>
 * beinhaltet die Methoden:
 * addMedium
 * dropMedium
 * findMedium
 * sort
 *
 * @author: Karen Witt | Erweitet von Ana María Gómez Quitral
 * Letzte Änderung: 12.11.2023
 */
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium>, Serializable {

    ArrayList<Medium> media = new ArrayList();
    boolean sortedA = false;
    boolean sortedZ = false;

    public boolean addMedium(Medium m)
    {
        boolean returnBoolean = false;

        if(m instanceof Buch)
        {
            if (m.getTitel() != "" & ((Buch) m).getErscheinungsjahr() > 0 & ((Buch) m).getVerfasser() != "" &
                    ((Buch) m).getVerlag() != "" & ((Buch) m).getIsbn() != null)
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }

        else if(m instanceof CD)
        {
            if (m.getTitel() != "" & ((CD) m).getKuenster() != "" & ((CD) m).getLabel() != "" )
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }

        else if(m instanceof ElektronischesMedium)
        {
            if (m.getTitel() != "" & ((ElektronischesMedium) m).getUrl() != "")
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }

        else if(m instanceof Zeitschrift)
        {
            if (m.getTitel() != "" & ((Zeitschrift) m).getNummer() > 0 & ((Zeitschrift) m).getVolume() > 0 & ((Zeitschrift) m).getIssn() != "")
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }//si el medio no es reconocido dentro del tipo de los guardados
        else {
            throw new IllegalArgumentException("There´s no recognizable media");
        }
        return returnBoolean;
    }

    /*public boolean dropMedium(String _title) {
        boolean returnBoolean = false;

        ArrayList<Medium> deleteMedia = findMedium(_title);

        try {
            if (!(_title.isEmpty())) {
                if (deleteMedia.size() > 1) {
                    throw new DuplicateEntryException();
                } else if (deleteMedia.size() == 1) {
                    media.removeAll(deleteMedia);
                    returnBoolean = true;
                } else {
                    System.out.println("The title " + _title + " could not be found. No statements were deleted.");
                }
            } else {
                throw new IllegalArgumentException("Please enter another title");
            }
        } catch (NullPointerException | DuplicateEntryException e) {
            System.err.println(e);
        }
        return returnBoolean;
    }*/

    public boolean dropMedium(String _title, MTyp typ, boolean deleteAll){

        boolean returnBoolean = false;
        ArrayList<Medium> deleteMedia = findMedium(_title);

        if (deleteAll == true)
        {
            media.removeAll(deleteMedia);
            returnBoolean = true;
        } else{
            for(Medium s : deleteMedia){
                if(s instanceof Buch && typ == MTyp.BUCH){
                    media.remove(s);
                    returnBoolean = true;
                } else if (s instanceof CD && typ == MTyp.CD) {
                    media.remove(s);
                    returnBoolean = true;
                } else if (s instanceof Zeitschrift && typ == MTyp.ZEITSCHRIFT) {
                    media.remove(s);
                    returnBoolean = true;
                } else if (s instanceof ElektronischesMedium && typ == MTyp.ELEKTRONISCHESMEDIUM) {
                    media.remove(s);
                    returnBoolean = true;
                }
            }
        }
        return returnBoolean;
    }

    public ArrayList<Medium> findMedium(String _title){

        ArrayList<Medium> titleExist = new ArrayList<>();

        try {
            if (!(_title.isEmpty())) {
                int i = 0;
                for (Medium s : media) {
                    if (s.getTitel() == _title) {
                        titleExist.add(s);
                        i=1;
                    }
                }
                if (i == 0) {
                    System.out.println("Title was not found");
                    return null;
                }
            } else {
                throw new IllegalArgumentException("No empty parameters allowed");
            }
            return titleExist;
        }catch (NullPointerException e){
            System.err.println("No empty parameters allowed");
        }
        return titleExist;
    }



    public boolean sort(String dir) {
        boolean returnBoolean = false;

        if (media.size() < 2) {
        } else{

            if (dir == "Up" && sortedA == false) {
                Collections.sort(media);
                sortedA = true;
                sortedZ = false;
                returnBoolean = true;
            } else if (dir == "Down" && sortedZ == false) {
                Collections.sort(media, Collections.reverseOrder());
                sortedZ = true;
                sortedA = false;
                returnBoolean = true;
            } else {
                System.out.println("The parameter is not valid");
            }
        }
        return returnBoolean;
    }

    @Override
    public Iterator<Medium> iterator(){return media.iterator();}
}
/*
* if (media.size() < 2) {
            return false;
        } else{

            if (dir.equals("Up") && sortedA == false) {
                Collections.sort(media);
                sortedA = true;
                sortedZ = false;
                returnBoolean = true;
            } else if (dir.equals("Down") && sortedZ == false) {
                Collections.sort(media, Collections.reverseOrder());
                sortedZ = true;
                sortedA = false;
                returnBoolean = true;
            } else {
                System.out.println("The parameter is not valid");
            }
        }
        return returnBoolean;
    }*/