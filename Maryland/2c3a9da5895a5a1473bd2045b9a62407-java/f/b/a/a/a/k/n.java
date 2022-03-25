package f.b.a.a.a.k;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.m.a.f0;
import e.m.a.k;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import f.a.a.a.a;
import f.b.a.a.a.h.r;
import f.b.a.a.a.i.l;
import f.b.a.a.a.j.j;
import f.b.a.a.a.v.d;
import f.b.a.a.a.y.q0;
import gov.md.covid19.exposurenotifications.R;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class n extends q {
    public static final /* synthetic */ int h0 = 0;
    public l a0;
    public f0 b0;
    public ExposureNotificationViewModel c0;
    public ExposureHomeViewModel d0;
    public Animation e0;
    public Animation f0;
    public Animation g0;

    public final void A0(d dVar, ExposureNotificationViewModel.a aVar, boolean z) {
        LinearLayout linearLayout;
        int i2;
        ExposureNotificationViewModel.a aVar2 = ExposureNotificationViewModel.a.ENABLED;
        if (this.F != null) {
            l lVar = this.a0;
            ViewFlipper viewFlipper = lVar.f2110h;
            ViewFlipper viewFlipper2 = lVar.f2109g;
            ViewFlipper viewFlipper3 = lVar.f2112j;
            TextView textView = lVar.c;
            TextView textView2 = lVar.f2108f;
            TextView textView3 = lVar.f2107e;
            int i3 = 8;
            if (dVar.b() != 0 || z) {
                viewFlipper.setVisibility(aVar == aVar2 ? 8 : 0);
                viewFlipper2.setDisplayedChild(1);
                viewFlipper2.setVisibility(0);
                long a = dVar.a();
                Locale locale = v().getConfiguration().locale;
                SecureRandom secureRandom = r.a;
                long millis = TimeUnit.DAYS.toMillis(a);
                DateFormat dateInstance = DateFormat.getDateInstance(1, locale);
                dateInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
                textView.setText(dateInstance.format(Long.valueOf(millis)));
                viewFlipper3.setDisplayedChild(1);
                this.a0.f2114l.setVisibility(8);
                e.m.a.l J = this.b0.J("ExposureChecksDialogFragment");
                if (J != null) {
                    ((k) J).y0(false, false);
                }
                if (z) {
                    textView2.setText(R.string.exposure_details_url_revoked);
                    i2 = R.string.exposure_details_text_revoked;
                } else {
                    int b = dVar.b();
                    if (b == 1) {
                        textView2.setText(R.string.exposure_details_url_1);
                        i2 = R.string.exposure_details_text_1;
                    } else if (b == 2) {
                        textView2.setText(R.string.exposure_details_url_2);
                        i2 = R.string.exposure_details_text_2;
                    } else if (b == 3) {
                        textView2.setText(R.string.exposure_details_url_3);
                        i2 = R.string.exposure_details_text_3;
                    } else if (b == 4) {
                        textView2.setText(R.string.exposure_details_url_4);
                        i2 = R.string.exposure_details_text_4;
                    }
                }
                textView3.setText(i2);
            } else if (aVar == aVar2) {
                viewFlipper2.setDisplayedChild(0);
                viewFlipper2.setVisibility(0);
                viewFlipper3.setDisplayedChild(0);
                this.a0.f2114l.setVisibility(0);
            } else {
                viewFlipper2.setVisibility(8);
            }
            if (this.a0.f2109g.getVisibility() != 0 || aVar == aVar2) {
                linearLayout = this.a0.r;
            } else {
                linearLayout = this.a0.r;
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_exposure_home, viewGroup, false);
        int i2 = R.id.edge_case_fragment;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
        if (frameLayout != null) {
            i2 = R.id.exposure_date_new_badge;
            TextView textView = (TextView) inflate.findViewById(R.id.exposure_date_new_badge);
            if (textView != null) {
                i2 = R.id.exposure_details_date_exposed_text;
                TextView textView2 = (TextView) inflate.findViewById(R.id.exposure_details_date_exposed_text);
                if (textView2 != null) {
                    i2 = R.id.exposure_details_new_badge;
                    TextView textView3 = (TextView) inflate.findViewById(R.id.exposure_details_new_badge);
                    if (textView3 != null) {
                        i2 = R.id.exposure_details_text;
                        TextView textView4 = (TextView) inflate.findViewById(R.id.exposure_details_text);
                        if (textView4 != null) {
                            i2 = R.id.exposure_details_url_text;
                            TextView textView5 = (TextView) inflate.findViewById(R.id.exposure_details_url_text);
                            if (textView5 != null) {
                                i2 = R.id.exposure_information_flipper;
                                ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.exposure_information_flipper);
                                if (viewFlipper != null) {
                                    i2 = R.id.exposures_banner_flipper;
                                    ViewFlipper viewFlipper2 = (ViewFlipper) inflate.findViewById(R.id.exposures_banner_flipper);
                                    if (viewFlipper2 != null) {
                                        i2 = R.id.how_en_work_button_exposure;
                                        Button button = (Button) inflate.findViewById(R.id.how_en_work_button_exposure);
                                        if (button != null) {
                                            i2 = R.id.how_en_work_button_flipper;
                                            ViewFlipper viewFlipper3 = (ViewFlipper) inflate.findViewById(R.id.how_en_work_button_flipper);
                                            if (viewFlipper3 != null) {
                                                i2 = R.id.how_en_work_button_no_exposure;
                                                Button button2 = (Button) inflate.findViewById(R.id.how_en_work_button_no_exposure);
                                                if (button2 != null) {
                                                    i2 = R.id.how_en_works_horizontal_divider;
                                                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.how_en_works_horizontal_divider);
                                                    if (linearLayout != null) {
                                                        i2 = R.id.last_checked;
                                                        TextView textView6 = (TextView) inflate.findViewById(R.id.last_checked);
                                                        if (textView6 != null) {
                                                            i2 = R.id.pulse_large;
                                                            ImageView imageView = (ImageView) inflate.findViewById(R.id.pulse_large);
                                                            if (imageView != null) {
                                                                i2 = R.id.pulse_medium;
                                                                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.pulse_medium);
                                                                if (imageView2 != null) {
                                                                    i2 = R.id.pulse_small;
                                                                    ImageView imageView3 = (ImageView) inflate.findViewById(R.id.pulse_small);
                                                                    if (imageView3 != null) {
                                                                        i2 = R.id.see_more_button;
                                                                        Button button3 = (Button) inflate.findViewById(R.id.see_more_button);
                                                                        if (button3 != null) {
                                                                            i2 = R.id.view_flipper_divider;
                                                                            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.view_flipper_divider);
                                                                            if (linearLayout2 != null) {
                                                                                LinearLayout linearLayout3 = (LinearLayout) inflate;
                                                                                this.a0 = new l(linearLayout3, frameLayout, textView, textView2, textView3, textView4, textView5, viewFlipper, viewFlipper2, button, viewFlipper3, button2, linearLayout, textView6, imageView, imageView2, imageView3, button3, linearLayout2);
                                                                                return linearLayout3;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.c0.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.b0 = j();
        this.c0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        b0.b l2 = l();
        c0 i2 = i();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String t = a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            a0 a0Var = i2.a.get(t);
            if (!ExposureHomeViewModel.class.isInstance(a0Var)) {
                a0Var = l2 instanceof b0.c ? ((b0.c) l2).c(t, ExposureHomeViewModel.class) : l2.a(ExposureHomeViewModel.class);
                a0 put = i2.a.put(t, a0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof b0.e) {
                ((b0.e) l2).b(a0Var);
            }
            this.d0 = (ExposureHomeViewModel) a0Var;
            this.c0.f340d.f(B(), new d(this));
            this.a0.q.setOnClickListener(new e(this));
            this.a0.f2108f.setOnClickListener(new i(this));
            this.a0.f2113k.setOnClickListener(new c(this));
            this.a0.f2111i.setOnClickListener(new h(this));
            this.d0.c.f2361h.f(B(), new b(this));
            this.d0.c.f2362i.f(B(), new j(this));
            this.d0.c.f2360g.f(B(), new g(this));
            ExposureHomeViewModel exposureHomeViewModel = this.d0;
            q0.f fVar = q0.f.NEW;
            q0.f fVar2 = q0.f.SEEN;
            exposureHomeViewModel.d(fVar, fVar2);
            this.d0.c(fVar, fVar2);
            if (this.b0.I(R.id.edge_case_fragment) == null) {
                f.b.a.a.a.j.n nVar = new f.b.a.a.a.j.n();
                j.C0(nVar, true, false);
                e.m.a.a aVar = new e.m.a.a(this.b0);
                aVar.f(R.id.edge_case_fragment, nVar, null);
                aVar.c();
            }
            this.d0.f339d.f(B(), new f(this));
            this.e0 = AnimationUtils.loadAnimation(n0(), R.anim.pulsation_small);
            this.f0 = AnimationUtils.loadAnimation(n0(), R.anim.pulsation_medium);
            this.g0 = AnimationUtils.loadAnimation(n0(), R.anim.pulsation_large);
            this.a0.p.startAnimation(this.e0);
            this.a0.o.startAnimation(this.f0);
            this.a0.n.startAnimation(this.g0);
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void z0(String str) {
        Uri parse = Uri.parse(str);
        if (!"https".equals(parse.getScheme())) {
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.scheme("https");
            parse = buildUpon.build();
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            w0(intent);
        } catch (Exception e2) {
            Log.e("ExposureHomeFragment", "Exception while launching ACTION_VIEW with URL " + str, e2);
        }
    }
}
