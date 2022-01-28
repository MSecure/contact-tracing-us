package io.realm;

import java.util.Locale;

public interface OrderedCollectionChangeSet {

    public static class Range {
        public final int length;
        public final int startIndex;

        public Range(int i, int i2) {
            this.startIndex = i;
            this.length = i2;
        }

        public String toString() {
            return String.format(Locale.ENGLISH, "startIndex: %d, length: %d", Integer.valueOf(this.startIndex), Integer.valueOf(this.length));
        }
    }
}
