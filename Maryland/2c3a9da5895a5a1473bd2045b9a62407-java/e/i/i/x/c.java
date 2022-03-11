package e.i.i.x;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import java.util.Objects;

public class c {
    public final Object a;

    public static class a extends AccessibilityNodeProvider {
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            b a2 = this.a.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            Objects.requireNonNull(this.a);
            return null;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.a.c(i2, i3, bundle);
        }
    }

    public static class b extends a {
        public b(c cVar) {
            super(cVar);
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            b b = this.a.b(i2);
            if (b == null) {
                return null;
            }
            return b.a;
        }
    }

    /* renamed from: e.i.i.x.c$c  reason: collision with other inner class name */
    public static class C0040c extends b {
        public C0040c(c cVar) {
            super(cVar);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            Objects.requireNonNull(this.a);
        }
    }

    public c() {
        this.a = Build.VERSION.SDK_INT >= 26 ? new C0040c(this) : new b(this);
    }

    public c(Object obj) {
        this.a = obj;
    }

    public b a(int i2) {
        return null;
    }

    public b b(int i2) {
        return null;
    }

    public boolean c(int i2, int i3, Bundle bundle) {
        return false;
    }
}
