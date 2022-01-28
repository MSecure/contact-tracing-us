package com.facebook.react.uimanager;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.RecentlyNonNull;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEventType;
import com.facebook.react.views.image.ScaleTypeStartInside;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollCommandHandler;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollToCommandData;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper$ScrollToEndCommandData;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.ReactFontManager;
import com.facebook.soloader.MinElf$ElfError;
import com.facebook.yoga.YogaConfigJNIBase;
import com.facebook.yoga.YogaMeasureMode;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.WebSocketProtocol;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class ReactYogaConfigProvider {
    public static YogaConfigJNIBase YOGA_CONFIG;
    public static Boolean zza;
    public static Boolean zzc;
    public static Boolean zzd;
    public static Boolean zzf;
    public static Boolean zzg;

    public static Typeface applyStyles(Typeface typeface, int i, int i2, String str, AssetManager assetManager) {
        int i3 = 0;
        int style = typeface == null ? 0 : typeface.getStyle();
        if (i2 == 1 || ((style & 1) != 0 && i2 == -1)) {
            i3 = 1;
        }
        if (i == 2 || ((style & 2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            typeface = ReactFontManager.getInstance().getTypeface(str, i3, i2, assetManager);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i3);
        }
        if (typeface != null) {
            return typeface;
        }
        return Typeface.defaultFromStyle(i3);
    }

    public static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("negative size: ", i2));
        }
    }

    @RecentlyNonNull
    public static int beginObjectHeader(@RecentlyNonNull Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static long canonicalYearMonthDay(long j) {
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    public static void checkArgument(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument1(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument2(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = lenientFormat("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 >= 0) {
            str = lenientFormat("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("negative size: ", i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static void checkHandlerThread(@RecentlyNonNull Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 36);
            sb.append("Must be called on ");
            sb.append(name2);
            sb.append(" thread, but got ");
            sb.append(name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    public static int checkNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    @RecentlyNonNull
    public static String checkNotEmpty(@RecentlyNonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static <T> T checkNotNull1(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T checkNotNull2(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = badPositionIndex(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = badPositionIndex(i2, i3, "end index");
            } else {
                str = lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void checkState(@RecentlyNonNull boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @RecentlyNonNull
    public static Bundle createBundle(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + readSize);
        return readBundle;
    }

    @RecentlyNonNull
    public static byte[] createByteArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createByteArray;
    }

    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo(f, f2, f3));
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f, (int) f2, revealInfo.radius, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static CornerTreatment createCornerTreatment(int i) {
        if (i == 0) {
            return new RoundedCornerTreatment();
        }
        if (i != 1) {
            return new RoundedCornerTreatment();
        }
        return new CutCornerTreatment();
    }

    @RecentlyNonNull
    public static ArrayList<Double> createDoubleList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @RecentlyNonNull
    public static int[] createIntArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createIntArray;
    }

    @RecentlyNonNull
    public static ArrayList<Integer> createIntegerList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T createParcelable(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return createFromParcel;
    }

    @RecentlyNonNull
    public static String createString(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    @RecentlyNonNull
    public static <T> T[] createTypedArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return tArr;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> createTypedList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArrayList;
    }

    public static float dist(float f, float f2, float f3, float f4) {
        return (float) Math.hypot((double) (f3 - f), (double) (f4 - f2));
    }

    public static void dumbDeleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    dumbDeleteRecursive(file2);
                }
            } else {
                return;
            }
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("could not delete: " + file);
        }
    }

    public static void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            getEventDispatcherForReactTag((ReactContext) viewGroup.getContext(), viewGroup.getId()).dispatchEvent(ScrollEvent.obtain(viewGroup.getId(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), f, f2, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
        }
    }

    public static void ensureAtEnd(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i);
            throw new SafeParcelReader$ParseException(sb.toString(), parcel);
        }
    }

    @RecentlyNonNull
    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean equal1(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j;
        long j2;
        String str;
        long j3;
        String str2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel, allocate, 0) == 1179403647) {
            boolean z = true;
            if (getu8(fileChannel, allocate, 4) != 1) {
                z = false;
            }
            if (getu8(fileChannel, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long r15 = z ? getu32(fileChannel, allocate, 28) : get64(fileChannel, allocate, 32);
            long j11 = z ? (long) getu16(fileChannel, allocate, 44) : (long) getu16(fileChannel, allocate, 56);
            int i = getu16(fileChannel, allocate, z ? 42 : 54);
            if (j11 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                long r3 = z ? getu32(fileChannel, allocate, 32) : get64(fileChannel, allocate, 40);
                if (z) {
                    j10 = getu32(fileChannel, allocate, r3 + 28);
                } else {
                    j10 = getu32(fileChannel, allocate, r3 + 44);
                }
                j11 = j10;
            }
            long j12 = r15;
            long j13 = 0;
            while (true) {
                if (j13 >= j11) {
                    j = 0;
                    break;
                }
                if (z) {
                    j9 = getu32(fileChannel, allocate, j12 + 0);
                } else {
                    j9 = getu32(fileChannel, allocate, j12 + 0);
                }
                if (j9 == 2) {
                    j = z ? getu32(fileChannel, allocate, j12 + 4) : get64(fileChannel, allocate, j12 + 8);
                } else {
                    j12 += (long) i;
                    j13++;
                }
            }
            long j14 = 0;
            if (j != 0) {
                long j15 = j;
                long j16 = 0;
                int i2 = 0;
                while (true) {
                    long r7 = z ? getu32(fileChannel, allocate, j15 + j14) : get64(fileChannel, allocate, j15 + j14);
                    String str3 = "malformed DT_NEEDED section";
                    if (r7 == 1) {
                        if (i2 != Integer.MAX_VALUE) {
                            i2++;
                            j2 = r7;
                        } else {
                            throw new MinElf$ElfError(str3);
                        }
                    } else if (r7 == 5) {
                        if (z) {
                            j2 = r7;
                            j8 = getu32(fileChannel, allocate, j15 + 4);
                        } else {
                            j2 = r7;
                            j8 = get64(fileChannel, allocate, j15 + 8);
                        }
                        j16 = j8;
                    } else {
                        j2 = r7;
                    }
                    long j17 = 16;
                    j15 += z ? 8 : 16;
                    j14 = 0;
                    if (j2 != 0) {
                        z = z;
                        j = j;
                    } else if (j16 != 0) {
                        int i3 = 0;
                        while (true) {
                            if (((long) i3) >= j11) {
                                str = str3;
                                j3 = 0;
                                break;
                            }
                            if (z) {
                                j4 = getu32(fileChannel, allocate, r15 + j14);
                            } else {
                                j4 = getu32(fileChannel, allocate, r15 + j14);
                            }
                            if (j4 == 1) {
                                if (z) {
                                    j5 = getu32(fileChannel, allocate, r15 + 8);
                                } else {
                                    j5 = get64(fileChannel, allocate, r15 + j17);
                                }
                                if (z) {
                                    str = str3;
                                    j6 = getu32(fileChannel, allocate, r15 + 20);
                                } else {
                                    str = str3;
                                    j6 = get64(fileChannel, allocate, r15 + 40);
                                }
                                if (j5 <= j16 && j16 < j6 + j5) {
                                    if (z) {
                                        j7 = getu32(fileChannel, allocate, r15 + 4);
                                    } else {
                                        j7 = get64(fileChannel, allocate, r15 + 8);
                                    }
                                    j3 = j7 + (j16 - j5);
                                }
                            } else {
                                str = str3;
                            }
                            r15 += (long) i;
                            i3++;
                            str3 = str;
                            j17 = 16;
                            j14 = 0;
                        }
                        long j18 = 0;
                        if (j3 != 0) {
                            String[] strArr = new String[i2];
                            long j19 = j;
                            int i4 = 0;
                            while (true) {
                                long j20 = j19 + j18;
                                long r11 = z ? getu32(fileChannel, allocate, j20) : get64(fileChannel, allocate, j20);
                                if (r11 == 1) {
                                    long r6 = (z ? getu32(fileChannel, allocate, j19 + 4) : get64(fileChannel, allocate, j19 + 8)) + j3;
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        long j21 = r6 + 1;
                                        short u8Var = getu8(fileChannel, allocate, r6);
                                        if (u8Var == 0) {
                                            break;
                                        }
                                        sb.append((char) u8Var);
                                        r6 = j21;
                                    }
                                    strArr[i4] = sb.toString();
                                    if (i4 != Integer.MAX_VALUE) {
                                        i4++;
                                        str2 = str;
                                    } else {
                                        throw new MinElf$ElfError(str);
                                    }
                                } else {
                                    str2 = str;
                                }
                                j19 += z ? 8 : 16;
                                if (r11 != 0) {
                                    str = str2;
                                    j18 = 0;
                                } else if (i4 == i2) {
                                    return strArr;
                                } else {
                                    throw new MinElf$ElfError(str2);
                                }
                            }
                        } else {
                            throw new MinElf$ElfError("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new MinElf$ElfError("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new MinElf$ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new MinElf$ElfError("file is not ELF");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        throw r1;
     */
    public static void fsyncRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    fsyncRecursive(file2);
                }
                return;
            }
            throw new IOException("cannot list directory " + file);
        } else if (!file.getPath().endsWith("_lock")) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        }
    }

    public static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    public static Map getBubblingEventTypeConstants() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put("topChange", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onChange", "captured", "onChangeCapture")));
        builder.put("topSelect", AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onSelect", "captured", "onSelectCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.START), AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onTouchStart", "captured", "onTouchStartCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.MOVE), AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.END), AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture")));
        builder.put(TouchEventType.getJSEventName(TouchEventType.CANCEL), AppCompatDelegateImpl.ConfigurationImplApi17.of("phasedRegistrationNames", AppCompatDelegateImpl.ConfigurationImplApi17.of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture")));
        return builder.build();
    }

    public static int getColor(Context context, int i, int i2) {
        TypedValue resolve = resolve(context, i);
        return resolve != null ? resolve.data : i2;
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateList;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return typedArray.getColorStateList(i);
        }
        return colorStateList;
    }

    public static Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("UIView", AppCompatDelegateImpl.ConfigurationImplApi17.of("ContentMode", AppCompatDelegateImpl.ConfigurationImplApi17.of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        hashMap.put("StyleConstants", AppCompatDelegateImpl.ConfigurationImplApi17.of("PointerEventsValues", AppCompatDelegateImpl.ConfigurationImplApi17.of("none", 0, "boxNone", 1, "boxOnly", 2, "unspecified", 3)));
        hashMap.put("PopupMenu", AppCompatDelegateImpl.ConfigurationImplApi17.of(DialogModule.ACTION_DISMISSED, DialogModule.ACTION_DISMISSED, "itemSelected", "itemSelected"));
        hashMap.put("AccessibilityEventTypes", AppCompatDelegateImpl.ConfigurationImplApi17.of("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return hashMap;
    }

    public static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    public static ColorStateList getDefaultTextAttribute(Context context, int i) {
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(new int[]{i});
            ColorStateList colorStateList = typedArray.getColorStateList(0);
            typedArray.recycle();
            return colorStateList;
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public static Map getDirectEventTypeConstants() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put("topContentSizeChange", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onContentSizeChange"));
        builder.put("topLayout", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onLayout"));
        builder.put("topLoadingError", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onLoadingError"));
        builder.put("topLoadingFinish", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onLoadingFinish"));
        builder.put("topLoadingStart", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onLoadingStart"));
        builder.put("topSelectionChange", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onSelectionChange"));
        builder.put("topMessage", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onMessage"));
        builder.put("topClick", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onClick"));
        builder.put("topScrollBeginDrag", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onScrollBeginDrag"));
        builder.put("topScrollEndDrag", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onScrollEndDrag"));
        builder.put("topScroll", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onScroll"));
        builder.put("topMomentumScrollBegin", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onMomentumScrollBegin"));
        builder.put("topMomentumScrollEnd", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onMomentumScrollEnd"));
        return builder.build();
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        if (future.isDone()) {
            while (true) {
                try {
                    v = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return v;
        }
        throw new IllegalStateException(lenientFormat("Future was expected to be done: %s", future));
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawable;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) {
            return typedArray.getDrawable(i);
        }
        return drawable;
    }

    public static EventDispatcher getEventDispatcherForReactTag(ReactContext reactContext, int i) {
        UIManager uIManager = getUIManager(reactContext, getUIManagerType(i), false);
        if (uIManager == null) {
            return null;
        }
        return (EventDispatcher) uIManager.getEventDispatcher();
    }

    public static int getMeasureSpec(float f, YogaMeasureMode yogaMeasureMode) {
        if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
            return View.MeasureSpec.makeMeasureSpec((int) f, 1073741824);
        }
        if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
            return View.MeasureSpec.makeMeasureSpec((int) f, RecyclerView.UNDEFINED_DURATION);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public static ReactContext getReactContext(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static RootView getRootView(View view) {
        while (!(view instanceof RootView)) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return null;
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(parent instanceof View);
            view = (View) parent;
        }
        return (RootView) view;
    }

    public static String getStatusCodeString(@RecentlyNonNull int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    public static TimeZone getTimeZone() {
        return TimeZone.getTimeZone("UTC");
    }

    public static Calendar getTodayCalendar() {
        return getDayCopy(Calendar.getInstance());
    }

    public static UIManager getUIManager(ReactContext reactContext, int i) {
        return getUIManager(reactContext, i, true);
    }

    public static int getUIManagerType(int i) {
        return i % 2 == 0 ? 2 : 1;
    }

    public static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    public static Calendar getUtcCalendarOf(Calendar calendar) {
        Calendar instance = Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    public static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & 65535;
    }

    public static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    @RecentlyNonNull
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isUndefined(float f) {
        return Float.compare(f, Float.NaN) == 0;
    }

    @RecentlyNonNull
    @TargetApi(20)
    public static boolean isWearable(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzc == null) {
            zzc = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zzc.booleanValue();
    }

    @RecentlyNonNull
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(@RecentlyNonNull Context context) {
        if (isWearable(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (zzd == null) {
                    zzd = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!zzd.booleanValue() || isAtLeastO()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int layer(int i, int i2, float f) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, Math.round(((float) Color.alpha(i2)) * f)), i);
    }

    public static String lenientFormat(String str, Object... objArr) {
        int indexOf;
        String str2;
        String valueOf = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String str3 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str3, (Throwable) e);
                    str2 = "<" + str3 + " threw " + e.getClass().getName() + ">";
                }
            }
            objArr[i2] = str2;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static float lerp(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static long make(float f, float f2) {
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        return ((long) Float.floatToRawIntBits(f2)) | (((long) floatToRawIntBits) << 32);
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static void notifyNativeGestureStarted(View view, MotionEvent motionEvent) {
        getRootView(view).onChildStartedNativeGesture(motionEvent);
    }

    public static int parseFontStyle(String str) {
        if ("italic".equals(str)) {
            return 2;
        }
        return "normal".equals(str) ? 0 : -1;
    }

    public static String parseFontVariant(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                char c = 65535;
                switch (string.hashCode()) {
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    arrayList.add("'smcp'");
                } else if (c == 1) {
                    arrayList.add("'onum'");
                } else if (c == 2) {
                    arrayList.add("'lnum'");
                } else if (c == 3) {
                    arrayList.add("'tnum'");
                } else if (c == 4) {
                    arrayList.add("'pnum'");
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static int parseFontWeight(String str) {
        int charAt = (str == null || str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - '0') * 100;
        if (charAt == -1) {
            charAt = 0;
        }
        if (charAt == 700 || "bold".equals(str)) {
            return 1;
        }
        if (charAt == 400 || "normal".equals(str)) {
            return 0;
        }
        return charAt;
    }

    public static int parseOverScrollMode(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals("always")) {
            return 0;
        }
        if (str.equals("never")) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("wrong overScrollMode: ", str));
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j)) != -1) {
            j += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new MinElf$ElfError("ELF file truncated");
    }

    @RecentlyNonNull
    public static boolean readBoolean(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        zza(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    @RecentlyNonNull
    public static double readDouble(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        zza(parcel, i, 8);
        return parcel.readDouble();
    }

    @RecentlyNonNull
    public static IBinder readIBinder(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + readSize);
        return readStrongBinder;
    }

    @RecentlyNonNull
    public static int readInt(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        zza(parcel, i, 4);
        return parcel.readInt();
    }

    @RecentlyNonNull
    public static long readLong(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        zza(parcel, i, 8);
        return parcel.readLong();
    }

    @RecentlyNonNull
    public static int readSize(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        return (i & -65536) != -65536 ? (i >> 16) & Settings.DEFAULT_INITIAL_WINDOW_SIZE : parcel.readInt();
    }

    public static <T> void receiveCommand(ReactScrollViewCommandHelper$ScrollCommandHandler<T> reactScrollViewCommandHelper$ScrollCommandHandler, T t, int i, ReadableArray readableArray) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactScrollViewCommandHelper$ScrollCommandHandler);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(t);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray);
        if (i == 1) {
            scrollTo(reactScrollViewCommandHelper$ScrollCommandHandler, t, readableArray);
        } else if (i == 2) {
            reactScrollViewCommandHelper$ScrollCommandHandler.scrollToEnd(t, new ReactScrollViewCommandHelper$ScrollToEndCommandData(readableArray.getBoolean(0)));
        } else if (i == 3) {
            reactScrollViewCommandHelper$ScrollCommandHandler.flashScrollIndicators(t);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), reactScrollViewCommandHelper$ScrollCommandHandler.getClass().getSimpleName()));
        }
    }

    public static TypedValue resolve(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i, boolean z) {
        TypedValue resolve = resolve(context, i);
        if (resolve == null || resolve.type != 18) {
            return z;
        }
        return resolve.data != 0;
    }

    public static int resolveOrThrow(Context context, int i, String str) {
        TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            return resolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static <T> void scrollTo(ReactScrollViewCommandHelper$ScrollCommandHandler<T> reactScrollViewCommandHelper$ScrollCommandHandler, T t, ReadableArray readableArray) {
        reactScrollViewCommandHelper$ScrollCommandHandler.scrollTo(t, new ReactScrollViewCommandHelper$ScrollToCommandData(Math.round(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableArray.getDouble(0))), Math.round(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
    }

    public static void setElevation(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) background;
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.elevation != f) {
                materialShapeDrawableState.elevation = f;
                materialShapeDrawable.updateZ();
            }
        }
    }

    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawable.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider != null && elevationOverlayProvider.elevationOverlayEnabled) {
            float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                f += ViewCompat.getElevation((View) parent);
            }
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.parentAbsoluteElevation != f) {
                materialShapeDrawableState.parentAbsoluteElevation = f;
                materialShapeDrawable.updateZ();
            }
        }
    }

    public static void skipUnknownField(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
    }

    public static float[] toFloatArray(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        float[] fArr = new float[readableArray.size()];
        toFloatArray(readableArray, fArr);
        return fArr;
    }

    public static ScalingUtils$ScaleType toScaleType(String str) {
        if ("contain".equals(str)) {
            return ScalingUtils$ScaleType.FIT_CENTER;
        }
        if ("cover".equals(str)) {
            return ScalingUtils$ScaleType.CENTER_CROP;
        }
        if ("stretch".equals(str)) {
            return ScalingUtils$ScaleType.FIT_XY;
        }
        if ("center".equals(str)) {
            return ScalingUtils$ScaleType.CENTER_INSIDE;
        }
        if ("repeat".equals(str)) {
            return ScaleTypeStartInside.INSTANCE;
        }
        if (str == null) {
            return ScalingUtils$ScaleType.CENTER_CROP;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline9("Invalid resize mode: '", str, "'"));
    }

    @RecentlyNonNull
    public static Objects$ToStringHelper toStringHelper(@RecentlyNonNull Object obj) {
        return new Objects$ToStringHelper(obj, null);
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

    @RecentlyNonNull
    public static <ResultT> boolean trySetResultOrApiException(@RecentlyNonNull Status status, ResultT resultt, @RecentlyNonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            return taskCompletionSource.trySetResult(resultt);
        }
        return taskCompletionSource.trySetException(new ApiException(status));
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    @RecentlyNonNull
    public static int validateObjectHeader(@RecentlyNonNull Parcel parcel) {
        int readInt = parcel.readInt();
        int readSize = readSize(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new SafeParcelReader$ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = readSize + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new SafeParcelReader$ParseException(sb.toString(), parcel);
    }

    public static void writeBoolean(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull boolean z) {
        zza1(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeByteArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull byte[] bArr, @RecentlyNonNull boolean z) {
        if (bArr != null) {
            int zza2 = zza(parcel, i);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static void writeDouble(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull double d) {
        zza1(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Double> list, @RecentlyNonNull boolean z) {
        int zza2 = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeDouble(list.get(i2).doubleValue());
        }
        zzb(parcel, zza2);
    }

    public static void writeIBinder(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull boolean z) {
        if (iBinder != null) {
            int zza2 = zza(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static void writeInt(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zza1(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull int[] iArr, @RecentlyNonNull boolean z) {
        if (iArr != null) {
            int zza2 = zza(parcel, i);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static void writeIntegerList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Integer> list, @RecentlyNonNull boolean z) {
        int zza2 = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        zzb(parcel, zza2);
    }

    public static void writeLong(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull long j) {
        zza1(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeParcelable(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable parcelable, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (parcelable != null) {
            int zza2 = zza(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static void writeString(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
        if (str != null) {
            int zza2 = zza(parcel, i);
            parcel.writeString(str);
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull T[] tArr, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (tArr != null) {
            int zza2 = zza(parcel, i);
            int length = tArr.length;
            parcel.writeInt(length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, t, i2);
                }
            }
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<T> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza2 = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                T t = list.get(i2);
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, t, 0);
                }
            }
            zzb(parcel, zza2);
        } else if (z) {
            zza1(parcel, i, 0);
        }
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zza1(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    public static void zzb(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void checkArgument(@RecentlyNonNull boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static UIManager getUIManager(ReactContext reactContext, int i, boolean z) {
        if (reactContext.isBridgeless()) {
            return (UIManager) reactContext.getJSIModule(JSIModuleType.UIManager);
        }
        if (!reactContext.hasCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain a CatalystInstance."));
            return null;
        }
        if (!reactContext.hasActiveCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain an active CatalystInstance."));
            if (z) {
                return null;
            }
        }
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (i == 2) {
            return (UIManager) catalystInstance.getJSIModule(JSIModuleType.UIManager);
        }
        return (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
    }

    public static String zza(String str, Object... objArr) {
        int indexOf;
        String str2;
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String sb2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
                    String name2 = e.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(name2.length() + String.valueOf(sb2).length() + 9);
                    sb3.append("<");
                    sb3.append(sb2);
                    sb3.append(" threw ");
                    sb3.append(name2);
                    sb3.append(">");
                    str2 = sb3.toString();
                }
            }
            objArr[i2] = str2;
        }
        StringBuilder sb4 = new StringBuilder((objArr.length * 16) + str.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = str.indexOf("%s", i3)) != -1) {
            sb4.append((CharSequence) str, i3, indexOf);
            sb4.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb4.append((CharSequence) str, i3, str.length());
        if (i < objArr.length) {
            sb4.append(" [");
            sb4.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb4.append(", ");
                sb4.append(objArr[i4]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }

    public static void checkArgument(@RecentlyNonNull boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int getColor(View view, int i) {
        return resolveOrThrow(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static long make(int i, int i2) {
        return make((float) i, (float) i2);
    }

    public static int toFloatArray(ReadableArray readableArray, float[] fArr) {
        int length = readableArray.size() > fArr.length ? fArr.length : readableArray.size();
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        return readableArray.size();
    }

    public static void checkArgument(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(lenientFormat(str, obj));
        }
    }

    public static ColorStateList getColorStateList(Context context, TintTypedArray tintTypedArray, int i) {
        int resourceId;
        ColorStateList colorStateList;
        if (!tintTypedArray.mWrapped.hasValue(i) || (resourceId = tintTypedArray.mWrapped.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return tintTypedArray.getColorStateList(i);
        }
        return colorStateList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    public static <T> void receiveCommand(ReactScrollViewCommandHelper$ScrollCommandHandler<T> reactScrollViewCommandHelper$ScrollCommandHandler, T t, String str, ReadableArray readableArray) {
        char c;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactScrollViewCommandHelper$ScrollCommandHandler);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(t);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray);
        int hashCode = str.hashCode();
        if (hashCode != -402165208) {
            if (hashCode != 28425985) {
                if (hashCode == 2055114131 && str.equals("scrollToEnd")) {
                    c = 1;
                    if (c != 0) {
                        scrollTo(reactScrollViewCommandHelper$ScrollCommandHandler, t, readableArray);
                        return;
                    } else if (c == 1) {
                        reactScrollViewCommandHelper$ScrollCommandHandler.scrollToEnd(t, new ReactScrollViewCommandHelper$ScrollToEndCommandData(readableArray.getBoolean(0)));
                        return;
                    } else if (c == 2) {
                        reactScrollViewCommandHelper$ScrollCommandHandler.flashScrollIndicators(t);
                        return;
                    } else {
                        throw new IllegalArgumentException(String.format("Unsupported command %s received by %s.", str, reactScrollViewCommandHelper$ScrollCommandHandler.getClass().getSimpleName()));
                    }
                }
            } else if (str.equals("flashScrollIndicators")) {
                c = 2;
                if (c != 0) {
                }
            }
        } else if (str.equals("scrollTo")) {
            c = 0;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    public static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static int zza(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str = zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static void zza(Parcel parcel, int i, int i2) {
        int readSize = readSize(parcel, i);
        if (readSize != i2) {
            String hexString = Integer.toHexString(readSize);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(readSize);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new SafeParcelReader$ParseException(sb.toString(), parcel);
        }
    }

    public static String zza(int i, int i2, String str) {
        if (i < 0) {
            return zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void zza(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = zza(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = zza(i2, i3, "end index");
            } else {
                str = zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static <T extends Parcelable> void zza(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
