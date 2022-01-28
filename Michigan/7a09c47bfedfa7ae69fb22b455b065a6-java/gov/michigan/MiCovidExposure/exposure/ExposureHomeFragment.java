package gov.michigan.MiCovidExposure.exposure;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import android.widget.ViewSwitcher;
import androidx.fragment.app.Fragment;
import b.b.k.e;
import b.o.x;
import b.o.y;
import b.o.z;
import c.a.a.a.a;
import com.google.android.material.snackbar.Snackbar;
import e.a.a.b.f;
import e.a.a.b.g;
import e.a.a.b.h;
import e.a.a.b.i;
import e.a.a.b.j;
import e.a.a.b.k;
import e.a.a.b.l;
import e.a.a.b.m;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.home.ExposureNotificationViewModel;
import gov.michigan.MiCovidExposure.storage.ExposureEntity;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExposureHomeFragment extends Fragment {
    public static final String ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION = "com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION";
    public static final String EXPOSURE_NOTIFICATION_CHANNEL_ID = "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID";
    public final String TAG = "ExposureHomeFragment";
    public ExposureEntityAdapter adapter;
    public ExposureHomeViewModel exposureHomeViewModel;
    public ExposureNotificationViewModel exposureNotificationViewModel;

    private int getDaysSinceLastExposure(long j) {
        return ((int) Math.abs(System.currentTimeMillis() - j)) / 86400000;
    }

    private String getExposureMessage(Context context) {
        String str;
        int i;
        int daysSinceLastExposure = getDaysSinceLastExposure(new ExposureNotificationSharedPreferences(context).getTimestampSinceLastExposure(0L));
        if (daysSinceLastExposure == 0) {
            i = R.string.notification_message_zero_days;
        } else if (daysSinceLastExposure == 1) {
            i = R.string.notification_message_one_day;
        } else {
            str = context.getString(R.string.notification_message_two_days, Integer.valueOf(daysSinceLastExposure));
            return context.getString(R.string.notifications_enabled_possible_exposure_info1) + str + context.getString(R.string.notifications_enabled_possible_exposure_info2);
        }
        str = context.getString(i);
        return context.getString(R.string.notifications_enabled_possible_exposure_info1) + str + context.getString(R.string.notifications_enabled_possible_exposure_info2);
    }

    private String getVersionCode(String str) {
        try {
            return "" + getContext().getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return getString(R.string.debug_version_not_available);
        }
    }

    private void launchAboutAction() {
        startActivity(new Intent(requireContext(), ExposureAboutActivity.class));
    }

    private void refreshUi() {
        this.exposureNotificationViewModel.refreshIsEnabledState();
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshUiForEnabled */
    public void e(Boolean bool) {
        int i;
        TextView textView;
        LinearLayout linearLayout;
        ImageView imageView;
        LinearLayout linearLayout2;
        TextView textView2;
        TextView textView3;
        LinearLayout linearLayout3;
        TextView textView4;
        View view = getView();
        if (view != null) {
            ViewAnimator viewAnimator = (ViewAnimator) view.findViewById(R.id.exposures_list_empty_switcher);
            TextView textView5 = (TextView) view.findViewById(R.id.exposure_notifications_status);
            textView5.setVisibility(8);
            TextView textView6 = (TextView) view.findViewById(R.id.info_status);
            TextView textView7 = (TextView) view.findViewById(R.id.info_virus_status);
            TextView textView8 = (TextView) view.findViewById(R.id.info_point_heading);
            TextView textView9 = (TextView) view.findViewById(R.id.info_point1);
            TextView textView10 = (TextView) view.findViewById(R.id.info_point2);
            TextView textView11 = (TextView) view.findViewById(R.id.info_point3);
            TextView textView12 = (TextView) view.findViewById(R.id.checklist_link);
            TextView textView13 = (TextView) view.findViewById(R.id.disabled);
            Button button = (Button) view.findViewById(R.id.disable_button);
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.stop_notifs);
            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.checklist);
            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.heading);
            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.layout1);
            LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.layout2);
            LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.layout3);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.detected_image);
            ((ViewSwitcher) view.findViewById(R.id.settings_banner_switcher)).setDisplayedChild(bool.booleanValue() ? 1 : 0);
            ((TextView) view.findViewById(R.id.version)).setText(getString(R.string.app_version_number, getVersionCode(getContext().getPackageName())));
            if (bool.booleanValue()) {
                Long lastExposure = new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getLastExposure(0L);
                if (lastExposure.longValue() > 0) {
                    TextView textView14 = (TextView) view.findViewById(R.id.last_exposure_text);
                    textView14.setVisibility(0);
                    textView14.setText(R.string.exposure_last_checked);
                    textView3 = textView10;
                    textView2 = textView11;
                    textView14.append(new SimpleDateFormat(" MMMM dd, yyyy, hh:mm aa", Locale.getDefault()).format(new Date(lastExposure.longValue())));
                } else {
                    textView3 = textView10;
                    textView2 = textView11;
                }
                textView5.setVisibility(0);
                textView5.setText(R.string.turned_on);
                textView5.setTextColor(getResources().getColor(R.color.mi_light_blue));
                if (new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getPossibleExposureFound(false)) {
                    String[] split = getExposureMessage(getContext()).split("\n•");
                    linearLayout5.setVisibility(0);
                    textView12.setLinkTextColor(getResources().getColor(R.color.link_color));
                    textView6.setText(split[0]);
                    textView8.setText(split[1]);
                    textView9.setText(split[2]);
                    textView3.setText(split[3]);
                    textView2.setText(split[4]);
                    Linkify.addLinks(textView2, Patterns.PHONE, "tel:", Linkify.sPhoneNumberMatchFilter, Linkify.sPhoneNumberTransformFilter);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    linearLayout6.setVisibility(0);
                    textView12.setMovementMethod(LinkMovementMethod.getInstance());
                    linearLayout7.setVisibility(0);
                    linearLayout8.setVisibility(0);
                    linearLayout9.setVisibility(0);
                    textView6.setTextColor(-16777216);
                    viewAnimator.setDisplayedChild(1);
                    imageView2.setVisibility(0);
                    textView7.setText(R.string.possible_exposure);
                    textView7.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp6), 0, 0, 0);
                    if (!new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getDisabledNotifications(false)) {
                        linearLayout3 = linearLayout4;
                        linearLayout3.setVisibility(0);
                        textView4 = textView13;
                        textView4.setVisibility(8);
                    } else {
                        textView4 = textView13;
                        linearLayout3 = linearLayout4;
                        linearLayout3.setVisibility(8);
                        textView4.setVisibility(0);
                    }
                    button.setOnClickListener(new m(this, linearLayout3, textView4));
                    return;
                }
                textView = textView7;
                linearLayout2 = linearLayout9;
                imageView = imageView2;
                linearLayout = linearLayout8;
                i = 8;
                textView6.setText(R.string.notifications_enabled_info);
                viewAnimator.setDisplayedChild(0);
            } else {
                textView = textView7;
                linearLayout2 = linearLayout9;
                imageView = imageView2;
                linearLayout = linearLayout8;
                i = 8;
                viewAnimator.setDisplayedChild(0);
                textView5.setVisibility(8);
                textView5.setText(R.string.off);
                textView5.setTextColor(getResources().getColor(R.color.red_color));
                textView6.setText(R.string.notifications_disabled_info);
            }
            imageView.setVisibility(i);
            textView.setText(R.string.no_exposures);
            linearLayout7.setVisibility(i);
            linearLayout.setVisibility(i);
            linearLayout2.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public void refreshUiForExposureEntities(List<ExposureEntity> list) {
        View view = getView();
        if (view != null) {
            ViewAnimator viewAnimator = (ViewAnimator) view.findViewById(R.id.exposures_list_empty_switcher);
            viewAnimator.setDisplayedChild((list == null || list.isEmpty()) ? 0 : 1);
            if (new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getPossibleExposureFound(false)) {
                viewAnimator.setDisplayedChild(1);
            }
        }
    }

    public /* synthetic */ void f(View view) {
        this.exposureNotificationViewModel.startExposureNotifications();
    }

    public /* synthetic */ void h(Void r3) {
        View view = getView();
        if (view != null) {
            Snackbar.h(view, R.string.api_update_error_message_text, 0).j();
        }
    }

    public /* synthetic */ void i(View view) {
        launchAboutAction();
    }

    public /* synthetic */ void j(View view) {
        launchAboutAction();
    }

    public /* synthetic */ void k(final LinearLayout linearLayout, final TextView textView, View view) {
        final e a2 = new e.a(getActivity()).a();
        a2.f(getString(R.string.stop_notif_popup));
        a2.setCancelable(false);
        a2.e(-1, getString(R.string.stop_notif_ok), new DialogInterface.OnClickListener() {
            /* class gov.michigan.MiCovidExposure.exposure.ExposureHomeFragment.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                new ExposureNotificationSharedPreferences(ExposureHomeFragment.this.getContext().getApplicationContext()).setDisabledNotifications(true);
                linearLayout.setVisibility(8);
                textView.setVisibility(0);
                a2.dismiss();
            }
        });
        a2.e(-2, getString(R.string.stop_notif_cancel), new DialogInterface.OnClickListener() {
            /* class gov.michigan.MiCovidExposure.exposure.ExposureHomeFragment.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                a2.dismiss();
            }
        });
        a2.show();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_exposure_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshUi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ((TextView) view.findViewById(R.id.exposure_privacy_link)).setMovementMethod(LinkMovementMethod.getInstance());
        this.exposureNotificationViewModel = (ExposureNotificationViewModel) new y(requireActivity()).a(ExposureNotificationViewModel.class);
        y.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        z viewModelStore = getViewModelStore();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String q = a.q("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            x xVar = viewModelStore.f2263a.get(q);
            if (!ExposureHomeViewModel.class.isInstance(xVar)) {
                xVar = defaultViewModelProviderFactory instanceof y.c ? ((y.c) defaultViewModelProviderFactory).c(q, ExposureHomeViewModel.class) : defaultViewModelProviderFactory.a(ExposureHomeViewModel.class);
                x put = viewModelStore.f2263a.put(q, xVar);
                if (put != null) {
                    put.onCleared();
                }
            } else if (defaultViewModelProviderFactory instanceof y.e) {
                ((y.e) defaultViewModelProviderFactory).b(xVar);
            }
            this.exposureHomeViewModel = (ExposureHomeViewModel) xVar;
            this.exposureNotificationViewModel.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new j(this));
            Button button = (Button) view.findViewById(R.id.start_api_button);
            button.setOnClickListener(new g(this));
            this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new k(button));
            this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new l(this));
            view.findViewById(R.id.exposure_about_button).setOnClickListener(new i(this));
            view.findViewById(R.id.exposure_about_button1).setOnClickListener(new f(this));
            this.exposureHomeViewModel.getAllExposureEntityLiveData().observe(getViewLifecycleOwner(), new h(this));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
