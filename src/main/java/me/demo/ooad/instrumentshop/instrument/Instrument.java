package me.demo.ooad.instrumentshop.instrument;

/**
 * 乐器
 * Created by Think on 2016/9/20.
 */
public class Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec spec;
    private InstrumentType type;

    public Instrument(InstrumentType instrumentType, String serialNumber, double price, InstrumentSpec spec) {
        this.type = instrumentType;

        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }


    public InstrumentType getType() {
        return type;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }
}
