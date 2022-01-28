package com.facebook.react.util;

import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.devsupport.StackTraceHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSStackTrace {
    public static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    public static String format(String str, ReadableArray readableArray) {
        String str2;
        String string;
        StringBuilder sb = new StringBuilder(str);
        sb.append(", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            sb.append(map.getString(PromiseImpl.STACK_FRAME_KEY_METHOD_NAME));
            sb.append(ColorPropConverter.PREFIX_RESOURCE);
            if (map.hasKey(PromiseImpl.STACK_FRAME_KEY_FILE) && !map.isNull(PromiseImpl.STACK_FRAME_KEY_FILE) && map.getType(PromiseImpl.STACK_FRAME_KEY_FILE) == ReadableType.String && (string = map.getString(PromiseImpl.STACK_FRAME_KEY_FILE)) != null) {
                Matcher matcher = FILE_ID_PATTERN.matcher(string);
                if (matcher.find()) {
                    str2 = matcher.group(1) + ColorPropConverter.PACKAGE_DELIMITER;
                    sb.append(str2);
                    if (map.hasKey("lineNumber") || map.isNull("lineNumber") || map.getType("lineNumber") != ReadableType.Number) {
                        sb.append(-1);
                    } else {
                        sb.append(map.getInt("lineNumber"));
                    }
                    if (map.hasKey(StackTraceHelper.COLUMN_KEY) && !map.isNull(StackTraceHelper.COLUMN_KEY) && map.getType(StackTraceHelper.COLUMN_KEY) == ReadableType.Number) {
                        sb.append(ColorPropConverter.PACKAGE_DELIMITER);
                        sb.append(map.getInt(StackTraceHelper.COLUMN_KEY));
                    }
                    sb.append("\n");
                }
            }
            str2 = "";
            sb.append(str2);
            if (map.hasKey("lineNumber")) {
            }
            sb.append(-1);
            sb.append(ColorPropConverter.PACKAGE_DELIMITER);
            sb.append(map.getInt(StackTraceHelper.COLUMN_KEY));
            sb.append("\n");
        }
        return sb.toString();
    }
}
