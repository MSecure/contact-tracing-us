package com.google.common.base;

import com.google.common.base.JdkPattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Splitter {
    public final int limit;
    public final boolean omitEmptyStrings;
    public final Strategy strategy;
    public final CharMatcher trimmer;

    public static abstract class SplittingIterator extends AbstractIterator<String> {
        public int limit;
        public int offset = 0;
        public final boolean omitEmptyStrings;
        public final CharSequence toSplit;
        public final CharMatcher trimmer;

        public SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }
    }

    public interface Strategy {
    }

    public Splitter(Strategy strategy2, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = strategy2;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    public List<String> splitToList(CharSequence charSequence) {
        if (charSequence != null) {
            AnonymousClass3 r0 = (AnonymousClass3) this.strategy;
            AnonymousClass3.AnonymousClass1 r1 = new SplittingIterator(r0, this, charSequence, new JdkPattern.JdkMatcher(((JdkPattern) CommonPattern.this).pattern.matcher(charSequence))) {
                /* class com.google.common.base.Splitter.AnonymousClass3.AnonymousClass1 */
                public final /* synthetic */ CommonMatcher val$matcher;

                {
                    this.val$matcher = r4;
                }
            };
            ArrayList arrayList = new ArrayList();
            while (r1.hasNext()) {
                arrayList.add(r1.next());
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw null;
    }
}
