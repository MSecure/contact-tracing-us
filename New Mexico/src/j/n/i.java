package j.n;

import j.k.a.c;
import j.k.b.e;
import j.k.b.f;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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
public final class i extends f implements c<CharSequence, Integer, j.c<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f4583d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(List list, boolean z) {
        super(2);
        this.c = list;
        this.f4583d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // j.k.a.c
    /* Code decompiled incorrectly, please refer to instructions dump */
    public j.c<? extends Integer, ? extends Integer> c(Object obj, Object obj2) {
        j.c cVar;
        Object obj3;
        Object obj4;
        CharSequence charSequence = (CharSequence) obj;
        int intValue = ((Number) obj2).intValue();
        e.c(charSequence, "$receiver");
        List list = this.c;
        boolean z = this.f4583d;
        if (z || list.size() != 1) {
            if (intValue < 0) {
                intValue = 0;
            }
            j.l.c cVar2 = new j.l.c(intValue, charSequence.length());
            if (charSequence instanceof String) {
                int i2 = cVar2.c;
                int i3 = cVar2.f4571d;
                if (i3 < 0 ? intValue >= i2 : intValue <= i2) {
                    while (true) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it.next();
                            String str = (String) obj4;
                            if (h.j(str, 0, (String) charSequence, intValue, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj4;
                        if (str2 == null) {
                            if (intValue == i2) {
                                break;
                            }
                            intValue += i3;
                        } else {
                            cVar = new j.c(Integer.valueOf(intValue), str2);
                            break;
                        }
                    }
                    if (cVar != null) {
                        return new j.c<>(cVar.b, Integer.valueOf(((String) cVar.c).length()));
                    }
                    return null;
                }
                cVar = null;
                if (cVar != null) {
                }
            } else {
                int i4 = cVar2.c;
                int i5 = cVar2.f4571d;
                if (i5 < 0 ? intValue >= i4 : intValue <= i4) {
                    while (true) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it2.next();
                            String str3 = (String) obj3;
                            if (h.k(str3, 0, charSequence, intValue, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj3;
                        if (str4 == null) {
                            if (intValue == i4) {
                                break;
                            }
                            intValue += i5;
                        } else {
                            cVar = new j.c(Integer.valueOf(intValue), str4);
                            break;
                        }
                    }
                }
                cVar = null;
                if (cVar != null) {
                }
            }
        } else {
            e.c(list, "$this$single");
            e.c(list, "$this$single");
            int size = list.size();
            if (size == 0) {
                throw new NoSuchElementException("List is empty.");
            } else if (size == 1) {
                String str5 = (String) list.get(0);
                int d2 = h.d(charSequence, str5, intValue, false);
                if (d2 >= 0) {
                    cVar = new j.c(Integer.valueOf(d2), str5);
                    if (cVar != null) {
                    }
                }
                cVar = null;
                if (cVar != null) {
                }
            } else {
                throw new IllegalArgumentException("List has more than one element.");
            }
        }
    }
}
