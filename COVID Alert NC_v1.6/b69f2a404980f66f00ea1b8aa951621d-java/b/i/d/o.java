package b.i.d;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public final class o implements Iterable<Intent> {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Intent> f1023b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final Context f1024c;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public o(Context context) {
        this.f1024c = context;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1023b.iterator();
    }
}
