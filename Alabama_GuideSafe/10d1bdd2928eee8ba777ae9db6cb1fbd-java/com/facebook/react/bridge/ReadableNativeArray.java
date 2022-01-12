package com.facebook.react.bridge;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Arrays;

@DoNotStrip
public class ReadableNativeArray extends NativeArray implements ReadableArray {
    public static int jniPassCounter = 0;
    public Object[] mLocalArray;
    public ReadableType[] mLocalTypeArray;

    /* renamed from: com.facebook.react.bridge.ReadableNativeArray$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002b */
        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                ReadableType readableType = ReadableType.Null;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType2 = ReadableType.Boolean;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType3 = ReadableType.Number;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType4 = ReadableType.String;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr5 = $SwitchMap$com$facebook$react$bridge$ReadableType;
            ReadableType readableType5 = ReadableType.Map;
            iArr5[4] = 5;
            try {
                int[] iArr6 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType6 = ReadableType.Array;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        ReactBridge.staticInit();
    }

    public ReadableNativeArray(HybridData hybridData) {
        super(hybridData);
    }

    public static int getJNIPassCounter() {
        return jniPassCounter;
    }

    private Object[] getLocalArray() {
        Object[] objArr = this.mLocalArray;
        if (objArr != null) {
            return objArr;
        }
        synchronized (this) {
            if (this.mLocalArray == null) {
                jniPassCounter++;
                Object[] importArray = importArray();
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(importArray);
                this.mLocalArray = importArray;
            }
        }
        return this.mLocalArray;
    }

    private ReadableType[] getLocalTypeArray() {
        ReadableType[] readableTypeArr = this.mLocalTypeArray;
        if (readableTypeArr != null) {
            return readableTypeArr;
        }
        synchronized (this) {
            if (this.mLocalTypeArray == null) {
                jniPassCounter++;
                Object[] importTypeArray = importTypeArray();
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(importTypeArray);
                Object[] objArr = importTypeArray;
                this.mLocalTypeArray = (ReadableType[]) Arrays.copyOf(objArr, objArr.length, ReadableType[].class);
            }
        }
        return this.mLocalTypeArray;
    }

    private native Object[] importArray();

    private native Object[] importTypeArray();

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableNativeArray)) {
            return false;
        }
        return Arrays.deepEquals(getLocalArray(), ((ReadableNativeArray) obj).getLocalArray());
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean getBoolean(int i) {
        return ((Boolean) getLocalArray()[i]).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public double getDouble(int i) {
        return ((Double) getLocalArray()[i]).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public Dynamic getDynamic(int i) {
        return DynamicFromArray.create(this, i);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int getInt(int i) {
        return ((Double) getLocalArray()[i]).intValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public String getString(int i) {
        return (String) getLocalArray()[i];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ReadableType getType(int i) {
        return getLocalTypeArray()[i];
    }

    public int hashCode() {
        return getLocalArray().hashCode();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean isNull(int i) {
        return getLocalArray()[i] == null;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int size() {
        return getLocalArray().length;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ArrayList<Object> toArrayList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            int ordinal = getType(i).ordinal();
            if (ordinal == 0) {
                arrayList.add(null);
            } else if (ordinal == 1) {
                arrayList.add(Boolean.valueOf(getBoolean(i)));
            } else if (ordinal == 2) {
                arrayList.add(Double.valueOf(getDouble(i)));
            } else if (ordinal == 3) {
                arrayList.add(getString(i));
            } else if (ordinal == 4) {
                arrayList.add(getMap(i).toHashMap());
            } else if (ordinal == 5) {
                arrayList.add(getArray(i).toArrayList());
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline6("Could not convert object at index: ", i, "."));
            }
        }
        return arrayList;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ReadableNativeArray getArray(int i) {
        return (ReadableNativeArray) getLocalArray()[i];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public ReadableNativeMap getMap(int i) {
        return (ReadableNativeMap) getLocalArray()[i];
    }
}
