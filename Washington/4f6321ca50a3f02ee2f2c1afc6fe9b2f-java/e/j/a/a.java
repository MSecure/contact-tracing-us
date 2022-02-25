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
    public Cursor f1513d;

    /* renamed from: e  reason: collision with root package name */
    public Context f1514e;

    /* renamed from: f  reason: collision with root package name */
    public int f1515f;

    /* renamed from: g  reason: collision with root package name */
    public C0038a f1516g;

    /* renamed from: h  reason: collision with root package name */
    public DataSetObserver f1517h;

    /* renamed from: i  reason: collision with root package name */
    public b f1518i;

    /* renamed from: e.j.a.a$a  reason: collision with other inner class name */
    public class C0038a extends ContentObserver {
        public C0038a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.c && (cursor = aVar.f1513d) != null && !cursor.isClosed()) {
                aVar.b = aVar.f1513d.requery();
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
        this.f1513d = cursor;
        this.b = z2;
        this.f1514e = context;
        this.f1515f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1516g = new C0038a();
            bVar = new b();
        } else {
            bVar = null;
            this.f1516g = null;
        }
        this.f1517h = bVar;
        if (z2) {
            C0038a aVar = this.f1516g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1517h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1513d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0038a aVar = this.f1516g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.f1517h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f1513d = cursor;
            if (cursor != null) {
                C0038a aVar2 = this.f1516g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.f1517h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f1515f = cursor.getColumnIndexOrThrow("_id");
                this.b = true;
                notifyDataSetChanged();
            } else {
                this.f1515f = -1;
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
        if (!this.b || (cursor = this.f1513d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.f1513d.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.f1521l.inflate(cVar.f1520k, viewGroup, false);
        }
        a(view, this.f1514e, this.f1513d);
        return view;
    }

    public Filter getFilter() {
        if (this.f1518i == null) {
            this.f1518i = new b(this);
        }
        return this.f1518i;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1513d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1513d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1513d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f1513d.getLong(this.f1515f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1513d.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.f1514e, this.f1513d, viewGroup);
            }
            a(view, this.f1514e, this.f1513d);
            return view;
        } else {
            throw new IllegalStateException(f.a.a.a.a.q("couldn't move cursor to position ", i2));
        }
    }
}
