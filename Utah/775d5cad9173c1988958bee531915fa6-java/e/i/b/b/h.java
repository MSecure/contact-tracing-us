package e.i.b.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import e.b.a.m;
import e.i.c.e;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class h {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final WeakHashMap<b, SparseArray<a>> b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    public static class a {
        public final ColorStateList a;
        public final Configuration b;

        public a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.b = configuration;
        }
    }

    public static final class b {
        public final Resources a;
        public final Resources.Theme b;

        public b(Resources resources, Resources.Theme theme) {
            this.a = resources;
            this.b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && Objects.equals(this.b, bVar.b);
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b);
        }
    }

    public static abstract class c {

        public class a implements Runnable {
            public final /* synthetic */ Typeface b;

            public a(Typeface typeface) {
                this.b = typeface;
            }

            public void run() {
                c.this.e(this.b);
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ int b;

            public b(int i2) {
                this.b = i2;
            }

            public void run() {
                c.this.d(this.b);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i2, Handler handler) {
            c(handler).post(new b(i2));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new a(typeface));
        }

        public abstract void d(int i2);

        public abstract void e(Typeface typeface);
    }

    public static Typeface a(Context context, int i2) {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i2, new TypedValue(), 0, null, null, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        if (r17 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
        if (r17 != null) goto L_0x007d;
     */
    public static Typeface b(Context context, int i2, TypedValue typedValue, int i3, c cVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                Typeface a2 = e.b.a(e.c(resources, i2, i3));
                if (a2 != null) {
                    if (cVar != null) {
                        cVar.b(a2, handler);
                    }
                    typeface = a2;
                } else if (!z2) {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            c Z0 = m.e.Z0(resources.getXml(i2), resources);
                            if (Z0 != null) {
                                typeface = e.a(context, Z0, resources, i2, i3, cVar, handler, z);
                            } else if (cVar != null) {
                                cVar.a(-3, handler);
                            }
                        } else {
                            Typeface b2 = e.b(context, resources, i2, charSequence2, i3);
                            if (cVar != null) {
                                if (b2 != null) {
                                    cVar.b(b2, handler);
                                } else {
                                    cVar.a(-3, handler);
                                }
                            }
                            typeface = b2;
                        }
                    } catch (IOException | XmlPullParserException unused) {
                    }
                }
                if (typeface == null || cVar != null || z2) {
                    return typeface;
                }
                StringBuilder h2 = f.a.a.a.a.h("Font resource ID #0x");
                h2.append(Integer.toHexString(i2));
                h2.append(" could not be retrieved.");
                throw new Resources.NotFoundException(h2.toString());
            }
            cVar.a(-3, handler);
            if (typeface == null) {
            }
            return typeface;
        }
        StringBuilder h3 = f.a.a.a.a.h("Resource \"");
        h3.append(resources.getResourceName(i2));
        h3.append("\" (");
        h3.append(Integer.toHexString(i2));
        h3.append(") is not a Font: ");
        h3.append(typedValue);
        throw new Resources.NotFoundException(h3.toString());
    }
}
