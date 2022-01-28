package b.i.d;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public final class p implements Iterable<Intent> {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Intent> f1719b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final Context f1720c;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public p(Context context) {
        this.f1720c = context;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1719b.iterator();
    }
}
