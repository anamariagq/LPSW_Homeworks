import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Familie implements Iterable <String>{

    private int index = 0; //ver la relación con Iterable
    private ArrayList<String> mitglieder;
    //Arraylist para la creación de nuevos integrantes fam

    //contructor con padre y madre
    public Familie(String vater, String mutter) {
        if (vater == null || vater.isEmpty() || mutter == null || mutter.isEmpty()) {
            throw new IllegalArgumentException("No empty parameters allowed. For no Vater or Mutter, please enter an Empty Space");
        }
        mitglieder = new ArrayList<>();
        mitglieder.add(vater);
        mitglieder.add(mutter);
    }


    public void addKind(String kind) {
        if (kind == null || kind.isEmpty()) {
            throw new IllegalArgumentException("No empty parameters allowed. For no Children, please enter an Empty Space");
        }
        mitglieder.add(kind);
    }

    public String getMitglied(Familienmitglied mitglied) {
        if (mitglied == Familienmitglied.VATER) {
            return mitglieder.get(0);
        } else if (mitglied == Familienmitglied.MUTTER) {
            return mitglieder.get(1);
        } else if (mitglied == Familienmitglied.KIND && mitglieder.size() > 2) {
            StringBuilder kinder = new StringBuilder();
            for (int i = 2; i < mitglieder.size(); i++) {
                kinder.append(mitglieder.get(i));
                if (i != mitglieder.size() - 1) {//no es posicion, sino cantidad
                    kinder.append(", ");
                }
            }
            return kinder.toString();
        } else if (3 > mitglieder.size()) {
            System.out.println("Diese Familie besteht aus Vater und Mutter");
            return "";
        }else{
            return "";
        }
    }
    //método por defecto para la Interface Iterator
    @Override
    public Iterator <String> iterator(){return mitglieder.iterator();}
}




 /*for (int i = 0; i < mitglieder.size(); i++) {
            try {
                mitglieder.add(0, "vater");
                mitglieder.add(1, "mutter");
            } catch(IllegalArgumentException e){
                System.out.println("There was a problem with adding your statement.");

            }finally{
                System.out.println("Die Familien Mitglieder sind " + mitglieder);
            }
        }
    }*/
 /*for(int i= 2; i < mitglieder.size(); i++){
           try {
               mitglieder.add("kind" + i);
           }catch (IllegalArgumentException e){
               System.out.println("Die Familien Mitglieder sind " + mitglieder);
           }finally {
               System.out.println("Die Familien Mitglieder sind " + kind + ",");
           }// esto se podría hacer en una operación separada.
           //primero guardar y definir los elememtos. Posteriormente hacer
           //otras funciones
       }*/

