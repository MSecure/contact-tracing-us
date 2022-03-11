package e.i.i.w;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.accessibility.AccessibilityNodeInfo;
import e.i.i.w.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b {

    /* renamed from: d  reason: collision with root package name */
    public static int f1483d;
    public final AccessibilityNodeInfo a;
    public int b = -1;
    public int c = -1;

    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final a f1484e = new a(16, null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f1485f = new a(4096, null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f1486g = new a(8192, null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f1487h = new a(262144, null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f1488i = new a(524288, null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f1489j = new a(1048576, null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f1490k;

        /* renamed from: l  reason: collision with root package name */
        public static final a f1491l;
        public final Object a;
        public final int b;
        public final Class<? extends d.a> c;

        /* renamed from: d  reason: collision with root package name */
        public final d f1492d;

        static {
            new AccessibilityNodeInfo.AccessibilityAction(1, null);
            new AccessibilityNodeInfo.AccessibilityAction(2, null);
            new AccessibilityNodeInfo.AccessibilityAction(4, null);
            new AccessibilityNodeInfo.AccessibilityAction(8, null);
            new AccessibilityNodeInfo.AccessibilityAction(32, null);
            new AccessibilityNodeInfo.AccessibilityAction(64, null);
            new AccessibilityNodeInfo.AccessibilityAction(128, null);
            new AccessibilityNodeInfo.AccessibilityAction(256, null);
            new AccessibilityNodeInfo.AccessibilityAction(512, null);
            new AccessibilityNodeInfo.AccessibilityAction(1024, null);
            new AccessibilityNodeInfo.AccessibilityAction(2048, null);
            new AccessibilityNodeInfo.AccessibilityAction(16384, null);
            new AccessibilityNodeInfo.AccessibilityAction(32768, null);
            new AccessibilityNodeInfo.AccessibilityAction(65536, null);
            new AccessibilityNodeInfo.AccessibilityAction(131072, null);
            new AccessibilityNodeInfo.AccessibilityAction(2097152, null);
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908342, null);
            }
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908343, null);
            }
            f1490k = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908345, null);
            }
            f1491l = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908347, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908358, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908359, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908360, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908361, null);
            }
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908348, null);
            }
            if ((i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908349, null);
            }
            if ((i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908354, null);
            }
            if ((i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908356, null);
            }
            if ((i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908357, null);
            }
            if ((i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908362, null);
            }
            if ((i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908372, null);
            }
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, null, null, null);
        }

        public a(Object obj, int i2, CharSequence charSequence, d dVar, Class<? extends d.a> cls) {
            this.b = i2;
            this.f1492d = dVar;
            this.a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence) : obj;
            this.c = cls;
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.a;
            Object obj3 = ((a) obj).a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    /* renamed from: e.i.i.w.b$b  reason: collision with other inner class name */
    public static class C0035b {
        public final Object a;

        public C0035b(Object obj) {
            this.a = obj;
        }

        public static C0035b a(int i2, int i3, boolean z, int i4) {
            return new C0035b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4));
        }
    }

    public static class c {
        public final Object a;

        public c(Object obj) {
            this.a = obj;
        }

        public static c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
        }
    }

    public b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    public static String c(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                switch (i2) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public void a(a aVar) {
        this.a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.a);
    }

    public final List<Integer> b(String str) {
        ArrayList<Integer> integerArrayList = this.a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public CharSequence e() {
        return this.a.getContentDescription();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            if (bVar.a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(bVar.a)) {
            return false;
        }
        return this.c == bVar.c && this.b == bVar.b;
    }

    public Bundle f() {
        return this.a.getExtras();
    }

    public CharSequence g() {
        if (!(!b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())) {
            return this.a.getText();
        }
        List<Integer> b2 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> b3 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> b4 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> b5 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.a.getText(), 0, this.a.getText().length()));
        for (int i2 = 0; i2 < b2.size(); i2++) {
            spannableString.setSpan(new a(b5.get(i2).intValue(), this, f().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), b2.get(i2).intValue(), b3.get(i2).intValue(), b4.get(i2).intValue());
        }
        return spannableString;
    }

    public final void h(int i2, boolean z) {
        Bundle f2 = f();
        if (f2 != null) {
            int i3 = f2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            f2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i(Object obj) {
        this.a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C0035b) obj).a);
    }

    public void j(Object obj) {
        this.a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).a);
    }

    public void k(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setHintText(charSequence);
        } else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x014f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public String toString() {
        ?? r3;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        this.a.getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        this.a.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(this.a.getPackageName());
        sb.append("; className: ");
        sb.append(this.a.getClassName());
        sb.append("; text: ");
        sb.append(g());
        sb.append("; contentDescription: ");
        sb.append(e());
        sb.append("; viewId: ");
        sb.append(this.a.getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(this.a.isCheckable());
        sb.append("; checked: ");
        sb.append(this.a.isChecked());
        sb.append("; focusable: ");
        sb.append(this.a.isFocusable());
        sb.append("; focused: ");
        sb.append(this.a.isFocused());
        sb.append("; selected: ");
        sb.append(this.a.isSelected());
        sb.append("; clickable: ");
        sb.append(this.a.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.a.isLongClickable());
        sb.append("; enabled: ");
        sb.append(this.a.isEnabled());
        sb.append("; password: ");
        sb.append(this.a.isPassword());
        sb.append("; scrollable: " + this.a.isScrollable());
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.a.getActionList();
        if (actionList != null) {
            r3 = new ArrayList();
            int size = actionList.size();
            for (int i2 = 0; i2 < size; i2++) {
                r3.add(new a(actionList.get(i2), 0, null, null, null));
            }
        } else {
            r3 = Collections.emptyList();
        }
        for (int i3 = 0; i3 < r3.size(); i3++) {
            a aVar = (a) r3.get(i3);
            String c2 = c(aVar.a());
            if (c2.equals("ACTION_UNKNOWN") && ((AccessibilityNodeInfo.AccessibilityAction) aVar.a).getLabel() != null) {
                c2 = ((AccessibilityNodeInfo.AccessibilityAction) aVar.a).getLabel().toString();
            }
            sb.append(c2);
            if (i3 != r3.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
