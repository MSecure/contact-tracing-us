package b.b.q;

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
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.f;
import b.j.a.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public class r0 extends c implements View.OnClickListener {
    public final SearchView m;
    public final SearchableInfo n;
    public final Context o;
    public final WeakHashMap<String, Drawable.ConstantState> p;
    public final int q;
    public boolean r = false;
    public int s = 1;
    public ColorStateList t;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public int z = -1;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f925a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f926b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f927c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f928d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f929e;

        public a(View view) {
            this.f925a = (TextView) view.findViewById(16908308);
            this.f926b = (TextView) view.findViewById(16908309);
            this.f927c = (ImageView) view.findViewById(16908295);
            this.f928d = (ImageView) view.findViewById(16908296);
            this.f929e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public r0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    public static String e(Cursor cursor, String str) {
        return i(cursor, cursor.getColumnIndex(str));
    }

    public static String i(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v6, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012a  */
    @Override // b.j.a.a
    public void a(View view, Context context, Cursor cursor) {
        Drawable drawable;
        Drawable drawable2;
        Drawable.ConstantState constantState;
        String str;
        a aVar = (a) view.getTag();
        int i = this.z;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f925a != null) {
            String i3 = i(cursor, this.u);
            TextView textView = aVar.f925a;
            textView.setText(i3);
            textView.setVisibility(TextUtils.isEmpty(i3) ? 8 : 0);
        }
        if (aVar.f926b != null) {
            String i4 = i(cursor, this.w);
            if (i4 != null) {
                if (this.t == null) {
                    TypedValue typedValue = new TypedValue();
                    this.f1945e.getTheme().resolveAttribute(b.b.a.textColorSearchUrl, typedValue, true);
                    this.t = this.f1945e.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(i4);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, i4.length(), 33);
                str = spannableString;
            } else {
                str = i(cursor, this.v);
            }
            if (TextUtils.isEmpty(str)) {
                TextView textView2 = aVar.f925a;
                if (textView2 != null) {
                    textView2.setSingleLine(false);
                    aVar.f925a.setMaxLines(2);
                }
            } else {
                TextView textView3 = aVar.f925a;
                if (textView3 != null) {
                    textView3.setSingleLine(true);
                    aVar.f925a.setMaxLines(1);
                }
            }
            TextView textView4 = aVar.f926b;
            textView4.setText(str);
            textView4.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
        ImageView imageView = aVar.f927c;
        Drawable drawable3 = null;
        if (imageView != null) {
            int i5 = this.x;
            if (i5 == -1) {
                drawable = null;
            } else {
                drawable = g(cursor.getString(i5));
                if (drawable == null) {
                    ComponentName searchActivity = this.n.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.p.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState2 = this.p.get(flattenToShortString);
                        drawable = constantState2 == null ? null : constantState2.newDrawable(this.o.getResources());
                    } else {
                        PackageManager packageManager = this.f1945e.getPackageManager();
                        try {
                            ActivityInfo activityInfo = packageManager.getActivityInfo(searchActivity, RecyclerView.a0.FLAG_IGNORE);
                            int iconResource = activityInfo.getIconResource();
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
                        } catch (PackageManager.NameNotFoundException e2) {
                            e2.toString();
                        }
                        drawable2 = null;
                        if (drawable2 != null) {
                        }
                        this.p.put(flattenToShortString, constantState);
                        drawable = drawable2;
                    }
                    if (drawable == null) {
                        drawable = this.f1945e.getPackageManager().getDefaultActivityIcon();
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
        ImageView imageView2 = aVar.f928d;
        if (imageView2 != null) {
            int i6 = this.y;
            if (i6 != -1) {
                drawable3 = g(cursor.getString(i6));
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
        int i7 = this.s;
        if (i7 == 2 || (i7 == 1 && (i2 & 1) != 0)) {
            aVar.f929e.setVisibility(0);
            aVar.f929e.setTag(aVar.f925a.getText());
            aVar.f929e.setOnClickListener(this);
            return;
        }
        aVar.f929e.setVisibility(8);
    }

    @Override // b.j.a.a
    public void b(Cursor cursor) {
        if (!this.r) {
            try {
                super.b(cursor);
                if (cursor != null) {
                    this.u = cursor.getColumnIndex("suggest_text_1");
                    this.v = cursor.getColumnIndex("suggest_text_2");
                    this.w = cursor.getColumnIndex("suggest_text_2_url");
                    this.x = cursor.getColumnIndex("suggest_icon_1");
                    this.y = cursor.getColumnIndex("suggest_icon_2");
                    this.z = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception unused) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // b.j.a.a
    public CharSequence c(Cursor cursor) {
        String i;
        String i2;
        if (cursor == null) {
            return null;
        }
        String i3 = i(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (i3 != null) {
            return i3;
        }
        if (this.n.shouldRewriteQueryFromData() && (i2 = i(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return i2;
        }
        if (!this.n.shouldRewriteQueryFromText() || (i = i(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return i;
    }

    @Override // b.j.a.a, b.j.a.c
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = this.l.inflate(this.j, viewGroup, false);
        inflate.setTag(new a(inflate));
        ((ImageView) inflate.findViewById(f.edit_query)).setImageResource(this.q);
        return inflate;
    }

    public Drawable f(Uri uri) {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1945e.getPackageManager().getResourcesForApplication(authority);
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

    public final Drawable g(String str) {
        Uri parse;
        InputStream openInputStream;
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
                Drawable c2 = b.i.e.a.c(this.o, parseInt);
                if (c2 != null) {
                    this.p.put(str2, c2.getConstantState());
                }
                return c2;
            } catch (NumberFormatException unused) {
                Drawable.ConstantState constantState2 = this.p.get(str);
                Drawable newDrawable2 = constantState2 == null ? null : constantState2.newDrawable();
                if (newDrawable2 != null) {
                    return newDrawable2;
                }
                parse = Uri.parse(str);
                try {
                    if ("android.resource".equals(parse.getScheme())) {
                        try {
                            drawable = f(parse);
                        } catch (Resources.NotFoundException unused2) {
                            throw new FileNotFoundException("Resource does not exist: " + parse);
                        }
                    } else {
                        openInputStream = this.o.getContentResolver().openInputStream(parse);
                        if (openInputStream != null) {
                            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                            try {
                                openInputStream.close();
                            } catch (IOException unused3) {
                                String str3 = "Error closing icon stream for " + parse;
                            }
                            drawable = createFromStream;
                        } else {
                            throw new FileNotFoundException("Failed to open " + parse);
                        }
                    }
                } catch (FileNotFoundException e2) {
                    String str4 = "Icon not found: " + parse + ", " + e2.getMessage();
                }
                if (drawable != null) {
                    this.p.put(str, drawable.getConstantState());
                }
            } catch (Resources.NotFoundException unused4) {
                return null;
            } catch (Throwable th) {
                try {
                    openInputStream.close();
                } catch (IOException unused5) {
                    String str5 = "Error closing icon stream for " + parse;
                }
                throw th;
            }
        }
        return drawable;
    }

    @Override // b.j.a.a
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            View inflate = this.l.inflate(this.k, viewGroup, false);
            if (inflate != null) {
                ((a) inflate.getTag()).f925a.setText(e2.toString());
            }
            return inflate;
        }
    }

    @Override // b.j.a.a
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            View d2 = d(this.f1945e, this.f1944d, viewGroup);
            ((a) d2.getTag()).f925a.setText(e2.toString());
            return d2;
        }
    }

    public Cursor h(SearchableInfo searchableInfo, String str, int i) {
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
        return this.f1945e.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public boolean hasStableIds() {
        return false;
    }

    public final void j(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        j(this.f1944d);
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        j(this.f1944d);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.z((CharSequence) tag);
        }
    }
}
