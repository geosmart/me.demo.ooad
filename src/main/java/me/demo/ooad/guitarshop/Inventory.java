package me.demo.ooad.guitarshop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List search(GuitarSpec searchGuitar) {
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitor = (Guitar) i.next();
            GuitarSpec guitarSpec = guitor.getSpec();
            // Ignore serial number since that's unique
            // Ignore price since that's unique
            if (searchGuitar.getBuilder() != guitarSpec.getBuilder())
                continue;
            String model = searchGuitar.getModel().toLowerCase();
            if ((model != null) && (!model.equals("")) &&
                    (!model.equals(guitarSpec.getModel().toLowerCase())))
                continue;
            if (searchGuitar.getType() != guitarSpec.getType())
                continue;
            if (searchGuitar.getBackWood() != guitarSpec.getBackWood())
                continue;
            if (searchGuitar.getTopWood() != guitarSpec.getTopWood())
                continue;
            matchingGuitars.add(guitor);
        }
        return matchingGuitars;
    }
}
