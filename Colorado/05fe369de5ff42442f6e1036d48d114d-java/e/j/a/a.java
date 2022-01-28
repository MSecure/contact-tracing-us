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
    public Cursor f1338d;

    /* renamed from: e  reason: collision with root package name */
    public Context f1339e;

    /* renamed from: f  reason: collision with root package name */
    public int f1340f;

    /* renamed from: g  reason: collision with root package name */
    public C0037a f1341g;

    /* renamed from: h  reason: collision with root package name */
    public DataSetObserver f1342h;

    /* renamed from: i  reason: collision with root package name */
    public b f1343i;

    /* renamed from: e.j.a.a$a  reason: collision with other inner class name */
    public class C0037a extends ContentObserver {
        public C0037a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.c && (cursor = aVar.f1338d) != null && !cursor.isClosed()) {
                aVar.b = aVar.f1338d.requery();
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
        this.f1338d = cursor;
        this.b = z2;
        this.f1339e = context;
        this.f1340f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1341g = new C0037a();
            bVar = new b();
        } else {
            bVar = null;
            this.f1341g = null;
        }
        this.f1342h = bVar;
        if (z2) {
            C0037a aVar = this.f1341g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1342h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1338d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0037a aVar = this.f1341g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.f1342h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f1338d = cursor;
            if (cursor != null) {
                C0037a aVar2 = this.f1341g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.f1342h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f1340f = cursor.getColumnIndexOrThrow("_id");
                this.b = true;
                notifyDataSetChanged();
            } else {
                this.f1340f = -1;
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
        if (!this.b || (cursor = this.f1338d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.f1338d.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.f1346l.inflate(cVar.f1345k, viewGroup, false);
        }
        a(view, this.f1339e, this.f1338d);
        return view;
    }

    public Filter getFilter() {
        if (this.f1343i == null) {
            this.f1343i = new b(this);
        }
        return this.f1343i;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1338d) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1338d;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.b || (cursor = this.f1338d) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.f1338d.getLong(this.f1340f);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1338d.moveToPosition(i2)) {
            if (view == null) {
                view = d(this.f1339e, this.f1338d, viewGroup);
            }
            a(view, this.f1339e, this.f1338d);
            return view;
        } else {
            throw new IllegalStateException(f.a.a.a.a.v("couldn't move cursor to position ", i2));
        }
    }
}
