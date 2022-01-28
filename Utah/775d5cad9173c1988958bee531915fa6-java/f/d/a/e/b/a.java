package f.d.a.e.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.aboutlibraries.R$attr;
import com.mikepenz.aboutlibraries.R$color;
import com.mikepenz.aboutlibraries.R$id;
import com.mikepenz.aboutlibraries.R$layout;
import com.mikepenz.aboutlibraries.R$string;
import com.mikepenz.aboutlibraries.R$styleable;
import f.d.a.b;
import f.d.a.f.b;
import j.h;
import j.k.b.e;
import j.k.b.f;
import java.util.List;
import java.util.Objects;

public final class a extends f.d.b.q.a<C0130a> {
    public Integer b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f3784d;

    /* renamed from: e  reason: collision with root package name */
    public b f3785e;

    /* renamed from: f.d.a.e.b.a$a  reason: collision with other inner class name */
    public static final class C0130a extends RecyclerView.b0 {
        public View A;
        public TextView B;
        public ImageView t;
        public TextView u;
        public View v;
        public Button w;
        public Button x;
        public Button y;
        public TextView z;

        /* renamed from: f.d.a.e.b.a$a$a  reason: collision with other inner class name */
        public static final class C0131a extends f implements j.k.a.b<TypedArray, h> {
            public final /* synthetic */ C0130a c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f3786d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0131a(C0130a aVar, Context context) {
                super(1);
                this.c = aVar;
                this.f3786d = context;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // j.k.a.b
            public h d(TypedArray typedArray) {
                TypedArray typedArray2 = typedArray;
                e.c(typedArray2, "it");
                this.c.u.setTextColor(typedArray2.getColorStateList(R$styleable.AboutLibraries_aboutLibrariesDescriptionTitle));
                TextView textView = this.c.z;
                int i2 = R$styleable.AboutLibraries_aboutLibrariesDescriptionText;
                textView.setTextColor(typedArray2.getColorStateList(i2));
                this.c.B.setTextColor(typedArray2.getColorStateList(i2));
                View view = this.c.A;
                int i3 = R$styleable.AboutLibraries_aboutLibrariesDescriptionDivider;
                Context context = this.f3786d;
                e.b(context, "ctx");
                int i4 = R$attr.aboutLibrariesDescriptionDivider;
                Context context2 = this.f3786d;
                e.b(context2, "ctx");
                view.setBackgroundColor(typedArray2.getColor(i3, f.b.a.c.b.o.b.M0(context, i4, f.b.a.c.b.o.b.J0(context2, R$color.about_libraries_dividerLight_openSource))));
                Button button = this.c.w;
                int i5 = R$styleable.AboutLibraries_aboutLibrariesSpecialButtonText;
                button.setTextColor(typedArray2.getColorStateList(i5));
                this.c.x.setTextColor(typedArray2.getColorStateList(i5));
                this.c.y.setTextColor(typedArray2.getColorStateList(i5));
                return h.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0130a(View view) {
            super(view);
            e.c(view, "headerView");
            View findViewById = view.findViewById(R$id.aboutIcon);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.t = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R$id.aboutName);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.u = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R$id.aboutSpecialContainer);
            e.b(findViewById3, "headerView.findViewById(…id.aboutSpecialContainer)");
            this.v = findViewById3;
            View findViewById4 = view.findViewById(R$id.aboutSpecial1);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.Button");
            this.w = (Button) findViewById4;
            View findViewById5 = view.findViewById(R$id.aboutSpecial2);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.Button");
            this.x = (Button) findViewById5;
            View findViewById6 = view.findViewById(R$id.aboutSpecial3);
            Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.Button");
            this.y = (Button) findViewById6;
            View findViewById7 = view.findViewById(R$id.aboutVersion);
            Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
            this.z = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R$id.aboutDivider);
            e.b(findViewById8, "headerView.findViewById(R.id.aboutDivider)");
            this.A = findViewById8;
            View findViewById9 = view.findViewById(R$id.aboutDescription);
            Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
            this.B = (TextView) findViewById9;
            View view2 = this.a;
            e.b(view2, "itemView");
            Context context = view2.getContext();
            e.b(context, "ctx");
            f.b.a.c.b.o.b.n1(context, null, 0, 0, new C0131a(this, context), 7);
        }
    }

    public a(b bVar) {
        e.c(bVar, "libsBuilder");
        this.f3785e = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b5  */
    @Override // f.d.b.q.b, f.d.b.k
    public void g(RecyclerView.b0 b0Var, List list) {
        b bVar;
        StringBuilder sb;
        TextView textView;
        Drawable drawable;
        C0130a aVar = (C0130a) b0Var;
        e.c(aVar, "holder");
        e.c(list, "payloads");
        super.g(aVar, list);
        View view = aVar.a;
        e.b(view, "holder.itemView");
        Context context = view.getContext();
        if (!this.f3785e.f3762f || (drawable = this.f3784d) == null) {
            aVar.t.setVisibility(8);
        } else {
            aVar.t.setImageDrawable(drawable);
            aVar.t.setOnClickListener(b.b);
            aVar.t.setOnLongClickListener(c.b);
        }
        String str = this.f3785e.f3763g;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            aVar.u.setText(this.f3785e.f3763g);
        } else {
            aVar.u.setVisibility(8);
        }
        aVar.v.setVisibility(8);
        aVar.w.setVisibility(8);
        aVar.x.setVisibility(8);
        aVar.y.setVisibility(8);
        if (!TextUtils.isEmpty(this.f3785e.f3768l) && !TextUtils.isEmpty(this.f3785e.m)) {
            aVar.w.setText(this.f3785e.f3768l);
            aVar.w.setVisibility(0);
            aVar.w.setOnClickListener(new b(0, this, context));
            aVar.v.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.f3785e.n) && !TextUtils.isEmpty(this.f3785e.o)) {
            aVar.x.setText(this.f3785e.n);
            aVar.x.setVisibility(0);
            aVar.x.setOnClickListener(new b(1, this, context));
            aVar.v.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.f3785e.p) && !TextUtils.isEmpty(this.f3785e.q)) {
            aVar.y.setText(this.f3785e.p);
            aVar.y.setVisibility(0);
            aVar.y.setOnClickListener(new b(2, this, context));
            aVar.v.setVisibility(0);
        }
        Objects.requireNonNull(this.f3785e);
        b bVar2 = this.f3785e;
        if (bVar2.f3764h) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.c);
            sb.append(" (");
            sb.append(this.b);
            sb.append(')');
        } else if (bVar2.f3766j) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.c);
        } else if (bVar2.f3767k) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.b);
        } else {
            aVar.z.setVisibility(8);
            String str2 = this.f3785e.f3765i;
            if (!(str2 == null || str2.length() == 0)) {
                z = false;
            }
            if (z) {
                aVar.B.setText(Html.fromHtml(this.f3785e.f3765i));
                TextView textView2 = aVar.B;
                b.C0133b bVar3 = f.d.a.f.b.b;
                textView2.setMovementMethod((f.d.a.f.b) f.d.a.f.b.a.getValue());
            } else {
                aVar.B.setVisibility(8);
            }
            bVar = this.f3785e;
            if ((bVar.f3762f && !bVar.f3764h) || TextUtils.isEmpty(bVar.f3765i)) {
                aVar.A.setVisibility(8);
                return;
            }
        }
        textView.setText(sb.toString());
        String str22 = this.f3785e.f3765i;
        z = false;
        if (z) {
        }
        bVar = this.f3785e;
        if (bVar.f3762f) {
        }
    }

    @Override // f.d.b.k
    public int h() {
        return R$id.header_item_id;
    }

    @Override // f.d.b.q.a
    public int k() {
        return R$layout.listheader_opensource;
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // f.d.b.q.a
    public C0130a l(View view) {
        e.c(view, "v");
        return new C0130a(view);
    }
}
