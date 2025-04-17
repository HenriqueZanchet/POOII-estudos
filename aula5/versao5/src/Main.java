import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addInstrument("11277", 3999.95, buildSpec(InstrumentType.GUITAR, "Collings", "CJ", "Acoustic", "Indian Rosewood", "Sitka"));
        inventory.addInstrument("V95693", 1499.95, buildSpec(InstrumentType.GUITAR, "Fender", "Stratocaster", "Electric", "Alder", "Alder"));
        inventory.addInstrument("V9512", 1549.95, buildSpec(InstrumentType.GUITAR, "Fender", "Stratocaster", "Electric", "Alder", "Alder"));
        inventory.addInstrument("122784", 5495.95, buildSpec(InstrumentType.GUITAR, "Martin", "D-18", "Acoustic", "Mahogany", "Adirondack"));
        inventory.addInstrument("76531", 6295.95, buildSpec(InstrumentType.GUITAR, "Martin", "OM-28", "Acoustic", "Brazilian Rosewood", "Adriondack"));
        inventory.addInstrument("70108276", 2295.95, buildSpec(InstrumentType.GUITAR, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple"));
        inventory.addInstrument("82765501", 1890.95, buildSpec(InstrumentType.GUITAR, "Gibson", "SG '61 Reissue", "Electric", "Mahogany", "Mahogany"));
        inventory.addInstrument("77023", 6275.95, buildSpec(InstrumentType.MANDOLIN, "Gibson", "F5-G", "Acoustic", "Maple", "Spruce"));
        inventory.addInstrument("1092", 12995.95, buildSpec(InstrumentType.BANJO, "Gibson", "RB-3", "Acoustic", "Mahogany", "Mahogany"));

        inventory.addInstrument("S001", 2399.99, buildSpec(InstrumentType.SAXOPHONE, "Yamaha", "YAS-280", "Brass", "Brass", "Brass"));

        Map<String, Object> clientPrefs = new HashMap<>();
        clientPrefs.put("instrumentType", InstrumentType.GUITAR);
        clientPrefs.put("builder", "Fender");
        clientPrefs.put("model", "Stratocaster");
        clientPrefs.put("type", "Electric");

        InstrumentSpec searchSpec = new InstrumentSpec(clientPrefs);
        List<Instrument> matching = inventory.search(searchSpec);

        if (!matching.isEmpty()) {
            System.out.println("Instrumentos encontrados:");
            for (Instrument i : matching) {
                InstrumentSpec spec = i.getSpec();
                System.out.println("Serial: " + i.getSerialNumber() +
                        ", Preço: R$" + i.getPrice() +
                        ", Tipo: " + spec.getProperty("instrumentType") +
                        ", Modelo: " + spec.getProperty("model") +
                        ", Fabricante: " + spec.getProperty("builder") +
                        ", Tipo Corpo: " + spec.getProperty("type"));
            }
        } else {
            System.out.println("Nenhum instrumento correspondente foi encontrado.");
        }
    }

    private static InstrumentSpec buildSpec(InstrumentType type, String builder, String model, String typeStr, String backWood, String topWood) {
        Map<String, Object> props = new HashMap<>();
        props.put("instrumentType", type);
        props.put("builder", builder);
        props.put("model", model);
        props.put("type", typeStr);
        props.put("backWood", backWood);
        props.put("topWood", topWood);
        return new InstrumentSpec(props);
    }
}
