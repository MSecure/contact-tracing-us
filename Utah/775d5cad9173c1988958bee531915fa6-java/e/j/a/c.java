package e.j.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    public int f1589j;

    /* renamed from: k  reason: collision with root package name */
    public int f1590k;

    /* renamed from: l  reason: collision with root package name */
    public LayoutInflater f1591l;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, null, z);
        this.f1590k = i2;
        this.f1589j = i2;
        this.f1591l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // e.j.a.a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1591l.inflate(this.f1589j, viewGroup, false);
    }
}
