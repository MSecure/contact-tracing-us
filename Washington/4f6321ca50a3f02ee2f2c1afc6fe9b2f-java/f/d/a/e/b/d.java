package f.d.a.e.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.mikepenz.aboutlibraries.R$attr;
import com.mikepenz.aboutlibraries.R$color;
import com.mikepenz.aboutlibraries.R$id;
import com.mikepenz.aboutlibraries.R$layout;
import com.mikepenz.aboutlibraries.R$styleable;
import e.b.a.g;
import f.d.a.b;
import j.g;
import j.j.b.e;
import j.j.b.f;
import java.util.List;
import java.util.Objects;

public final class d extends f.d.b.q.a<a> {
    public final f.d.a.d.a b;
    public final b c;

    public static final class a extends RecyclerView.b0 {
        public TextView A;
        public MaterialCardView t;
        public TextView u;
        public TextView v;
        public View w;
        public TextView x;
        public View y;
        public TextView z;

        /* renamed from: f.d.a.e.b.d$a$a  reason: collision with other inner class name */
        public static final class C0128a extends f implements j.j.a.b<TypedArray, g> {
            public final /* synthetic */ a c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f3473d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0128a(a aVar, Context context) {
                super(1);
                this.c = aVar;
                this.f3473d = context;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // j.j.a.b
            public g d(TypedArray typedArray) {
                TypedArray typedArray2 = typedArray;
                e.c(typedArray2, "it");
                MaterialCardView materialCardView = this.c.t;
                int i2 = R$styleable.AboutLibraries_aboutLibrariesCardBackground;
                Context context = this.f3473d;
                e.b(context, "ctx");
                int i3 = R$attr.aboutLibrariesCardBackground;
                Context context2 = this.f3473d;
                e.b(context2, "ctx");
                materialCardView.setCardBackgroundColor(typedArray2.getColor(i2, f.b.a.c.b.o.b.Y0(context, i3, f.b.a.c.b.o.b.W0(context2, R$color.about_libraries_card))));
                this.c.u.setTextColor(typedArray2.getColorStateList(R$styleable.AboutLibraries_aboutLibrariesOpenSourceTitle));
                TextView textView = this.c.v;
                int i4 = R$styleable.AboutLibraries_aboutLibrariesOpenSourceText;
                textView.setTextColor(typedArray2.getColorStateList(i4));
                View view = this.c.w;
                int i5 = R$styleable.AboutLibraries_aboutLibrariesOpenSourceDivider;
                Context context3 = this.f3473d;
                e.b(context3, "ctx");
                int i6 = R$attr.aboutLibrariesOpenSourceDivider;
                Context context4 = this.f3473d;
                e.b(context4, "ctx");
                int i7 = R$color.about_libraries_dividerLight_openSource;
                view.setBackgroundColor(typedArray2.getColor(i5, f.b.a.c.b.o.b.Y0(context3, i6, f.b.a.c.b.o.b.W0(context4, i7))));
                this.c.x.setTextColor(typedArray2.getColorStateList(i4));
                View view2 = this.c.y;
                Context context5 = this.f3473d;
                e.b(context5, "ctx");
                Context context6 = this.f3473d;
                e.b(context6, "ctx");
                view2.setBackgroundColor(typedArray2.getColor(i5, f.b.a.c.b.o.b.Y0(context5, i6, f.b.a.c.b.o.b.W0(context6, i7))));
                this.c.z.setTextColor(typedArray2.getColorStateList(i4));
                this.c.A.setTextColor(typedArray2.getColorStateList(i4));
                return g.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            e.c(view, "itemView");
            this.t = (MaterialCardView) view;
            View findViewById = view.findViewById(R$id.libraryName);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.u = (TextView) findViewById;
            View findViewById2 = view.findViewById(R$id.libraryCreator);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.v = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R$id.libraryDescriptionDivider);
            e.b(findViewById3, "itemView.findViewById(R.…ibraryDescriptionDivider)");
            this.w = findViewById3;
            View findViewById4 = view.findViewById(R$id.libraryDescription);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            this.x = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R$id.libraryBottomDivider);
            e.b(findViewById5, "itemView.findViewById(R.id.libraryBottomDivider)");
            this.y = findViewById5;
            View findViewById6 = view.findViewById(R$id.libraryVersion);
            Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
            this.z = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R$id.libraryLicense);
            Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
            this.A = (TextView) findViewById7;
            Context context = view.getContext();
            e.b(context, "ctx");
            f.b.a.c.b.o.b.F1(context, null, 0, 0, new C0128a(this, context), 7);
        }
    }

    public d(f.d.a.d.a aVar, b bVar) {
        e.c(aVar, "library");
        e.c(bVar, "libsBuilder");
        this.b = aVar;
        this.c = bVar;
    }

    public static final void m(d dVar, Context context, b bVar, f.d.a.d.a aVar) {
        String str;
        Objects.requireNonNull(dVar);
        try {
            Objects.requireNonNull(bVar);
            f.d.a.d.b a2 = aVar.a();
            String str2 = null;
            if (!(a2 == null || (str = a2.f3469e) == null)) {
                if (str.length() > 0) {
                    g.a aVar2 = new g.a(context);
                    f.d.a.d.b a3 = aVar.a();
                    if (a3 != null) {
                        str2 = a3.f3469e;
                    }
                    aVar2.a.f21f = Html.fromHtml(str2);
                    aVar2.a().show();
                    return;
                }
            }
            f.d.a.d.b a4 = aVar.a();
            if (a4 != null) {
                str2 = a4.c;
            }
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018a, code lost:
        if (r1 != true) goto L_0x018c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a7  */
    @Override // f.d.b.q.b, f.d.b.k
    public void g(RecyclerView.b0 b0Var, List list) {
        CharSequence charSequence;
        TextView textView;
        String str;
        TextView textView2;
        f.d.a.d.b a2;
        String str2;
        f.d.a.d.b a3;
        String str3;
        a aVar = (a) b0Var;
        e.c(aVar, "holder");
        e.c(list, "payloads");
        super.g(aVar, list);
        View view = aVar.a;
        e.b(view, "holder.itemView");
        Context context = view.getContext();
        aVar.u.setText(this.b.f3460e);
        aVar.v.setText(this.b.f3461f);
        if (TextUtils.isEmpty(this.b.f3463h)) {
            textView = aVar.x;
            charSequence = this.b.f3463h;
        } else {
            textView = aVar.x;
            charSequence = Html.fromHtml(this.b.f3463h);
        }
        textView.setText(charSequence);
        Objects.requireNonNull(this.c);
        boolean z = false;
        if (!(!(this.b.f3464i.length() == 0) || (a3 = this.b.a()) == null || (str3 = a3.b) == null)) {
            if (str3.length() == 0) {
                aVar.y.setVisibility(8);
                aVar.z.setVisibility(8);
                aVar.A.setVisibility(8);
                if (this.b.f3462g.length() > 0) {
                    aVar.v.setOnClickListener(new c(0, this, context));
                    aVar.v.setOnLongClickListener(new defpackage.a(0, this, context));
                } else {
                    aVar.v.setOnTouchListener(null);
                    aVar.v.setOnClickListener(null);
                    aVar.v.setOnLongClickListener(null);
                }
                if (!(this.b.f3466k.length() > 0)) {
                    if (!(this.b.n.length() > 0)) {
                        aVar.x.setOnTouchListener(null);
                        aVar.x.setOnClickListener(null);
                        aVar.x.setOnLongClickListener(null);
                        if (this.b.a() == null) {
                            f.d.a.d.b a4 = this.b.a();
                            if (!(a4 == null || (str = a4.c) == null)) {
                                if (str.length() > 0) {
                                    z = true;
                                }
                            }
                            Objects.requireNonNull(this.c);
                            aVar.A.setOnClickListener(new c(2, this, context));
                            aVar.A.setOnLongClickListener(new defpackage.a(2, this, context));
                            return;
                        }
                        aVar.A.setOnTouchListener(null);
                        aVar.A.setOnClickListener(null);
                        aVar.A.setOnLongClickListener(null);
                        return;
                    }
                }
                aVar.x.setOnClickListener(new c(1, this, context));
                aVar.x.setOnLongClickListener(new defpackage.a(1, this, context));
                if (this.b.a() == null) {
                }
            }
        }
        aVar.y.setVisibility(0);
        aVar.z.setVisibility(0);
        aVar.A.setVisibility(0);
        String str4 = "";
        if (this.b.f3464i.length() > 0) {
            Objects.requireNonNull(this.c);
            aVar.z.setText(this.b.f3464i);
        } else {
            aVar.z.setText(str4);
        }
        if (!(this.b.a() == null || (a2 = this.b.a()) == null || (str2 = a2.b) == null)) {
            if ((str2.length() > 0) && this.c.f3447e) {
                textView2 = aVar.A;
                f.d.a.d.b a5 = this.b.a();
                str4 = a5 != null ? a5.b : null;
                textView2.setText(str4);
                if (this.b.f3462g.length() > 0) {
                }
                if (!(this.b.f3466k.length() > 0)) {
                }
                aVar.x.setOnClickListener(new c(1, this, context));
                aVar.x.setOnLongClickListener(new defpackage.a(1, this, context));
                if (this.b.a() == null) {
                }
            }
        }
        textView2 = aVar.A;
        textView2.setText(str4);
        if (this.b.f3462g.length() > 0) {
        }
        if (!(this.b.f3466k.length() > 0)) {
        }
        aVar.x.setOnClickListener(new c(1, this, context));
        aVar.x.setOnLongClickListener(new defpackage.a(1, this, context));
        if (this.b.a() == null) {
        }
    }

    @Override // f.d.b.k
    public int h() {
        return R$id.library_item_id;
    }

    @Override // f.d.b.q.a
    public int k() {
        return R$layout.listitem_opensource;
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // f.d.b.q.a
    public a l(View view) {
        e.c(view, "v");
        return new a(view);
    }
}
