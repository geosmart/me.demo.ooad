package me.demo.ooad.instrumentshop.guitor;

import me.demo.ooad.instrumentshop.InstrumentSpec;

/**
 * Created by Think on 2016/9/8.
 */
public class GuitarSpec extends InstrumentSpec {
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.numStrings = numStrings;
    }

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
    }

    public boolean matchs(InstrumentSpec otherSpec) {
        //parent match
        if (!(otherSpec instanceof GuitarSpec)) {
            return false;
        }
        if (!super.matchs(otherSpec)) {
            return false;
        }
        GuitarSpec spec = (GuitarSpec) otherSpec;
        if (numStrings != spec.getNumStrings()) {
            return false;
        }
        return true;
    }

    public int getNumStrings() {
        return numStrings;
    }
}
