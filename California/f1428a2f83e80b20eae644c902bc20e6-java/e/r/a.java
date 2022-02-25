package e.r;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.navigation.R$styleable;
import e.r.q;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@q.b("activity")
public class a extends q<C0046a> {
    public Context a;
    public Activity b;

    /* renamed from: e.r.a$a  reason: collision with other inner class name */
    public static class C0046a extends j {

        /* renamed from: j  reason: collision with root package name */
        public Intent f1725j;

        /* renamed from: k  reason: collision with root package name */
        public String f1726k;

        public C0046a(q<? extends C0046a> qVar) {
            super(qVar);
        }

        @Override // e.r.j
        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R$styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            if (this.f1725j == null) {
                this.f1725j = new Intent();
            }
            this.f1725j.setPackage(string);
            String string2 = obtainAttributes.getString(R$styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                ComponentName componentName = new ComponentName(context, string2);
                if (this.f1725j == null) {
                    this.f1725j = new Intent();
                }
                this.f1725j.setComponent(componentName);
            }
            String string3 = obtainAttributes.getString(R$styleable.ActivityNavigator_action);
            if (this.f1725j == null) {
                this.f1725j = new Intent();
            }
            this.f1725j.setAction(string3);
            String string4 = obtainAttributes.getString(R$styleable.ActivityNavigator_data);
            if (string4 != null) {
                Uri parse = Uri.parse(string4);
                if (this.f1725j == null) {
                    this.f1725j = new Intent();
                }
                this.f1725j.setData(parse);
            }
            this.f1726k = obtainAttributes.getString(R$styleable.ActivityNavigator_dataPattern);
            obtainAttributes.recycle();
        }

        @Override // e.r.j
        public boolean l() {
            return false;
        }

        @Override // e.r.j
        public String toString() {
            Intent intent = this.f1725j;
            String str = null;
            ComponentName component = intent == null ? null : intent.getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                Intent intent2 = this.f1725j;
                if (intent2 != null) {
                    str = intent2.getAction();
                }
                if (str != null) {
                    sb.append(" action=");
                    sb.append(str);
                }
            }
            return sb.toString();
        }
    }

    public static final class b implements q.a {
    }

    public a(Context context) {
        this.a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    /* Return type fixed from 'e.r.j' to match base method */
    @Override // e.r.q
    public C0046a a() {
        return new C0046a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.r.j, android.os.Bundle, e.r.o, e.r.q$a] */
    @Override // e.r.q
    public j b(C0046a aVar, Bundle bundle, o oVar, q.a aVar2) {
        Activity activity;
        Intent intent;
        int intExtra;
        C0046a aVar3 = aVar;
        if (aVar3.f1725j != null) {
            Intent intent2 = new Intent(aVar3.f1725j);
            if (bundle != null) {
                intent2.putExtras(bundle);
                String str = aVar3.f1726k;
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + str);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = aVar2 instanceof b;
            int i2 = 0;
            if (z) {
                Objects.requireNonNull((b) aVar2);
                intent2.addFlags(0);
            }
            if (!(this.a instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (oVar != null && oVar.a) {
                intent2.addFlags(536870912);
            }
            Activity activity2 = this.b;
            if (!(activity2 == null || (intent = activity2.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar3.f1745d);
            if (oVar != null) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", oVar.f1760f);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", oVar.f1761g);
            }
            if (z) {
                Objects.requireNonNull((b) aVar2);
            }
            this.a.startActivity(intent2);
            if (oVar == null || (activity = this.b) == null) {
                return null;
            }
            int i3 = oVar.f1758d;
            int i4 = oVar.f1759e;
            if (i3 == -1 && i4 == -1) {
                return null;
            }
            if (i3 == -1) {
                i3 = 0;
            }
            if (i4 != -1) {
                i2 = i4;
            }
            activity.overridePendingTransition(i3, i2);
            return null;
        }
        StringBuilder h2 = f.a.a.a.a.h("Destination ");
        h2.append(aVar3.f1745d);
        h2.append(" does not have an Intent set.");
        throw new IllegalStateException(h2.toString());
    }

    @Override // e.r.q
    public boolean e() {
        Activity activity = this.b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
