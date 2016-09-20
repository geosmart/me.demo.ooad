package me.demo.ooad.instrumentshop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import me.demo.ooad.instrumentshop.guitor.Guitar;
import me.demo.ooad.instrumentshop.guitor.GuitarSpec;
import me.demo.ooad.instrumentshop.mandolin.Mandolin;
import me.demo.ooad.instrumentshop.mandolin.MandolinSpec;

/**
 * 乐器仓库
 * Created by Think on 2016/9/8.
 */
public class Inventory {
    private List instruments;

    public Inventory() {
        instruments = new LinkedList();
    }


    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;
        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, spec);
        } else if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, spec);
        }
        if (null != instrument) {
            instruments.add(instrument);
        }
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

    public List search(InstrumentSpec searchInstrumentSpec) {
        List matchingInstruments = new LinkedList();

        for (Iterator i = instruments.iterator(); i.hasNext(); ) {
            Instrument instrument = (Instrument) i.next();
            if (searchInstrumentSpec instanceof GuitarSpec) {
                if (instrument instanceof Guitar) {
                    GuitarSpec spec = (GuitarSpec) instrument.getSpec();
                    //在guitoSpec中封装match
                    if (spec.matchs(searchInstrumentSpec)) {
                        matchingInstruments.add(instrument);
                    }
                }
            } else if (searchInstrumentSpec instanceof MandolinSpec) {
                if (instrument instanceof Mandolin) {
                    MandolinSpec spec = (MandolinSpec) instrument.getSpec();
                    //在guitoSpec中封装match
                    if (spec.matchs(searchInstrumentSpec)) {
                        matchingInstruments.add(instrument);
                    }
                }
            } else {
                i.next();
            }
        }
        return matchingInstruments;
    }
}
