package me.demo.ooad.instrumentshop.instrument;

/**
 * Created by Think on 2016/9/21.
 */
public enum InstrumentType {
    MANDOLIN, GUITAR, BASE,BANJO;

    public String toString() {
        switch (this) {
            case MANDOLIN:
                return "mandolin";
            case GUITAR:
                return "guitar";
            default:
                return "unspecified";
        }
    }
}
