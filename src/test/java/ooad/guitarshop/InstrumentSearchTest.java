package ooad.guitarshop;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.demo.ooad.instrumentshop.instrument.Instrument;
import me.demo.ooad.instrumentshop.instrument.InstrumentSpec;
import me.demo.ooad.instrumentshop.Inventory;
import me.demo.ooad.instrumentshop.instrument.spec.Builder;
import me.demo.ooad.instrumentshop.instrument.InstrumentType;
import me.demo.ooad.instrumentshop.instrument.spec.Type;
import me.demo.ooad.instrumentshop.instrument.spec.Wood;
import me.demo.ooad.instrumentshop.instrument.spec.Style;

/**
 * search instrument test
 */
public class InstrumentSearchTest {
    Inventory inventory;

    @Before
    public void setup() {
        initInventory();
    }

    @Test
    public void test_search() {
        Map<String, Object> mandolinSpecProperties = new HashMap<>();
        mandolinSpecProperties.put("builder", Builder.PRS);
        mandolinSpecProperties.put("model", "Dave Navarro Signature");
        mandolinSpecProperties.put("type", Type.ELECTRIC);
        mandolinSpecProperties.put("style", Style.A);
        mandolinSpecProperties.put("topWood", Wood.MAHOGANY);
        mandolinSpecProperties.put("backWood", Wood.MAPLE);

        //search mandolin
        List matchingInstruments = inventory.search(InstrumentType.MANDOLIN,new InstrumentSpec(mandolinSpecProperties));
        printSearchResult(matchingInstruments);

        //search guitar
        Map<String, Object> guitarSpecProperties = new HashMap<>();
        guitarSpecProperties.put("builder", Builder.FENDER);
        guitarSpecProperties.put("model", "Stratocastor");
        guitarSpecProperties.put("type", Type.ELECTRIC);
        guitarSpecProperties.put("numStrings", 12);
        guitarSpecProperties.put("topWood", Wood.ALDER);
        guitarSpecProperties.put("backWood", Wood.ALDER);
        matchingInstruments = inventory.search(InstrumentType.GUITAR,new InstrumentSpec(guitarSpecProperties));
        printSearchResult(matchingInstruments);


        //search guitar
        Map<String, Object> testEmptyMap = new HashMap<>();
        matchingInstruments = inventory.search(InstrumentType.GUITAR,new InstrumentSpec(testEmptyMap));
        printSearchResult(matchingInstruments);
    }

    private void printSearchResult(List matchingInstruments) {
        if (!matchingInstruments.isEmpty()) {
            System.out.println("Erin, you might like these:");
            for (Iterator i = matchingInstruments.iterator(); i.hasNext(); ) {
                Instrument instrument = (Instrument) i.next();
                InstrumentSpec spec = instrument.getSpec();
                String instrumentType = instrument.getInstrumentType().toString();
                System.out.println("  We have a " +
                        spec.getProperty("builder") + " " + spec.getProperty("model") + " " +
                        spec.getProperty("type") + " " + instrumentType + ":\n     " +
                        spec.getProperty("backWood") + " back and sides,\n     " +
                        spec.getProperty("topWood") + " top.\n  You can have it for only $" +
                        instrument.getPrice() + "!\n  ----");
            }
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    private void initInventory() {
        // Set up Rick's guitar inventory
        inventory = new Inventory();

        // add guitar
        inventory.addInstrument(InstrumentType.GUITAR, "11277", 3999.95, new InstrumentSpec(generateInstrumentProp(Builder.COLLINGS, "CJ", Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA)));

        inventory.addInstrument(InstrumentType.GUITAR, "V95693", 1499.95, new InstrumentSpec(generateInstrumentProp(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER)));
        inventory.addInstrument(InstrumentType.GUITAR, "V9512", 1549.95, new InstrumentSpec(generateInstrumentProp(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER)));

        //add mandolin
        inventory.addInstrument(InstrumentType.MANDOLIN, "6-29584", 2100.95, new InstrumentSpec(generateInstrumentProp(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, Style.A, Wood.MAHOGANY, Wood.MAPLE)));
    }

    public Map<String, Object> generateInstrumentProp(Builder builder, String model, Type type, Wood topWood, Wood backWood) {
        Map<String, Object> specProperties = new HashMap<>();
        specProperties.put("builder", builder);
        specProperties.put("model", model);
        specProperties.put("type", type);
        specProperties.put("topWood", topWood);
        specProperties.put("backWood", backWood);
        return specProperties;
    }

    public Map<String, Object> generateInstrumentProp(Builder builder, String model, Type type, int numStrings, Wood topWood, Wood backWood) {
        Map<String, Object> specProperties = new HashMap<>();
        specProperties.put("builder", builder);
        specProperties.put("model", model);
        specProperties.put("type", type);
        specProperties.put("topWood", topWood);
        specProperties.put("backWood", backWood);
        specProperties.put("numStrings", numStrings);
        return specProperties;
    }

    public Map<String, Object> generateInstrumentProp(Builder builder, String model, Type type, Style style, Wood topWood, Wood backWood) {
        Map<String, Object> specProperties = new HashMap<>();
        specProperties.put("builder", builder);
        specProperties.put("model", model);
        specProperties.put("type", type);
        specProperties.put("topWood", topWood);
        specProperties.put("backWood", backWood);
        specProperties.put("style", style);
        return specProperties;
    }
}
