// comentário de teste

import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // set up Rick's guitar inventory
        Inventory inventory = new Inventory();
        InitializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELETRIC, Wood.ALDER, Wood.ALDER);

        List matchingGuitars = inventory.search(whatErinLikes);
        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                GuitarSpec spec = guitar.getSpec();
                System.out.println(" We have a "
                        + spec.getBuilder() + " " + spec.getModel() + " "
                        + spec.getType() + " guitar:\n   "
                        + spec.getBackWood() + " back and sides,\n   "
                        + spec.getTopWood() + " top.\n You can have it for only $"
                        + guitar.getPrice() + "!\n   -----");
            }

        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    private static void InitializeInventory(Inventory inventory) {
        // Add guitars to the inventory
        inventory.addGuitar(
                "V95693",
                1499.95,
                Builder.FENDER,
                "Stratocastor",
                Type.ELETRIC,
                Wood.ALDER,
                Wood.ALDER);
    }
}
