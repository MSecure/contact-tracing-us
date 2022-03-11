package e.j.a;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import e.b.f.r0;
import java.util.Objects;

public class b extends Filter {
    public a a;

    public interface a {
    }

    public b(a aVar) {
        this.a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return ((r0) this.a).c((Cursor) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursor;
        r0 r0Var = (r0) this.a;
        Objects.requireNonNull(r0Var);
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (r0Var.m.getVisibility() == 0 && r0Var.m.getWindowVisibility() == 0) {
            try {
                cursor = r0Var.g(r0Var.n, charSequence2, 50);
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
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        cursor = null;
        Filter.FilterResults filterResults2 = new Filter.FilterResults();
        if (cursor == null) {
        }
        return filterResults2;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.a;
        Cursor cursor = ((a) aVar).f1527d;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((r0) aVar).b((Cursor) obj);
        }
    }
}
