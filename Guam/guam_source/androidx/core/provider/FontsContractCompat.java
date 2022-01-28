package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.SelfDestructiveThread;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.PromiseImpl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat {
    public static final SelfDestructiveThread sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    public static final Comparator<byte[]> sByteArrayComparator = new Comparator<byte[]>() {
        /* class androidx.core.provider.FontsContractCompat.AnonymousClass5 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                i2 = bArr3.length;
                i = bArr4.length;
            } else {
                for (int i3 = 0; i3 < bArr3.length; i3++) {
                    if (bArr3[i3] != bArr4[i3]) {
                        i2 = bArr3[i3];
                        i = bArr4[i3];
                    }
                }
                return 0;
            }
            return (i2 == 1 ? 1 : 0) - (i == 1 ? 1 : 0);
        }
    };
    public static final Object sLock = new Object();
    public static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies = new SimpleArrayMap<>();
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);

    public static class FontFamilyResult {
        public final FontInfo[] mFonts;
        public final int mStatusCode;

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.mStatusCode = i;
            this.mFonts = fontInfoArr;
        }
    }

    public static class FontInfo {
        public final boolean mItalic;
        public final int mResultCode;
        public final int mTtcIndex;
        public final Uri mUri;
        public final int mWeight;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            if (uri != null) {
                this.mUri = uri;
                this.mTtcIndex = i;
                this.mWeight = i2;
                this.mItalic = z;
                this.mResultCode = i3;
                return;
            }
            throw null;
        }
    }

    public static final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(Typeface typeface, int i) {
            this.mTypeface = typeface;
            this.mResult = i;
        }
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.core.provider.FontsContractCompat$FontInfo[], android.database.Cursor] */
    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        Cursor cursor;
        Uri uri;
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = fontRequest.mProviderAuthority;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(GeneratedOutlineSupport.outline8("No package found for authority: ", str));
        } else if (resolveContentProvider.packageName.equals(fontRequest.mProviderPackage)) {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, sByteArrayComparator);
            List<List<byte[]>> list = fontRequest.mCertificates;
            if (list == null) {
                list = AppCompatDelegateImpl.ConfigurationImplApi17.readCerts(resources, fontRequest.mCertificatesArray);
            }
            int i = 0;
            while (true) {
                cursor = 0;
                if (i >= list.size()) {
                    resolveContentProvider = cursor;
                    break;
                }
                ArrayList arrayList2 = new ArrayList(list.get(i));
                Collections.sort(arrayList2, sByteArrayComparator);
                if (arrayList.size() == arrayList2.size()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            z = true;
                            break;
                        } else if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                z = false;
                if (z) {
                    break;
                }
                i++;
            }
            if (resolveContentProvider == null) {
                return new FontFamilyResult(1, cursor);
            }
            String str2 = resolveContentProvider.authority;
            ArrayList arrayList3 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str2).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath(PromiseImpl.STACK_FRAME_KEY_FILE).build();
            try {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.mQuery}, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("result_code");
                    arrayList3 = new ArrayList();
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    int columnIndex3 = cursor.getColumnIndex("file_id");
                    int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                    int columnIndex5 = cursor.getColumnIndex("font_weight");
                    int columnIndex6 = cursor.getColumnIndex("font_italic");
                    while (cursor.moveToNext()) {
                        int i3 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                        int i4 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                        if (columnIndex3 == -1) {
                            uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                        } else {
                            uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                        }
                        arrayList3.add(new FontInfo(uri, i4, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i3));
                    }
                }
                return new FontFamilyResult(0, (FontInfo[]) arrayList3.toArray(new FontInfo[0]));
            } finally {
                if (cursor != 0) {
                    cursor.close();
                }
            }
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Found content provider ", str, ", but package was not ");
            outline17.append(fontRequest.mProviderPackage);
            throw new PackageManager.NameNotFoundException(outline17.toString());
        }
    }

    public static TypefaceResult getFontInternal(Context context, FontRequest fontRequest, int i) {
        try {
            FontFamilyResult fetchFonts = fetchFonts(context, null, fontRequest);
            int i2 = fetchFonts.mStatusCode;
            int i3 = -3;
            if (i2 == 0) {
                Typeface createFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, null, fetchFonts.mFonts, i);
                if (createFromFontInfo != null) {
                    i3 = 0;
                }
                return new TypefaceResult(createFromFontInfo, i3);
            }
            if (i2 == 1) {
                i3 = -2;
            }
            return new TypefaceResult(null, i3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(null, -1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        r3 = androidx.core.provider.FontsContractCompat.sBackgroundThread;
        r4 = new androidx.core.provider.FontsContractCompat.AnonymousClass3();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        if (r3 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        r3.post(new androidx.core.provider.SelfDestructiveThread.AnonymousClass2(r3, r1, new android.os.Handler(), r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        throw null;
     */
    public static Typeface getFontSync(final Context context, final FontRequest fontRequest, final ResourcesCompat$FontCallback resourcesCompat$FontCallback, final Handler handler, boolean z, int i, final int i2) {
        AnonymousClass2 r3;
        final String str = fontRequest.mIdentifier + "-" + i2;
        Typeface typeface = sTypefaceCache.get(str);
        if (typeface != null) {
            if (resourcesCompat$FontCallback != null) {
                resourcesCompat$FontCallback.onFontRetrieved(typeface);
            }
            return typeface;
        } else if (!z || i != -1) {
            AnonymousClass1 r1 = new Callable<TypefaceResult>() {
                /* class androidx.core.provider.FontsContractCompat.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public TypefaceResult call() throws Exception {
                    TypefaceResult fontInternal = FontsContractCompat.getFontInternal(context, fontRequest, i2);
                    Typeface typeface = fontInternal.mTypeface;
                    if (typeface != null) {
                        FontsContractCompat.sTypefaceCache.put(str, typeface);
                    }
                    return fontInternal;
                }
            };
            if (z) {
                try {
                    return ((TypefaceResult) sBackgroundThread.postAndWait(r1, i)).mTypeface;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                if (resourcesCompat$FontCallback == null) {
                    r3 = null;
                } else {
                    r3 = new SelfDestructiveThread.ReplyCallback<TypefaceResult>() {
                        /* class androidx.core.provider.FontsContractCompat.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
                        public void onReply(TypefaceResult typefaceResult) {
                            TypefaceResult typefaceResult2 = typefaceResult;
                            if (typefaceResult2 == null) {
                                ResourcesCompat$FontCallback.this.callbackFailAsync(1, handler);
                                return;
                            }
                            int i = typefaceResult2.mResult;
                            if (i == 0) {
                                ResourcesCompat$FontCallback.this.callbackSuccessAsync(typefaceResult2.mTypeface, handler);
                            } else {
                                ResourcesCompat$FontCallback.this.callbackFailAsync(i, handler);
                            }
                        }
                    };
                }
                synchronized (sLock) {
                    ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> orDefault = sPendingReplies.getOrDefault(str, null);
                    if (orDefault != null) {
                        if (r3 != null) {
                            orDefault.add(r3);
                        }
                        return null;
                    } else if (r3 != null) {
                        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = new ArrayList<>();
                        arrayList.add(r3);
                        sPendingReplies.put(str, arrayList);
                    }
                }
            }
        } else {
            TypefaceResult fontInternal = getFontInternal(context, fontRequest, i2);
            if (resourcesCompat$FontCallback != null) {
                int i3 = fontInternal.mResult;
                if (i3 == 0) {
                    resourcesCompat$FontCallback.callbackSuccessAsync(fontInternal.mTypeface, handler);
                } else {
                    resourcesCompat$FontCallback.callbackFailAsync(i3, handler);
                }
            }
            return fontInternal.mTypeface;
        }
    }

    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.mResultCode == 0) {
                Uri uri = fontInfo.mUri;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, AppCompatDelegateImpl.ConfigurationImplApi17.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
