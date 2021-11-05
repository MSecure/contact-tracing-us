package b.i.l.w;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1918a;

    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final c f1919a;

        public a(c cVar) {
            this.f1919a = cVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            b a2 = this.f1919a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.f1906a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (this.f1919a != null) {
                return null;
            }
            throw null;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f1919a.c(i, i2, bundle);
        }
    }

    public static class b extends a {
        public b(c cVar) {
            super(cVar);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            b b2 = this.f1919a.b(i);
            if (b2 == null) {
                return null;
            }
            return b2.f1906a;
        }
    }

    public c() {
        this.f1918a = new b(this);
    }

    public c(Object obj) {
        this.f1918a = obj;
    }

    public b a(int i) {
        return null;
    }

    public b b(int i) {
        return null;
    }

    public boolean c(int i, int i2, Bundle bundle) {
        return false;
    }
}
