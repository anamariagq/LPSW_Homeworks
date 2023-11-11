import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arraylist;

public class Zettelkasten implements Iterable<Medium>{

    ArrayList<Medium> media = new ArrayList();

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

        if(m instanceof CD)
        {
            if (m.getTitel() != "" & ((CD) m).getKuenster() > 0 & ((CD) m).getLabel() != "" )
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }

        if(m instanceof ElektronischesMedium)
        {
            if (m.getTitel() != "" & ((ElektronischesMedium) m).getUrl() > 0 )
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }

        if(m instanceof Zeitschrift)
        {
            if (m.getTitel() != "" & ((Zeitschrift) m).getNummer() > 0 & ((Zeitschrift) m).getVolume() > 0 & ((Zeitschrift) m).getIssn() != "")
            {
                media.add(m);
                returnBoolean = true;
            } else{
                throw new IllegalArgumentException("Die angegebene Information ist unvollständig");
            }
        }
        return returnBoolean;
    }
    @Override
    public Iterator<Medium> Iterator(){return media.iterator();}
}
