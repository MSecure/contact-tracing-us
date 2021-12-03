package e.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.R$id;
import e.w.h;

public abstract class a0 extends h {
    public static final String[] z = {"android:visibility:visibility", "android:visibility:parent"};
    public int y = 3;

    public static class a extends AnimatorListenerAdapter implements h.d {
        public final View a;
        public final int b;
        public final ViewGroup c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1755d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1756e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1757f = false;

        public a(View view, int i2, boolean z) {
            this.a = view;
            this.b = i2;
            this.c = (ViewGroup) view.getParent();
            this.f1755d = z;
            g(true);
        }

        @Override // e.w.h.d
        public void a(h hVar) {
            g(false);
        }

        @Override // e.w.h.d
        public void b(h hVar) {
            g(true);
        }

        @Override // e.w.h.d
        public void c(h hVar) {
        }

        @Override // e.w.h.d
        public void d(h hVar) {
        }

        @Override // e.w.h.d
        public void e(h hVar) {
            f();
            hVar.v(this);
        }

        public final void f() {
            if (!this.f1757f) {
                s.a.f(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z) {
            ViewGroup viewGroup;
            if (this.f1755d && this.f1756e != z && (viewGroup = this.c) != null) {
                this.f1756e = z;
                r.a(viewGroup, z);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f1757f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f1757f) {
                s.a.f(this.a, this.b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f1757f) {
                s.a.f(this.a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static class b {
        public boolean a;
        public boolean b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1758d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f1759e;

        /* renamed from: f  reason: collision with root package name */
        public ViewGroup f1760f;
    }

    public final void H(p pVar) {
        pVar.a.put("android:visibility:visibility", Integer.valueOf(pVar.b.getVisibility()));
        pVar.a.put("android:visibility:parent", pVar.b.getParent());
        int[] iArr = new int[2];
        pVar.b.getLocationOnScreen(iArr);
        pVar.a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (r9 == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        if (r0.f1759e == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        if (r0.c == 0) goto L_0x0093;
     */
    public final b I(p pVar, p pVar2) {
        b bVar = new b();
        bVar.a = false;
        bVar.b = false;
        if (pVar == null || !pVar.a.containsKey("android:visibility:visibility")) {
            bVar.c = -1;
            bVar.f1759e = null;
        } else {
            bVar.c = ((Integer) pVar.a.get("android:visibility:visibility")).intValue();
            bVar.f1759e = (ViewGroup) pVar.a.get("android:visibility:parent");
        }
        if (pVar2 == null || !pVar2.a.containsKey("android:visibility:visibility")) {
            bVar.f1758d = -1;
            bVar.f1760f = null;
        } else {
            bVar.f1758d = ((Integer) pVar2.a.get("android:visibility:visibility")).intValue();
            bVar.f1760f = (ViewGroup) pVar2.a.get("android:visibility:parent");
        }
        if (pVar != null && pVar2 != null) {
            int i2 = bVar.c;
            int i3 = bVar.f1758d;
            if (i2 == i3 && bVar.f1759e == bVar.f1760f) {
                return bVar;
            }
            if (i2 != i3) {
                if (i2 != 0) {
                }
                bVar.b = false;
                bVar.a = true;
                return bVar;
            }
            if (bVar.f1760f != null) {
            }
            bVar.b = false;
            bVar.a = true;
            return bVar;
        } else if (!(pVar == null && bVar.f1758d == 0)) {
            if (pVar2 == null) {
            }
            return bVar;
        }
        bVar.b = true;
        bVar.a = true;
        return bVar;
    }

    public abstract Animator J(ViewGroup viewGroup, View view, p pVar, p pVar2);

    @Override // e.w.h
    public void d(p pVar) {
        H(pVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (I(n(r1, false), q(r1, false)).a != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f9  */
    @Override // e.w.h
    public Animator k(ViewGroup viewGroup, p pVar, p pVar2) {
        int i2;
        int i3;
        a0 a0Var;
        Animator J;
        z zVar;
        boolean z2;
        View view;
        View view2;
        boolean z3;
        boolean z4;
        boolean z5;
        Bitmap bitmap;
        ViewGroup viewGroup2;
        int i4;
        int round;
        Float f2;
        b I = I(pVar, pVar2);
        if (!I.a || (I.f1759e == null && I.f1760f == null)) {
            return null;
        }
        float f3 = 0.0f;
        boolean z6 = true;
        if (I.b) {
            if ((this.y & 1) == 1 && pVar2 != null) {
                if (pVar == null) {
                    View view3 = (View) pVar2.b.getParent();
                }
                View view4 = pVar2.b;
                c cVar = (c) this;
                float floatValue = (pVar == null || (f2 = (Float) pVar.a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f2.floatValue();
                if (floatValue != 1.0f) {
                    f3 = floatValue;
                }
                return cVar.K(view4, f3, 1.0f);
            }
            return null;
        }
        int i5 = I.f1758d;
        if ((this.y & 2) == 2 && pVar != null) {
            View view5 = pVar.b;
            View view6 = pVar2 != null ? pVar2.b : null;
            int i6 = R$id.save_overlay_view;
            ImageView imageView = (View) view5.getTag(i6);
            if (imageView != null) {
                i3 = i5;
                i2 = i6;
                view6 = null;
            } else {
                if (view6 == null || view6.getParent() == null) {
                    if (view6 != null) {
                        view = view6;
                        view6 = null;
                    }
                    view6 = null;
                    view = null;
                    z2 = true;
                    if (z2) {
                        if (view5.getParent() == null) {
                            i3 = i5;
                            imageView = view5;
                            i2 = i6;
                            z6 = false;
                        } else if (view5.getParent() instanceof View) {
                            View view7 = (View) view5.getParent();
                            if (!I(q(view7, true), n(view7, true)).a) {
                                boolean z7 = o.a;
                                Matrix matrix = new Matrix();
                                matrix.setTranslate((float) (-view7.getScrollX()), (float) (-view7.getScrollY()));
                                y yVar = s.a;
                                yVar.g(view5, matrix);
                                yVar.h(viewGroup, matrix);
                                RectF rectF = new RectF(0.0f, 0.0f, (float) view5.getWidth(), (float) view5.getHeight());
                                matrix.mapRect(rectF);
                                int round2 = Math.round(rectF.left);
                                int round3 = Math.round(rectF.top);
                                int round4 = Math.round(rectF.right);
                                int round5 = Math.round(rectF.bottom);
                                ImageView imageView2 = new ImageView(view5.getContext());
                                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                if (o.a) {
                                    z4 = !view5.isAttachedToWindow();
                                    if (viewGroup != null) {
                                        z3 = viewGroup.isAttachedToWindow();
                                        z5 = o.b;
                                        if (z5 || !z4) {
                                            view2 = view6;
                                            i3 = i5;
                                            i4 = 0;
                                            viewGroup2 = null;
                                        } else if (!z3) {
                                            i3 = i5;
                                            view2 = view6;
                                            i2 = i6;
                                            bitmap = null;
                                            if (bitmap != null) {
                                                imageView2.setImageBitmap(bitmap);
                                            }
                                            imageView2.measure(View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824), View.MeasureSpec.makeMeasureSpec(round5 - round3, 1073741824));
                                            imageView2.layout(round2, round3, round4, round5);
                                            imageView = imageView2;
                                        } else {
                                            view2 = view6;
                                            ViewGroup viewGroup3 = (ViewGroup) view5.getParent();
                                            int indexOfChild = viewGroup3.indexOfChild(view5);
                                            viewGroup.getOverlay().add(view5);
                                            viewGroup2 = viewGroup3;
                                            i3 = i5;
                                            i4 = indexOfChild;
                                        }
                                        i2 = i6;
                                        round = Math.round(rectF.width());
                                        int round6 = Math.round(rectF.height());
                                        if (round > 0 || round6 <= 0) {
                                            bitmap = null;
                                        } else {
                                            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round6)));
                                            int round7 = Math.round(((float) round) * min);
                                            int round8 = Math.round(((float) round6) * min);
                                            matrix.postTranslate(-rectF.left, -rectF.top);
                                            matrix.postScale(min, min);
                                            if (o.c) {
                                                Picture picture = new Picture();
                                                Canvas beginRecording = picture.beginRecording(round7, round8);
                                                beginRecording.concat(matrix);
                                                view5.draw(beginRecording);
                                                picture.endRecording();
                                                bitmap = Bitmap.createBitmap(picture);
                                            } else {
                                                bitmap = Bitmap.createBitmap(round7, round8, Bitmap.Config.ARGB_8888);
                                                Canvas canvas = new Canvas(bitmap);
                                                canvas.concat(matrix);
                                                view5.draw(canvas);
                                            }
                                        }
                                        if (z5 && z4) {
                                            viewGroup.getOverlay().remove(view5);
                                            viewGroup2.addView(view5, i4);
                                        }
                                        if (bitmap != null) {
                                        }
                                        imageView2.measure(View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824), View.MeasureSpec.makeMeasureSpec(round5 - round3, 1073741824));
                                        imageView2.layout(round2, round3, round4, round5);
                                        imageView = imageView2;
                                    }
                                } else {
                                    z4 = false;
                                }
                                z3 = false;
                                z5 = o.b;
                                if (z5) {
                                }
                                view2 = view6;
                                i3 = i5;
                                i4 = 0;
                                viewGroup2 = null;
                                i2 = i6;
                                round = Math.round(rectF.width());
                                int round62 = Math.round(rectF.height());
                                if (round > 0) {
                                }
                                bitmap = null;
                                viewGroup.getOverlay().remove(view5);
                                viewGroup2.addView(view5, i4);
                                if (bitmap != null) {
                                }
                                imageView2.measure(View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824), View.MeasureSpec.makeMeasureSpec(round5 - round3, 1073741824));
                                imageView2.layout(round2, round3, round4, round5);
                                imageView = imageView2;
                            } else {
                                i3 = i5;
                                view2 = view6;
                                i2 = i6;
                                int id = view7.getId();
                                imageView = view;
                                if (view7.getParent() == null) {
                                    imageView = view;
                                    if (id != -1) {
                                        viewGroup.findViewById(id);
                                        imageView = view;
                                    }
                                }
                            }
                            view6 = view2;
                            z6 = false;
                        }
                    }
                    i3 = i5;
                    view2 = view6;
                    i2 = i6;
                    imageView = view;
                    view6 = view2;
                    z6 = false;
                } else {
                    if (i5 == 4 || view5 == view6) {
                        view = null;
                    }
                    view6 = null;
                    view = null;
                    z2 = true;
                    if (z2) {
                    }
                    i3 = i5;
                    view2 = view6;
                    i2 = i6;
                    imageView = view;
                    view6 = view2;
                    z6 = false;
                }
                z2 = false;
                if (z2) {
                }
                i3 = i5;
                view2 = view6;
                i2 = i6;
                imageView = view;
                view6 = view2;
                z6 = false;
            }
            if (imageView != null) {
                if (!z6) {
                    int[] iArr = (int[]) pVar.a.get("android:visibility:screenLocation");
                    int i7 = iArr[0];
                    int i8 = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    imageView.offsetLeftAndRight((i7 - iArr2[0]) - imageView.getLeft());
                    imageView.offsetTopAndBottom((i8 - iArr2[1]) - imageView.getTop());
                    viewGroup.getOverlay().add(imageView);
                }
                a0Var = this;
                J = a0Var.J(viewGroup, imageView, pVar, pVar2);
                if (z6) {
                    return J;
                }
                if (J == null) {
                    viewGroup.getOverlay().remove(imageView);
                    return J;
                }
                view5.setTag(i2, imageView);
                zVar = new z(a0Var, viewGroup, imageView, view5);
            } else {
                a0Var = this;
                if (view6 != null) {
                    int visibility = view6.getVisibility();
                    y yVar2 = s.a;
                    yVar2.f(view6, 0);
                    J = a0Var.J(viewGroup, view6, pVar, pVar2);
                    if (J != null) {
                        a aVar = new a(view6, i3, true);
                        J.addListener(aVar);
                        J.addPauseListener(aVar);
                        zVar = aVar;
                    } else {
                        yVar2.f(view6, visibility);
                        return J;
                    }
                }
            }
            a0Var.a(zVar);
            return J;
        }
        return null;
    }

    @Override // e.w.h
    public String[] p() {
        return z;
    }

    @Override // e.w.h
    public boolean r(p pVar, p pVar2) {
        if (pVar == null && pVar2 == null) {
            return false;
        }
        if (pVar != null && pVar2 != null && pVar2.a.containsKey("android:visibility:visibility") != pVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b I = I(pVar, pVar2);
        if (I.a) {
            return I.c == 0 || I.f1758d == 0;
        }
        return false;
    }
}
