package me.demo.ooad.instrumentshop;

import me.demo.ooad.instrumentshop.guitor.Builder;
import me.demo.ooad.instrumentshop.guitor.Type;
import me.demo.ooad.instrumentshop.guitor.Wood;

/**
 * 乐器特性
 * Created by Think on 2016/9/20.
 */
public class InstrumentSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood, topWood;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public boolean matchs(InstrumentSpec guitarSpec) {
        // Ignore serial number since that's unique
        // Ignore price since that's unique
        if (builder != guitarSpec.getBuilder()) {
            return false;
        }
        String model = guitarSpec.getModel().toLowerCase();
        if ((model != null) && (!model.equals("")) &&
                (!model.equals(guitarSpec.getModel().toLowerCase()))) {
            return false;
        }
        if (type != guitarSpec.getType()) {
            return false;
        }
        if (backWood != guitarSpec.getBackWood()) {
            return false;
        }
        if (topWood != guitarSpec.getTopWood()) {
            return false;
        }
        return true;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
}
