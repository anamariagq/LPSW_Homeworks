public class Program {

    public static void main (String [] args) {
        Familie familie1 = new Familie("Vater", "Mutter");
        familie1.addKind("Kind1A");
        familie1.addKind("Kind1B");

        Familie familieKeineKinder = new Familie("Vater2", "Mutter2");
        /*familieKeineKinder.addKind(" ");*/

        Familie famVieleKinder = new Familie("Vater3", "Mutter3");
        famVieleKinder.addKind("Kind3A");
        famVieleKinder.addKind("Kind3B");
        famVieleKinder.addKind("Kind3C");
        famVieleKinder.addKind("Kind3D");

        Familie alleinerziehrVater = new Familie("VaterA", " ");
        alleinerziehrVater.addKind("Kind4A");


        Familie alleinerziehrMutter = new Familie(" ", "Mutter");
        alleinerziehrMutter.addKind("Kind5A");


        System.out.println("Familie1: ");
        System.out.println(familie1.getMitglied(Familienmitglied.VATER));
        System.out.println(familie1.getMitglied(Familienmitglied.MUTTER));
        System.out.println(familie1.getMitglied(Familienmitglied.KIND));

        System.out.println("\n");

        System.out.println("Familie2: ");
        System.out.println(familieKeineKinder.getMitglied(Familienmitglied.VATER));
        System.out.println(familieKeineKinder.getMitglied(Familienmitglied.MUTTER));
        System.out.println(familieKeineKinder.getMitglied(Familienmitglied.KIND));

        System.out.println("\n");


        System.out.println("Familie3: ");
        System.out.println(famVieleKinder.getMitglied(Familienmitglied.VATER));
        System.out.println(famVieleKinder.getMitglied(Familienmitglied.MUTTER));
        System.out.println(famVieleKinder.getMitglied(Familienmitglied.KIND));

        System.out.println("\n");


        System.out.println("Familie Allerinerziehr: ");
        System.out.println(alleinerziehrVater.getMitglied(Familienmitglied.VATER));
        System.out.println(alleinerziehrVater.getMitglied(Familienmitglied.MUTTER));
        System.out.println(alleinerziehrVater.getMitglied(Familienmitglied.KIND));

        System.out.println("\n");


        System.out.println("Familie Allerinerziehr: ");
        System.out.println(alleinerziehrMutter.getMitglied(Familienmitglied.VATER));
        System.out.println(alleinerziehrMutter.getMitglied(Familienmitglied.MUTTER));
        System.out.println(alleinerziehrMutter.getMitglied(Familienmitglied.KIND));

        System.out.println("\n");



    }
}
