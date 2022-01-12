package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

public enum TextProperties$TextDecoration {
    None("none"),
    Underline("underline"),
    Overline("overline"),
    LineThrough("line-through"),
    Blink("blink");
    
    public static final Map<String, TextProperties$TextDecoration> decorationToEnum = new HashMap();
    public final String decoration;

    /* access modifiers changed from: public */
    static {
        TextProperties$TextDecoration[] values = values();
        for (TextProperties$TextDecoration textProperties$TextDecoration : values) {
            decorationToEnum.put(textProperties$TextDecoration.decoration, textProperties$TextDecoration);
        }
    }

    /* access modifiers changed from: public */
    TextProperties$TextDecoration(String str) {
        this.decoration = str;
    }

    public String toString() {
        return this.decoration;
    }
}
