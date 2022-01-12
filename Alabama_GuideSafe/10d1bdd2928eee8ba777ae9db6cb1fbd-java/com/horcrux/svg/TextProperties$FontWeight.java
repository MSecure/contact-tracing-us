package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

public enum TextProperties$FontWeight {
    Normal("normal"),
    Bold("bold"),
    w100("100"),
    w200("200"),
    w300("300"),
    w400("400"),
    w500("500"),
    w600("600"),
    w700("700"),
    w800("800"),
    w900("900"),
    Bolder("bolder"),
    Lighter("lighter");
    
    public static final Map<String, TextProperties$FontWeight> weightToEnum = new HashMap();
    public final String weight;

    /* access modifiers changed from: public */
    static {
        TextProperties$FontWeight[] values = values();
        for (TextProperties$FontWeight textProperties$FontWeight : values) {
            weightToEnum.put(textProperties$FontWeight.weight, textProperties$FontWeight);
        }
    }

    /* access modifiers changed from: public */
    TextProperties$FontWeight(String str) {
        this.weight = str;
    }

    public String toString() {
        return this.weight;
    }
}
