public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYANS, PRS, ANY;

    public String toString() {
        switch(this) {
            case FENDER: return "Fender";
            case MARTIN: return "Martin";
            case GIBSON: return "Gibson";
            case COLLINGS: return "Collings";
            case OLSON: return "Olson";
            case RYANS: return "Ryans";
            case PRS: return "Prs";
            case ANY: return "Any";
            default: return "";
        }
    }
}