package com.bugsnag.android;

import com.facebook.react.bridge.PromiseImpl;
import java.util.Map;

public class StackframeDeserializer {
    public Stackframe deserialize(Map<String, Object> map) {
        Object obj = map.get("method");
        Number number = null;
        if (obj == null) {
            obj = null;
        }
        String str = (String) obj;
        Object obj2 = map.get(PromiseImpl.STACK_FRAME_KEY_FILE);
        if (obj2 == null) {
            obj2 = null;
        }
        String str2 = (String) obj2;
        Object obj3 = map.get("lineNumber");
        if (obj3 == null) {
            obj3 = null;
        }
        Number number2 = (Number) obj3;
        Object obj4 = map.get("inProject");
        if (obj4 == null) {
            obj4 = null;
        }
        Boolean bool = (Boolean) obj4;
        Object obj5 = map.get(PromiseImpl.ERROR_MAP_KEY_CODE);
        if (obj5 == null) {
            obj5 = null;
        }
        Map map2 = (Map) obj5;
        Object obj6 = map.get("columnNumber");
        if (obj6 != null) {
            number = obj6;
        }
        return new Stackframe(str, str2, number2, bool, map2, number);
    }
}
