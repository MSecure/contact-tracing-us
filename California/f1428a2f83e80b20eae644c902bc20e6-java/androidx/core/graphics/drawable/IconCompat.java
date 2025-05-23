package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import f.a.a.a.a;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f144k = PorterDuff.Mode.SRC_IN;
    public int a = -1;
    public Object b;
    public byte[] c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f145d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f146e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f147f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f148g = null;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f149h = f144k;

    /* renamed from: i  reason: collision with root package name */
    public String f150i = null;

    /* renamed from: j  reason: collision with root package name */
    public String f151j;

    public IconCompat() {
    }

    public IconCompat(int i2) {
        this.a = i2;
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(Resources resources, String str, int i2) {
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f146e = i2;
            iconCompat.b = str;
            iconCompat.f151j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public int c() {
        int i2;
        int i3 = this.a;
        if (i3 == -1 && (i2 = Build.VERSION.SDK_INT) >= 23) {
            Icon icon = (Icon) this.b;
            if (i2 >= 28) {
                return icon.getResId();
            }
            try {
                return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Log.e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            }
        } else if (i3 == 2) {
            return this.f146e;
        } else {
            throw new IllegalStateException("called getResId() on " + this);
        }
    }

    public Uri d() {
        int i2;
        int i3 = this.a;
        if (i3 == -1 && (i2 = Build.VERSION.SDK_INT) >= 23) {
            Icon icon = (Icon) this.b;
            if (i2 >= 28) {
                return icon.getUri();
            }
            try {
                return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            }
        } else if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.b);
        } else {
            throw new IllegalStateException("called getUri() on " + this);
        }
    }

    @Deprecated
    public Icon e() {
        Icon icon;
        Bitmap bitmap;
        int i2 = Build.VERSION.SDK_INT;
        int i3 = this.a;
        String str = null;
        switch (i3) {
            case -1:
                return (Icon) this.b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                bitmap = (Bitmap) this.b;
                icon = Icon.createWithBitmap(bitmap);
                break;
            case 2:
                if (i3 == -1 && i2 >= 23) {
                    Icon icon2 = (Icon) this.b;
                    if (i2 >= 28) {
                        str = icon2.getResPackage();
                    } else {
                        try {
                            str = (String) icon2.getClass().getMethod("getResPackage", new Class[0]).invoke(icon2, new Object[0]);
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                            Log.e("IconCompat", "Unable to get icon package", e2);
                        }
                    }
                } else if (i3 == 2) {
                    str = this.f151j;
                } else {
                    throw new IllegalStateException("called getResPackage() on " + this);
                }
                icon = Icon.createWithResource(str, this.f146e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.b, this.f146e, this.f147f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.b);
                break;
            case 5:
                Bitmap bitmap2 = (Bitmap) this.b;
                if (i2 < 26) {
                    bitmap = a(bitmap2, false);
                    icon = Icon.createWithBitmap(bitmap);
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap(bitmap2);
                    break;
                }
            case 6:
                if (i2 >= 30) {
                    icon = Icon.createWithAdaptiveBitmapContentUri(d());
                    break;
                } else {
                    StringBuilder h2 = a.h("Context is required to resolve the file uri of the icon: ");
                    h2.append(d());
                    throw new IllegalArgumentException(h2.toString());
                }
        }
        ColorStateList colorStateList = this.f148g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f149h;
        if (mode == f144k) {
            return icon;
        }
        icon.setTintMode(mode);
        return icon;
    }

    public String toString() {
        String str;
        int i2;
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                i2 = ((Bitmap) this.b).getHeight();
                sb.append(i2);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f151j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f146e);
                if (this.f147f != 0) {
                    sb.append(" off=");
                    i2 = this.f147f;
                    sb.append(i2);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.f148g != null) {
            sb.append(" tint=");
            sb.append(this.f148g);
        }
        if (this.f149h != f144k) {
            sb.append(" mode=");
            sb.append(this.f149h);
        }
        sb.append(")");
        return sb.toString();
    }
}
