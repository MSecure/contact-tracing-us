package com.google.common.util.concurrent;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.android.volley.CacheDispatcher;
import com.android.volley.NetworkDispatcher;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.NoCache;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzv;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.gson.Gson;
import com.horcrux.svg.ElementType;
import com.horcrux.svg.PathElement;
import com.horcrux.svg.Point;
import com.horcrux.svg.SVGLength;
import com.th3rdwave.safeareacontext.EdgeInsets;
import com.th3rdwave.safeareacontext.Rect;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerImplKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.LazyStandaloneCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
import retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1;
import retrofit2.KotlinExtensions$suspendAndThrow$1;

public final class MoreExecutors {
    public static ArrayList<PathElement> elements;
    public static int i;
    public static int l;
    public static WeakReference<Activity> mActivity;
    public static Path mPath;
    public static boolean mPenDown;
    public static float mPenDownX;
    public static float mPenDownY;
    public static float mPenX;
    public static float mPenY;
    public static float mPivotX;
    public static float mPivotY;
    public static float mScale;
    public static Dialog mSplashDialog;
    public static RequestQueue queue;
    public static String s;

    public static class ListeningDecorator extends AbstractListeningExecutorService {
        public final ExecutorService delegate;

        public ListeningDecorator(ExecutorService executorService) {
            if (executorService != null) {
                this.delegate = executorService;
                return;
            }
            throw null;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(j, timeUnit);
        }

        public final void execute(Runnable runnable) {
            this.delegate.execute(runnable);
        }

        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        public final void shutdown() {
            this.delegate.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "$this$addSuppressed");
        Intrinsics.checkNotNullParameter(th2, "exception");
        if (th != th2) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String str = (String) hashtable.get(attributeTypeAndValue.type);
        if (str != null) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(attributeTypeAndValue.type.identifier);
        }
        stringBuffer.append('=');
        stringBuffer.append(valueToString(attributeTypeAndValue.value));
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d0 A[LOOP:0: B:50:0x01ce->B:51:0x01d0, LOOP_END] */
    public static void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        double d;
        float f6;
        float f7;
        int ceil;
        int i2;
        double d2;
        ElementType elementType = ElementType.kCGPathElementAddCurveToPoint;
        float f8 = mPenX;
        float f9 = mPenY;
        float abs = Math.abs(f2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f5 - f9 : f : f2);
        float abs2 = Math.abs(f == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? f4 - f8 : f);
        if (abs2 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || abs == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || (f4 == f8 && f5 == f9)) {
            lineTo(f4, f5);
            return;
        }
        float radians = (float) Math.toRadians((double) f3);
        double d3 = (double) radians;
        float cos = (float) Math.cos(d3);
        float sin = (float) Math.sin(d3);
        float f10 = f4 - f8;
        float f11 = f5 - f9;
        float f12 = ((sin * f11) / 2.0f) + ((cos * f10) / 2.0f);
        float f13 = -sin;
        float f14 = ((cos * f11) / 2.0f) + ((f13 * f10) / 2.0f);
        float f15 = abs2 * abs2;
        float f16 = f15 * abs * abs;
        float f17 = abs * abs * f12 * f12;
        float f18 = f15 * f14 * f14;
        float f19 = (f16 - f18) - f17;
        if (f19 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            d = d3;
            float sqrt = (float) Math.sqrt((double) (1.0f - (f19 / f16)));
            abs2 *= sqrt;
            abs *= sqrt;
            f7 = f10 / 2.0f;
            f6 = f11 / 2.0f;
        } else {
            d = d3;
            float sqrt2 = (float) Math.sqrt((double) (f19 / (f18 + f17)));
            if (z == z2) {
                sqrt2 = -sqrt2;
            }
            float f20 = (((-sqrt2) * f14) * abs2) / abs;
            float f21 = ((sqrt2 * f12) * abs) / abs2;
            float f22 = (cos * f20) - (sin * f21);
            f6 = (f11 / 2.0f) + (f21 * cos) + (f20 * sin);
            f7 = (f10 / 2.0f) + f22;
        }
        float f23 = cos / abs2;
        float f24 = sin / abs2;
        float f25 = f13 / abs;
        float f26 = cos / abs;
        float f27 = -f7;
        float f28 = -f6;
        float atan2 = (float) Math.atan2((double) ((f26 * f28) + (f25 * f27)), (double) ((f28 * f24) + (f27 * f23)));
        float f29 = f10 - f7;
        float f30 = f11 - f6;
        float atan22 = (float) Math.atan2((double) ((f26 * f30) + (f25 * f29)), (double) ((f24 * f30) + (f23 * f29)));
        float f31 = f7 + f8;
        float f32 = f6 + f9;
        float f33 = f10 + f8;
        float f34 = f11 + f9;
        setPenDown();
        mPivotX = f33;
        mPenX = f33;
        mPivotY = f34;
        mPenY = f34;
        if (abs2 == abs && radians == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            float degrees = (float) Math.toDegrees((double) atan2);
            float abs3 = Math.abs((degrees - ((float) Math.toDegrees((double) atan22))) % 360.0f);
            if (!z ? abs3 > 180.0f : abs3 < 180.0f) {
                abs3 = 360.0f - abs3;
            }
            if (!z2) {
                abs3 = -abs3;
            }
            float f35 = f31 - abs2;
            float f36 = mScale;
            mPath.arcTo(new RectF(f35 * f36, (f32 - abs2) * f36, (f31 + abs2) * f36, (f32 + abs2) * f36), degrees, abs3);
            elements.add(new PathElement(elementType, new Point[]{new Point((double) f33, (double) f34)}));
            return;
        }
        float cos2 = (float) Math.cos(d);
        float sin2 = (float) Math.sin(d);
        float f37 = cos2 * abs2;
        float f38 = (-sin2) * abs;
        float f39 = sin2 * abs2;
        float f40 = cos2 * abs;
        float f41 = atan22 - atan2;
        if (f41 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || !z2) {
            if (f41 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && !z2) {
                d2 = ((double) f41) - 6.283185307179586d;
            }
            double pow = Math.pow(10.0d, 4.0d);
            ceil = (int) Math.ceil(Math.abs(((double) Math.round((((double) f41) / 1.5707963267948966d) * pow)) / pow));
            float f42 = f41 / ((float) ceil);
            float tan = (float) (Math.tan((double) (f42 / 4.0f)) * 1.3333333333333333d);
            double d4 = (double) atan2;
            float cos3 = (float) Math.cos(d4);
            float sin3 = (float) Math.sin(d4);
            i2 = 0;
            while (i2 < ceil) {
                float f43 = cos3 - (tan * sin3);
                float f44 = (cos3 * tan) + sin3;
                float f45 = atan2 + f42;
                double d5 = (double) f45;
                float cos4 = (float) Math.cos(d5);
                float sin4 = (float) Math.sin(d5);
                float f46 = (tan * sin4) + cos4;
                float f47 = sin4 - (tan * cos4);
                float f48 = (f38 * f44) + (f37 * f43) + f31;
                float f49 = (f44 * f40) + (f43 * f39) + f32;
                float f50 = (f38 * f47) + (f37 * f46) + f31;
                float f51 = (f47 * f40) + (f46 * f39) + f32;
                float f52 = (f38 * sin4) + (f37 * cos4) + f31;
                float f53 = (f40 * sin4) + (f39 * cos4) + f32;
                Path path = mPath;
                float f54 = mScale;
                path.cubicTo(f48 * f54, f49 * f54, f50 * f54, f51 * f54, f52 * f54, f53 * f54);
                elements.add(new PathElement(elementType, new Point[]{new Point((double) f48, (double) f49), new Point((double) f50, (double) f51), new Point((double) f52, (double) f53)}));
                i2++;
                f42 = f42;
                atan2 = f45;
                f40 = f40;
                f31 = f31;
                f38 = f38;
                tan = tan;
                f39 = f39;
                ceil = ceil;
                cos3 = cos4;
                f32 = f32;
                f37 = f37;
                sin3 = sin4;
            }
        }
        d2 = ((double) f41) + 6.283185307179586d;
        f41 = (float) d2;
        double pow2 = Math.pow(10.0d, 4.0d);
        ceil = (int) Math.ceil(Math.abs(((double) Math.round((((double) f41) / 1.5707963267948966d) * pow2)) / pow2));
        float f422 = f41 / ((float) ceil);
        float tan2 = (float) (Math.tan((double) (f422 / 4.0f)) * 1.3333333333333333d);
        double d42 = (double) atan2;
        float cos32 = (float) Math.cos(d42);
        float sin32 = (float) Math.sin(d42);
        i2 = 0;
        while (i2 < ceil) {
        }
    }

    public static boolean areEqual(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 != bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static final <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.type.equals(attributeTypeAndValue2.type) && canonicalize(valueToString(attributeTypeAndValue.value)).equals(canonicalize(valueToString(attributeTypeAndValue2.value)));
    }

    public static int bigEndianToInt(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        return (bArr[i4 + 1] & 255) | (bArr[i2] << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
    }

    public static String buildKeySelection(int i2) {
        String[] strArr = new String[i2];
        Arrays.fill(strArr, ColorPropConverter.PREFIX_ATTR);
        return GeneratedOutlineSupport.outline14(GeneratedOutlineSupport.outline17("key IN ("), TextUtils.join(", ", strArr), ")");
    }

    public static String bytesToHex(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            cArr[i4] = charArray[i3 >>> 4];
            cArr[i4 + 1] = charArray[i3 & 15];
        }
        return new String(cArr);
    }

    public static String canonicalize(String str) {
        String lowerCase = Strings.toLowerCase(str);
        int i2 = 1;
        if (lowerCase.length() > 0 && lowerCase.charAt(0) == '#') {
            try {
                ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(Hex.decode(lowerCase.substring(1)));
                if (fromByteArray instanceof ASN1String) {
                    lowerCase = Strings.toLowerCase(((ASN1String) fromByteArray).getString());
                }
            } catch (IOException e) {
                throw new IllegalStateException("unknown encoding in name: " + e);
            }
        }
        if (lowerCase.length() > 1) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i4 < lowerCase.length() && lowerCase.charAt(i3) == '\\' && lowerCase.charAt(i4) == ' ') {
                    i3 += 2;
                } else {
                    int length = lowerCase.length() - 1;
                }
            }
            int length2 = lowerCase.length() - 1;
            while (true) {
                int i5 = length2 - 1;
                if (i5 > 0 && lowerCase.charAt(i5) == '\\' && lowerCase.charAt(length2) == ' ') {
                    length2 -= 2;
                } else if (i3 > 0 || length2 < lowerCase.length() - 1) {
                    lowerCase = lowerCase.substring(i3, length2 + 1);
                }
            }
            lowerCase = lowerCase.substring(i3, length2 + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lowerCase.length() != 0) {
            char charAt = lowerCase.charAt(0);
            stringBuffer.append(charAt);
            while (i2 < lowerCase.length()) {
                char charAt2 = lowerCase.charAt(i2);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i2++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static final int checkRadix(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        StringBuilder outline18 = GeneratedOutlineSupport.outline18("radix ", i2, " was not in valid range ");
        outline18.append(new IntRange(2, 36));
        throw new IllegalArgumentException(outline18.toString());
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            addSuppressed(th, th2);
        }
    }

    public static final int coerceIn(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
        } else if (i2 < i3) {
            return i3;
        } else {
            return i2 > i4 ? i4 : i2;
        }
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    public static int compareInts(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int compareLongs(long j, long j2) {
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONObject) {
                writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else {
                writableNativeArray.pushString(obj.toString());
            }
        }
        return writableNativeArray;
    }

    public static WritableMap convertJsonToMap(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeMap.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeMap.putString(next, (String) obj);
            } else {
                writableNativeMap.putString(next, obj.toString());
            }
        }
        return writableNativeMap;
    }

    public static WritableArray convertListToWritableArray(List<?> list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            WritableMap writableMap = null;
            try {
                writableMap = convertJsonToMap(new JSONObject(new Gson().toJson(it.next())));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            writableNativeArray.pushMap(writableMap);
        }
        return writableNativeArray;
    }

    public static Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        Intrinsics.checkNotNullParameter(objArr, "$this$copyInto");
        Intrinsics.checkNotNullParameter(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
        return objArr2;
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object startUndispatchedOrReturn = startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        if (startUndispatchedOrReturn == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return startUndispatchedOrReturn;
    }

    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, continuation);
        }
        CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(continuation, continuation, function2, r);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(continuation, context, continuation, context, function2, r);
    }

    public static final Object createFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "exception");
        return new Result.Failure(th);
    }

    public static void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        setPenDown();
        mPenX = f5;
        mPenY = f6;
        Path path = mPath;
        float f7 = mScale;
        path.cubicTo(f * f7, f2 * f7, f3 * f7, f4 * f7, f5 * f7, f6 * f7);
        elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point((double) f, (double) f2), new Point((double) f3, (double) f4), new Point((double) f5, (double) f6)}));
    }

    public static void deepMergeInto(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject2.optJSONObject(next);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
            if (optJSONObject == null || optJSONObject2 == null) {
                jSONObject.put(next, jSONObject2.get(next));
            } else {
                deepMergeInto(optJSONObject2, optJSONObject);
                jSONObject.put(next, optJSONObject2);
            }
        }
    }

    public static void dismissDialog(FragmentActivity fragmentActivity, String str, Promise promise) {
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to close a " + str + " dialog while not attached to an Activity");
            return;
        }
        DialogFragment dialogFragment = (DialogFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
        boolean z = dialogFragment != null;
        if (z) {
            dialogFragment.dismiss();
        }
        promise.resolve(Boolean.valueOf(z));
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    public static boolean equals1(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static Field findField(Class cls, Class cls2, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            return null;
        }
    }

    public static long floorDiv(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    public static long floorMod(long j, long j2) {
        return ((j % j2) + j2) % j2;
    }

    public static int[] fromBigInteger(int i2, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i2) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[((i2 + 31) >> 5)];
        int i3 = 0;
        while (bigInteger.signum() != 0) {
            iArr[i3] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i3++;
        }
        return iArr;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static double fromRelative(String str, double d, double d2, double d3) {
        double doubleValue;
        String trim = str.trim();
        int length = trim.length();
        int i2 = length - 1;
        if (length == 0 || trim.equals("normal")) {
            return 0.0d;
        }
        if (trim.codePointAt(i2) == 37) {
            return (Double.valueOf(trim.substring(0, i2)).doubleValue() / 100.0d) * d;
        }
        int i3 = length - 2;
        if (i3 > 0) {
            String substring = trim.substring(i3);
            char c = 65535;
            int hashCode = substring.hashCode();
            if (hashCode != 3178) {
                if (hashCode != 3240) {
                    if (hashCode != 3365) {
                        if (hashCode != 3488) {
                            if (hashCode != 3571) {
                                if (hashCode != 3588) {
                                    if (hashCode == 3592 && substring.equals("px")) {
                                        c = 0;
                                    }
                                } else if (substring.equals("pt")) {
                                    c = 2;
                                }
                            } else if (substring.equals("pc")) {
                                c = 3;
                            }
                        } else if (substring.equals("mm")) {
                            c = 4;
                        }
                    } else if (substring.equals("in")) {
                        c = 6;
                    }
                } else if (substring.equals("em")) {
                    c = 1;
                }
            } else if (substring.equals("cm")) {
                c = 5;
            }
            switch (c) {
                case 0:
                    length = i3;
                    d3 = 1.0d;
                    break;
                case 1:
                    length = i3;
                    break;
                case 2:
                    d3 = 1.25d;
                    length = i3;
                    break;
                case 3:
                    d3 = 15.0d;
                    length = i3;
                    break;
                case 4:
                    d3 = 3.543307d;
                    length = i3;
                    break;
                case 5:
                    d3 = 35.43307d;
                    length = i3;
                    break;
                case 6:
                    d3 = 90.0d;
                    length = i3;
                    break;
                default:
                    d3 = 1.0d;
                    break;
            }
            doubleValue = Double.valueOf(trim.substring(0, length)).doubleValue() * d3;
        } else {
            doubleValue = Double.valueOf(trim).doubleValue();
        }
        return doubleValue * d2;
    }

    public static RequestQueue get() {
        if (queue == null) {
            RequestQueue requestQueue = new RequestQueue(new NoCache(), new BasicNetwork(new HurlStack()));
            queue = requestQueue;
            CacheDispatcher cacheDispatcher = requestQueue.mCacheDispatcher;
            if (cacheDispatcher != null) {
                cacheDispatcher.mQuit = true;
                cacheDispatcher.interrupt();
            }
            NetworkDispatcher[] networkDispatcherArr = requestQueue.mDispatchers;
            for (NetworkDispatcher networkDispatcher : networkDispatcherArr) {
                if (networkDispatcher != null) {
                    networkDispatcher.mQuit = true;
                    networkDispatcher.interrupt();
                }
            }
            CacheDispatcher cacheDispatcher2 = new CacheDispatcher(requestQueue.mCacheQueue, requestQueue.mNetworkQueue, requestQueue.mCache, requestQueue.mDelivery);
            requestQueue.mCacheDispatcher = cacheDispatcher2;
            cacheDispatcher2.start();
            for (int i2 = 0; i2 < requestQueue.mDispatchers.length; i2++) {
                NetworkDispatcher networkDispatcher2 = new NetworkDispatcher(requestQueue.mNetworkQueue, requestQueue.mNetwork, requestQueue.mCache, requestQueue.mDelivery);
                requestQueue.mDispatchers[i2] = networkDispatcher2;
                networkDispatcher2.start();
            }
        }
        return queue;
    }

    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static WritableMap getDBError(String str) {
        return getError(null, "Database Error");
    }

    public static WritableMap getError(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("message", str2);
        if (str != null) {
            createMap.putString("key", str);
        }
        return createMap;
    }

    public static Rect getFrame(ViewGroup viewGroup, View view) {
        if (view.getParent() == null) {
            return null;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getDrawingRect(rect);
        try {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            return new Rect((float) rect.left, (float) rect.top, (float) view.getWidth(), (float) view.getHeight());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> ListenableFuture<T> getFutureWithTimeout(Task<T> task, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return FluentFuture.from(AppCompatDelegateImpl.ConfigurationImplApi17.getFuture(new CallbackToFutureAdapter$Resolver(scheduledExecutorService) {
            /* class com.google.common.util.concurrent.$$Lambda$MoreExecutors$p54Y1WXRW9foPnNW5xmDXuaXvYM */
            public final /* synthetic */ ScheduledExecutorService f$1;

            {
                this.f$1 = r2;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
            public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
                MoreExecutors.lambda$getFutureWithTimeout$1(Task.this, this.f$1, callbackToFutureAdapter$Completer);
                return "GmsCoreTask";
            }
        })).withTimeout(j, timeUnit, scheduledExecutorService);
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static WritableMap getInvalidKeyError(String str) {
        return getError(null, "Invalid key");
    }

    public static WritableMap getInvalidValueError(String str) {
        return getError(null, "Invalid Value");
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals("double") ? Double.class : cls;
            case 104431:
                if (name.equals("int")) {
                    return Integer.class;
                }
                return cls;
            case 3039496:
                if (name.equals("byte")) {
                    return Byte.class;
                }
                return cls;
            case 3052374:
                if (name.equals("char")) {
                    return Character.class;
                }
                return cls;
            case 3327612:
                if (name.equals("long")) {
                    return Long.class;
                }
                return cls;
            case 3625364:
                if (name.equals("void")) {
                    return Void.class;
                }
                return cls;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.class;
                }
                return cls;
            case 97526364:
                if (name.equals("float")) {
                    return Float.class;
                }
                return cls;
            case 109413500:
                if (name.equals("short")) {
                    return Short.class;
                }
                return cls;
            default:
                return cls;
        }
    }

    public static float getLastPointerX(MotionEvent motionEvent, boolean z) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            int pointerCount = motionEvent.getPointerCount();
            int i2 = 0;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (i3 != actionIndex) {
                    i2++;
                    f = motionEvent.getX(i3) + rawX + f;
                }
            }
            return f / ((float) i2);
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getX(pointerCount2) + rawX;
    }

    public static float getLastPointerY(MotionEvent motionEvent, boolean z) {
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            int pointerCount = motionEvent.getPointerCount();
            int i2 = 0;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (i3 != actionIndex) {
                    i2++;
                    f = motionEvent.getY(i3) + rawY + f;
                }
            }
            return f / ((float) i2);
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getY(pointerCount2) + rawY;
    }

    public static String getMD5Checksum(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        if (digest == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(digest.length * 2);
        for (byte b : digest) {
            sb.append("0123456789ABCDEF".charAt((b & 240) >> 4));
            sb.append("0123456789ABCDEF".charAt(b & 15));
        }
        return sb.toString();
    }

    public static EdgeInsets getSafeAreaInsets(View view) {
        EdgeInsets edgeInsets;
        if (view.getHeight() == 0) {
            return null;
        }
        View rootView = view.getRootView();
        WindowInsets rootWindowInsets = rootView.getRootWindowInsets();
        if (rootWindowInsets == null) {
            edgeInsets = null;
        } else {
            edgeInsets = new EdgeInsets((float) rootWindowInsets.getSystemWindowInsetTop(), (float) rootWindowInsets.getSystemWindowInsetRight(), (float) Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), (float) rootWindowInsets.getSystemWindowInsetLeft());
        }
        if (edgeInsets == null) {
            return null;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        edgeInsets.top = Math.max(edgeInsets.top - ((float) rect.top), (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        edgeInsets.left = Math.max(edgeInsets.left - ((float) rect.left), (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        edgeInsets.bottom = Math.max((((float) (view.getHeight() + rect.top)) + edgeInsets.bottom) - ((float) rootView.getHeight()), (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        edgeInsets.right = Math.max((((float) (view.getWidth() + rect.left)) + edgeInsets.right) - ((float) rootView.getWidth()), (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        return edgeInsets;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b6  */
    public static Matrix getTransform(RectF rectF, RectF rectF2, String str, int i2) {
        double d;
        double max;
        double d2;
        double d3;
        double width = (double) rectF.width();
        double height = (double) rectF.height();
        double d4 = (double) rectF2.left;
        double d5 = (double) rectF2.top;
        double width2 = (double) rectF2.width();
        double height2 = (double) rectF2.height();
        double d6 = width2 / width;
        double d7 = height2 / height;
        double d8 = d4 - (((double) rectF.left) * d6);
        double d9 = d5 - (((double) rectF.top) * d7);
        if (i2 == 2) {
            d = Math.min(d6, d7);
            if (d > 1.0d) {
                d2 = 2.0d;
                d8 -= ((width2 / d) - width) / 2.0d;
                d3 = (height2 / d) - height;
            } else {
                d2 = 2.0d;
                d8 -= (width2 - (width * d)) / 2.0d;
                d3 = height2 - (height * d);
            }
            d9 -= d3 / d2;
            d7 = d;
        } else {
            if (str.equals("none") || i2 != 0) {
                if (!str.equals("none") && i2 == 1) {
                    max = Math.max(d6, d7);
                }
                if (str.contains("xMid")) {
                    d8 += (width2 - (width * d6)) / 2.0d;
                }
                if (str.contains("xMax")) {
                    d8 = (width2 - (width * d6)) + d8;
                }
                if (str.contains("YMid")) {
                    d9 += (height2 - (height * d7)) / 2.0d;
                }
                if (str.contains("YMax")) {
                    d9 += height2 - (height * d7);
                }
                d = d6;
            } else {
                max = Math.min(d6, d7);
            }
            d6 = max;
            d7 = d6;
            if (str.contains("xMid")) {
            }
            if (str.contains("xMax")) {
            }
            if (str.contains("YMid")) {
            }
            if (str.contains("YMax")) {
            }
            d = d6;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) d8, (float) d9);
        matrix.preScale((float) d, (float) d7);
        return matrix;
    }

    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
        }
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i2 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i2;
            }
            i2 = (i2 * 257) ^ bArr[length];
        }
    }

    public static void intToBigEndian(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i5] = (byte) (i2 >>> 8);
        bArr[i5 + 1] = (byte) i2;
    }

    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "$this$intercepted");
        ContinuationImpl continuationImpl = (ContinuationImpl) (!(continuation instanceof ContinuationImpl) ? null : continuation);
        if (continuationImpl != null && (continuation = (Continuation<T>) continuationImpl.intercepted) == null) {
            CoroutineContext coroutineContext = continuationImpl._context;
            Intrinsics.checkNotNull(coroutineContext);
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
            if (continuationInterceptor == null || (continuation = continuationInterceptor.interceptContinuation(continuationImpl)) == null) {
                continuation = continuationImpl;
            }
            continuationImpl.intercepted = continuation;
        }
        return (Continuation<T>) continuation;
    }

    public static void inversionResult(int[] iArr, int i2, int[] iArr2, int[] iArr3) {
        if (i2 < 0) {
            int length = iArr.length;
            long j = 0;
            for (int i3 = 0; i3 < length; i3++) {
                long j2 = (((long) iArr2[i3]) & 4294967295L) + (4294967295L & ((long) iArr[i3])) + j;
                iArr3[i3] = (int) j2;
                j = j2 >>> 32;
            }
            return;
        }
        System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
    }

    public static int inversionStep(int[] iArr, int[] iArr2, int i2, int[] iArr3, int i3) {
        int length = iArr.length;
        int i4 = 0;
        while (iArr2[0] == 0) {
            int i5 = i2;
            int i6 = 0;
            while (true) {
                i5--;
                if (i5 < 0) {
                    break;
                }
                int i7 = iArr2[i5];
                iArr2[i5] = i6;
                i6 = i7;
            }
            i4 += 32;
        }
        int i8 = iArr2[0];
        int i9 = 0;
        while ((i8 & 1) == 0) {
            i8 >>>= 1;
            i9++;
        }
        if (i9 > 0) {
            int i10 = 0;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                int i11 = iArr2[i2];
                iArr2[i2] = (i10 << (-i9)) | (i11 >>> i9);
                i10 = i11;
            }
            i4 += i9;
        }
        for (int i12 = 0; i12 < i4; i12++) {
            if ((iArr3[0] & 1) != 0) {
                if (i3 < 0) {
                    long j = 0;
                    for (int i13 = 0; i13 < length; i13++) {
                        long j2 = (((long) iArr[i13]) & 4294967295L) + (4294967295L & ((long) iArr3[i13])) + j;
                        iArr3[i13] = (int) j2;
                        j = j2 >>> 32;
                    }
                    i3 += (int) j;
                } else {
                    i3 = subFrom(length, iArr, iArr3) + i3;
                }
            }
            int i14 = i3;
            int i15 = length;
            while (true) {
                i15--;
                if (i15 < 0) {
                    break;
                }
                int i16 = iArr3[i15];
                iArr3[i15] = (i14 << 31) | (i16 >>> 1);
                i14 = i16;
            }
        }
        return i3;
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return job.invokeOnCompletion(z, z2, function1);
    }

    public static final boolean isCancellableMode(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static boolean isOne(int i2, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            if (iArr[i3] != 0) {
                return false;
            }
        }
        return true;
    }

    public static Object lambda$getFutureWithTimeout$1(Task task, ScheduledExecutorService scheduledExecutorService, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) throws Exception {
        $$Lambda$MoreExecutors$u3vrlwkWZPofPzCXdya5NSOCJl8 r0 = new OnCompleteListener() {
            /* class com.google.common.util.concurrent.$$Lambda$MoreExecutors$u3vrlwkWZPofPzCXdya5NSOCJl8 */

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MoreExecutors.lambda$null$0(CallbackToFutureAdapter$Completer.this, task);
            }
        };
        zzu zzu = (zzu) task;
        zzq<TResult> zzq = zzu.zzb;
        zzv.zza(scheduledExecutorService);
        zzq.zza(new zzi(scheduledExecutorService, r0));
        zzu.zze();
        return "GmsCoreTask";
    }

    public static void lambda$null$0(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, Task task) {
        try {
            if (((zzu) task).zzd) {
                callbackToFutureAdapter$Completer.setCancelled();
            } else if (task.getException() != null) {
                callbackToFutureAdapter$Completer.setException(task.getException());
            } else {
                callbackToFutureAdapter$Completer.set(task.getResult());
            }
        } catch (Exception e) {
            callbackToFutureAdapter$Completer.setException(e);
        }
    }

    /* JADX INFO: finally extract failed */
    public static Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        AbstractCoroutine abstractCoroutine;
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineStart coroutineStart2 = (i2 & 2) != 0 ? CoroutineStart.DEFAULT : null;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart2 != null) {
            if (coroutineStart2 == CoroutineStart.LAZY) {
                abstractCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
            } else {
                abstractCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
            }
            abstractCoroutine.initParentJob$kotlinx_coroutines_core();
            int ordinal = coroutineStart2.ordinal();
            if (ordinal == 0) {
                startCoroutineCancellable$default(function2, abstractCoroutine, abstractCoroutine, null, 4);
            } else if (ordinal != 1) {
                if (ordinal == 2) {
                    Intrinsics.checkNotNullParameter(function2, "$this$startCoroutine");
                    Intrinsics.checkNotNullParameter(abstractCoroutine, "completion");
                    intercepted(createCoroutineUnintercepted(function2, abstractCoroutine, abstractCoroutine)).resumeWith(Unit.INSTANCE);
                } else if (ordinal == 3) {
                    Intrinsics.checkNotNullParameter(abstractCoroutine, "completion");
                    try {
                        CoroutineContext context = abstractCoroutine.getContext();
                        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
                        try {
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2);
                            Object invoke = function2.invoke(abstractCoroutine, abstractCoroutine);
                            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                            if (invoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                                abstractCoroutine.resumeWith(invoke);
                            }
                        } catch (Throwable th) {
                            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        abstractCoroutine.resumeWith(createFailure(th2));
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return abstractCoroutine;
        }
        throw null;
    }

    public static void line(float f, float f2) {
        lineTo(f + mPenX, f2 + mPenY);
    }

    public static void lineTo(float f, float f2) {
        setPenDown();
        mPenX = f;
        mPivotX = f;
        mPenY = f2;
        mPivotY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.lineTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point((double) f, (double) f2)}));
    }

    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static void longToBigEndian(long j, byte[] bArr, int i2) {
        intToBigEndian((int) (j >>> 32), bArr, i2);
        intToBigEndian((int) (j & 4294967295L), bArr, i2 + 4);
    }

    public static final int mapCapacity(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        if (pairArr.length <= 0) {
            return EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(pairArr.length));
        Intrinsics.checkNotNullParameter(pairArr, "$this$toMap");
        Intrinsics.checkNotNullParameter(linkedHashMap, "destination");
        Intrinsics.checkNotNullParameter(linkedHashMap, "$this$putAll");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            linkedHashMap.put(pair.first, pair.second);
        }
        return linkedHashMap;
    }

    /* JADX INFO: finally extract failed */
    public static boolean mergeImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) throws JSONException {
        String str3;
        Cursor query = sQLiteDatabase.query("catalystLocalStorage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
        try {
            if (!query.moveToFirst()) {
                query.close();
                str3 = null;
            } else {
                str3 = query.getString(0);
                query.close();
            }
            if (str3 != null) {
                JSONObject jSONObject = new JSONObject(str3);
                deepMergeInto(jSONObject, new JSONObject(str2));
                str2 = jSONObject.toString();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            return -1 != sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", null, contentValues, 5);
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public static final int mod(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    public static void moveTo(float f, float f2) {
        mPenX = f;
        mPivotX = f;
        mPenDownX = f;
        mPenY = f2;
        mPivotY = f2;
        mPenDownY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.moveTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point((double) f, (double) f2)}));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return list;
        }
        return listOf(list.get(0));
    }

    public static boolean parse_flag() {
        skip_spaces();
        char charAt = s.charAt(i);
        if (charAt == '0' || charAt == '1') {
            int i2 = i + 1;
            i = i2;
            if (i2 < l && s.charAt(i2) == ',') {
                i++;
            }
            skip_spaces();
            return charAt == '1';
        }
        throw new Error(String.format("Unexpected flag '%c' (i=%d, s=%s)", Character.valueOf(charAt), Integer.valueOf(i), s));
    }

    public static float parse_list_number() {
        int i2;
        char charAt;
        if (i != l) {
            skip_spaces();
            int i3 = i;
            if (i3 != l) {
                char charAt2 = s.charAt(i3);
                if (charAt2 == '-' || charAt2 == '+') {
                    int i4 = i + 1;
                    i = i4;
                    charAt2 = s.charAt(i4);
                }
                if (charAt2 >= '0' && charAt2 <= '9') {
                    skip_digits();
                    int i5 = i;
                    if (i5 < l) {
                        charAt2 = s.charAt(i5);
                    }
                } else if (charAt2 != '.') {
                    throw new Error(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(charAt2), Integer.valueOf(i), s));
                }
                if (charAt2 == '.') {
                    i++;
                    skip_digits();
                    int i6 = i;
                    if (i6 < l) {
                        charAt2 = s.charAt(i6);
                    }
                }
                if ((charAt2 == 'e' || charAt2 == 'E') && (i2 = i + 1) < l && (charAt = s.charAt(i2)) != 'm' && charAt != 'x') {
                    int i7 = i + 1;
                    i = i7;
                    char charAt3 = s.charAt(i7);
                    if (charAt3 == '+' || charAt3 == '-') {
                        i++;
                        skip_digits();
                    } else if (charAt3 < '0' || charAt3 > '9') {
                        throw new Error(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(charAt3), Integer.valueOf(i), s));
                    } else {
                        skip_digits();
                    }
                }
                String substring = s.substring(i3, i);
                float parseFloat = Float.parseFloat(substring);
                if (Float.isInfinite(parseFloat) || Float.isNaN(parseFloat)) {
                    throw new Error(String.format("Invalid number '%s' (start=%d, i=%d, s=%s)", substring, Integer.valueOf(i3), Integer.valueOf(i), s));
                }
                skip_spaces();
                int i8 = i;
                if (i8 < l && s.charAt(i8) == ',') {
                    i++;
                }
                return parseFloat;
            }
            throw new Error(String.format("Unexpected end (s=%s)", s));
        }
        throw new Error(String.format("Unexpected end (s=%s)", s));
    }

    public static void quadraticBezierCurveTo(float f, float f2, float f3, float f4) {
        mPivotX = f;
        mPivotY = f2;
        float f5 = f * 2.0f;
        float f6 = f2 * 2.0f;
        float f7 = (mPenX + f5) / 3.0f;
        float f8 = (mPenY + f6) / 3.0f;
        cubicTo(f7, f8, (f3 + f5) / 3.0f, (f4 + f6) / 3.0f, f3, f4);
    }

    public static final <T> Object recoverResult(Object obj, Continuation<? super T> continuation) {
        if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        }
        Throwable th = ((CompletedExceptionally) obj).cause;
        if (DebugKt.RECOVER_STACK_TRACES && (continuation instanceof CoroutineStackFrame)) {
            th = StackTraceRecoveryKt.access$recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
        return createFailure(th);
    }

    public static final boolean regionMatches(String str, int i2, String str2, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "$this$regionMatches");
        Intrinsics.checkNotNullParameter(str2, "other");
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(GeneratedOutlineSupport.outline10(str, " must not be null"));
    }

    public static final <T> void resume(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        Object createFailure = exceptionalResult$kotlinx_coroutines_core != null ? createFailure(exceptionalResult$kotlinx_coroutines_core) : dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (!z) {
            continuation.resumeWith(createFailure);
        } else if (continuation != null) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                dispatchedContinuation.continuation.resumeWith(createFailure);
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        }
    }

    public static void reverseByteArray(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            byte b = bArr[i2];
            bArr[i2] = bArr[(bArr.length - i2) - 1];
            bArr[(bArr.length - i2) - 1] = b;
        }
    }

    public static int safeAdd(int i2, int i3) {
        int i4 = i2 + i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) < 0) {
            return i4;
        }
        throw new ArithmeticException("Addition overflows an int: " + i2 + " + " + i3);
    }

    public static long safeMultiply(long j, int i2) {
        if (i2 != -1) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return j;
            }
            long j2 = (long) i2;
            long j3 = j * j2;
            if (j3 / j2 == j) {
                return j3;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i2);
        } else if (j != Long.MIN_VALUE) {
            return -j;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i2);
        }
    }

    public static long safeSubtract(long j, long j2) {
        long j3 = j - j2;
        if ((j ^ j3) >= 0 || (j ^ j2) >= 0) {
            return j3;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j + " - " + j2);
    }

    public static final <T> Set<T> setOf(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    public static void setPenDown() {
        if (!mPenDown) {
            mPenDownX = mPenX;
            mPenDownY = mPenY;
            mPenDown = true;
        }
    }

    public static final char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static void skip_digits() {
        while (true) {
            int i2 = i;
            if (i2 < l && Character.isDigit(s.charAt(i2))) {
                i++;
            } else {
                return;
            }
        }
    }

    public static void skip_spaces() {
        while (true) {
            int i2 = i;
            if (i2 < l && Character.isWhitespace(s.charAt(i2))) {
                i++;
            } else {
                return;
            }
        }
    }

    public static void smoothCurveTo(float f, float f2, float f3, float f4) {
        mPivotX = f;
        mPivotY = f2;
        cubicTo((mPenX * 2.0f) - mPivotX, (mPenY * 2.0f) - mPivotY, f, f2, f3, f4);
    }

    public static void smoothQuadraticBezierCurveTo(float f, float f2) {
        quadraticBezierCurveTo((mPenX * 2.0f) - mPivotX, (mPenY * 2.0f) - mPivotY, f, f2);
    }

    public static void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i2) {
        int i3 = i2 & 4;
        try {
            DispatchedContinuationKt.resumeCancellableWith(intercepted(createCoroutineUnintercepted(function2, obj, continuation)), Unit.INSTANCE, null);
        } catch (Throwable th) {
            continuation.resumeWith(createFailure(th));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        scopeCoroutine.initParentJob$kotlinx_coroutines_core();
        if (function2 != null) {
            try {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2);
                obj = function2.invoke(r, scopeCoroutine);
            } catch (Throwable th) {
                obj = new CompletedExceptionally(th, false, 2);
            }
            if (obj == coroutineSingletons || (makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return coroutineSingletons;
            }
            if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
            }
            Throwable th2 = ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
            Continuation<T> continuation = scopeCoroutine.uCont;
            if (!DebugKt.RECOVER_STACK_TRACES) {
                throw th2;
            } else if (!(continuation instanceof CoroutineStackFrame)) {
                throw th2;
            } else {
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(th2, (CoroutineStackFrame) continuation);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }

    public static boolean startsWith$default(String str, String str2, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "$this$startsWith");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    public static int subFrom(int i2, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((((long) iArr2[i3]) & 4294967295L) - (4294967295L & ((long) iArr[i3]))) + j;
            iArr2[i3] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    public static final Object suspendAndThrow(Exception exc, Continuation<?> continuation) {
        KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        int i2;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            int i3 = kotlinExtensions$suspendAndThrow$1.label;
            if ((i3 & RecyclerView.UNDEFINED_DURATION) != 0) {
                kotlinExtensions$suspendAndThrow$1.label = i3 - RecyclerView.UNDEFINED_DURATION;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                i2 = kotlinExtensions$suspendAndThrow$1.label;
                if (i2 != 0) {
                    throwOnFailure(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = exc;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    Dispatchers.Default.dispatch(kotlinExtensions$suspendAndThrow$1.getContext(), new KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(kotlinExtensions$suspendAndThrow$1, exc));
                    Intrinsics.checkNotNullParameter(kotlinExtensions$suspendAndThrow$1, "frame");
                    return coroutineSingletons;
                } else if (i2 == 1) {
                    Exception exc2 = (Exception) kotlinExtensions$suspendAndThrow$1.L$0;
                    throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        Object obj2 = kotlinExtensions$suspendAndThrow$1.result;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        i2 = kotlinExtensions$suspendAndThrow$1.label;
        if (i2 != 0) {
        }
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        Long l2;
        String systemProp = SystemPropsKt__SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j;
        }
        Intrinsics.checkNotNullParameter(systemProp, "$this$toLongOrNull");
        Intrinsics.checkNotNullParameter(systemProp, "$this$toLongOrNull");
        checkRadix(10);
        int length = systemProp.length();
        if (length != 0) {
            int i2 = 0;
            char charAt = systemProp.charAt(0);
            boolean z = true;
            long j4 = -9223372036854775807L;
            if ((charAt < '0' ? 65535 : charAt == '0' ? (char) 0 : 1) >= 0) {
                z = false;
            } else if (length != 1) {
                if (charAt == '-') {
                    j4 = Long.MIN_VALUE;
                    i2 = 1;
                } else if (charAt == '+') {
                    z = false;
                    i2 = 1;
                }
            }
            long j5 = 0;
            long j6 = -256204778801521550L;
            while (true) {
                if (i2 < length) {
                    int digit = Character.digit((int) systemProp.charAt(i2), 10);
                    if (digit < 0) {
                        break;
                    }
                    if (j5 < j6) {
                        if (j6 != -256204778801521550L) {
                            break;
                        }
                        j6 = j4 / ((long) 10);
                        if (j5 < j6) {
                            break;
                        }
                    }
                    long j7 = j5 * ((long) 10);
                    long j8 = (long) digit;
                    if (j7 < j4 + j8) {
                        break;
                    }
                    j5 = j7 - j8;
                    i2++;
                } else {
                    if (!z) {
                        j5 = -j5;
                    }
                    l2 = Long.valueOf(j5);
                }
            }
        }
        l2 = null;
        if (l2 != null) {
            long longValue = l2.longValue();
            if (j2 <= longValue && j3 >= longValue) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
    }

    public static int systemProp$default(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return (int) systemProp(str, (long) i2, (long) i3, (long) i4);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final String toDebugString(Continuation<?> continuation) {
        Object obj;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            obj = continuation + '@' + getHexAddress(continuation);
        } catch (Throwable th) {
            obj = createFailure(th);
        }
        if (Result.m10exceptionOrNullimpl(obj) != null) {
            obj = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) obj;
    }

    public static final <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toList");
        int length = tArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length == 1) {
            return listOf(tArr[0]);
        }
        Intrinsics.checkNotNullParameter(tArr, "$this$toMutableList");
        Intrinsics.checkNotNullParameter(tArr, "$this$asCollection");
        return new ArrayList(new ArrayAsCollection(tArr, false));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toMap");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(m, "$this$putAll");
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            m.put(pair.first, pair.second);
        }
        return m;
    }

    public static int toMatrixData(ReadableArray readableArray, float[] fArr, float f) {
        int size = readableArray.size();
        if (size != 6) {
            return size;
        }
        fArr[0] = (float) readableArray.getDouble(0);
        fArr[1] = (float) readableArray.getDouble(2);
        fArr[2] = ((float) readableArray.getDouble(4)) * f;
        fArr[3] = (float) readableArray.getDouble(1);
        fArr[4] = (float) readableArray.getDouble(3);
        fArr[5] = ((float) readableArray.getDouble(5)) * f;
        return 6;
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <T> Object toState(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable r0 = Result.m10exceptionOrNullimpl(obj);
        if (r0 != null) {
            return new CompletedExceptionally(r0, false, 2);
        }
        if (function1 != null) {
            return new CompletedWithCancellation(obj, function1);
        }
        return obj;
    }

    public static Throwable tryInternalFastPathGetFailure(InternalFutureFailureAccess internalFutureFailureAccess) {
        AbstractFuture abstractFuture = (AbstractFuture) internalFutureFailureAccess;
        if (abstractFuture == null) {
            throw null;
        } else if (!(abstractFuture instanceof AbstractFuture.Trusted)) {
            return null;
        } else {
            Object obj = abstractFuture.value;
            if (obj instanceof AbstractFuture.Failure) {
                return ((AbstractFuture.Failure) obj).exception;
            }
            return null;
        }
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        if (!(aSN1Encodable instanceof ASN1String) || (aSN1Encodable instanceof DERUniversalString)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                byte[] encode = Hex.encode(aSN1Encodable.toASN1Primitive().getEncoded("DER"));
                int length = encode.length;
                char[] cArr = new char[length];
                for (int i3 = 0; i3 != length; i3++) {
                    cArr[i3] = (char) (encode[i3] & 255);
                }
                sb.append(new String(cArr));
                stringBuffer.append(sb.toString());
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((ASN1String) aSN1Encodable).getString();
            if (string.length() <= 0 || string.charAt(0) != '#') {
                stringBuffer.append(string);
            } else {
                stringBuffer.append("\\" + string);
            }
        }
        int length2 = stringBuffer.length();
        int i4 = 2;
        if (!(stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#')) {
            i4 = 0;
        }
        while (i4 != length2) {
            if (stringBuffer.charAt(i4) == ',' || stringBuffer.charAt(i4) == '\"' || stringBuffer.charAt(i4) == '\\' || stringBuffer.charAt(i4) == '+' || stringBuffer.charAt(i4) == '=' || stringBuffer.charAt(i4) == '<' || stringBuffer.charAt(i4) == '>' || stringBuffer.charAt(i4) == ';') {
                stringBuffer.insert(i4, "\\");
                i4++;
                length2++;
            }
            i4++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.length() > i2 && stringBuffer.charAt(i2) == ' ') {
                stringBuffer.insert(i2, "\\");
                i2 += 2;
            }
        }
        int length3 = stringBuffer.length() - 1;
        while (length3 >= 0 && stringBuffer.charAt(length3) == ' ') {
            stringBuffer.insert(length3, '\\');
            length3--;
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for r4v11, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object withContext(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object obj;
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        Job job = (Job) plus.get(Job.Key);
        if (job == null || job.isActive()) {
            if (plus == context) {
                ScopeCoroutine scopeCoroutine = new ScopeCoroutine(plus, continuation);
                obj = startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
            } else if (Intrinsics.areEqual((ContinuationInterceptor) plus.get(ContinuationInterceptor.Key), (ContinuationInterceptor) context.get(ContinuationInterceptor.Key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(plus, continuation);
                Object updateThreadContext = ThreadContextKt.updateThreadContext(plus, null);
                try {
                    Object startUndispatchedOrReturn = startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                    obj = startUndispatchedOrReturn;
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(plus, continuation);
                dispatchedCoroutine.initParentJob$kotlinx_coroutines_core();
                startCoroutineCancellable$default(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4);
                while (true) {
                    int i2 = dispatchedCoroutine._decision;
                    z = false;
                    if (i2 == 0) {
                        if (DispatchedCoroutine._decision$FU.compareAndSet(dispatchedCoroutine, 0, 1)) {
                            z = true;
                            break;
                        }
                    } else if (i2 != 2) {
                        throw new IllegalStateException("Already suspended".toString());
                    }
                }
                if (z) {
                    obj = coroutineSingletons;
                } else {
                    obj = JobSupportKt.unboxState(dispatchedCoroutine.getState$kotlinx_coroutines_core());
                    if (obj instanceof CompletedExceptionally) {
                        throw ((CompletedExceptionally) obj).cause;
                    }
                }
            }
            if (obj == coroutineSingletons) {
                Intrinsics.checkNotNullParameter(continuation, "frame");
            }
            return obj;
        }
        throw job.getCancellationException();
    }

    public static int floorMod(long j, int i2) {
        long j2 = (long) i2;
        return (int) (((j % j2) + j2) % j2);
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length > 0) {
            return asList(tArr);
        }
        return EmptyList.INSTANCE;
    }

    public static long safeAdd(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        throw new ArithmeticException("Addition overflows a long: " + j + " + " + j2);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 1;
        }
        if ((i2 & 8) != 0) {
            j3 = RecyclerView.FOREVER_NS;
        }
        return systemProp(str, j, j2, j3);
    }

    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        public final ScheduledExecutorService delegate;

        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements Object<V>, ListenableFuture {
            public final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.scheduledDelegate = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture
            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.scheduledDelegate.cancel(z);
                }
                return cancel;
            }

            public int compareTo(Object obj) {
                return this.scheduledDelegate.compareTo((Delayed) obj);
            }

            public long getDelay(TimeUnit timeUnit) {
                return this.scheduledDelegate.getDelay(timeUnit);
            }
        }

        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            public final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                if (runnable != null) {
                    this.delegate = runnable;
                    return;
                }
                throw null;
            }

            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th) {
                    setException(th);
                    Throwables.throwIfUnchecked(th);
                    throw new RuntimeException(th);
                }
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.delegate = scheduledExecutorService;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(callable);
            return new ListenableScheduledTask(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(Executors.callable(runnable, null));
            return new ListenableScheduledTask(trustedListenableFutureTask, this.delegate.schedule(trustedListenableFutureTask, j, timeUnit));
        }
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i2 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i2;
            }
            i2 = (i2 * 257) ^ iArr[length];
        }
    }

    public static boolean areEqual(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return true;
        }
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 != iArr.length; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static long safeMultiply(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + j2);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static double fromRelative(SVGLength sVGLength, double d, double d2, double d3, double d4) {
        double d5;
        if (sVGLength == null) {
            return d2;
        }
        SVGLength.UnitType unitType = sVGLength.unit;
        double d6 = sVGLength.value;
        switch (unitType.ordinal()) {
            case 1:
            case 5:
                d4 = 1.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 2:
                d5 = (d6 / 100.0d) * d;
                break;
            case 3:
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 4:
                d4 /= 2.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 6:
                d4 = 35.43307d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 7:
                d4 = 3.543307d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 8:
                d4 = 90.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 9:
                d4 = 1.25d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 10:
                d4 = 15.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            default:
                d5 = d6 * d3;
                break;
        }
        return d5 + d2;
    }
}
