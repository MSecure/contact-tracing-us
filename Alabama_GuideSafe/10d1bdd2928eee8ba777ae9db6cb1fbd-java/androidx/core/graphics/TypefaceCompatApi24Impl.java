package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    public static final Method sAddFontWeightStyle;
    public static final Method sCreateFromFamiliesWithDefault;
    public static final Class<?> sFontFamily;
    public static final Constructor<?> sFontFamilyCtor;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method;
        sCreateFromFamiliesWithDefault = method2;
    }

    public static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        try {
            obj = sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        FontResourcesParserCompat$FontFileResourceEntry[] fontResourcesParserCompat$FontFileResourceEntryArr = fontResourcesParserCompat$FontFamilyFilesResourceEntry.mEntries;
        for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFileResourceEntryArr) {
            int i2 = fontResourcesParserCompat$FontFileResourceEntry.mResourceId;
            File tempFile = AppCompatDelegateImpl.ConfigurationImplApi17.getTempFile(context);
            if (tempFile != null) {
                try {
                    if (AppCompatDelegateImpl.ConfigurationImplApi17.copyToFile(tempFile, resources, i2)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(tempFile);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                                fileInputStream.close();
                                tempFile.delete();
                                if (!(mappedByteBuffer == null && addFontWeightStyle(obj, mappedByteBuffer, fontResourcesParserCompat$FontFileResourceEntry.mTtcIndex, fontResourcesParserCompat$FontFileResourceEntry.mWeight, fontResourcesParserCompat$FontFileResourceEntry.mItalic))) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        } catch (IOException unused2) {
                            mappedByteBuffer = null;
                        }
                    }
                } finally {
                    tempFile.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer == null) {
                return null;
            }
        }
        return createFromFamiliesWithDefault(obj);
        throw th;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Object obj;
        try {
            obj = sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            Uri uri = fontInfo.mUri;
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
            if (byteBuffer == null) {
                byteBuffer = AppCompatDelegateImpl.ConfigurationImplApi17.mmap(context, cancellationSignal, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !addFontWeightStyle(obj, byteBuffer, fontInfo.mTtcIndex, fontInfo.mWeight, fontInfo.mItalic)) {
                return null;
            }
        }
        Typeface createFromFamiliesWithDefault = createFromFamiliesWithDefault(obj);
        if (createFromFamiliesWithDefault == null) {
            return null;
        }
        return Typeface.create(createFromFamiliesWithDefault, i);
    }
}
