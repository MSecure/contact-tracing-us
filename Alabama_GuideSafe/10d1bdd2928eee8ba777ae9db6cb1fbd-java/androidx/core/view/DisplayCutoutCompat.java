package androidx.core.view;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class DisplayCutoutCompat {
    public final Object mDisplayCutout;

    public DisplayCutoutCompat(Object obj) {
        this.mDisplayCutout = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        DisplayCutoutCompat displayCutoutCompat = (DisplayCutoutCompat) obj;
        Object obj2 = this.mDisplayCutout;
        if (obj2 == null) {
            return displayCutoutCompat.mDisplayCutout == null;
        }
        return obj2.equals(displayCutoutCompat.mDisplayCutout);
    }

    public int hashCode() {
        Object obj = this.mDisplayCutout;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("DisplayCutoutCompat{");
        outline17.append(this.mDisplayCutout);
        outline17.append("}");
        return outline17.toString();
    }
}
