public enum InstrumentType {
    GUITAR, MANDOLIN, BANJO, SAXOPHONE;

    @Override
    public String toString() {
        switch (this) {
            case GUITAR: return "Guitar";
            case MANDOLIN: return "Mandolin";
            case BANJO: return "Banjo";
            case SAXOPHONE: return "Saxophone";
            default: return "Unknown";
        }
    }
}
