package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.provider.FontsContractCompat;

@SuppressLint({"NewApi"})
public class TypefaceCompat {
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    public static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else {
            if (i >= 24) {
                if (TypefaceCompatApi24Impl.sAddFontWeightStyle == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (TypefaceCompatApi24Impl.sAddFontWeightStyle != null) {
                    sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
                }
            }
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        }
    }

    public static Typeface create(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry, Resources resources, int i, int i2, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler, boolean z) {
        Typeface typeface;
        if (fontResourcesParserCompat$FamilyResourceEntry instanceof FontResourcesParserCompat$ProviderResourceEntry) {
            FontResourcesParserCompat$ProviderResourceEntry fontResourcesParserCompat$ProviderResourceEntry = (FontResourcesParserCompat$ProviderResourceEntry) fontResourcesParserCompat$FamilyResourceEntry;
            boolean z2 = false;
            if (!z ? resourcesCompat$FontCallback == null : fontResourcesParserCompat$ProviderResourceEntry.mStrategy == 0) {
                z2 = true;
            }
            typeface = FontsContractCompat.getFontSync(context, fontResourcesParserCompat$ProviderResourceEntry.mRequest, resourcesCompat$FontCallback, handler, z2, z ? fontResourcesParserCompat$ProviderResourceEntry.mTimeoutMs : -1, i2);
        } else {
            typeface = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry) fontResourcesParserCompat$FamilyResourceEntry, resources, i2);
            if (resourcesCompat$FontCallback != null) {
                if (typeface != null) {
                    resourcesCompat$FontCallback.callbackSuccessAsync(typeface, handler);
                } else {
                    resourcesCompat$FontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typeface != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, i2), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    public static String createResourceUid(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
