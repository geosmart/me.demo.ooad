package me.demo.ooad.instrumentshop.instrument;

import java.util.Iterator;
import java.util.Map;

/**
 * 乐器特性
 * Created by Think on 2016/9/20.
 */
public class InstrumentSpec {
    private Map properties;

    public InstrumentSpec(Map properties) {
        this.properties = properties;
    }

    public Map getProperties() {
        return properties;
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public boolean matchs(InstrumentSpec matchSpec) {
        for (Iterator i = matchSpec.getProperties().keySet().iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            if (!matchSpec.getProperty(key).equals(properties.get(key))) {
                return false;
            }
        }
        return true;
    }


}
