package com.horcrux.svg;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.HashMap;
import java.util.Map;

public enum TextProperties$AlignmentBaseline {
    baseline("baseline"),
    textBottom("text-bottom"),
    alphabetic("alphabetic"),
    ideographic("ideographic"),
    middle("middle"),
    central("central"),
    mathematical("mathematical"),
    textTop("text-top"),
    bottom(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM),
    center("center"),
    top(RNGestureHandlerModule.KEY_HIT_SLOP_TOP),
    textBeforeEdge("text-before-edge"),
    textAfterEdge("text-after-edge"),
    beforeEdge("before-edge"),
    afterEdge("after-edge"),
    hanging("hanging");
    
    public static final Map<String, TextProperties$AlignmentBaseline> alignmentToEnum = new HashMap();
    public final String alignment;

    /* access modifiers changed from: public */
    static {
        TextProperties$AlignmentBaseline[] values = values();
        for (TextProperties$AlignmentBaseline textProperties$AlignmentBaseline : values) {
            alignmentToEnum.put(textProperties$AlignmentBaseline.alignment, textProperties$AlignmentBaseline);
        }
    }

    /* access modifiers changed from: public */
    TextProperties$AlignmentBaseline(String str) {
        this.alignment = str;
    }

    public static TextProperties$AlignmentBaseline getEnum(String str) {
        if (alignmentToEnum.containsKey(str)) {
            return alignmentToEnum.get(str);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline10("Unknown String Value: ", str));
    }

    public String toString() {
        return this.alignment;
    }
}
