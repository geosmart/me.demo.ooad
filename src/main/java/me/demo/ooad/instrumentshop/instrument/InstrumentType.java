package me.demo.ooad.instrumentshop.instrument;

/**
 * 乐器类型
 * Created by Think on 2016/9/21.
 */
public enum InstrumentType {
    /**
     * 曼陀林
     */
    MANDOLIN,
    /**
     * 吉他
     */
    GUITAR,
    /**
     * 班卓琴
     */
    BANJO;

    public String toString() {
        switch (this) {
            case MANDOLIN:
                return "曼陀林";
            case GUITAR:
                return "吉他";
            case BANJO:
                return "班卓琴";
            default:
                return "unspecified";
        }
    }
}
