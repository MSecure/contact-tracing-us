package com.google.common.base;

public abstract class CharMatcher {

    public static abstract class FastMatcher extends CharMatcher {
    }

    public static abstract class NamedFastMatcher extends FastMatcher {
        public final String description;

        public NamedFastMatcher(String str) {
            this.description = str;
        }

        public final String toString() {
            return this.description;
        }
    }

    public static final class None extends NamedFastMatcher {
        public static final None INSTANCE = new None();

        public None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return false;
        }
    }

    public static final class Whitespace extends NamedFastMatcher {
        public static final Whitespace INSTANCE = new Whitespace();
        public static final int SHIFT = Integer.numberOfLeadingZeros(31);

        public Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((48906 * c) >>> SHIFT) == c;
        }
    }

    public abstract boolean matches(char c);
}
