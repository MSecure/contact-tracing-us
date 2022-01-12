package com.google.common.base;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class Platform {
    public static final PatternCompiler patternCompiler = new JdkPatternCompiler(null);

    public static final class JdkPatternCompiler implements PatternCompiler {
        public JdkPatternCompiler() {
        }

        public JdkPatternCompiler(AnonymousClass1 r1) {
        }
    }

    static {
        Logger.getLogger(Platform.class.getName());
    }

    public static CommonPattern compilePattern(String str) {
        if (str == null) {
            throw null;
        } else if (((JdkPatternCompiler) patternCompiler) != null) {
            return new JdkPattern(Pattern.compile(str));
        } else {
            throw null;
        }
    }

    public static String emptyToNull(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }
}
