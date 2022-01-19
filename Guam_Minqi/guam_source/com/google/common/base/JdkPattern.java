package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JdkPattern extends CommonPattern implements Serializable {
    public final Pattern pattern;

    public static final class JdkMatcher extends CommonMatcher {
        public final Matcher matcher;

        public JdkMatcher(Matcher matcher2) {
            if (matcher2 != null) {
                this.matcher = matcher2;
                return;
            }
            throw null;
        }
    }

    public JdkPattern(Pattern pattern2) {
        if (pattern2 != null) {
            this.pattern = pattern2;
            return;
        }
        throw null;
    }

    public String toString() {
        return this.pattern.toString();
    }
}
