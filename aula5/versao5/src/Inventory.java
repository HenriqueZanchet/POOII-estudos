import java.util.*;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        instruments = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        instruments.add(new Instrument(serialNumber, price, spec));
    }

    public List<Instrument> search(InstrumentSpec searchSpec) {
        List<Instrument> matchingInstruments = new ArrayList<>();
        for (Instrument instrument : instruments) {
            if (instrument.getSpec().matches(searchSpec)) {
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }
}
