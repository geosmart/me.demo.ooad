package me.demo.ooad.instrumentshop.instrument.spec;

/**
 * Created by Think on 2016/9/20.
 */
public enum Style {
    A, F;

    public String toString() {
        switch (this) {
            case A:
                return "a style";
            case F:
                return "f style";
            default:
                return "unspecified";
        }
    }
}
