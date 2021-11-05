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
    public boolean f1223b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1224c;

    /* renamed from: d  reason: collision with root package name */
    public Cursor f1225d;

    /* renamed from: e  reason: collision with root package name */
    public Context f1226e;
    public int f;
    public C0028a g;
    public DataSetObserver h;
    public b i;

    /* renamed from: b.j.a.a$a  reason: collision with other inner class name */
    public class C0028a extends ContentObserver {
        public C0028a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.f1224c && (cursor = aVar.f1225d) != null && !cursor.isClosed()) {
                aVar.f1223b = aVar.f1225d.requery();
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f1223b = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f1223b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        b bVar;
        boolean z2 = true;
        boolean z3 = z ? true : true;
        if (z3 && true) {
            z3 |= true;
            this.f1224c = true;
        } else {
            this.f1224c = false;
        }
        z2 = cursor == null ? false : z2;
        this.f1225d = cursor;
        this.f1223b = z2;
        this.f1226e = context;
        this.f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if (z3 & true) {
            this.g = new C0028a();
            bVar = new b();
        } else {
            bVar = null;
            this.g = null;
        }
        this.h = bVar;
        if (z2) {
            C0028a aVar = this.g;
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
        Cursor cursor2 = this.f1225d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0028a aVar = this.g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f1225d = cursor;
            if (cursor != null) {
                C0028a aVar2 = this.g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f = cursor.getColumnIndexOrThrow("_id");
                this.f1223b = true;
                notifyDataSetChanged();
            } else {
                this.f = -1;
                this.f1223b = false;
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
        if (!this.f1223b || (cursor = this.f1225d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1223b) {
            return null;
        }
        this.f1225d.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.l.inflate(cVar.k, viewGroup, false);
        }
        a(view, this.f1226e, this.f1225d);
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
        if (!this.f1223b || (cursor = this.f1225d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1225d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f1223b || (cursor = this.f1225d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f1225d.getLong(this.f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1223b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1225d.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.f1226e, this.f1225d, viewGroup);
            }
            a(view, this.f1226e, this.f1225d);
            return view;
        } else {
            throw new IllegalStateException(c.a.a.a.a.l("couldn't move cursor to position ", i2));
        }
    }
}
