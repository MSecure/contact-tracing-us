package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import androidx.appcompat.widget.SuggestionsAdapter;

public class CursorFilter extends Filter {
    public CursorFilterClient mClient;

    public interface CursorFilterClient {
    }

    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return ((SuggestionsAdapter) this.mClient).convertToString((Cursor) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        String str;
        Cursor cursor;
        SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mClient;
        if (suggestionsAdapter != null) {
            if (charSequence == null) {
                str = "";
            } else {
                str = charSequence.toString();
            }
            if (suggestionsAdapter.mSearchView.getVisibility() == 0 && suggestionsAdapter.mSearchView.getWindowVisibility() == 0) {
                try {
                    cursor = suggestionsAdapter.getSearchManagerSuggestions(suggestionsAdapter.mSearchable, str, 50);
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
                } catch (RuntimeException e) {
                    Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
                }
            }
            cursor = null;
            Filter.FilterResults filterResults2 = new Filter.FilterResults();
            if (cursor == null) {
            }
            return filterResults2;
        }
        throw null;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        CursorFilterClient cursorFilterClient = this.mClient;
        Cursor cursor = ((CursorAdapter) cursorFilterClient).mCursor;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((SuggestionsAdapter) cursorFilterClient).changeCursor((Cursor) obj);
        }
    }
}
