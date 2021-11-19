package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
public final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static long offset(int i) {
        return (long) (i & OFFSET_MASK);
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema2 != null && extensionSchema2.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0391  */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        int i;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        String str;
        Class<?> cls;
        int i12;
        int[] iArr2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Field field;
        int i19;
        char charAt;
        int i20;
        Object obj;
        Field field2;
        Object obj2;
        Field field3;
        int i21;
        int i22;
        char charAt2;
        int i23;
        char charAt3;
        int i24;
        char charAt4;
        int i25;
        char charAt5;
        int i26;
        char charAt6;
        int i27;
        char charAt7;
        int i28;
        char charAt8;
        int i29;
        char charAt9;
        int i30;
        char charAt10;
        int i31;
        char charAt11;
        int i32;
        char charAt12;
        int i33;
        char charAt13;
        char charAt14;
        int i34 = 0;
        boolean z2 = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int charAt15 = stringInfo.charAt(0);
        if (charAt15 >= 55296) {
            int i35 = charAt15 & 8191;
            int i36 = 1;
            int i37 = 13;
            while (true) {
                i = i36 + 1;
                charAt14 = stringInfo.charAt(i36);
                if (charAt14 < 55296) {
                    break;
                }
                i35 |= (charAt14 & 8191) << i37;
                i37 += 13;
                i36 = i;
            }
            charAt15 = i35 | (charAt14 << i37);
        } else {
            i = 1;
        }
        int i38 = i + 1;
        int charAt16 = stringInfo.charAt(i);
        if (charAt16 >= 55296) {
            int i39 = charAt16 & 8191;
            int i40 = 13;
            while (true) {
                i33 = i38 + 1;
                charAt13 = stringInfo.charAt(i38);
                if (charAt13 < 55296) {
                    break;
                }
                i39 |= (charAt13 & 8191) << i40;
                i40 += 13;
                i38 = i33;
            }
            charAt16 = i39 | (charAt13 << i40);
            i38 = i33;
        }
        if (charAt16 == 0) {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            iArr = EMPTY_INT_ARRAY;
            i7 = 0;
        } else {
            int i41 = i38 + 1;
            int charAt17 = stringInfo.charAt(i38);
            if (charAt17 >= 55296) {
                int i42 = charAt17 & 8191;
                int i43 = 13;
                while (true) {
                    i32 = i41 + 1;
                    charAt12 = stringInfo.charAt(i41);
                    if (charAt12 < 55296) {
                        break;
                    }
                    i42 |= (charAt12 & 8191) << i43;
                    i43 += 13;
                    i41 = i32;
                }
                charAt17 = i42 | (charAt12 << i43);
                i41 = i32;
            }
            int i44 = i41 + 1;
            int charAt18 = stringInfo.charAt(i41);
            if (charAt18 >= 55296) {
                int i45 = charAt18 & 8191;
                int i46 = 13;
                while (true) {
                    i31 = i44 + 1;
                    charAt11 = stringInfo.charAt(i44);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i45 |= (charAt11 & 8191) << i46;
                    i46 += 13;
                    i44 = i31;
                }
                charAt18 = i45 | (charAt11 << i46);
                i44 = i31;
            }
            int i47 = i44 + 1;
            int charAt19 = stringInfo.charAt(i44);
            if (charAt19 >= 55296) {
                int i48 = charAt19 & 8191;
                int i49 = 13;
                while (true) {
                    i30 = i47 + 1;
                    charAt10 = stringInfo.charAt(i47);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i48 |= (charAt10 & 8191) << i49;
                    i49 += 13;
                    i47 = i30;
                }
                charAt19 = i48 | (charAt10 << i49);
                i47 = i30;
            }
            int i50 = i47 + 1;
            i5 = stringInfo.charAt(i47);
            if (i5 >= 55296) {
                int i51 = i5 & 8191;
                int i52 = 13;
                while (true) {
                    i29 = i50 + 1;
                    charAt9 = stringInfo.charAt(i50);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i51 |= (charAt9 & 8191) << i52;
                    i52 += 13;
                    i50 = i29;
                }
                i5 = i51 | (charAt9 << i52);
                i50 = i29;
            }
            int i53 = i50 + 1;
            i4 = stringInfo.charAt(i50);
            if (i4 >= 55296) {
                int i54 = i4 & 8191;
                int i55 = 13;
                while (true) {
                    i28 = i53 + 1;
                    charAt8 = stringInfo.charAt(i53);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i54 |= (charAt8 & 8191) << i55;
                    i55 += 13;
                    i53 = i28;
                }
                i4 = i54 | (charAt8 << i55);
                i53 = i28;
            }
            int i56 = i53 + 1;
            int charAt20 = stringInfo.charAt(i53);
            if (charAt20 >= 55296) {
                int i57 = charAt20 & 8191;
                int i58 = 13;
                while (true) {
                    i27 = i56 + 1;
                    charAt7 = stringInfo.charAt(i56);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i57 |= (charAt7 & 8191) << i58;
                    i58 += 13;
                    i56 = i27;
                }
                charAt20 = i57 | (charAt7 << i58);
                i56 = i27;
            }
            int i59 = i56 + 1;
            int charAt21 = stringInfo.charAt(i56);
            if (charAt21 >= 55296) {
                int i60 = charAt21 & 8191;
                int i61 = 13;
                while (true) {
                    i26 = i59 + 1;
                    charAt6 = stringInfo.charAt(i59);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i60 |= (charAt6 & 8191) << i61;
                    i61 += 13;
                    i59 = i26;
                }
                charAt21 = i60 | (charAt6 << i61);
                i59 = i26;
            }
            int i62 = i59 + 1;
            i2 = stringInfo.charAt(i59);
            if (i2 >= 55296) {
                int i63 = i2 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i25 = i64 + 1;
                    charAt5 = stringInfo.charAt(i64);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i63 |= (charAt5 & 8191) << i65;
                    i65 += 13;
                    i64 = i25;
                }
                i2 = i63 | (charAt5 << i65);
                i62 = i25;
            }
            i3 = (charAt17 * 2) + charAt18;
            i7 = charAt17;
            i38 = i62;
            iArr = new int[(i2 + charAt20 + charAt21)];
            i34 = charAt19;
            i6 = charAt20;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects2 = rawMessageInfo.getObjects();
        Class<?> cls2 = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[(i4 * 3)];
        Object[] objArr = new Object[(i4 * 2)];
        int i66 = i2 + i6;
        int i67 = i2;
        int i68 = i66;
        int i69 = 0;
        int i70 = 0;
        while (i38 < length) {
            int i71 = i38 + 1;
            int charAt22 = stringInfo.charAt(i38);
            if (charAt22 >= 55296) {
                int i72 = charAt22 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i24 = i73 + 1;
                    charAt4 = stringInfo.charAt(i73);
                    i8 = i2;
                    if (charAt4 < 55296) {
                        break;
                    }
                    i72 |= (charAt4 & 8191) << i74;
                    i74 += 13;
                    i73 = i24;
                    i2 = i8;
                }
                charAt22 = i72 | (charAt4 << i74);
                i9 = i24;
            } else {
                i8 = i2;
                i9 = i71;
            }
            int i75 = i9 + 1;
            int charAt23 = stringInfo.charAt(i9);
            if (charAt23 >= 55296) {
                int i76 = charAt23 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i23 = i77 + 1;
                    charAt3 = stringInfo.charAt(i77);
                    z = z2;
                    if (charAt3 < 55296) {
                        break;
                    }
                    i76 |= (charAt3 & 8191) << i78;
                    i78 += 13;
                    i77 = i23;
                    z2 = z;
                }
                charAt23 = i76 | (charAt3 << i78);
                i10 = i23;
            } else {
                z = z2;
                i10 = i75;
            }
            int i79 = charAt23 & 255;
            if ((charAt23 & 1024) != 0) {
                iArr[i69] = i70;
                i69++;
            }
            if (i79 >= 51) {
                int i80 = i10 + 1;
                int charAt24 = stringInfo.charAt(i10);
                char c = 55296;
                if (charAt24 >= 55296) {
                    int i81 = charAt24 & 8191;
                    int i82 = 13;
                    while (true) {
                        i22 = i80 + 1;
                        charAt2 = stringInfo.charAt(i80);
                        if (charAt2 < c) {
                            break;
                        }
                        i81 |= (charAt2 & 8191) << i82;
                        i82 += 13;
                        i80 = i22;
                        c = 55296;
                    }
                    charAt24 = i81 | (charAt2 << i82);
                    i80 = i22;
                }
                int i83 = i79 - 51;
                if (i83 == 9 || i83 == 17) {
                    i21 = i3 + 1;
                    objArr[((i70 / 3) * 2) + 1] = objects2[i3];
                } else {
                    if (i83 == 12 && (charAt15 & 1) == 1) {
                        i21 = i3 + 1;
                        objArr[((i70 / 3) * 2) + 1] = objects2[i3];
                    }
                    int i84 = charAt24 * 2;
                    obj = objects2[i84];
                    if (!(obj instanceof Field)) {
                        field2 = (Field) obj;
                    } else {
                        field2 = reflectField(cls2, (String) obj);
                        objects2[i84] = field2;
                    }
                    iArr2 = iArr3;
                    i11 = charAt22;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i85 = i84 + 1;
                    obj2 = objects2[i85];
                    if (!(obj2 instanceof Field)) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = reflectField(cls2, (String) obj2);
                        objects2[i85] = field3;
                    }
                    str = stringInfo;
                    cls = cls2;
                    i16 = charAt15;
                    i15 = (int) unsafe.objectFieldOffset(field3);
                    i14 = objectFieldOffset;
                    i13 = i79;
                    i38 = i80;
                    i12 = 0;
                }
                i3 = i21;
                int i842 = charAt24 * 2;
                obj = objects2[i842];
                if (!(obj instanceof Field)) {
                }
                iArr2 = iArr3;
                i11 = charAt22;
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(field2);
                int i852 = i842 + 1;
                obj2 = objects2[i852];
                if (!(obj2 instanceof Field)) {
                }
                str = stringInfo;
                cls = cls2;
                i16 = charAt15;
                i15 = (int) unsafe.objectFieldOffset(field3);
                i14 = objectFieldOffset2;
                i13 = i79;
                i38 = i80;
                i12 = 0;
            } else {
                iArr2 = iArr3;
                i11 = charAt22;
                int i86 = i3 + 1;
                Field reflectField = reflectField(cls2, (String) objects2[i3]);
                if (i79 == 9 || i79 == 17) {
                    objArr[((i70 / 3) * 2) + 1] = reflectField.getType();
                } else {
                    if (i79 == 27 || i79 == 49) {
                        i20 = i86 + 1;
                        objArr[((i70 / 3) * 2) + 1] = objects2[i86];
                    } else if (i79 == 12 || i79 == 30 || i79 == 44) {
                        if ((charAt15 & 1) == 1) {
                            i20 = i86 + 1;
                            objArr[((i70 / 3) * 2) + 1] = objects2[i86];
                        }
                    } else if (i79 == 50) {
                        int i87 = i67 + 1;
                        iArr[i67] = i70;
                        int i88 = (i70 / 3) * 2;
                        int i89 = i86 + 1;
                        objArr[i88] = objects2[i86];
                        if ((charAt23 & 2048) != 0) {
                            i86 = i89 + 1;
                            objArr[i88 + 1] = objects2[i89];
                            i67 = i87;
                        } else {
                            i67 = i87;
                            i86 = i89;
                        }
                    }
                    i17 = i79;
                    i86 = i20;
                    int objectFieldOffset3 = (int) unsafe.objectFieldOffset(reflectField);
                    if ((charAt15 & 1) != 1) {
                        i13 = i17;
                        if (i13 <= 17) {
                            i18 = i10 + 1;
                            int charAt25 = stringInfo.charAt(i10);
                            if (charAt25 >= 55296) {
                                int i90 = charAt25 & 8191;
                                int i91 = 13;
                                while (true) {
                                    i19 = i18 + 1;
                                    charAt = stringInfo.charAt(i18);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i90 |= (charAt & 8191) << i91;
                                    i91 += 13;
                                    i18 = i19;
                                }
                                charAt25 = i90 | (charAt << i91);
                                i18 = i19;
                            }
                            int i92 = (i7 * 2) + (charAt25 / 32);
                            Object obj3 = objects2[i92];
                            str = stringInfo;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = reflectField(cls2, (String) obj3);
                                objects2[i92] = field;
                            }
                            cls = cls2;
                            i16 = charAt15;
                            i15 = (int) unsafe.objectFieldOffset(field);
                            i12 = charAt25 % 32;
                            if (i13 >= 18 && i13 <= 49) {
                                iArr[i68] = objectFieldOffset3;
                                i68++;
                            }
                            i3 = i86;
                            i14 = objectFieldOffset3;
                            i38 = i18;
                        } else {
                            str = stringInfo;
                            cls = cls2;
                            i16 = charAt15;
                        }
                    } else {
                        str = stringInfo;
                        cls = cls2;
                        i16 = charAt15;
                        i13 = i17;
                    }
                    i18 = i10;
                    i15 = 0;
                    i12 = 0;
                    iArr[i68] = objectFieldOffset3;
                    i68++;
                    i3 = i86;
                    i14 = objectFieldOffset3;
                    i38 = i18;
                }
                i17 = i79;
                int objectFieldOffset32 = (int) unsafe.objectFieldOffset(reflectField);
                if ((charAt15 & 1) != 1) {
                }
                i18 = i10;
                i15 = 0;
                i12 = 0;
                iArr[i68] = objectFieldOffset32;
                i68++;
                i3 = i86;
                i14 = objectFieldOffset32;
                i38 = i18;
            }
            int i93 = i70 + 1;
            iArr2[i70] = i11;
            int i94 = i93 + 1;
            iArr2[i93] = ((charAt23 & 512) != 0 ? ENFORCE_UTF8_MASK : 0) | ((charAt23 & 256) != 0 ? REQUIRED_MASK : 0) | (i13 << 20) | i14;
            int i95 = i94 + 1;
            iArr2[i94] = (i12 << 20) | i15;
            iArr3 = iArr2;
            cls2 = cls;
            charAt15 = i16;
            i5 = i5;
            length = length;
            i2 = i8;
            z2 = z;
            i69 = i69;
            i70 = i95;
            stringInfo = str;
        }
        return new MessageSchema<>(iArr3, objArr, i34, i5, rawMessageInfo.getDefaultInstance(), z2, false, iArr, i2, i66, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        int i;
        int i2;
        int i3;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i2 = 0;
            i = 0;
        } else {
            i2 = fields[0].getFieldNumber();
            i = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i4++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = null;
        int[] iArr3 = i4 > 0 ? new int[i4] : null;
        if (i5 > 0) {
            iArr2 = new int[i5];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fields.length) {
            FieldInfo fieldInfo2 = fields[i6];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i7, z, objArr);
            if (i8 < checkInitialized.length && checkInitialized[i8] == fieldNumber) {
                checkInitialized[i8] = i7;
                i8++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr3[i9] = i7;
                i9++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i3 = i7;
                iArr2[i10] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i10++;
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr3.length + iArr2.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length, iArr3.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length + iArr3.length, iArr2.length);
        return new MessageSchema<>(iArr, objArr, i2, i, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr3.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5  */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, boolean z, Object[] objArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        int objectFieldOffset;
        int objectFieldOffset2;
        OneofInfo oneof = fieldInfo.getOneof();
        int i6 = 0;
        if (oneof != null) {
            i2 = fieldInfo.getType().id() + 51;
            objectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            objectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fieldInfo.getType();
            objectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            int id = type.id();
            if (!z && !type.isList() && !type.isMap()) {
                i5 = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
                i2 = id;
                i3 = objectFieldOffset;
                i4 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getPresenceField());
                iArr[i] = fieldInfo.getFieldNumber();
                int i7 = i + 1;
                if (fieldInfo.isEnforceUtf8()) {
                }
                if (fieldInfo.isRequired()) {
                }
                iArr[i7] = (i2 << 20) | i6 | r5 | i3;
                iArr[i + 2] = (i5 << 20) | i4;
                Class<?> messageFieldClass = fieldInfo.getMessageFieldClass();
                if (fieldInfo.getMapDefaultEntry() != null) {
                }
            } else if (fieldInfo.getCachedSizeField() == null) {
                i5 = 0;
                i2 = id;
                i3 = objectFieldOffset;
                i4 = 0;
                iArr[i] = fieldInfo.getFieldNumber();
                int i72 = i + 1;
                int i8 = fieldInfo.isEnforceUtf8() ? ENFORCE_UTF8_MASK : 0;
                if (fieldInfo.isRequired()) {
                    i6 = REQUIRED_MASK;
                }
                iArr[i72] = (i2 << 20) | i6 | i8 | i3;
                iArr[i + 2] = (i5 << 20) | i4;
                Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
                if (fieldInfo.getMapDefaultEntry() != null) {
                    int i9 = (i / 3) * 2;
                    objArr[i9] = fieldInfo.getMapDefaultEntry();
                    if (messageFieldClass2 != null) {
                        objArr[i9 + 1] = messageFieldClass2;
                        return;
                    } else if (fieldInfo.getEnumVerifier() != null) {
                        objArr[i9 + 1] = fieldInfo.getEnumVerifier();
                        return;
                    } else {
                        return;
                    }
                } else if (messageFieldClass2 != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass2;
                    return;
                } else if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                } else {
                    return;
                }
            } else {
                objectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
                i2 = id;
            }
        }
        i3 = objectFieldOffset;
        i4 = objectFieldOffset2;
        i5 = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        int i722 = i + 1;
        if (fieldInfo.isEnforceUtf8()) {
        }
        if (fieldInfo.isRequired()) {
        }
        iArr[i722] = (i2 << 20) | i6 | i8 | i3;
        iArr[i + 2] = (i5 << 20) | i4;
        Class<?> messageFieldClass22 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, offset));
            case 1:
                return arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat(t, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, offset));
            case 2:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 3:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 4:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 5:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 6:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 7:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean(t, offset) == UnsafeUtil.getBoolean(t2, offset);
            case 8:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 9:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 10:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 11:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 12:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 13:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 14:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 15:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset);
            case 16:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset);
            case 17:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            default:
                return true;
        }
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int i2;
        int length = this.buffer.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i4);
            int numberAt = numberAt(i4);
            long offset = offset(typeAndOffsetAt);
            int i5 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i2 = i3 * 53;
                    i = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(UnsafeUtil.getFloat(t, offset));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = Internal.hashBoolean(UnsafeUtil.getBoolean(t, offset));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, offset);
                    if (object != null) {
                        i5 = object.hashCode();
                    }
                    i3 = (i3 * 53) + i5;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getObject(t, offset).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getInt(t, offset);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, offset);
                    if (object2 != null) {
                        i5 = object2.hashCode();
                    }
                    i3 = (i3 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getObject(t, offset).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = UnsafeUtil.getObject(t, offset).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, offset)));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(oneofFloatAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashBoolean(oneofBooleanAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = UnsafeUtil.getObject(t, offset).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = UnsafeUtil.getObject(t, offset).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = oneofIntAt(t, offset);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = Internal.hashLong(oneofLongAt(t, offset));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, numberAt, i4)) {
                        i2 = i3 * 53;
                        i = UnsafeUtil.getObject(t, offset).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : hashCode;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, offset, UnsafeUtil.getDouble(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, offset, UnsafeUtil.getFloat(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, offset, UnsafeUtil.getBoolean(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 9:
                mergeMessage(t, t2, i);
                return;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 17:
                mergeMessage(t, t2, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t, t2, i);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t, t2, i);
                return;
            default:
                return;
        }
    }

    private void mergeMessage(T t, T t2, int i) {
        long offset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        int numberAt = numberAt(i);
        long offset = offset(typeAndOffsetAt);
        if (isOneofPresent(t2, numberAt, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, numberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setOneofPresent(t, numberAt, i);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int i3;
        int computeBoolSize;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        Unsafe unsafe = UNSAFE;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < this.buffer.length) {
            int typeAndOffsetAt = typeAndOffsetAt(i10);
            int numberAt = numberAt(i10);
            int type = type(typeAndOffsetAt);
            if (type <= 17) {
                i2 = this.buffer[i10 + 2];
                int i13 = OFFSET_MASK & i2;
                int i14 = 1 << (i2 >>> 20);
                if (i13 != i9) {
                    i12 = unsafe.getInt(t, (long) i13);
                    i9 = i13;
                }
                i = i14;
            } else {
                i2 = (!this.useCachedSizeField || type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i10 + 2] & OFFSET_MASK;
                i = 0;
            }
            long offset = offset(typeAndOffsetAt);
            switch (type) {
                case 0:
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i3 = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i11 += i3;
                        break;
                    }
                case 1:
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i3 = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i11 += i3;
                        break;
                    }
                case 2:
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i3 = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(t, offset));
                        i11 += i3;
                        break;
                    }
                case 3:
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i3 = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(t, offset));
                        i11 += i3;
                        break;
                    }
                case 4:
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i3 = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(t, offset));
                        i11 += i3;
                        break;
                    }
                case 5:
                    if ((i12 & i) == 0) {
                        break;
                    } else {
                        i3 = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        i11 += i3;
                        break;
                    }
                case 6:
                    if ((i12 & i) != 0) {
                        i3 = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i11 += i3;
                        break;
                    }
                    break;
                case 7:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i11 += computeBoolSize;
                    }
                    break;
                case 8:
                    if ((i12 & i) != 0) {
                        Object object = unsafe.getObject(t, offset);
                        computeBoolSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object) : CodedOutputStream.computeStringSize(numberAt, (String) object);
                        i11 += computeBoolSize;
                    }
                    break;
                case 9:
                    if ((i12 & i) != 0) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i10));
                        i11 += computeBoolSize;
                    }
                    break;
                case 10:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 11:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 12:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 13:
                    if ((i12 & i) != 0) {
                        i4 = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i11 += i4;
                    }
                    break;
                case 14:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        i11 += computeBoolSize;
                    }
                    break;
                case 15:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 16:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 17:
                    if ((i12 & i) != 0) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t, offset), getMessageFieldSchema(i10));
                        i11 += computeBoolSize;
                    }
                    break;
                case 18:
                    computeBoolSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += computeBoolSize;
                    break;
                case 19:
                    z = false;
                    i5 = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 20:
                    z = false;
                    i5 = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 21:
                    z = false;
                    i5 = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 22:
                    z = false;
                    i5 = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 23:
                    z = false;
                    i5 = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 24:
                    z = false;
                    i5 = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 25:
                    z = false;
                    i5 = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 26:
                    computeBoolSize = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(t, offset));
                    i11 += computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(t, offset), getMessageFieldSchema(i10));
                    i11 += computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(t, offset));
                    i11 += computeBoolSize;
                    break;
                case 29:
                    computeBoolSize = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += computeBoolSize;
                    break;
                case 30:
                    z = false;
                    i5 = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 31:
                    z = false;
                    i5 = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 32:
                    z = false;
                    i5 = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 33:
                    z = false;
                    i5 = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 34:
                    z = false;
                    i5 = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i11 += i5;
                    break;
                case 35:
                    i8 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 36:
                    i8 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 37:
                    i8 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 38:
                    i8 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 39:
                    i8 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 40:
                    i8 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 41:
                    i8 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 42:
                    i8 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 43:
                    i8 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 44:
                    i8 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 45:
                    i8 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 46:
                    i8 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 47:
                    i8 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 48:
                    i8 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i8 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i2, i8);
                        }
                        i7 = CodedOutputStream.computeTagSize(numberAt);
                        i6 = CodedOutputStream.computeUInt32SizeNoTag(i8);
                        i4 = i7 + i6 + i8;
                        i11 += i4;
                    }
                    break;
                case 49:
                    computeBoolSize = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(t, offset), getMessageFieldSchema(i10));
                    i11 += computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(t, offset), getMapFieldDefaultEntry(i10));
                    i11 += computeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i11 += computeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i11 += computeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        i11 += computeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, numberAt, i10)) {
                        i4 = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i11 += i4;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i11 += computeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, numberAt, i10)) {
                        Object object2 = unsafe.getObject(t, offset);
                        computeBoolSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        i11 += computeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i10));
                        i11 += computeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, numberAt, i10)) {
                        i4 = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i11 += i4;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        i11 += computeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t, offset));
                        i11 += computeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, numberAt, i10)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t, offset), getMessageFieldSchema(i10));
                        i11 += computeBoolSize;
                    }
                    break;
            }
            i10 += 3;
            i9 = i9;
        }
        int unknownFieldsSerializedSize = i11 + getUnknownFieldsSerializedSize((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int computeDoubleSize;
        int i;
        int i2;
        int i3;
        Unsafe unsafe = UNSAFE;
        int i4 = 0;
        for (int i5 = 0; i5 < this.buffer.length; i5 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i5);
            long offset = offset(typeAndOffsetAt);
            int i6 = (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i5 + 2] & OFFSET_MASK;
            switch (type) {
                case 0:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (isFieldPresent(t, i5)) {
                        Object object = UnsafeUtil.getObject(t, offset);
                        if (object instanceof ByteString) {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if (isFieldPresent(t, i5)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    break;
                case 19:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    break;
                case 20:
                    computeDoubleSize = SchemaUtil.computeSizeInt64List(numberAt, listAt(t, offset), false);
                    break;
                case 21:
                    computeDoubleSize = SchemaUtil.computeSizeUInt64List(numberAt, listAt(t, offset), false);
                    break;
                case 22:
                    computeDoubleSize = SchemaUtil.computeSizeInt32List(numberAt, listAt(t, offset), false);
                    break;
                case 23:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    break;
                case 24:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    break;
                case 25:
                    computeDoubleSize = SchemaUtil.computeSizeBoolList(numberAt, listAt(t, offset), false);
                    break;
                case 26:
                    computeDoubleSize = SchemaUtil.computeSizeStringList(numberAt, listAt(t, offset));
                    break;
                case 27:
                    computeDoubleSize = SchemaUtil.computeSizeMessageList(numberAt, listAt(t, offset), getMessageFieldSchema(i5));
                    break;
                case 28:
                    computeDoubleSize = SchemaUtil.computeSizeByteStringList(numberAt, listAt(t, offset));
                    break;
                case 29:
                    computeDoubleSize = SchemaUtil.computeSizeUInt32List(numberAt, listAt(t, offset), false);
                    break;
                case 30:
                    computeDoubleSize = SchemaUtil.computeSizeEnumList(numberAt, listAt(t, offset), false);
                    break;
                case 31:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    break;
                case 32:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    break;
                case 33:
                    computeDoubleSize = SchemaUtil.computeSizeSInt32List(numberAt, listAt(t, offset), false);
                    break;
                case 34:
                    computeDoubleSize = SchemaUtil.computeSizeSInt64List(numberAt, listAt(t, offset), false);
                    break;
                case 35:
                    i2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 36:
                    i2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 37:
                    i2 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 38:
                    i2 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 39:
                    i2 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 40:
                    i2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 41:
                    i2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 42:
                    i2 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 43:
                    i2 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 44:
                    i2 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    i2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 46:
                    i2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 47:
                    i2 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 48:
                    i2 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (i2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, (long) i6, i2);
                        }
                        i3 = CodedOutputStream.computeTagSize(numberAt);
                        i = CodedOutputStream.computeUInt32SizeNoTag(i2);
                        computeDoubleSize = i3 + i + i2;
                        break;
                    } else {
                        continue;
                    }
                case 49:
                    computeDoubleSize = SchemaUtil.computeSizeGroupList(numberAt, listAt(t, offset), getMessageFieldSchema(i5));
                    break;
                case 50:
                    computeDoubleSize = this.mapFieldSchema.getSerializedSize(numberAt, UnsafeUtil.getObject(t, offset), getMapFieldDefaultEntry(i5));
                    break;
                case 51:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 56:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (isOneofPresent(t, numberAt, i5)) {
                        Object object2 = UnsafeUtil.getObject(t, offset);
                        if (object2 instanceof ByteString) {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object2);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 62:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 63:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 64:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 67:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t, offset));
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i5));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i4 += computeDoubleSize;
        }
        return i4 + getUnknownFieldsSerializedSize((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t));
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        int i2;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.iterator();
                entry = it.next();
                int i3 = -1;
                length = this.buffer.length;
                Unsafe unsafe = UNSAFE;
                i = 0;
                int i4 = 0;
                while (i < length) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    int type = type(typeAndOffsetAt);
                    if (this.proto3 || type > 17) {
                        entry2 = entry;
                        i2 = 0;
                    } else {
                        int i5 = this.buffer[i + 2];
                        int i6 = i5 & OFFSET_MASK;
                        if (i6 != i3) {
                            i4 = unsafe.getInt(t, (long) i6);
                            i3 = i6;
                        }
                        i2 = 1 << (i5 >>> 20);
                        entry2 = entry;
                    }
                    while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry2);
                        entry2 = it.hasNext() ? it.next() : null;
                    }
                    long offset = offset(typeAndOffsetAt);
                    switch (type) {
                        case 0:
                            if ((i2 & i4) != 0) {
                                writer.writeDouble(numberAt, doubleAt(t, offset));
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 1:
                            if ((i2 & i4) != 0) {
                                writer.writeFloat(numberAt, floatAt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 2:
                            if ((i2 & i4) != 0) {
                                writer.writeInt64(numberAt, unsafe.getLong(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 3:
                            if ((i2 & i4) != 0) {
                                writer.writeUInt64(numberAt, unsafe.getLong(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 4:
                            if ((i2 & i4) != 0) {
                                writer.writeInt32(numberAt, unsafe.getInt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 5:
                            if ((i2 & i4) != 0) {
                                writer.writeFixed64(numberAt, unsafe.getLong(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 6:
                            if ((i2 & i4) != 0) {
                                writer.writeFixed32(numberAt, unsafe.getInt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 7:
                            if ((i2 & i4) != 0) {
                                writer.writeBool(numberAt, booleanAt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 8:
                            if ((i2 & i4) != 0) {
                                writeString(numberAt, unsafe.getObject(t, offset), writer);
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 9:
                            if ((i2 & i4) != 0) {
                                writer.writeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 10:
                            if ((i2 & i4) != 0) {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 11:
                            if ((i2 & i4) != 0) {
                                writer.writeUInt32(numberAt, unsafe.getInt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 12:
                            if ((i2 & i4) != 0) {
                                writer.writeEnum(numberAt, unsafe.getInt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 13:
                            if ((i2 & i4) != 0) {
                                writer.writeSFixed32(numberAt, unsafe.getInt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 14:
                            if ((i2 & i4) != 0) {
                                writer.writeSFixed64(numberAt, unsafe.getLong(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 15:
                            if ((i2 & i4) != 0) {
                                writer.writeSInt32(numberAt, unsafe.getInt(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 16:
                            if ((i2 & i4) != 0) {
                                writer.writeSInt64(numberAt, unsafe.getLong(t, offset));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 17:
                            if ((i2 & i4) != 0) {
                                writer.writeGroup(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                            } else {
                                continue;
                            }
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i), (List) unsafe.getObject(t, offset), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i), (List) unsafe.getObject(t, offset), writer, getMessageFieldSchema(i));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i), (List) unsafe.getObject(t, offset), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                            i += 3;
                            i3 = i3;
                            entry = entry2;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(i), (List) unsafe.getObject(t, offset), writer, getMessageFieldSchema(i));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, unsafe.getObject(t, offset), i);
                            break;
                        case 51:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset));
                                break;
                            }
                            break;
                        case 52:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset));
                                break;
                            }
                            break;
                        case 53:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 54:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 55:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 56:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 57:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 58:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset));
                                break;
                            }
                            break;
                        case 59:
                            if (isOneofPresent(t, numberAt, i)) {
                                writeString(numberAt, unsafe.getObject(t, offset), writer);
                                break;
                            }
                            break;
                        case 60:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                                break;
                            }
                            break;
                        case 61:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(t, offset));
                                break;
                            }
                            break;
                        case 62:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 63:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 64:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 65:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 66:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 67:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 68:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeGroup(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                                break;
                            }
                            break;
                    }
                    i += 3;
                    i3 = i3;
                    entry = entry2;
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                writeUnknownInMessageTo((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t, writer);
            }
        }
        it = null;
        entry = null;
        int i32 = -1;
        length = this.buffer.length;
        Unsafe unsafe2 = UNSAFE;
        i = 0;
        int i42 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        writeUnknownInMessageTo((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t, writer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.iterator();
                entry = it.next();
                length = this.buffer.length;
                for (i = 0; i < length; i += 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (isFieldPresent(t, i)) {
                                writer.writeDouble(numberAt, doubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (isFieldPresent(t, i)) {
                                writer.writeFloat(numberAt, floatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (isFieldPresent(t, i)) {
                                writer.writeInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (isFieldPresent(t, i)) {
                                writer.writeUInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (isFieldPresent(t, i)) {
                                writer.writeInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (isFieldPresent(t, i)) {
                                writer.writeFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (isFieldPresent(t, i)) {
                                writer.writeFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (isFieldPresent(t, i)) {
                                writer.writeBool(numberAt, booleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (isFieldPresent(t, i)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (isFieldPresent(t, i)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (isFieldPresent(t, i)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (isFieldPresent(t, i)) {
                                writer.writeUInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (isFieldPresent(t, i)) {
                                writer.writeEnum(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (isFieldPresent(t, i)) {
                                writer.writeSFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (isFieldPresent(t, i)) {
                                writer.writeSFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (isFieldPresent(t, i)) {
                                writer.writeSInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (isFieldPresent(t, i)) {
                                writer.writeSInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (isFieldPresent(t, i)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(i));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(i));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), i);
                            break;
                        case 51:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (isOneofPresent(t, numberAt, i)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                writeUnknownInMessageTo((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t, writer);
            }
        }
        it = null;
        entry = null;
        length = this.buffer.length;
        while (i < length) {
        }
        while (entry != null) {
        }
        writeUnknownInMessageTo((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t, writer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    private void writeFieldsInDescendingOrder(T t, Writer writer) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        writeUnknownInMessageTo((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.descendingIterator();
                entry = it.next();
                for (length = this.buffer.length - 3; length >= 0; length -= 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(length);
                    int numberAt = numberAt(length);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) > numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (isFieldPresent(t, length)) {
                                writer.writeDouble(numberAt, doubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (isFieldPresent(t, length)) {
                                writer.writeFloat(numberAt, floatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (isFieldPresent(t, length)) {
                                writer.writeInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (isFieldPresent(t, length)) {
                                writer.writeUInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (isFieldPresent(t, length)) {
                                writer.writeInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (isFieldPresent(t, length)) {
                                writer.writeFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (isFieldPresent(t, length)) {
                                writer.writeFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (isFieldPresent(t, length)) {
                                writer.writeBool(numberAt, booleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (isFieldPresent(t, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (isFieldPresent(t, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (isFieldPresent(t, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (isFieldPresent(t, length)) {
                                writer.writeUInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (isFieldPresent(t, length)) {
                                writer.writeEnum(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (isFieldPresent(t, length)) {
                                writer.writeSFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (isFieldPresent(t, length)) {
                                writer.writeSFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (isFieldPresent(t, length)) {
                                writer.writeSInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (isFieldPresent(t, length)) {
                                writer.writeSInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (isFieldPresent(t, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), length);
                            break;
                        case 51:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (isOneofPresent(t, numberAt, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Objects.requireNonNull(extensionRegistryLite);
        mergeFromHelper((UnknownFieldSchema<UT, UB>) this.unknownFieldSchema, (ExtensionSchema<ET>) this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.protobuf.ExtensionSchema<ET> r18, T r19, com.google.protobuf.Reader r20, com.google.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1718
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x001d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x001d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int i3;
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i4 = registers.int1;
        if (i4 < 0 || i4 > i2 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i5 = decodeVarint32 + i4;
        K k = metadata.defaultKey;
        V v = metadata.defaultValue;
        while (decodeVarint32 < i5) {
            int i6 = decodeVarint32 + 1;
            byte b = bArr[decodeVarint32];
            if (b < 0) {
                i3 = ArrayDecoders.decodeVarint32(b, bArr, i6, registers);
                b = registers.int1;
            } else {
                i3 = i6;
            }
            int i7 = b >>> 3;
            int i8 = b & 7;
            if (i7 != 1) {
                if (i7 == 2 && i8 == metadata.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i3, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    v = registers.object1;
                }
            } else if (i8 == metadata.keyType.getWireType()) {
                decodeVarint32 = decodeMapEntryValue(bArr, i3, i2, metadata.keyType, null, registers);
                k = registers.object1;
            }
            decodeVarint32 = ArrayDecoders.skipField(b, bArr, i3, i2, registers);
        }
        if (decodeVarint32 == i5) {
            map.put(k, v);
            return i5;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int i8;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufList);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    i8 = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                } else if (i5 == 0) {
                    i8 = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                T t2 = t;
                UnknownFieldSetLite unknownFieldSetLite = t2.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, protobufList, getEnumFieldVerifier(i6), unknownFieldSetLite, this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    t2.unknownFields = unknownFieldSetLite2;
                }
                return i8;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList, registers);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                break;
        }
        return i;
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t, j, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j2 = (long) (this.buffer[i8 + 2] & OFFSET_MASK);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                    int i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                    int i10 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Long.valueOf(registers.long1));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint64;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint32;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint642;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    int i13 = registers.int1;
                    if (i13 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & ENFORCE_UTF8_MASK) == 0 || Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i13)) {
                        unsafe.putObject(t, j, new String(bArr, decodeVarint322, i13, Internal.UTF_8));
                        decodeVarint322 += i13;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint322;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int decodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i, i2, registers);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeMessageField;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int decodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                    unsafe.putObject(t, j, registers.object1);
                    unsafe.putInt(t, j2, i4);
                    return decodeBytes;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    int i14 = registers.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                        unsafe.putObject(t, j, Integer.valueOf(i14));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        getMutableUnknownFields(t).storeField(i3, Long.valueOf((long) i14));
                    }
                    return decodeVarint323;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint324;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint643;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int decodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i, i2, (i3 & -8) | 4, registers);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object2, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeGroupField;
                }
                break;
        }
        return i;
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) ((Class) this.objects[i2 + 1]));
        this.objects[i2] = schemaFor;
        return schemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0359, code lost:
        if (r0 != r4) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03a2, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03c5, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03c8, code lost:
        r2 = r0;
        r8 = r18;
        r0 = r35;
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03cf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03e4  */
    public int parseProto2Message(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i4;
        MessageSchema<T> messageSchema;
        T t2;
        byte b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        char c;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        MessageSchema<T> messageSchema2 = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i22 = i2;
        int i23 = i3;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = UNSAFE;
        int i24 = i;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        int i29 = -1;
        while (true) {
            if (i24 < i22) {
                int i30 = i24 + 1;
                byte b2 = bArr2[i24];
                if (b2 < 0) {
                    i5 = ArrayDecoders.decodeVarint32(b2, bArr2, i30, registers2);
                    b = registers2.int1;
                } else {
                    b = b2;
                    i5 = i30;
                }
                int i31 = b >>> 3;
                int i32 = b & 7;
                if (i31 > i28) {
                    i6 = messageSchema2.positionForFieldNumber(i31, i25 / 3);
                } else {
                    i6 = messageSchema2.positionForFieldNumber(i31);
                }
                if (i6 == -1) {
                    i10 = i31;
                    i12 = i5;
                    i11 = b;
                    i7 = i27;
                    i9 = i29;
                    unsafe = unsafe2;
                    i13 = i23;
                    i8 = 0;
                    if (i11 == i13 || i13 == 0) {
                        if (this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                            i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                        } else {
                            i24 = ArrayDecoders.decodeExtensionOrUnknownField(i11, bArr, i12, i2, t, this.defaultInstance, this.unknownFieldSchema, registers);
                        }
                        t3 = t;
                        bArr2 = bArr;
                        i22 = i2;
                        i26 = i11;
                        messageSchema2 = this;
                        registers2 = registers;
                        i28 = i10;
                        i29 = i9;
                        i25 = i8;
                        i27 = i7;
                        i23 = i13;
                    } else {
                        messageSchema = this;
                        i4 = i13;
                        i24 = i12;
                        i26 = i11;
                        i29 = i9;
                        i27 = i7;
                    }
                } else {
                    int i33 = messageSchema2.buffer[i6 + 1];
                    int type = type(i33);
                    long offset = offset(i33);
                    if (type <= 17) {
                        int i34 = messageSchema2.buffer[i6 + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & OFFSET_MASK;
                        if (i36 != i29) {
                            c = 65535;
                            i16 = i6;
                            if (i29 != -1) {
                                unsafe2.putInt(t3, (long) i29, i27);
                            }
                            i27 = unsafe2.getInt(t3, (long) i36);
                            i29 = i36;
                        } else {
                            i16 = i6;
                            c = 65535;
                        }
                        switch (type) {
                            case 0:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i18 = i5;
                                i17 = b;
                                if (i32 == 1) {
                                    UnsafeUtil.putDouble(t3, offset, ArrayDecoders.decodeDouble(bArr2, i18));
                                    i24 = i18 + 8;
                                    i27 |= i35;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                }
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                    break;
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 1:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i18 = i5;
                                i17 = b;
                                if (i32 == 5) {
                                    UnsafeUtil.putFloat(t3, offset, ArrayDecoders.decodeFloat(bArr2, i18));
                                    i24 = i18 + 4;
                                    i27 |= i35;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                }
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 2:
                            case 3:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i18 = i5;
                                i17 = b;
                                if (i32 == 0) {
                                    i20 = ArrayDecoders.decodeVarint64(bArr2, i18, registers2);
                                    unsafe2.putLong(t, offset, registers2.long1);
                                    i27 |= i35;
                                    i25 = i19;
                                    i24 = i20;
                                    i26 = i17;
                                    i28 = i10;
                                    i22 = i2;
                                    i23 = i3;
                                }
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 4:
                            case 11:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i18 = i5;
                                i17 = b;
                                if (i32 == 0) {
                                    i24 = ArrayDecoders.decodeVarint32(bArr2, i18, registers2);
                                    unsafe2.putInt(t3, offset, registers2.int1);
                                    i27 |= i35;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                }
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 5:
                            case 14:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i17 = b;
                                if (i32 == 1) {
                                    i18 = i5;
                                    unsafe2.putLong(t, offset, ArrayDecoders.decodeFixed64(bArr2, i5));
                                    i24 = i18 + 8;
                                    i27 |= i35;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 6:
                            case 13:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i21 = i2;
                                i17 = b;
                                if (i32 == 5) {
                                    unsafe2.putInt(t3, offset, ArrayDecoders.decodeFixed32(bArr2, i5));
                                    i24 = i5 + 4;
                                    i27 |= i35;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    i22 = i21;
                                    i23 = i3;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 7:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i21 = i2;
                                i17 = b;
                                if (i32 == 0) {
                                    i24 = ArrayDecoders.decodeVarint64(bArr2, i5, registers2);
                                    UnsafeUtil.putBoolean(t3, offset, registers2.long1 != 0);
                                    i27 |= i35;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    i22 = i21;
                                    i23 = i3;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 8:
                                i19 = i16;
                                i10 = i31;
                                bArr2 = bArr;
                                i21 = i2;
                                i17 = b;
                                if (i32 == 2) {
                                    if ((i33 & ENFORCE_UTF8_MASK) == 0) {
                                        i24 = ArrayDecoders.decodeString(bArr2, i5, registers2);
                                    } else {
                                        i24 = ArrayDecoders.decodeStringRequireUtf8(bArr2, i5, registers2);
                                    }
                                    unsafe2.putObject(t3, offset, registers2.object1);
                                    i27 |= i35;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    i22 = i21;
                                    i23 = i3;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 9:
                                i19 = i16;
                                i17 = b;
                                i10 = i31;
                                bArr2 = bArr;
                                if (i32 != 2) {
                                    i18 = i5;
                                    i13 = i3;
                                    i7 = i27;
                                    i9 = i29;
                                    i8 = i19;
                                    unsafe = unsafe2;
                                    i12 = i18;
                                    i11 = i17;
                                    if (i11 == i13) {
                                    }
                                    if (this.hasExtensions) {
                                    }
                                    i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                    t3 = t;
                                    bArr2 = bArr;
                                    i22 = i2;
                                    i26 = i11;
                                    messageSchema2 = this;
                                    registers2 = registers;
                                    i28 = i10;
                                    i29 = i9;
                                    i25 = i8;
                                    i27 = i7;
                                    i23 = i13;
                                    break;
                                } else {
                                    i21 = i2;
                                    i24 = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i19), bArr2, i5, i21, registers2);
                                    if ((i27 & i35) == 0) {
                                        unsafe2.putObject(t3, offset, registers2.object1);
                                    } else {
                                        unsafe2.putObject(t3, offset, Internal.mergeMessage(unsafe2.getObject(t3, offset), registers2.object1));
                                    }
                                    i27 |= i35;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    i22 = i21;
                                    i23 = i3;
                                }
                                break;
                            case 10:
                                i19 = i16;
                                i17 = b;
                                i10 = i31;
                                bArr2 = bArr;
                                if (i32 == 2) {
                                    i24 = ArrayDecoders.decodeBytes(bArr2, i5, registers2);
                                    unsafe2.putObject(t3, offset, registers2.object1);
                                    i27 |= i35;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 12:
                                i19 = i16;
                                i17 = b;
                                i10 = i31;
                                bArr2 = bArr;
                                if (i32 == 0) {
                                    i24 = ArrayDecoders.decodeVarint32(bArr2, i5, registers2);
                                    int i37 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i19);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i37)) {
                                        unsafe2.putInt(t3, offset, i37);
                                        i27 |= i35;
                                        i23 = i3;
                                        i25 = i19;
                                        i26 = i17;
                                        i28 = i10;
                                        break;
                                    } else {
                                        getMutableUnknownFields(t).storeField(i17, Long.valueOf((long) i37));
                                        i23 = i3;
                                        i25 = i19;
                                        i26 = i17;
                                        i28 = i10;
                                    }
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 15:
                                i19 = i16;
                                i17 = b;
                                i10 = i31;
                                bArr2 = bArr;
                                if (i32 == 0) {
                                    i24 = ArrayDecoders.decodeVarint32(bArr2, i5, registers2);
                                    unsafe2.putInt(t3, offset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i27 |= i35;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 16:
                                i19 = i16;
                                i17 = b;
                                i10 = i31;
                                if (i32 == 0) {
                                    bArr2 = bArr;
                                    i20 = ArrayDecoders.decodeVarint64(bArr2, i5, registers2);
                                    unsafe2.putLong(t, offset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i27 |= i35;
                                    i25 = i19;
                                    i24 = i20;
                                    i26 = i17;
                                    i28 = i10;
                                    i22 = i2;
                                    i23 = i3;
                                }
                                i18 = i5;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                            case 17:
                                if (i32 == 3) {
                                    Schema messageFieldSchema = messageSchema2.getMessageFieldSchema(i16);
                                    i19 = i16;
                                    i10 = i31;
                                    i17 = b;
                                    i24 = ArrayDecoders.decodeGroupField(messageFieldSchema, bArr, i5, i2, (i31 << 3) | 4, registers);
                                    if ((i27 & i35) == 0) {
                                        unsafe2.putObject(t3, offset, registers2.object1);
                                    } else {
                                        unsafe2.putObject(t3, offset, Internal.mergeMessage(unsafe2.getObject(t3, offset), registers2.object1));
                                    }
                                    i27 |= i35;
                                    bArr2 = bArr;
                                    i23 = i3;
                                    i25 = i19;
                                    i26 = i17;
                                    i28 = i10;
                                    break;
                                } else {
                                    i19 = i16;
                                    i17 = b;
                                    i10 = i31;
                                    i18 = i5;
                                    i13 = i3;
                                    i7 = i27;
                                    i9 = i29;
                                    i8 = i19;
                                    unsafe = unsafe2;
                                    i12 = i18;
                                    i11 = i17;
                                    if (i11 == i13) {
                                    }
                                    if (this.hasExtensions) {
                                    }
                                    i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                    t3 = t;
                                    bArr2 = bArr;
                                    i22 = i2;
                                    i26 = i11;
                                    messageSchema2 = this;
                                    registers2 = registers;
                                    i28 = i10;
                                    i29 = i9;
                                    i25 = i8;
                                    i27 = i7;
                                    i23 = i13;
                                    break;
                                }
                                break;
                            default:
                                i18 = i5;
                                i19 = i16;
                                i10 = i31;
                                i17 = b;
                                i13 = i3;
                                i7 = i27;
                                i9 = i29;
                                i8 = i19;
                                unsafe = unsafe2;
                                i12 = i18;
                                i11 = i17;
                                if (i11 == i13) {
                                }
                                if (this.hasExtensions) {
                                }
                                i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                                t3 = t;
                                bArr2 = bArr;
                                i22 = i2;
                                i26 = i11;
                                messageSchema2 = this;
                                registers2 = registers;
                                i28 = i10;
                                i29 = i9;
                                i25 = i8;
                                i27 = i7;
                                i23 = i13;
                                break;
                        }
                    } else {
                        i10 = i31;
                        bArr2 = bArr;
                        if (type != 27) {
                            i8 = i6;
                            i7 = i27;
                            if (type <= 49) {
                                i9 = i29;
                                unsafe = unsafe2;
                                i14 = b;
                                i24 = parseRepeatedField(t, bArr, i5, i2, b, i10, i32, i8, (long) i33, type, offset, registers);
                            } else {
                                unsafe = unsafe2;
                                i15 = i5;
                                i14 = b;
                                i9 = i29;
                                if (type != 50) {
                                    i24 = parseOneofField(t, bArr, i15, i2, i14, i10, i32, i33, type, offset, i8, registers);
                                } else if (i32 == 2) {
                                    i24 = parseMapField(t, bArr, i15, i2, i8, offset, registers);
                                }
                            }
                            messageSchema2 = this;
                            t3 = t;
                            bArr2 = bArr;
                            i22 = i2;
                            i23 = i3;
                            registers2 = registers;
                            i28 = i10;
                            i26 = i14;
                            i29 = i9;
                            i25 = i8;
                            i27 = i7;
                        } else if (i32 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t3, offset);
                            if (!protobufList.isModifiable()) {
                                int size = protobufList.size();
                                protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t3, offset, protobufList);
                            }
                            i24 = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i6), b, bArr, i5, i2, protobufList, registers);
                            i23 = i3;
                            i26 = b;
                            i28 = i10;
                            i25 = i6;
                            i27 = i27;
                        } else {
                            i8 = i6;
                            i7 = i27;
                            i9 = i29;
                            unsafe = unsafe2;
                            i15 = i5;
                            i14 = b;
                        }
                        i13 = i3;
                        i12 = i15;
                        i11 = i14;
                        if (i11 == i13) {
                        }
                        if (this.hasExtensions) {
                        }
                        i24 = ArrayDecoders.decodeUnknownField(i11, bArr, i12, i2, getMutableUnknownFields(t), registers);
                        t3 = t;
                        bArr2 = bArr;
                        i22 = i2;
                        i26 = i11;
                        messageSchema2 = this;
                        registers2 = registers;
                        i28 = i10;
                        i29 = i9;
                        i25 = i8;
                        i27 = i7;
                        i23 = i13;
                    }
                    i22 = i2;
                }
                unsafe2 = unsafe;
            } else {
                unsafe = unsafe2;
                i4 = i23;
                messageSchema = messageSchema2;
            }
        }
        if (i29 != -1) {
            t2 = t;
            unsafe.putInt(t2, (long) i29, i27);
        } else {
            t2 = t;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i38 = messageSchema.checkInitializedCount; i38 < messageSchema.repeatedFieldOffsetStart; i38++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i38], unknownFieldSetLite, (UnknownFieldSchema<UT, UB>) messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i24 != i2) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i24 > i2 || i26 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i24;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01de, code lost:
        if (r0 != r8) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x020c, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022b, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe;
        int i8;
        int i9;
        int i10;
        int i11;
        MessageSchema<T> messageSchema = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = UNSAFE;
        int i13 = -1;
        int i14 = i;
        int i15 = -1;
        int i16 = 0;
        while (i14 < i12) {
            int i17 = i14 + 1;
            byte b2 = bArr2[i14];
            if (b2 < 0) {
                i3 = ArrayDecoders.decodeVarint32(b2, bArr2, i17, registers2);
                b = registers2.int1;
            } else {
                b = b2;
                i3 = i17;
            }
            int i18 = b >>> 3;
            int i19 = b & 7;
            if (i18 > i15) {
                i4 = messageSchema.positionForFieldNumber(i18, i16 / 3);
            } else {
                i4 = messageSchema.positionForFieldNumber(i18);
            }
            if (i4 == i13) {
                i6 = i18;
                i8 = i3;
                unsafe = unsafe2;
                i5 = i13;
                i7 = 0;
            } else {
                int i20 = messageSchema.buffer[i4 + 1];
                int type = type(i20);
                long offset = offset(i20);
                if (type <= 17) {
                    boolean z = true;
                    switch (type) {
                        case 0:
                            i10 = i4;
                            if (i19 == 1) {
                                UnsafeUtil.putDouble(t2, offset, ArrayDecoders.decodeDouble(bArr2, i3));
                                i14 = i3 + 8;
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i7 = i10;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 1:
                            i10 = i4;
                            if (i19 == 5) {
                                UnsafeUtil.putFloat(t2, offset, ArrayDecoders.decodeFloat(bArr2, i3));
                                i14 = i3 + 4;
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i7 = i10;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 2:
                        case 3:
                            i10 = i4;
                            if (i19 == 0) {
                                i11 = ArrayDecoders.decodeVarint64(bArr2, i3, registers2);
                                unsafe2.putLong(t, offset, registers2.long1);
                                i14 = i11;
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i7 = i10;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 4:
                        case 11:
                            i10 = i4;
                            if (i19 == 0) {
                                i14 = ArrayDecoders.decodeVarint32(bArr2, i3, registers2);
                                unsafe2.putInt(t2, offset, registers2.int1);
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i7 = i10;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 5:
                        case 14:
                            if (i19 == 1) {
                                i10 = i4;
                                unsafe2.putLong(t, offset, ArrayDecoders.decodeFixed64(bArr2, i3));
                                i14 = i3 + 8;
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 6:
                        case 13:
                            if (i19 == 5) {
                                unsafe2.putInt(t2, offset, ArrayDecoders.decodeFixed32(bArr2, i3));
                                i14 = i3 + 4;
                                i16 = i4;
                                i15 = i18;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 7:
                            if (i19 == 0) {
                                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i3, registers2);
                                if (registers2.long1 == 0) {
                                    z = false;
                                }
                                UnsafeUtil.putBoolean(t2, offset, z);
                                i14 = decodeVarint64;
                                i16 = i4;
                                i15 = i18;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 8:
                            if (i19 == 2) {
                                if ((ENFORCE_UTF8_MASK & i20) == 0) {
                                    i14 = ArrayDecoders.decodeString(bArr2, i3, registers2);
                                } else {
                                    i14 = ArrayDecoders.decodeStringRequireUtf8(bArr2, i3, registers2);
                                }
                                unsafe2.putObject(t2, offset, registers2.object1);
                                i16 = i4;
                                i15 = i18;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 9:
                            if (i19 == 2) {
                                i14 = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(i4), bArr2, i3, i12, registers2);
                                Object object = unsafe2.getObject(t2, offset);
                                if (object == null) {
                                    unsafe2.putObject(t2, offset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t2, offset, Internal.mergeMessage(object, registers2.object1));
                                }
                                i16 = i4;
                                i15 = i18;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 10:
                            if (i19 == 2) {
                                i14 = ArrayDecoders.decodeBytes(bArr2, i3, registers2);
                                unsafe2.putObject(t2, offset, registers2.object1);
                                i16 = i4;
                                i15 = i18;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 12:
                            i10 = i4;
                            if (i19 == 0) {
                                i14 = ArrayDecoders.decodeVarint32(bArr2, i3, registers2);
                                unsafe2.putInt(t2, offset, registers2.int1);
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i7 = i10;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 15:
                            i10 = i4;
                            if (i19 == 0) {
                                i14 = ArrayDecoders.decodeVarint32(bArr2, i3, registers2);
                                unsafe2.putInt(t2, offset, CodedInputStream.decodeZigZag32(registers2.int1));
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i7 = i10;
                            i5 = -1;
                            i8 = i9;
                            break;
                        case 16:
                            if (i19 == 0) {
                                i11 = ArrayDecoders.decodeVarint64(bArr2, i3, registers2);
                                i10 = i4;
                                unsafe2.putLong(t, offset, CodedInputStream.decodeZigZag64(registers2.long1));
                                i14 = i11;
                                i15 = i18;
                                i16 = i10;
                                break;
                            }
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                        default:
                            i7 = i4;
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            i8 = i9;
                            break;
                    }
                } else if (type == 27) {
                    if (i19 == 2) {
                        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t2, offset);
                        if (!protobufList.isModifiable()) {
                            int size = protobufList.size();
                            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t2, offset, protobufList);
                        }
                        i14 = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i4), b, bArr, i3, i2, protobufList, registers);
                        i15 = i18;
                        i16 = i4;
                    }
                    i7 = i4;
                    i6 = i18;
                    i9 = i3;
                    unsafe = unsafe2;
                    i5 = -1;
                    i8 = i9;
                } else {
                    i7 = i4;
                    if (type <= 49) {
                        i6 = i18;
                        unsafe = unsafe2;
                        i5 = -1;
                        i14 = parseRepeatedField(t, bArr, i3, i2, b, i18, i19, i7, (long) i20, type, offset, registers);
                    } else {
                        i6 = i18;
                        i9 = i3;
                        unsafe = unsafe2;
                        i5 = -1;
                        if (type == 50) {
                            if (i19 == 2) {
                                i14 = parseMapField(t, bArr, i9, i2, i7, offset, registers);
                            }
                            i8 = i9;
                        } else {
                            i14 = parseOneofField(t, bArr, i9, i2, b, i6, i19, i20, type, offset, i7, registers);
                        }
                    }
                    i8 = i14;
                }
                i13 = -1;
            }
            i14 = ArrayDecoders.decodeUnknownField(b, bArr, i8, i2, getMutableUnknownFields(t), registers);
            messageSchema = this;
            t2 = t;
            bArr2 = bArr;
            i12 = i2;
            registers2 = registers;
            unsafe2 = unsafe;
            i16 = i7;
            i15 = i6;
            i13 = i5;
        }
        if (i14 == i12) {
            return i14;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i2 >= i) {
                break;
            }
            long offset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, offset);
            if (object != null) {
                UnsafeUtil.putObject(t, offset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, (long) this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, numberAt, (Map<K, V>) this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema2);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(next.getValue().intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema2.newBuilder();
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub, i2, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.checkInitializedCount; i4++) {
            int i5 = this.intArray[i4];
            int numberAt = numberAt(i5);
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            if (!this.proto3) {
                int i6 = this.buffer[i5 + 2];
                int i7 = OFFSET_MASK & i6;
                i = 1 << (i6 >>> 20);
                if (i7 != i2) {
                    i3 = UNSAFE.getInt(t, (long) i7);
                    i2 = i7;
                }
            } else {
                i = 0;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t, i5, i3, i)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t, numberAt, i5) && !isInitialized(t, typeAndOffsetAt, getMessageFieldSchema(i5))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t, typeAndOffsetAt, i5)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t, typeAndOffsetAt, i5)) {
                    return false;
                }
            } else if (isFieldPresent(t, i5, i3, i) && !isInitialized(t, typeAndOffsetAt, getMessageFieldSchema(i5))) {
                return false;
            }
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.protobuf.Schema */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.google.protobuf.Schema */
    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r5v11 */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<T> schema = 0;
        for (Object obj : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            boolean isInitialized = schema.isInitialized(obj);
            schema = schema;
            if (!isInitialized) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3) {
        if (this.proto3) {
            return isFieldPresent(t, i);
        }
        return (i2 & i3) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        if (this.proto3) {
            int typeAndOffsetAt = typeAndOffsetAt(i);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t, offset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t, offset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t, offset);
                case 8:
                    Object object = UnsafeUtil.getObject(t, offset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject(t, offset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, offset));
                case 11:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 12:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 15:
                    return UnsafeUtil.getInt(t, offset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t, offset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t, offset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
            return (UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
    }

    private void setFieldPresent(T t, int i) {
        if (!this.proto3) {
            int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
            long j = (long) (presenceMaskAndOffsetAt & OFFSET_MASK);
            UnsafeUtil.putInt(t, j, UnsafeUtil.getInt(t, j) | (1 << (presenceMaskAndOffsetAt >>> 20)));
        }
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i) & OFFSET_MASK);
        return UnsafeUtil.getInt(t, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, presenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK), i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int numberAt = numberAt(i4);
            if (i == numberAt) {
                return i4;
            }
            if (i < numberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
