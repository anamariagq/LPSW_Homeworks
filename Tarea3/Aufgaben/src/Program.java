import java.io.*;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;


public class Program {
    public static void main(String[] args) {
        Adresse adresse = new Adresse(); //creación de un objeto "adresse" de la clase Adresse
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");
        Person hugo = new Person(); //creación de un objeto "hugo" de la clase Person
        hugo.setName("Hugo Schmidt");//da el valor al objeto hugo
        hugo.setAdresse(adresse);
        Person erika = new Person();//creación de un objeto "erika" de la clase Person
        erika.setName("Erika Schmidt");//da el valor al objeto erika
        erika.setAdresse(adresse);

        // creación de un ArrayList (list) de tipo Persona
        ArrayList<Person> list = new ArrayList<>();
        list.add(hugo);
        list.add(erika);

        //serialización - deserialización con try/catch
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("caso1"));
            out.writeObject(list);
            out.close();
        } catch (IOException e) {
            System.out.println("There´s a problem writing the file");
        }

        //ArrayList de tipo persona. Se da valor de null para ser rellenado
        ArrayList<Person> newList = null;
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream("caso1"));
            newList = (ArrayList<Person>) in.readObject();
            in.close();
        } catch (IOException e) {
            System.out.println("There´s a problem reading the file");
        } catch (ClassNotFoundException e) {
            System.out.println("The class could not be found");
        }

        //para probar que la listas ingresadas de las personas en la lista
        //se comprueba que la infromacion esta correctamente referenciada
        //porque tienen el mismo origen y puede dar error
        //porque ambos objetos del typ person immer auf die selber adresse referenzieren
        System.out.printf("%s%n%s%n", list, newList);

        if (newList.get(0).getAdresse() == newList.get(1).getAdresse()) {
            System.out.println("Beide Adresse sind gelich");
        }
    }
}
/*ArrayList: instancia que almacena objetos de un <tipo>. Se usa
* new para crear una nueva instancia vacía de ArrayList<>().
* <Person> será tomado automáticamente por Java.
* add() agrega objetos a la lista, losque se almacenan como un array,
* pero tendrán su posición entre(), ejem: (0) bzz. (1), etc*/
