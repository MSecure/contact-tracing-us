package e.k.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import e.k.a.b;
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {
    public boolean b;
    public boolean c;

    /* renamed from: d */
    public Cursor f1668d;

    /* renamed from: e */
    public Context f1669e;

    /* renamed from: f */
    public int f1670f;

    /* renamed from: g */
    public C0044a f1671g;

    /* renamed from: h */
    public DataSetObserver f1672h;

    /* renamed from: i */
    public b f1673i;

    /* renamed from: e.k.a.a$a */
    /* loaded from: classes.dex */
    public class C0044a extends ContentObserver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0044a() {
            super(new Handler());
            a.this = r1;
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.c && (cursor = aVar.f1668d) != null && !cursor.isClosed()) {
                aVar.b = aVar.f1668d.requery();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
            a.this = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        b bVar;
        boolean z2 = true;
        int i2 = z ? 1 : 2;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.c = true;
        } else {
            this.c = false;
        }
        z2 = cursor == null ? false : z2;
        this.f1668d = cursor;
        this.b = z2;
        this.f1669e = context;
        this.f1670f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1671g = new C0044a();
            bVar = new b();
        } else {
            bVar = null;
            this.f1671g = null;
        }
        this.f1672h = bVar;
        if (z2) {
            C0044a aVar = this.f1671g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1672h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1668d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0044a aVar = this.f1671g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.f1672h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f1668d = cursor;
            if (cursor != null) {
                C0044a aVar2 = this.f1671g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.f1672h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f1670f = cursor.getColumnIndexOrThrow("_id");
                this.b = true;
                notifyDataSetChanged();
            } else {
                this.f1670f = -1;
                this.b = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.b || (cursor = this.f1668d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.f1668d.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.f1676l.inflate(cVar.f1675k, viewGroup, false);
        }
        a(view, this.f1669e, this.f1668d);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1673i == null) {
            this.f1673i = new b(this);
        }
        return this.f1673i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1668d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1668d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1668d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f1668d.getLong(this.f1670f);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1668d.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.f1669e, this.f1668d, viewGroup);
            }
            a(view, this.f1669e, this.f1668d);
            return view;
        } else {
            throw new IllegalStateException(f.a.a.a.a.u("couldn't move cursor to position ", i2));
        }
    }
}
