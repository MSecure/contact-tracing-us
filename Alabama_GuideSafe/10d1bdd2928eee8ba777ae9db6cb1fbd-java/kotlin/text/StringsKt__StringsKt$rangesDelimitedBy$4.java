package kotlin.text;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* compiled from: Strings.kt */
public final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function2
    public Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        Pair pair;
        Object obj;
        Object obj2;
        CharSequence charSequence2 = charSequence;
        int intValue = num.intValue();
        Intrinsics.checkNotNullParameter(charSequence2, "$receiver");
        List list = this.$delimitersList;
        boolean z = this.$ignoreCase;
        if (z || list.size() != 1) {
            if (intValue < 0) {
                intValue = 0;
            }
            IntRange intRange = new IntRange(intValue, charSequence2.length());
            if (charSequence2 instanceof String) {
                int i = intRange.first;
                int i2 = intRange.last;
                int i3 = intRange.step;
                if (i3 < 0 ? i >= i2 : i <= i2) {
                    while (true) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (MoreExecutors.regionMatches(str, 0, (String) charSequence2, i, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (i == i2) {
                                break;
                            }
                            i += i3;
                        } else {
                            pair = new Pair(Integer.valueOf(i), str2);
                            break;
                        }
                    }
                    if (pair == null) {
                        return new Pair(pair.first, Integer.valueOf(pair.second.length()));
                    }
                    return null;
                }
            } else {
                int i4 = intRange.first;
                int i5 = intRange.last;
                int i6 = intRange.step;
                if (i6 < 0 ? i4 >= i5 : i4 <= i5) {
                    while (true) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (StringsKt__StringNumberConversionsKt.regionMatchesImpl(str3, 0, charSequence2, i4, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (i4 == i5) {
                                break;
                            }
                            i4 += i6;
                        } else {
                            pair = new Pair(Integer.valueOf(i4), str4);
                            break;
                        }
                    }
                    if (pair == null) {
                    }
                }
            }
        } else {
            Intrinsics.checkNotNullParameter(list, "$this$single");
            Intrinsics.checkNotNullParameter(list, "$this$single");
            int size = list.size();
            if (size == 0) {
                throw new NoSuchElementException("List is empty.");
            } else if (size == 1) {
                String str5 = (String) list.get(0);
                int indexOf$default = StringsKt__StringNumberConversionsKt.indexOf$default(charSequence2, str5, intValue, false, 4);
                if (indexOf$default >= 0) {
                    pair = new Pair(Integer.valueOf(indexOf$default), str5);
                    if (pair == null) {
                    }
                }
            } else {
                throw new IllegalArgumentException("List has more than one element.");
            }
        }
        pair = null;
        if (pair == null) {
        }
    }
}
