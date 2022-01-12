package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final ByteString[] byteStrings;
    public final int[] trie;

    public Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Buffer buffer2;
        if (i2 < i3) {
            for (int i9 = i2; i9 < i3; i9++) {
                if (list.get(i9).size() < i) {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i == byteString.size()) {
                int intValue = list2.get(i2).intValue();
                int i10 = i2 + 1;
                i4 = i10;
                i5 = intValue;
                byteString = list.get(i10);
            } else {
                i5 = -1;
                i4 = i2;
            }
            long j2 = 4;
            if (byteString.getByte(i) != byteString2.getByte(i)) {
                int i11 = 1;
                for (int i12 = i4 + 1; i12 < i3; i12++) {
                    if (list.get(i12 - 1).getByte(i) != list.get(i12).getByte(i)) {
                        i11++;
                    }
                }
                long j3 = j + ((long) ((int) (buffer.size / 4))) + 2 + ((long) (i11 * 2));
                buffer.writeInt(i11);
                buffer.writeInt(i5);
                for (int i13 = i4; i13 < i3; i13++) {
                    byte b = list.get(i13).getByte(i);
                    if (i13 == i4 || b != list.get(i13 - 1).getByte(i)) {
                        buffer.writeInt(b & 255);
                    }
                }
                Buffer buffer3 = new Buffer();
                int i14 = i4;
                while (i14 < i3) {
                    byte b2 = list.get(i14).getByte(i);
                    int i15 = i14 + 1;
                    int i16 = i15;
                    while (true) {
                        if (i16 >= i3) {
                            i7 = i3;
                            break;
                        } else if (b2 != list.get(i16).getByte(i)) {
                            i7 = i16;
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (i15 == i7 && i + 1 == list.get(i14).size()) {
                        buffer.writeInt(list2.get(i14).intValue());
                        i8 = i7;
                        buffer2 = buffer3;
                    } else {
                        buffer.writeInt((int) ((((long) ((int) (buffer3.size / j2))) + j3) * -1));
                        i8 = i7;
                        buffer2 = buffer3;
                        buildTrieRecursive(j3, buffer3, i + 1, list, i14, i7, list2);
                    }
                    buffer3 = buffer2;
                    i14 = i8;
                    j2 = 4;
                }
                buffer.write(buffer3, buffer3.size);
                return;
            }
            int i17 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            int i18 = i;
            while (i18 < min && byteString.getByte(i18) == byteString2.getByte(i18)) {
                i17++;
                i18++;
            }
            long j4 = 1 + j + ((long) ((int) (buffer.size / 4))) + 2 + ((long) i17);
            buffer.writeInt(-i17);
            buffer.writeInt(i5);
            int i19 = i;
            while (true) {
                i6 = i + i17;
                if (i19 >= i6) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i19) & 255);
                i19++;
            }
            if (i4 + 1 != i3) {
                Buffer buffer4 = new Buffer();
                buffer.writeInt((int) ((((long) ((int) (buffer4.size / 4))) + j4) * -1));
                buildTrieRecursive(j4, buffer4, i6, list, i4, i3, list2);
                buffer.write(buffer4, buffer4.size);
            } else if (i6 == list.get(i4).size()) {
                buffer.writeInt(list2.get(i4).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i3);
                int i4 = i3 + 1;
                int i5 = i4;
                while (i5 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i5);
                    if (byteString2 == null) {
                        throw null;
                    } else if (!byteString2.rangeEquals(0, byteString, 0, byteString.size())) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                        arrayList.remove(i5);
                        arrayList2.remove(i5);
                    } else {
                        i5++;
                    }
                }
                i3 = i4;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int i6 = (int) (buffer.size / 4);
            int[] iArr = new int[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i7] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    public final int size() {
        return this.byteStrings.length;
    }
}
