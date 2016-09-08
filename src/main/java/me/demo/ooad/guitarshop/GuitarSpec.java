package me.demo.ooad.guitarshop;

/**
 * Created by Think on 2016/9/8.
 */
public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood, topWood;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.numStrings = numStrings;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public boolean matchs(GuitarSpec guitarSpec) {
        // Ignore serial number since that's unique
        // Ignore price since that's unique
        if (builder != guitarSpec.getBuilder())
            return false;
        String model = guitarSpec.getModel().toLowerCase();
        if ((model != null) && (!model.equals("")) &&
                (!model.equals(guitarSpec.getModel().toLowerCase())))
            return false;
        if (type != guitarSpec.getType())
            return false;
        if (numStrings != guitarSpec.getNumStrings())
            return false;
        if (backWood != guitarSpec.getBackWood())
            return false;
        if (topWood != guitarSpec.getTopWood())
            return false;
        return true;
    }

    public int getNumStrings() {
        return numStrings;
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
