package me.demo.ooad.instrumentshop.mandolin;

import me.demo.ooad.instrumentshop.InstrumentSpec;
import me.demo.ooad.instrumentshop.guitor.Builder;
import me.demo.ooad.instrumentshop.guitor.Type;
import me.demo.ooad.instrumentshop.guitor.Wood;

/**
 * Created by Think on 2016/9/8.
 */
public class MandolinSpec extends InstrumentSpec {
    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Style style, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public boolean match(InstrumentSpec otherSpec) {
        if (!(otherSpec instanceof MandolinSpec)) {
            return false;
        }
        if (!super.matchs(otherSpec)) {
            return false;
        }
        MandolinSpec spec = (MandolinSpec) otherSpec;
        if (!style.equals(spec.getStyle())) {
            return false;
        }
        return true;
    }

    public Style getStyle() {
        return style;
    }
}

