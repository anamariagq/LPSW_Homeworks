import java.io.*;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;


public class Program {
    public static void main(String[] args) {
        Adresse adresse = new Adresse();
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");
        Person hugo = new Person();
        hugo.setName("Hugo Schmidt");
        hugo.setAdresse(adresse);
        Person erika = new Person();
        erika.setName("Erika Schmidt");
        erika.setAdresse(adresse);

        // creación de un ArrayList

        ArrayList<Person> list = new ArrayList<>();
        list.add(hugo);
        list.add(erika);

        //serialización con try/catch
        try{
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("caso1"));
            out.writeObject(list);
            out.close();
        }catch(IOException e){
            System.out.println("There´s a problem writing the file");
        }

        ArrayList<Person> newList = null;
        try{
            ObjectInput in = new ObjectInputStream(new FileInputStream("caso1"));
            newList = (ArrayList<Person>) in.readObject();
            in.close();
        }catch(IOException e){
            System.out.println("There´s a problem reading the file");
        }catch (ClassNotFoundException e){
            System.out.println("The class could not be found");
        }

        //para probar que la listas ingresadas de las personas en la lista
        //se comprueba que la infromacion esta correctamente referenciada
        //porque tienen el mismo origen y puede dar error
        //porque ambos objetos del typ person immer auf die selber adresse referenzieren
        System.out.printf("%s%n%s%n", list, newList);

        if(newList.get(0).getAdresse() == newList.get(1).getAdresse()){
            System.out.println("Beide Adresse sind gelich");
        }
    }

