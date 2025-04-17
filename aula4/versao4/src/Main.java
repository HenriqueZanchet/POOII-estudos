import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adicionando guitarras ao inventário
        inventory.addInstrument("G123", 1500.00,
                new GuitarSpec(Builder.FENDER, "Stratocaster", Type.ELETRIC, 6, Wood.ALDER, Wood.ALDER));

        inventory.addInstrument("G456", 1800.00,
                new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELETRIC, 6, Wood.MAHOGANY, Wood.MAPLE));

        inventory.addInstrument("G789", 2000.00,
                new GuitarSpec(Builder.MARTIN, "D12X1", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD, Wood.SITKA));

        // Adicionando bandolins ao inventário
        inventory.addInstrument("M101", 800.00,
                new MandolinSpec(Builder.OLSON, "Vintage A", Type.ACOUSTIC, Style.A, Wood.MAPLE, Wood.MAPLE));

        inventory.addInstrument("M202", 900.00,
                new MandolinSpec(Builder.OLSON, "Vintage F", Type.ACOUSTIC, Style.F, Wood.CEDAR, Wood.COCOBOLO));

        // Cliente procura por guitarra
        GuitarSpec searchGuitar = new GuitarSpec(Builder.MARTIN, "D12X1", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD, Wood.SITKA);
        List<Guitar> guitars = inventory.search(searchGuitar);

        System.out.println("Guitarras encontradas:");
        if (guitars.isEmpty()) {
            System.out.println("Nenhuma guitarra encontrada.");
        } else {
            for (Guitar g : guitars) {
                System.out.println("Serial: " + g.getSerialNumber() + " | Preço: R$" + g.getPrice());
            }
        }

        // Cliente procura por bandolim
        MandolinSpec searchMandolin = new MandolinSpec(Builder.OLSON, "Vintage A", Type.ACOUSTIC, Style.A, Wood.MAPLE, Wood.MAPLE);
        List<Mandolin> mandolins = inventory.search(searchMandolin);

        System.out.println("\nBandolins encontrados:");
        if (mandolins.isEmpty()) {
            System.out.println("Nenhum bandolim encontrado.");
        } else {
            for (Mandolin m : mandolins) {
                System.out.println("Serial: " + m.getSerialNumber() + " | Preço: R$" + m.getPrice());
            }
        }
    }
}
