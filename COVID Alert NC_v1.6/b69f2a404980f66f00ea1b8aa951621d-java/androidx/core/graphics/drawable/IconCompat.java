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
import androidx.versionedparcelable.CustomVersionedParcelable;
import c.a.a.a.a;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f137a = -1;

    /* renamed from: b  reason: collision with root package name */
    public Object f138b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f139c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f140d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f141e = 0;
    public int f = 0;
    public ColorStateList g = null;
    public PorterDuff.Mode h = j;
    public String i = null;

    public IconCompat() {
    }

    public IconCompat(int i2) {
        this.f137a = i2;
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
            iconCompat.f141e = i2;
            iconCompat.f138b = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public int c() {
        int i2 = this.f137a;
        if (i2 == -1) {
            int i3 = Build.VERSION.SDK_INT;
            Icon icon = (Icon) this.f138b;
            if (i3 >= 28) {
                return icon.getResId();
            }
            try {
                return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        } else if (i2 == 2) {
            return this.f141e;
        } else {
            throw new IllegalStateException("called getResId() on " + this);
        }
    }

    public String d() {
        int i2 = this.f137a;
        if (i2 == -1) {
            int i3 = Build.VERSION.SDK_INT;
            Icon icon = (Icon) this.f138b;
            if (i3 >= 28) {
                return icon.getResPackage();
            }
            try {
                return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        } else if (i2 == 2) {
            return ((String) this.f138b).split(":", -1)[0];
        } else {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
    }

    public Uri e() {
        int i2 = this.f137a;
        if (i2 == -1) {
            int i3 = Build.VERSION.SDK_INT;
            Icon icon = (Icon) this.f138b;
            if (i3 >= 28) {
                return icon.getUri();
            }
            try {
                return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        } else if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f138b);
        } else {
            throw new IllegalStateException("called getUri() on " + this);
        }
    }

    @Deprecated
    public Icon f() {
        Icon icon;
        Bitmap bitmap;
        switch (this.f137a) {
            case -1:
                return (Icon) this.f138b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                bitmap = (Bitmap) this.f138b;
                icon = Icon.createWithBitmap(bitmap);
                break;
            case 2:
                icon = Icon.createWithResource(d(), this.f141e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.f138b, this.f141e, this.f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.f138b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    bitmap = a((Bitmap) this.f138b, false);
                    icon = Icon.createWithBitmap(bitmap);
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f138b);
                    break;
                }
            case 6:
                StringBuilder g2 = a.g("Context is required to resolve the file uri of the icon: ");
                g2.append(e());
                throw new IllegalArgumentException(g2.toString());
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.h;
        if (mode == j) {
            return icon;
        }
        icon.setTintMode(mode);
        return icon;
    }

    public String toString() {
        String str;
        int i2;
        if (this.f137a == -1) {
            return String.valueOf(this.f138b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f137a) {
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
        switch (this.f137a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f138b).getWidth());
                sb.append("x");
                i2 = ((Bitmap) this.f138b).getHeight();
                sb.append(i2);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(d());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f141e);
                if (this.f != 0) {
                    sb.append(" off=");
                    i2 = this.f;
                    sb.append(i2);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f138b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != j) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }
}
