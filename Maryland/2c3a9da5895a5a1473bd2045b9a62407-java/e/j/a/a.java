package e.j.a;

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
import e.j.a.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public Cursor f1527d;

    /* renamed from: e  reason: collision with root package name */
    public Context f1528e;

    /* renamed from: f  reason: collision with root package name */
    public int f1529f;

    /* renamed from: g  reason: collision with root package name */
    public C0042a f1530g;

    /* renamed from: h  reason: collision with root package name */
    public DataSetObserver f1531h;

    /* renamed from: i  reason: collision with root package name */
    public b f1532i;

    /* renamed from: e.j.a.a$a  reason: collision with other inner class name */
    public class C0042a extends ContentObserver {
        public C0042a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.c && (cursor = aVar.f1527d) != null && !cursor.isClosed()) {
                aVar.b = aVar.f1527d.requery();
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.b = true;
            aVar.notifyDataSetChanged();
        }

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
        this.f1527d = cursor;
        this.b = z2;
        this.f1528e = context;
        this.f1529f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1530g = new C0042a();
            bVar = new b();
        } else {
            bVar = null;
            this.f1530g = null;
        }
        this.f1531h = bVar;
        if (z2) {
            C0042a aVar = this.f1530g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1531h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1527d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0042a aVar = this.f1530g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.f1531h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f1527d = cursor;
            if (cursor != null) {
                C0042a aVar2 = this.f1530g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.f1531h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f1529f = cursor.getColumnIndexOrThrow("_id");
                this.b = true;
                notifyDataSetChanged();
            } else {
                this.f1529f = -1;
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

    public int getCount() {
        Cursor cursor;
        if (!this.b || (cursor = this.f1527d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.f1527d.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.f1535l.inflate(cVar.f1534k, viewGroup, false);
        }
        a(view, this.f1528e, this.f1527d);
        return view;
    }

    public Filter getFilter() {
        if (this.f1532i == null) {
            this.f1532i = new b(this);
        }
        return this.f1532i;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1527d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1527d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1527d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f1527d.getLong(this.f1529f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1527d.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.f1528e, this.f1527d, viewGroup);
            }
            a(view, this.f1528e, this.f1527d);
            return view;
        } else {
            throw new IllegalStateException(f.a.a.a.a.q("couldn't move cursor to position ", i2));
        }
    }
}
