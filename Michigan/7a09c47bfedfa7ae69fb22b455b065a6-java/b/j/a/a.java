package b.j.a;

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
import b.j.a.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1942b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1943c;

    /* renamed from: d  reason: collision with root package name */
    public Cursor f1944d;

    /* renamed from: e  reason: collision with root package name */
    public Context f1945e;

    /* renamed from: f  reason: collision with root package name */
    public int f1946f;

    /* renamed from: g  reason: collision with root package name */
    public C0038a f1947g;
    public DataSetObserver h;
    public b i;

    /* renamed from: b.j.a.a$a  reason: collision with other inner class name */
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
            if (aVar.f1943c && (cursor = aVar.f1944d) != null && !cursor.isClosed()) {
                aVar.f1942b = aVar.f1944d.requery();
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f1942b = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f1942b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        b bVar;
        boolean z2 = true;
        boolean z3 = z ? true : true;
        if (z3 && true) {
            z3 |= true;
            this.f1943c = true;
        } else {
            this.f1943c = false;
        }
        z2 = cursor == null ? false : z2;
        this.f1944d = cursor;
        this.f1942b = z2;
        this.f1945e = context;
        this.f1946f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if (z3 & true) {
            this.f1947g = new C0038a();
            bVar = new b();
        } else {
            bVar = null;
            this.f1947g = null;
        }
        this.h = bVar;
        if (z2) {
            C0038a aVar = this.f1947g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1944d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0038a aVar = this.f1947g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f1944d = cursor;
            if (cursor != null) {
                C0038a aVar2 = this.f1947g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f1946f = cursor.getColumnIndexOrThrow("_id");
                this.f1942b = true;
                notifyDataSetChanged();
            } else {
                this.f1946f = -1;
                this.f1942b = false;
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
        if (!this.f1942b || (cursor = this.f1944d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1942b) {
            return null;
        }
        this.f1944d.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.l.inflate(cVar.k, viewGroup, false);
        }
        a(view, this.f1945e, this.f1944d);
        return view;
    }

    public Filter getFilter() {
        if (this.i == null) {
            this.i = new b(this);
        }
        return this.i;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f1942b || (cursor = this.f1944d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1944d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f1942b || (cursor = this.f1944d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f1944d.getLong(this.f1946f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1942b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1944d.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.f1945e, this.f1944d, viewGroup);
            }
            a(view, this.f1945e, this.f1944d);
            return view;
        } else {
            throw new IllegalStateException(c.a.a.a.a.n("couldn't move cursor to position ", i2));
        }
    }
}
