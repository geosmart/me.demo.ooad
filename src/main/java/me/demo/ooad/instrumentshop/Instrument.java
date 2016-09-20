package me.demo.ooad.instrumentshop;

/**
 * 乐器
 * Created by Think on 2016/9/20.
 */
public abstract class Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec spec;

    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
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


    public InstrumentSpec getSpec() {
        return spec;
    }
}
