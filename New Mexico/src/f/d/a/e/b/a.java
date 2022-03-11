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
/* loaded from: classes.dex */
public final class a extends f.d.b.q.a<C0132a> {
    public Integer b;
    public String c;

    /* renamed from: d */
    public Drawable f4039d;

    /* renamed from: e */
    public b f4040e;

    /* renamed from: f.d.a.e.b.a$a */
    /* loaded from: classes.dex */
    public static final class C0132a extends RecyclerView.b0 {
        public View A;
        public TextView B;
        public ImageView t;
        public TextView u;
        public View v;
        public Button w;
        public Button x;
        public Button y;
        public TextView z;

        /* renamed from: f.d.a.e.b.a$a$a */
        /* loaded from: classes.dex */
        public static final class C0133a extends f implements j.k.a.b<TypedArray, h> {

            /* renamed from: d */
            public final /* synthetic */ Context f4041d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0133a(Context context) {
                super(1);
                C0132a.this = r1;
                this.f4041d = context;
            }

            public Object d(Object obj) {
                TypedArray typedArray = (TypedArray) obj;
                e.c(typedArray, "it");
                C0132a.this.u.setTextColor(typedArray.getColorStateList(R$styleable.AboutLibraries_aboutLibrariesDescriptionTitle));
                TextView textView = C0132a.this.z;
                int i2 = R$styleable.AboutLibraries_aboutLibrariesDescriptionText;
                textView.setTextColor(typedArray.getColorStateList(i2));
                C0132a.this.B.setTextColor(typedArray.getColorStateList(i2));
                View view = C0132a.this.A;
                int i3 = R$styleable.AboutLibraries_aboutLibrariesDescriptionDivider;
                Context context = this.f4041d;
                e.b(context, "ctx");
                int i4 = R$attr.aboutLibrariesDescriptionDivider;
                Context context2 = this.f4041d;
                e.b(context2, "ctx");
                view.setBackgroundColor(typedArray.getColor(i3, f.b.a.c.b.o.b.N0(context, i4, f.b.a.c.b.o.b.K0(context2, R$color.about_libraries_dividerLight_openSource))));
                Button button = C0132a.this.w;
                int i5 = R$styleable.AboutLibraries_aboutLibrariesSpecialButtonText;
                button.setTextColor(typedArray.getColorStateList(i5));
                C0132a.this.x.setTextColor(typedArray.getColorStateList(i5));
                C0132a.this.y.setTextColor(typedArray.getColorStateList(i5));
                return h.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0132a(View view) {
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
            f.b.a.c.b.o.b.o1(context, null, 0, 0, new C0133a(context), 7);
        }
    }

    public a(b bVar) {
        e.c(bVar, "libsBuilder");
        this.f4040e = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b5  */
    @Override // f.d.b.q.b, f.d.b.k
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void g(RecyclerView.b0 b0Var, List list) {
        String str;
        b bVar;
        StringBuilder sb;
        TextView textView;
        Drawable drawable;
        C0132a aVar = (C0132a) b0Var;
        e.c(aVar, "holder");
        e.c(list, "payloads");
        super.g(aVar, list);
        View view = aVar.a;
        e.b(view, "holder.itemView");
        Context context = view.getContext();
        if (!this.f4040e.f4017f || (drawable = this.f4039d) == null) {
            aVar.t.setVisibility(8);
        } else {
            aVar.t.setImageDrawable(drawable);
            aVar.t.setOnClickListener(b.b);
            aVar.t.setOnLongClickListener(c.b);
        }
        String str2 = this.f4040e.f4018g;
        boolean z = true;
        if (!(str2 == null || str2.length() == 0)) {
            aVar.u.setText(this.f4040e.f4018g);
        } else {
            aVar.u.setVisibility(8);
        }
        aVar.v.setVisibility(8);
        aVar.w.setVisibility(8);
        aVar.x.setVisibility(8);
        aVar.y.setVisibility(8);
        if (!TextUtils.isEmpty(this.f4040e.f4023l) && !TextUtils.isEmpty(this.f4040e.m)) {
            aVar.w.setText(this.f4040e.f4023l);
            aVar.w.setVisibility(0);
            aVar.w.setOnClickListener(new b(0, this, context));
            aVar.v.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.f4040e.n) && !TextUtils.isEmpty(this.f4040e.o)) {
            aVar.x.setText(this.f4040e.n);
            aVar.x.setVisibility(0);
            aVar.x.setOnClickListener(new b(1, this, context));
            aVar.v.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.f4040e.p) && !TextUtils.isEmpty(this.f4040e.q)) {
            aVar.y.setText(this.f4040e.p);
            aVar.y.setVisibility(0);
            aVar.y.setOnClickListener(new b(2, this, context));
            aVar.v.setVisibility(0);
        }
        Objects.requireNonNull(this.f4040e);
        b bVar2 = this.f4040e;
        if (bVar2.f4019h) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.c);
            sb.append(" (");
            sb.append(this.b);
            sb.append(')');
        } else if (bVar2.f4021j) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.c);
        } else if (bVar2.f4022k) {
            textView = aVar.z;
            sb = new StringBuilder();
            sb.append(context.getString(R$string.version));
            sb.append(' ');
            sb.append(this.b);
        } else {
            aVar.z.setVisibility(8);
            str = this.f4040e.f4020i;
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (z) {
                aVar.B.setText(Html.fromHtml(this.f4040e.f4020i));
                TextView textView2 = aVar.B;
                b.C0135b bVar3 = f.d.a.f.b.b;
                textView2.setMovementMethod((f.d.a.f.b) f.d.a.f.b.a.getValue());
            } else {
                aVar.B.setVisibility(8);
            }
            bVar = this.f4040e;
            if ((bVar.f4017f && !bVar.f4019h) || TextUtils.isEmpty(bVar.f4020i)) {
                aVar.A.setVisibility(8);
                return;
            }
        }
        textView.setText(sb.toString());
        str = this.f4040e.f4020i;
        if (str == null) {
            z = false;
        }
        if (z) {
        }
        bVar = this.f4040e;
        if (bVar.f4017f) {
        }
    }

    public int h() {
        return R$id.header_item_id;
    }

    public int k() {
        return R$layout.listheader_opensource;
    }

    public RecyclerView.b0 l(View view) {
        e.c(view, "v");
        return new C0132a(view);
    }
}
