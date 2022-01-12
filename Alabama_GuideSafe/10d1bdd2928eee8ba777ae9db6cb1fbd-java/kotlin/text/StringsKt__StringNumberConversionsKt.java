package kotlin.text;

import com.facebook.react.modules.network.NetworkingModule;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;

public class StringsKt__StringNumberConversionsKt extends StringsKt__StringBuilderKt {
    public static boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        Intrinsics.checkNotNullParameter(charSequence, "$this$contains");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z2, 2) < 0) {
                return false;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z2, false, 16) < 0) {
            return false;
        }
        return true;
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            intProgression = new IntRange(i, i2);
        } else {
            int lastIndex = getLastIndex(charSequence);
            if (i > lastIndex) {
                i = lastIndex;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            intProgression = new IntProgression(i, i2, -1);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i3 = intProgression.first;
            int i4 = intProgression.last;
            int i5 = intProgression.step;
            if (i5 < 0 ? i3 >= i4 : i3 <= i4) {
                while (!regionMatchesImpl(charSequence2, 0, charSequence, i3, charSequence2.length(), z)) {
                    if (i3 != i4) {
                        i3 += i5;
                    }
                }
                return i3;
            }
        } else {
            int i6 = intProgression.first;
            int i7 = intProgression.last;
            int i8 = intProgression.step;
            if (i8 < 0 ? i6 >= i7 : i6 <= i7) {
                while (!MoreExecutors.regionMatches((String) charSequence2, 0, (String) charSequence, i6, charSequence2.length(), z)) {
                    if (i6 != i7) {
                        i6 += i8;
                    }
                }
                return i6;
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    public static int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        if (!z) {
            return ((String) charSequence).indexOf(c, i);
        }
        char[] cArr = {c};
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOfAny");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (!z) {
            return ((String) charSequence).indexOf(MoreExecutors.single(cArr), i);
        }
        if (i < 0) {
            i = 0;
        }
        int lastIndex = getLastIndex(charSequence);
        if (i <= lastIndex) {
            while (true) {
                char charAt = charSequence.charAt(i);
                int i3 = 0;
                while (true) {
                    if (i3 >= 1) {
                        z2 = false;
                        break;
                    } else if (MoreExecutors.equals(cArr[i3], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$regionMatchesImpl");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!MoreExecutors.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2) {
        int i3 = 0;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "$this$split");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        int i4 = 10;
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                if (i >= 0) {
                    int indexOf = indexOf(charSequence, str, 0, z);
                    if (indexOf == -1 || i == 1) {
                        return MoreExecutors.listOf(charSequence.toString());
                    }
                    if (i <= 0) {
                        z2 = false;
                    }
                    if (z2 && i <= 10) {
                        i4 = i;
                    }
                    ArrayList arrayList = new ArrayList(i4);
                    do {
                        arrayList.add(charSequence.subSequence(i3, indexOf).toString());
                        i3 = str.length() + indexOf;
                        if (z2 && arrayList.size() == i - 1) {
                            break;
                        }
                        indexOf = indexOf(charSequence, str, i3, z);
                    } while (indexOf != -1);
                    arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                    return arrayList;
                }
                throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
            }
        }
        if (i >= 0) {
            DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(charSequence, 0, i, new StringsKt__StringsKt$rangesDelimitedBy$4(MoreExecutors.asList(strArr), z));
            Intrinsics.checkNotNullParameter(delimitedRangesSequence, "$this$asIterable");
            SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence);
            ArrayList arrayList2 = new ArrayList(MoreExecutors.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
            Iterator it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
            while (it.hasNext()) {
                IntRange intRange = (IntRange) it.next();
                Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
                Intrinsics.checkNotNullParameter(intRange, "range");
                arrayList2.add(charSequence.subSequence(Integer.valueOf(intRange.first).intValue(), Integer.valueOf(intRange.last).intValue() + 1).toString());
            }
            return arrayList2;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public static String substringAfterLast$default(String str, char c, String str2, int i) {
        String str3 = (i & 2) != 0 ? str : null;
        Intrinsics.checkNotNullParameter(str, "$this$substringAfterLast");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int lastIndex = getLastIndex(str);
        Intrinsics.checkNotNullParameter(str, "$this$lastIndexOf");
        int lastIndexOf = str.lastIndexOf(c, lastIndex);
        if (lastIndexOf == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }
}
