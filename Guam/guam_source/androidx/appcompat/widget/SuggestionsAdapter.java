package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    public boolean mClosed = false;
    public final int mCommitIconResId;
    public int mFlagsCol = -1;
    public int mIconName1Col = -1;
    public int mIconName2Col = -1;
    public final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    public final Context mProviderContext;
    public int mQueryRefinement = 1;
    public final SearchView mSearchView;
    public final SearchableInfo mSearchable;
    public int mText1Col = -1;
    public int mText2Col = -1;
    public int mText2UrlCol = -1;
    public ColorStateList mUrlColor;

    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    public static String getColumnString(Cursor cursor, String str) {
        return getStringOrNull(cursor, cursor.getColumnIndex(str));
    }

    public static String getStringOrNull(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v9, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0145  */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable.ConstantState constantState;
        String str;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.mFlagsCol;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (childViewCache.mText1 != null) {
            String stringOrNull = getStringOrNull(cursor, this.mText1Col);
            TextView textView = childViewCache.mText1;
            textView.setText(stringOrNull);
            if (TextUtils.isEmpty(stringOrNull)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        if (childViewCache.mText2 != null) {
            String stringOrNull2 = getStringOrNull(cursor, this.mText2UrlCol);
            if (stringOrNull2 != null) {
                if (this.mUrlColor == null) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
                    this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(stringOrNull2);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, stringOrNull2.length(), 33);
                str = spannableString;
            } else {
                str = getStringOrNull(cursor, this.mText2Col);
            }
            if (TextUtils.isEmpty(str)) {
                TextView textView2 = childViewCache.mText1;
                if (textView2 != null) {
                    textView2.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else {
                TextView textView3 = childViewCache.mText1;
                if (textView3 != null) {
                    textView3.setSingleLine(true);
                    childViewCache.mText1.setMaxLines(1);
                }
            }
            TextView textView4 = childViewCache.mText2;
            textView4.setText(str);
            if (TextUtils.isEmpty(str)) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
            }
        }
        ImageView imageView = childViewCache.mIcon1;
        if (imageView != null) {
            int i3 = this.mIconName1Col;
            if (i3 == -1) {
                drawable2 = null;
            } else {
                drawable2 = getDrawableFromResourceValue(cursor.getString(i3));
                if (drawable2 == null) {
                    ComponentName searchActivity = this.mSearchable.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState2 = this.mOutsideDrawablesCache.get(flattenToShortString);
                        if (constantState2 == null) {
                            drawable2 = null;
                        } else {
                            drawable2 = constantState2.newDrawable(this.mProviderContext.getResources());
                        }
                    } else {
                        PackageManager packageManager = this.mContext.getPackageManager();
                        try {
                            ActivityInfo activityInfo = packageManager.getActivityInfo(searchActivity, 128);
                            int iconResource = activityInfo.getIconResource();
                            if (iconResource != 0) {
                                drawable3 = packageManager.getDrawable(searchActivity.getPackageName(), iconResource, activityInfo.applicationInfo);
                                if (drawable3 == null) {
                                    StringBuilder outline16 = GeneratedOutlineSupport.outline16("Invalid icon resource ", iconResource, " for ");
                                    outline16.append(searchActivity.flattenToShortString());
                                    Log.w("SuggestionsAdapter", outline16.toString());
                                }
                                if (drawable3 != null) {
                                    constantState = null;
                                } else {
                                    constantState = drawable3.getConstantState();
                                }
                                this.mOutsideDrawablesCache.put(flattenToShortString, constantState);
                                drawable2 = drawable3;
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.w("SuggestionsAdapter", e.toString());
                        }
                        drawable3 = null;
                        if (drawable3 != null) {
                        }
                        this.mOutsideDrawablesCache.put(flattenToShortString, constantState);
                        drawable2 = drawable3;
                    }
                    if (drawable2 == null) {
                        drawable2 = this.mContext.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView.setImageDrawable(drawable2);
            if (drawable2 == null) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                drawable2.setVisible(false, false);
                drawable2.setVisible(true, false);
            }
        }
        ImageView imageView2 = childViewCache.mIcon2;
        if (imageView2 != null) {
            int i4 = this.mIconName2Col;
            if (i4 == -1) {
                drawable = null;
            } else {
                drawable = getDrawableFromResourceValue(cursor.getString(i4));
            }
            imageView2.setImageDrawable(drawable);
            if (drawable == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                drawable.setVisible(false, false);
                drawable.setVisible(true, false);
            }
        }
        int i5 = this.mQueryRefinement;
        if (i5 == 2 || (i5 == 1 && (i2 & 1) != 0)) {
            childViewCache.mIconRefine.setVisibility(0);
            childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
            childViewCache.mIconRefine.setOnClickListener(this);
            return;
        }
        childViewCache.mIconRefine.setVisibility(8);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public CharSequence convertToString(Cursor cursor) {
        String stringOrNull;
        String stringOrNull2;
        if (cursor == null) {
            return null;
        }
        String stringOrNull3 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (stringOrNull3 != null) {
            return stringOrNull3;
        }
        if (this.mSearchable.shouldRewriteQueryFromData() && (stringOrNull2 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return stringOrNull2;
        }
        if (!this.mSearchable.shouldRewriteQueryFromText() || (stringOrNull = getStringOrNull(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return stringOrNull;
    }

    public Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    public final Drawable getDrawableFromResourceValue(String str) {
        Drawable drawable;
        Uri parse;
        InputStream openInputStream;
        Drawable drawable2;
        Drawable drawable3 = null;
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + this.mProviderContext.getPackageName() + ColorPropConverter.PATH_DELIMITER + parseInt;
                Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(str2);
                if (constantState == null) {
                    drawable2 = null;
                } else {
                    drawable2 = constantState.newDrawable();
                }
                if (drawable2 != null) {
                    return drawable2;
                }
                Drawable drawable4 = ContextCompat.getDrawable(this.mProviderContext, parseInt);
                if (drawable4 != null) {
                    this.mOutsideDrawablesCache.put(str2, drawable4.getConstantState());
                }
                return drawable4;
            } catch (NumberFormatException unused) {
                Drawable.ConstantState constantState2 = this.mOutsideDrawablesCache.get(str);
                if (constantState2 == null) {
                    drawable = null;
                } else {
                    drawable = constantState2.newDrawable();
                }
                if (drawable != null) {
                    return drawable;
                }
                parse = Uri.parse(str);
                try {
                    if ("android.resource".equals(parse.getScheme())) {
                        try {
                            drawable3 = getDrawableFromResourceUri(parse);
                        } catch (Resources.NotFoundException unused2) {
                            throw new FileNotFoundException("Resource does not exist: " + parse);
                        }
                    } else {
                        openInputStream = this.mProviderContext.getContentResolver().openInputStream(parse);
                        if (openInputStream != null) {
                            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                            try {
                                openInputStream.close();
                            } catch (IOException e) {
                                Log.e("SuggestionsAdapter", "Error closing icon stream for " + parse, e);
                            }
                            drawable3 = createFromStream;
                        } else {
                            throw new FileNotFoundException("Failed to open " + parse);
                        }
                    }
                } catch (FileNotFoundException e2) {
                    Log.w("SuggestionsAdapter", "Icon not found: " + parse + ", " + e2.getMessage());
                }
                if (drawable3 != null) {
                    this.mOutsideDrawablesCache.put(str, drawable3.getConstantState());
                }
            } catch (Resources.NotFoundException unused3) {
                Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
                return null;
            } catch (Throwable th) {
                try {
                    openInputStream.close();
                } catch (IOException e3) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + parse, e3);
                }
                throw th;
            }
        }
        return drawable3;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
            if (inflate != null) {
                ((ChildViewCache) inflate.getTag()).mText1.setText(e.toString());
            }
            return inflate;
        }
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            ((ChildViewCache) newView.getTag()).mText1.setText(e.toString());
            return newView;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = this.mInflater.inflate(this.mLayout, viewGroup, false);
        inflate.setTag(new ChildViewCache(inflate));
        ((ImageView) inflate.findViewById(R$id.edit_query)).setImageResource(this.mCommitIconResId);
        return inflate;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(this.mCursor);
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(this.mCursor);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
    }

    public final void updateSpinnerState(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }
}
