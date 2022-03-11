package e.k.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    public int f1674j;

    /* renamed from: k  reason: collision with root package name */
    public int f1675k;

    /* renamed from: l  reason: collision with root package name */
    public LayoutInflater f1676l;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, null, z);
        this.f1675k = i2;
        this.f1674j = i2;
        this.f1676l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // e.k.a.a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1676l.inflate(this.f1674j, viewGroup, false);
    }
}
