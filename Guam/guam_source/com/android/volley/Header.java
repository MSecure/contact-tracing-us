package com.android.volley;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;

public final class Header {
    public final String mName;
    public final String mValue;

    public Header(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.mName, header.mName) && TextUtils.equals(this.mValue, header.mValue);
    }

    public int hashCode() {
        return this.mValue.hashCode() + (this.mName.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Header[name=");
        outline15.append(this.mName);
        outline15.append(",value=");
        return GeneratedOutlineSupport.outline12(outline15, this.mValue, "]");
    }
}
