package b.v;

import android.view.View;
import android.view.WindowId;

public class e0 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f1800a;

    public e0(View view) {
        this.f1800a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof e0) && ((e0) obj).f1800a.equals(this.f1800a);
    }

    public int hashCode() {
        return this.f1800a.hashCode();
    }
}
