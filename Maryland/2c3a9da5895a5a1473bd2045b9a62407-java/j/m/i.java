package j.m;

import j.j.a.c;
import j.j.b.e;
import j.j.b.f;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class i extends f implements c<CharSequence, Integer, j.c<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f4108d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(List list, boolean z) {
        super(2);
        this.c = list;
        this.f4108d = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // j.j.a.c
    public j.c<? extends Integer, ? extends Integer> c(CharSequence charSequence, Integer num) {
        j.c cVar;
        Object obj;
        Object obj2;
        CharSequence charSequence2 = charSequence;
        int intValue = num.intValue();
        e.c(charSequence2, "$receiver");
        List list = this.c;
        boolean z = this.f4108d;
        if (z || list.size() != 1) {
            if (intValue < 0) {
                intValue = 0;
            }
            j.k.c cVar2 = new j.k.c(intValue, charSequence2.length());
            if (charSequence2 instanceof String) {
                int i2 = cVar2.c;
                int i3 = cVar2.f4096d;
                if (i3 < 0 ? intValue >= i2 : intValue <= i2) {
                    while (true) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (h.j(str, 0, (String) charSequence2, intValue, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
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
                        return new j.c(cVar.b, Integer.valueOf(cVar.c.length()));
                    }
                    return null;
                }
            } else {
                int i4 = cVar2.c;
                int i5 = cVar2.f4096d;
                if (i5 < 0 ? intValue >= i4 : intValue <= i4) {
                    while (true) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (h.k(str3, 0, charSequence2, intValue, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
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
            }
        } else {
            e.c(list, "$this$single");
            e.c(list, "$this$single");
            int size = list.size();
            if (size == 0) {
                throw new NoSuchElementException("List is empty.");
            } else if (size == 1) {
                String str5 = (String) list.get(0);
                int d2 = h.d(charSequence2, str5, intValue, false);
                if (d2 >= 0) {
                    cVar = new j.c(Integer.valueOf(d2), str5);
                    if (cVar != null) {
                    }
                }
            } else {
                throw new IllegalArgumentException("List has more than one element.");
            }
        }
        cVar = null;
        if (cVar != null) {
        }
    }
}
