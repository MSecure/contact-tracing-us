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
import j.g;
import j.j.b.e;
import j.j.b.f;
import java.util.List;
import java.util.Objects;

public final class a extends f.d.b.q.a<C0126a> {
    public Integer b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f3470d;

    /* renamed from: e  reason: collision with root package name */
    public b f3471e;

    /* renamed from: f.d.a.e.b.a$a  reason: collision with other inner class name */
    public static final class C0126a extends RecyclerView.b0 {
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
        public static final class C0127a extends f implements j.j.a.b<TypedArray, g> {
            public final /* synthetic */ C0126a c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Context f3472d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0127a(C0126a aVar, Context context) {
                super(1);
                this.c = aVar;
                this.f3472d = context;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // j.j.a.b
            public g d(TypedArray typedArray) {
                TypedArray typedArray2 = typedArray;
                e.c(typedArray2, "it");
                this.c.u.setTextColor(typedArray2.getColorStateList(R$styleable.AboutLibraries_aboutLibrariesDescriptionTitle));
                TextView textView = this.c.z;
                int i2 = R$styleable.AboutLibraries_aboutLibrariesDescriptionText;
                textView.setTextColor(typedArray2.getColorStateList(i2));
                this.c.B.setTextColor(typedArray2.getColorStateList(i2));
                View view = this.c.A;
                int i3 = R$styleable.AboutLibraries_aboutLibrariesDescriptionDivider;
                Context context = this.f3472d;
                e.b(context, "ctx");
                int i4 = R$attr.aboutLibrariesDescriptionDivider;
                Context context2 = this.f3472d;
                e.b(context2, "ctx");
                view.setBackgroundColor(typedArray2.getColor(i3, f.b.a.c.b.o.b.Y0(context, i4, f.b.a.c.b.o.b.W0(context2, R$color.about_libraries_dividerLight_openSource))));
                Button button = this.c.w;
                int i5 = R$styleable.AboutLibraries_aboutLibrariesSpecialButtonText;
                button.setTextColor(typedArray2.getColorStateList(i5));
                this.c.x.setTextColor(typedArray2.getColorStateList(i5));
                this.c.y.setTextColor(typedArray2.getColorStateList(i5));
                return g.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0126a(View view) {
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
            f.b.a.c.b.o.b.F1(context, null, 0, 0, new C0127a(this, context), 7);
        }
    }

    public a(b bVar) {
        e.c(bVar, "libsBuilder");
        this.f3471e = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b5  */
    @Override // f.d.b.q.b, f.d.b.k
    public void g(RecyclerView.b0 b0Var, List list) {
        b bVar;
        StringBuilder sb;
        TextView textView;
        Drawable drawable;
        C0126a aVar = (C0126a) b0Var;
        e.c(aVar, "holder");
        e.c(list, "payloads");
        super.g(aVar, list);
        View view = aVar.a;
        e.b(view, "holder.itemView");
        Context context = view.getContext();
        if (!this.f3471e.f3448f || (drawable = this.f3470d) == null) {
            aVar.t.setVisibility(8);
        } else {
            aVar.t.setImageDrawable(drawable);
            aVar.t.setOnClickListener(b.b);
            aVar.t.setOnLongClickListener(c.b);
        }
        String str = this.f3471e.f3449g;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            aVar.u.setText(this.f3471e.f3449g);
        } else {
            aVar.u.setVisibility(8);
        }
        aVar.v.setVisibility(8);
        aVar.w.setVisibility(8);
        aVar.x.setVisibility(8);
        aVar.y.setVisibility(8);
        if (!TextUtils.isEmpty(this.f3471e.f3454l) && !TextUtils.isEmpty(this.f3471e.m)) {
            aVar.w.setText(this.f3471e.f3454l);
            aVar.w.setVisibility(0);
            aVar.w.setOnClickListener(new b(0, this, context));
            aVar.v.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.f3471e.n) && !TextUtils.isEmpty(this.f3471e.o)) {
            aVar.x.setText(this.f3471e.n);
            aVar.x.setVisibility(0);
            aVar.x.setOnClickListener(new b(1, this, context));
            aVar.v.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.f3471e.p) && !TextUtils.isEmpty(this.f3471e.q)) {
            aVar.y.setText(this.f3471e.p);
            aVar.y.setVisibility(0);
            aVar.y.setOnClickListener(new b(2, this, context));
            aVar.v.setVisibility(0);
        }
        Objects.requireNonNull(this.f3471e);
        b bVar2 = this.f3471e;
        if (bVar2.f3450h) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.c);
            sb.append(" (");
            sb.append(this.b);
            sb.append(')');
        } else if (bVar2.f3452j) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.c);
        } else if (bVar2.f3453k) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.b);
        } else {
            aVar.z.setVisibility(8);
            String str2 = this.f3471e.f3451i;
            if (!(str2 == null || str2.length() == 0)) {
                z = false;
            }
            if (z) {
                aVar.B.setText(Html.fromHtml(this.f3471e.f3451i));
                TextView textView2 = aVar.B;
                b.C0129b bVar3 = f.d.a.f.b.b;
                textView2.setMovementMethod((f.d.a.f.b) f.d.a.f.b.a.getValue());
            } else {
                aVar.B.setVisibility(8);
            }
            bVar = this.f3471e;
            if ((bVar.f3448f && !bVar.f3450h) || TextUtils.isEmpty(bVar.f3451i)) {
                aVar.A.setVisibility(8);
                return;
            }
        }
        textView.setText(sb.toString());
        String str22 = this.f3471e.f3451i;
        z = false;
        if (z) {
        }
        bVar = this.f3471e;
        if (bVar.f3448f) {
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
    public C0126a l(View view) {
        e.c(view, "v");
        return new C0126a(view);
    }
}
