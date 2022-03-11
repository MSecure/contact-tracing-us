package e.b.f;

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
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import e.j.b.a;
import e.k.a.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class v0 extends c implements View.OnClickListener {
    public static final /* synthetic */ int z;
    public final SearchView m;
    public final SearchableInfo n;
    public final Context o;
    public final WeakHashMap<String, Drawable.ConstantState> p;
    public final int q;
    public ColorStateList s;
    public int r = 1;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;

    /* loaded from: classes.dex */
    public static final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;

        /* renamed from: d */
        public final ImageView f1033d;

        /* renamed from: e */
        public final ImageView f1034e;

        public a(View view) {
            this.a = (TextView) view.findViewById(16908308);
            this.b = (TextView) view.findViewById(16908309);
            this.c = (ImageView) view.findViewById(16908295);
            this.f1033d = (ImageView) view.findViewById(16908296);
            this.f1034e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public v0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    public static String h(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012a  */
    @Override // e.k.a.a
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void a(View view, Context context, Cursor cursor) {
        Drawable drawable;
        Drawable drawable2;
        Drawable.ConstantState constantState;
        ActivityInfo activityInfo;
        int iconResource;
        String str;
        a aVar = (a) view.getTag();
        int i2 = this.y;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.a != null) {
            String h2 = h(cursor, this.t);
            TextView textView = aVar.a;
            textView.setText(h2);
            textView.setVisibility(TextUtils.isEmpty(h2) ? 8 : 0);
        }
        if (aVar.b != null) {
            String h3 = h(cursor, this.v);
            if (h3 != null) {
                if (this.s == null) {
                    TypedValue typedValue = new TypedValue();
                    this.o.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
                    this.s = this.o.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(h3);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.s, null), 0, h3.length(), 33);
                str = spannableString;
            } else {
                str = h(cursor, this.u);
            }
            if (TextUtils.isEmpty(str)) {
                TextView textView2 = aVar.a;
                if (textView2 != null) {
                    textView2.setSingleLine(false);
                    aVar.a.setMaxLines(2);
                }
            } else {
                TextView textView3 = aVar.a;
                if (textView3 != null) {
                    textView3.setSingleLine(true);
                    aVar.a.setMaxLines(1);
                }
            }
            TextView textView4 = aVar.b;
            textView4.setText(str);
            textView4.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
        ImageView imageView = aVar.c;
        Drawable drawable3 = null;
        if (imageView != null) {
            int i4 = this.w;
            if (i4 == -1) {
                drawable = null;
            } else {
                drawable = f(cursor.getString(i4));
                if (drawable == null) {
                    ComponentName searchActivity = this.n.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.p.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState2 = this.p.get(flattenToShortString);
                        drawable = constantState2 == null ? null : constantState2.newDrawable(this.o.getResources());
                    } else {
                        PackageManager packageManager = this.o.getPackageManager();
                        try {
                            activityInfo = packageManager.getActivityInfo(searchActivity, 128);
                            iconResource = activityInfo.getIconResource();
                        } catch (PackageManager.NameNotFoundException e2) {
                            e2.toString();
                        }
                        if (iconResource != 0) {
                            drawable2 = packageManager.getDrawable(searchActivity.getPackageName(), iconResource, activityInfo.applicationInfo);
                            if (drawable2 == null) {
                                searchActivity.flattenToShortString();
                            }
                            if (drawable2 != null) {
                                constantState = null;
                            } else {
                                constantState = drawable2.getConstantState();
                            }
                            this.p.put(flattenToShortString, constantState);
                            drawable = drawable2;
                        }
                        drawable2 = null;
                        if (drawable2 != null) {
                        }
                        this.p.put(flattenToShortString, constantState);
                        drawable = drawable2;
                    }
                    if (drawable == null) {
                        drawable = this.o.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView.setImageDrawable(drawable);
            if (drawable == null) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                drawable.setVisible(false, false);
                drawable.setVisible(true, false);
            }
        }
        ImageView imageView2 = aVar.f1033d;
        if (imageView2 != null) {
            int i5 = this.x;
            if (i5 != -1) {
                drawable3 = f(cursor.getString(i5));
            }
            imageView2.setImageDrawable(drawable3);
            if (drawable3 == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                drawable3.setVisible(false, false);
                drawable3.setVisible(true, false);
            }
        }
        int i6 = this.r;
        if (i6 == 2 || (i6 == 1 && (i3 & 1) != 0)) {
            aVar.f1034e.setVisibility(0);
            aVar.f1034e.setTag(aVar.a.getText());
            aVar.f1034e.setOnClickListener(this);
            return;
        }
        aVar.f1034e.setVisibility(8);
    }

    @Override // e.k.a.a
    public void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.t = cursor.getColumnIndex("suggest_text_1");
                this.u = cursor.getColumnIndex("suggest_text_2");
                this.v = cursor.getColumnIndex("suggest_text_2_url");
                this.w = cursor.getColumnIndex("suggest_icon_1");
                this.x = cursor.getColumnIndex("suggest_icon_2");
                this.y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception unused) {
        }
    }

    @Override // e.k.a.a
    public CharSequence c(Cursor cursor) {
        String h2;
        String h3;
        if (cursor == null) {
            return null;
        }
        String h4 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (h4 != null) {
            return h4;
        }
        if (this.n.shouldRewriteQueryFromData() && (h3 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return h3;
        }
        if (!this.n.shouldRewriteQueryFromText() || (h2 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return h2;
    }

    @Override // e.k.a.c, e.k.a.a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = this.f1676l.inflate(this.f1674j, viewGroup, false);
        inflate.setTag(new a(inflate));
        ((ImageView) inflate.findViewById(R$id.edit_query)).setImageResource(this.q);
        return inflate;
    }

    public Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.o.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final Drawable f(String str) {
        Drawable drawable = null;
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + this.o.getPackageName() + "/" + parseInt;
                Drawable.ConstantState constantState = this.p.get(str2);
                Drawable newDrawable = constantState == null ? null : constantState.newDrawable();
                if (newDrawable != null) {
                    return newDrawable;
                }
                Context context = this.o;
                Object obj = e.j.b.a.a;
                Drawable b = a.b.b(context, parseInt);
                if (b != null) {
                    this.p.put(str2, b.getConstantState());
                }
                return b;
            } catch (Resources.NotFoundException unused) {
                return null;
            } catch (NumberFormatException unused2) {
                Drawable.ConstantState constantState2 = this.p.get(str);
                Drawable newDrawable2 = constantState2 == null ? null : constantState2.newDrawable();
                if (newDrawable2 != null) {
                    return newDrawable2;
                }
                Uri parse = Uri.parse(str);
                try {
                } catch (FileNotFoundException e2) {
                    String str3 = "Icon not found: " + parse + ", " + e2.getMessage();
                    if (drawable != null) {
                        this.p.put(str, drawable.getConstantState());
                    }
                    return drawable;
                }
                if ("android.resource".equals(parse.getScheme())) {
                    try {
                        drawable = e(parse);
                        if (drawable != null) {
                        }
                    } catch (Resources.NotFoundException unused3) {
                        throw new FileNotFoundException("Resource does not exist: " + parse);
                    }
                } else {
                    InputStream openInputStream = this.o.getContentResolver().openInputStream(parse);
                    if (openInputStream != null) {
                        drawable = Drawable.createFromStream(openInputStream, null);
                        try {
                            openInputStream.close();
                        } catch (IOException unused4) {
                            String str4 = "Error closing icon stream for " + parse;
                        }
                        if (drawable != null) {
                        }
                    } else {
                        throw new FileNotFoundException("Failed to open " + parse);
                    }
                }
                String str32 = "Icon not found: " + parse + ", " + e2.getMessage();
                if (drawable != null) {
                }
            }
        }
        return drawable;
    }

    public Cursor g(SearchableInfo searchableInfo, String str, int i2) {
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
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.o.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    @Override // e.k.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View inflate = this.f1676l.inflate(this.f1675k, viewGroup, false);
            if (inflate != null) {
                ((a) inflate.getTag()).a.setText(e2.toString());
            }
            return inflate;
        }
    }

    @Override // e.k.a.a, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View d2 = d(this.o, this.f1668d, viewGroup);
            ((a) d2.getTag()).a.setText(e2.toString());
            return d2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final void i(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        i(this.f1668d);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        i(this.f1668d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.x((CharSequence) tag);
        }
    }
}
