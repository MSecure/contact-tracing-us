package e.j.j;

import android.text.TextUtils;
import android.view.View;
import e.j.j.v;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public class s extends v.b<CharSequence> {
    public s(int i2, Class cls, int i3, int i4) {
        super(i2, cls, i3, i4);
    }

    @Override // e.j.j.v.b
    public CharSequence b(View view) {
        return v.l.b(view);
    }

    @Override // e.j.j.v.b
    public void c(View view, Object obj) {
        v.l.h(view, (CharSequence) obj);
    }

    public boolean f(Object obj, Object obj2) {
        return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
    }
}
