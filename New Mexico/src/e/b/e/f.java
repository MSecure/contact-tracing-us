package e.b.e;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import e.b.e.i.i;
import e.b.e.i.j;
import e.b.f.c1;
import e.b.f.i0;
import e.j.j.d;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class f extends MenuInflater {

    /* renamed from: e */
    public static final Class<?>[] f802e;

    /* renamed from: f */
    public static final Class<?>[] f803f;
    public final Object[] a;
    public final Object[] b;
    public Context c;

    /* renamed from: d */
    public Object f804d;

    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] c = {MenuItem.class};
        public Object a;
        public Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e2) {
                StringBuilder j2 = f.a.a.a.a.j("Couldn't resolve menu item onClick handler ", str, " in class ");
                j2.append(cls.getName());
                InflateException inflateException = new InflateException(j2.toString());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public d A;
        public CharSequence B;
        public CharSequence C;
        public Menu a;

        /* renamed from: h */
        public boolean f809h;

        /* renamed from: i */
        public int f810i;

        /* renamed from: j */
        public int f811j;

        /* renamed from: k */
        public CharSequence f812k;

        /* renamed from: l */
        public CharSequence f813l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;
        public int b = 0;
        public int c = 0;

        /* renamed from: d */
        public int f805d = 0;

        /* renamed from: e */
        public int f806e = 0;

        /* renamed from: f */
        public boolean f807f = true;

        /* renamed from: g */
        public boolean f808g = true;

        public b(Menu menu) {
            f.this = r1;
            this.a = menu;
        }

        public SubMenu a() {
            this.f809h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.b, this.f810i, this.f811j, this.f812k);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, f.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception unused) {
                return null;
            }
        }

        public final void c(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f813l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!f.this.c.isRestricted()) {
                    f fVar = f.this;
                    if (fVar.f804d == null) {
                        fVar.f804d = fVar.a(fVar.c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(fVar.f804d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    iVar.x = (iVar.x & -5) | 4;
                } else if (menuItem instanceof j) {
                    j jVar = (j) menuItem;
                    try {
                        if (jVar.f872e == null) {
                            jVar.f872e = jVar.f871d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        jVar.f872e.invoke(jVar.f871d, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) b(str, f.f802e, f.this.a));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0 && !z) {
                menuItem.setActionView(i3);
            }
            d dVar = this.A;
            if (dVar != null && (menuItem instanceof e.j.e.a.b)) {
                ((e.j.e.a.b) menuItem).a(dVar);
            }
            CharSequence charSequence = this.B;
            boolean z2 = menuItem instanceof e.j.e.a.b;
            if (z2) {
                ((e.j.e.a.b) menuItem).mo4setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z2) {
                ((e.j.e.a.b) menuItem).mo5setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c = this.n;
            int i4 = this.o;
            if (z2) {
                ((e.j.e.a.b) menuItem).setAlphabeticShortcut(c, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c, i4);
            }
            char c2 = this.p;
            int i5 = this.q;
            if (z2) {
                ((e.j.e.a.b) menuItem).setNumericShortcut(c2, i5);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i5);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (z2) {
                    ((e.j.e.a.b) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList == null) {
                return;
            }
            if (z2) {
                ((e.j.e.a.b) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f802e = clsArr;
        f803f = clsArr;
    }

    public f(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        char c;
        char c2;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(f.a.a.a.a.x("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            } else if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.b = 0;
                        bVar.c = 0;
                        bVar.f805d = 0;
                        bVar.f806e = 0;
                        bVar.f807f = true;
                        bVar.f808g = true;
                    } else if (name2.equals("item")) {
                        if (!bVar.f809h) {
                            d dVar = bVar.A;
                            if (dVar == null || !dVar.a()) {
                                bVar.f809h = true;
                                bVar.c(bVar.a.add(bVar.b, bVar.f810i, bVar.f811j, bVar.f812k));
                            } else {
                                bVar.a();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                    eventType = xmlPullParser.next();
                }
                eventType = xmlPullParser.next();
            } else {
                if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        TypedArray obtainStyledAttributes = f.this.c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        bVar.b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
                        bVar.c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
                        bVar.f805d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
                        bVar.f806e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
                        bVar.f807f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
                        bVar.f808g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        c1 p = c1.p(f.this.c, attributeSet, R$styleable.MenuItem);
                        bVar.f810i = p.l(R$styleable.MenuItem_android_id, 0);
                        bVar.f811j = (p.j(R$styleable.MenuItem_android_menuCategory, bVar.c) & -65536) | (p.j(R$styleable.MenuItem_android_orderInCategory, bVar.f805d) & 65535);
                        bVar.f812k = p.n(R$styleable.MenuItem_android_title);
                        bVar.f813l = p.n(R$styleable.MenuItem_android_titleCondensed);
                        bVar.m = p.l(R$styleable.MenuItem_android_icon, 0);
                        String m = p.m(R$styleable.MenuItem_android_alphabeticShortcut);
                        if (m == null) {
                            c = 0;
                        } else {
                            c = m.charAt(0);
                        }
                        bVar.n = c;
                        bVar.o = p.j(R$styleable.MenuItem_alphabeticModifiers, 4096);
                        String m2 = p.m(R$styleable.MenuItem_android_numericShortcut);
                        if (m2 == null) {
                            c2 = 0;
                        } else {
                            c2 = m2.charAt(0);
                        }
                        bVar.p = c2;
                        bVar.q = p.j(R$styleable.MenuItem_numericModifiers, 4096);
                        int i2 = R$styleable.MenuItem_android_checkable;
                        bVar.r = p.o(i2) ? p.a(i2, false) : bVar.f806e ? 1 : 0;
                        bVar.s = p.a(R$styleable.MenuItem_android_checked, false);
                        bVar.t = p.a(R$styleable.MenuItem_android_visible, bVar.f807f);
                        bVar.u = p.a(R$styleable.MenuItem_android_enabled, bVar.f808g);
                        bVar.v = p.j(R$styleable.MenuItem_showAsAction, -1);
                        bVar.z = p.m(R$styleable.MenuItem_android_onClick);
                        bVar.w = p.l(R$styleable.MenuItem_actionLayout, 0);
                        bVar.x = p.m(R$styleable.MenuItem_actionViewClass);
                        String m3 = p.m(R$styleable.MenuItem_actionProviderClass);
                        bVar.y = m3;
                        if ((m3 != null) && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (d) bVar.b(m3, f803f, f.this.b);
                        } else {
                            bVar.A = null;
                        }
                        bVar.B = p.n(R$styleable.MenuItem_contentDescription);
                        bVar.C = p.n(R$styleable.MenuItem_tooltipText);
                        int i3 = R$styleable.MenuItem_iconTintMode;
                        if (p.o(i3)) {
                            bVar.E = i0.e(p.j(i3, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        int i4 = R$styleable.MenuItem_iconTint;
                        if (p.o(i4)) {
                            bVar.D = p.c(i4);
                        } else {
                            bVar.D = null;
                        }
                        p.b.recycle();
                        bVar.f809h = false;
                    } else {
                        if (name3.equals("menu")) {
                            b(xmlPullParser, attributeSet, bVar.a());
                        } else {
                            z2 = true;
                            str = name3;
                        }
                        eventType = xmlPullParser.next();
                    }
                }
                eventType = xmlPullParser.next();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser] */
    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        XmlResourceParser xmlResourceParser = menu instanceof e.j.e.a.a;
        if (xmlResourceParser == 0) {
            super.inflate(i2, menu);
            return;
        }
        try {
            xmlResourceParser = 0;
            try {
                try {
                    xmlResourceParser = this.c.getResources().getLayout(i2);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
