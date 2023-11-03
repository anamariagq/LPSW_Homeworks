import java.io.IOException;
import java.util.ArrayList;
public class Familie {
    private ArrayList<String> mitglieder;

    public Familie(String vater, String mutter) {//aquí va el código
        if(vatter == null || vater.isEmpty() || mutter == null || mutter.isEmpty()){
            throw new IllegalArgumentException("No empty parameters allowed. For no Vater or Mutter, please enter an Empty Space");
        }
        mitglieder = new ArrayList<>();
        mitglieder.add(vater);//necesario??
        mitglieder.add(mutter);
        //la ki hace al comienzo una IllegalArgumentException y cierra el programa
    }


    public void addKind(String kind) {//Código
        if(vatter == null || vater.isEmpty() || mutter == null || mutter.isEmpty()){
            throw new IllegalArgumentException("No empty parameters allowed. For no Children, please enter an Empty Space");
        }
      mitglieder.add(kind);
    }

    public void getMitglied(Familienmitglied mitglied){
        if(mitglied == Familienmitglied.VATER){
            return mitglied.get(0);
        } else if (mitglied == Familienmitglied.MUTTER) {
            return mitglied.get(1);
        } else if (mitglied == Familienmitglied.KIND) {
            if(mitglied.size()>2){
                return mitglied.get(", ");
            } else{
                return ".";
            }
        }
        return ".";
    }

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

