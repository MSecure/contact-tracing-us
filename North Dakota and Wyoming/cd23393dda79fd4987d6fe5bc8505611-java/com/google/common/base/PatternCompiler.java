package com.google.common.base;

/* access modifiers changed from: package-private */
public interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
