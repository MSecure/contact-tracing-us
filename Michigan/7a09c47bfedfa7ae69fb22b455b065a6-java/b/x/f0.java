package b.x;

import android.view.View;
import android.view.WindowId;

public class f0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f2687a;

    public f0(View view) {
        this.f2687a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof f0) && ((f0) obj).f2687a.equals(this.f2687a);
    }

    public int hashCode() {
        return this.f2687a.hashCode();
    }
}
