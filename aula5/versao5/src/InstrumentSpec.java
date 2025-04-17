import java.util.Map;

public class InstrumentSpec {
    private Map<String, Object> properties;

    public InstrumentSpec(Map<String, Object> properties) {
        if (properties == null)
            throw new IllegalArgumentException("Propriedades não podem ser nulas");
        this.properties = properties;
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        for (String key : otherSpec.getProperties().keySet()) {
            if (!properties.containsKey(key)) return false;
            if (!properties.get(key).equals(otherSpec.getProperty(key))) return false;
        }
        return true;
    }
}
