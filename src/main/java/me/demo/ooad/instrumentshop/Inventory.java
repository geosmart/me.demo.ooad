package me.demo.ooad.instrumentshop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import me.demo.ooad.instrumentshop.instrument.Instrument;
import me.demo.ooad.instrumentshop.instrument.InstrumentSpec;
import me.demo.ooad.instrumentshop.instrument.InstrumentType;

/**
 * 乐器仓库
 * Created by Think on 2016/9/8.
 */
public class Inventory {
    private List instruments;

    public Inventory() {
        instruments = new LinkedList();
    }


    public void addInstrument(InstrumentType instrumentType, String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(instrumentType, serialNumber, price, spec);
        instruments.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        for (Iterator i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument) i.next();
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List search(InstrumentType instrumentType, InstrumentSpec searchInstrumentSpec) {
        List matchingInstruments = new LinkedList();
        if (!searchInstrumentSpec.getProperties().isEmpty()) {
            for (Iterator i = instruments.iterator(); i.hasNext(); ) {
                Instrument instrument = (Instrument) i.next();
                if (instrumentType.equals(instrument.getInstrumentType()) && instrument.getSpec().matchs(searchInstrumentSpec)) {
                    matchingInstruments.add(instrument);
                }
            }
        }
        return matchingInstruments;
    }
}
