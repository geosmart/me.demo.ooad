package ooad.guitarshop;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import me.demo.ooad.instrumentshop.Instrument;
import me.demo.ooad.instrumentshop.InstrumentSpec;
import me.demo.ooad.instrumentshop.Inventory;
import me.demo.ooad.instrumentshop.guitor.Builder;
import me.demo.ooad.instrumentshop.guitor.GuitarSpec;
import me.demo.ooad.instrumentshop.guitor.Type;
import me.demo.ooad.instrumentshop.guitor.Wood;
import me.demo.ooad.instrumentshop.mandolin.MandolinSpec;
import me.demo.ooad.instrumentshop.mandolin.Style;

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
        //search mandolin
        InstrumentSpec searchMandolin = new MandolinSpec(Builder.PRS,
                "Dave Navarro Signature", Type.ELECTRIC, Style.A,
                Wood.MAHOGANY, Wood.MAPLE);
        List matchingInstruments = inventory.search(searchMandolin);
        printSearchResult(matchingInstruments);

        //search guitar
        InstrumentSpec searchGuitar = new GuitarSpec(Builder.FENDER, "Stratocastor",
                Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER);
        matchingInstruments = inventory.search(searchGuitar);
        printSearchResult(matchingInstruments);
    }

    private void printSearchResult(List matchingInstruments) {
        if (!matchingInstruments.isEmpty()) {
            System.out.println("Erin, you might like these:");
            for (Iterator i = matchingInstruments.iterator(); i.hasNext(); ) {
                Instrument instrument = (Instrument) i.next();
                InstrumentSpec spec = instrument.getSpec();
                String instrumentType = instrument.getClass().getSimpleName();
                System.out.println("  We have a " +
                        spec.getBuilder() + " " + spec.getModel() + " " +
                        spec.getType() + " " + instrumentType + ":\n     " +
                        spec.getBackWood() + " back and sides,\n     " +
                        spec.getTopWood() + " top.\n  You can have it for only $" +
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
        inventory.addInstrument("11277", 3999.95, new GuitarSpec(Builder.COLLINGS,
                "CJ", Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD, Wood.SITKA));

        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, 12,
                Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("V9512", 1549.95, new GuitarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, 12,
                Wood.ALDER, Wood.ALDER));

        //add mandolin
        inventory.addInstrument("6-29584", 2100.95, new MandolinSpec(Builder.PRS,
                "Dave Navarro Signature", Type.ELECTRIC, Style.A,
                Wood.MAHOGANY, Wood.MAPLE));
    }
}
