package com.google.common.base;

import java.util.Arrays;

public final class MoreObjects$ToStringHelper {
    public final String className;
    public final ValueHolder holderHead;
    public ValueHolder holderTail;
    public boolean omitNullValues = false;

    public static final class ValueHolder {
        public String name;
        public ValueHolder next;
        public Object value;

        public ValueHolder(MoreObjects$1 moreObjects$1) {
        }
    }

    public MoreObjects$ToStringHelper(String str, MoreObjects$1 moreObjects$1) {
        ValueHolder valueHolder = new ValueHolder(null);
        this.holderHead = valueHolder;
        this.holderTail = valueHolder;
        this.className = str;
    }

    public final MoreObjects$ToStringHelper addHolder(String str, Object obj) {
        ValueHolder valueHolder = new ValueHolder(null);
        this.holderTail.next = valueHolder;
        this.holderTail = valueHolder;
        valueHolder.value = obj;
        if (str != null) {
            valueHolder.name = str;
            return this;
        }
        throw null;
    }

    public String toString() {
        boolean z = this.omitNullValues;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        String str = "";
        for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
            Object obj = valueHolder.value;
            if (!z || obj != null) {
                sb.append(str);
                String str2 = valueHolder.name;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
