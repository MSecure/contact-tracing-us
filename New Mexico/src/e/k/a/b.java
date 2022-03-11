package e.k.a;

import android.database.Cursor;
import android.widget.Filter;
import e.b.f.v0;
import java.util.Objects;
/* loaded from: classes.dex */
public class b extends Filter {
    public a a;

    /* loaded from: classes.dex */
    public interface a {
    }

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return ((v0) this.a).c((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    @Override // android.widget.Filter
    /* Code decompiled incorrectly, please refer to instructions dump */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursor;
        v0 v0Var = (v0) this.a;
        Objects.requireNonNull(v0Var);
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (v0Var.m.getVisibility() == 0 && v0Var.m.getWindowVisibility() == 0) {
            try {
                cursor = v0Var.g(v0Var.n, charSequence2, 50);
            } catch (RuntimeException unused) {
            }
            if (cursor != null) {
                cursor.getCount();
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (cursor == null) {
                    filterResults.count = cursor.getCount();
                    filterResults.values = cursor;
                } else {
                    filterResults.count = 0;
                    filterResults.values = null;
                }
                return filterResults;
            }
        }
        cursor = null;
        Filter.FilterResults filterResults2 = new Filter.FilterResults();
        if (cursor == null) {
        }
        return filterResults2;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.a;
        Cursor cursor = ((a) aVar).f1668d;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((v0) aVar).b((Cursor) obj);
        }
    }
}
