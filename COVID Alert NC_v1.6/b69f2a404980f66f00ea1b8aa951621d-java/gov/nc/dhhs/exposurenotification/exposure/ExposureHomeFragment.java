package gov.nc.dhhs.exposurenotification.exposure;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
import b.l.d.z;
import b.n.x;
import b.n.y;
import c.a.a.a.a;
import com.google.android.material.snackbar.Snackbar;
import d.a.a.a.d.d;
import d.a.a.a.d.f;
import d.a.a.a.d.g;
import d.a.a.a.d.h;
import d.a.a.a.d.i;
import d.a.a.a.d.j;
import d.a.a.a.d.k;
import d.a.a.a.d.l;
import d.a.a.a.d.m;
import d.a.a.a.d.n;
import d.a.a.a.d.o;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationActivity;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;
import gov.nc.dhhs.exposurenotification.home.HomeFragment;
import gov.nc.dhhs.exposurenotification.onboarding.HowItWorksActivity;
import gov.nc.dhhs.exposurenotification.storage.ExposureEntity;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExposureHomeFragment extends Fragment {
    public static final String ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION = "com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION";
    public static final String EXPOSURE_NOTIFICATION_CHANNEL_ID = "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID";
    public static boolean how_it_works_in_navbar_enabled = false;
    public final String TAG = "ExposureHomeFragment";
    public ExposureEntityAdapter adapter;
    public ExposureHomeViewModel exposureHomeViewModel;
    public ExposureNotificationViewModel exposureNotificationViewModel;

    private void bluetoothAction() {
        startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
    }

    private int getDaysSinceLastExposure(long j) {
        return ((int) Math.abs(System.currentTimeMillis() - j)) / 86400000;
    }

    private String getExposureMessage(Context context) {
        String str;
        SimpleDateFormat simpleDateFormat;
        int daysSinceLastExposure = getDaysSinceLastExposure(new ExposureNotificationSharedPreferences(context).getTimestampSinceLastExposure(0L));
        int i = 14 - daysSinceLastExposure;
        if (daysSinceLastExposure == 0) {
            str = context.getString(R.string.notification_message_zero_days);
        } else {
            long currentTimeMillis = System.currentTimeMillis() - ((long) (86400000 * daysSinceLastExposure));
            Locale locale = Locale.getDefault();
            if (daysSinceLastExposure == 1) {
                str = context.getString(R.string.notification_message_one_day, Integer.valueOf(daysSinceLastExposure), simpleDateFormat.format(new Date(currentTimeMillis)));
            } else {
                simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy", locale);
                str = context.getString(R.string.notification_message_two_days, Integer.valueOf(daysSinceLastExposure), simpleDateFormat.format(new Date(currentTimeMillis)));
            }
        }
        return context.getString(R.string.notifications_enabled_possible_exposure_info1) + " " + str + context.getString(R.string.notifications_enabled_possible_exposure_info2) + "\n•" + i;
    }

    private String getVersionName(String str) {
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
    public void i(final Boolean bool) {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        int i;
        LinearLayout linearLayout5;
        char c2;
        String str;
        TextView textView2;
        LinearLayout linearLayout6;
        View view = getView();
        if (view != null) {
            final ViewAnimator viewAnimator = (ViewAnimator) view.findViewById(R.id.vs1);
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            AnonymousClass1 r4 = new BroadcastReceiver() {
                /* class gov.nc.dhhs.exposurenotification.exposure.ExposureHomeFragment.AnonymousClass1 */

                public void onReceive(Context context, Intent intent) {
                    int i;
                    ViewAnimator viewAnimator;
                    if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                        if (intExtra == 10 && bool.booleanValue()) {
                            viewAnimator = viewAnimator;
                            i = 1;
                        } else if (intExtra == 12) {
                            viewAnimator = viewAnimator;
                            i = 0;
                        } else {
                            return;
                        }
                        viewAnimator.setDisplayedChild(i);
                    }
                }
            };
            if (!defaultAdapter.isEnabled() && bool.booleanValue()) {
                viewAnimator.setDisplayedChild(1);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            getActivity().registerReceiver(r4, intentFilter);
            ViewSwitcher viewSwitcher = (ViewSwitcher) view.findViewById(R.id.settings_banner_switcher);
            ViewAnimator viewAnimator2 = (ViewAnimator) view.findViewById(R.id.exposures_list_empty_switcher);
            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.exposure_notifications_status);
            linearLayout7.setVisibility(8);
            TextView textView3 = (TextView) view.findViewById(R.id.info_status);
            TextView textView4 = (TextView) view.findViewById(R.id.info_virus_status);
            TextView textView5 = (TextView) view.findViewById(R.id.info_point1);
            TextView textView6 = (TextView) view.findViewById(R.id.info_point2);
            TextView textView7 = (TextView) view.findViewById(R.id.info_point3);
            TextView textView8 = (TextView) view.findViewById(R.id.info_point4);
            TextView textView9 = (TextView) view.findViewById(R.id.info_point5);
            TextView textView10 = (TextView) view.findViewById(R.id.disabled);
            TextView textView11 = (TextView) view.findViewById(R.id.get_tested_text);
            TextView textView12 = (TextView) view.findViewById(R.id.get_tested_text2);
            Button button = (Button) view.findViewById(R.id.disable_button);
            LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.layout1);
            LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.layout2);
            LinearLayout linearLayout10 = (LinearLayout) view.findViewById(R.id.layout3);
            LinearLayout linearLayout11 = (LinearLayout) view.findViewById(R.id.layout4);
            LinearLayout linearLayout12 = (LinearLayout) view.findViewById(R.id.layout5);
            LinearLayout linearLayout13 = (LinearLayout) view.findViewById(R.id.stop_notifs);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.detected_image);
            ((TextView) view.findViewById(R.id.version)).setText(getString(R.string.app_version_number, getVersionName(getContext().getPackageName())));
            ((TextView) view.findViewById(R.id.versionBluetooth)).setText(getString(R.string.app_version_number, getVersionName(getContext().getPackageName())));
            Long lastExposure = new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getLastExposure(0L);
            if (lastExposure.longValue() != 0) {
                TextView textView13 = (TextView) view.findViewById(R.id.last_exposure_text);
                textView13.setVisibility(0);
                textView13.setText(R.string.exposure_last_checked);
                Date date = new Date(lastExposure.longValue());
                StringBuilder g = a.g("<b><font color=#2E8540>");
                g.append(new SimpleDateFormat(" MMMM dd, yyyy, HH:mm aa").format(date));
                g.append("</font></b>");
                textView13.append(Html.fromHtml(g.toString()));
            }
            viewSwitcher.setDisplayedChild(bool.booleanValue() ? 1 : 0);
            if (bool.booleanValue()) {
                linearLayout7.setVisibility(0);
                if (new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getPossibleExposureFound(false)) {
                    long timestampSinceLastExposure = new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getTimestampSinceLastExposure(0L);
                    String[] split = getExposureMessage(getContext()).split("\n•");
                    textView11.setMovementMethod(LinkMovementMethod.getInstance());
                    textView12.setText(Html.fromHtml(getString(R.string.get_tested_text2)));
                    textView12.setMovementMethod(LinkMovementMethod.getInstance());
                    textView12.setOnClickListener(new l(this));
                    if (14 - Integer.parseInt(split[6]) == 5) {
                        c2 = 0;
                        view.findViewById(R.id.tested_day_notif).setVisibility(0);
                    } else {
                        c2 = 0;
                        view.findViewById(R.id.tested_day_notif).setVisibility(8);
                    }
                    textView3.setText(split[c2]);
                    textView5.setText(R.string.notifications_enabled_possible_exposure_info2_1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                    String format = simpleDateFormat.format(new Date(1209600000 + timestampSinceLastExposure));
                    String str2 = getResources().getString(R.string.notifications_enabled_possible_exposure_info2_2) + " (" + simpleDateFormat.format(new Date(timestampSinceLastExposure + 518400000)) + ") " + getResources().getString(R.string.notifications_enabled_possible_exposure_info2_2_2);
                    if (Locale.getDefault().getLanguage().equals("es")) {
                        str = String.format(" (hace %s dias desde hoy o %s)", split[6], format);
                    } else if ("1".equalsIgnoreCase(split[6])) {
                        str = String.format(" (%s day from today or %s)", split[6], format);
                    } else {
                        str = String.format(" (%s days from today or %s)", split[6], format);
                    }
                    textView5.append(str);
                    textView5.setMovementMethod(LinkMovementMethod.getInstance());
                    textView6.setText(Html.fromHtml(str2));
                    textView6.setMovementMethod(LinkMovementMethod.getInstance());
                    textView7.setText(R.string.notifications_enabled_possible_exposure_info2_3);
                    textView8.setText(R.string.notifications_enabled_possible_exposure_info2_4);
                    textView8.setMovementMethod(LinkMovementMethod.getInstance());
                    textView9.setText(Html.fromHtml(getString(R.string.notifications_enabled_possible_exposure_info2_5)));
                    textView9.setMovementMethod(LinkMovementMethod.getInstance());
                    textView9.setOnClickListener(new i(this));
                    if (!new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getDisabledNotifications(false)) {
                        linearLayout6 = linearLayout13;
                        linearLayout6.setVisibility(0);
                        textView2 = textView10;
                        textView2.setVisibility(8);
                    } else {
                        textView2 = textView10;
                        linearLayout6 = linearLayout13;
                        linearLayout6.setVisibility(8);
                        textView2.setVisibility(0);
                    }
                    button.setOnClickListener(new o(this, linearLayout6, textView2));
                    linearLayout8.setVisibility(0);
                    linearLayout9.setVisibility(0);
                    linearLayout10.setVisibility(0);
                    linearLayout11.setVisibility(0);
                    linearLayout12.setVisibility(0);
                    textView3.setTextColor(-16777216);
                    viewAnimator2.setDisplayedChild(1);
                    imageView2.setVisibility(0);
                    textView4.setText(R.string.possible_exposure);
                    textView4.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp6), 0, 0, 0);
                    return;
                }
                textView = textView4;
                linearLayout5 = linearLayout8;
                linearLayout4 = linearLayout9;
                linearLayout3 = linearLayout10;
                linearLayout2 = linearLayout11;
                linearLayout = linearLayout12;
                imageView = imageView2;
                textView3.setText(R.string.notifications_enabled_info);
                viewAnimator2.setDisplayedChild(0);
                i = 8;
            } else {
                textView = textView4;
                linearLayout5 = linearLayout8;
                linearLayout4 = linearLayout9;
                linearLayout3 = linearLayout10;
                linearLayout2 = linearLayout11;
                linearLayout = linearLayout12;
                imageView = imageView2;
                viewAnimator2.setDisplayedChild(0);
                linearLayout7.setVisibility(8);
                textView3.setText(R.string.notifications_disabled_info);
                i = 8;
            }
            imageView.setVisibility(i);
            textView.setText(R.string.no_exposures);
            linearLayout5.setVisibility(i);
            linearLayout4.setVisibility(i);
            linearLayout3.setVisibility(i);
            linearLayout2.setVisibility(i);
            linearLayout.setVisibility(i);
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

    public /* synthetic */ void e(View view) {
        how_it_works_in_navbar_enabled = true;
        startActivity(new Intent(requireContext(), HowItWorksActivity.class));
    }

    public /* synthetic */ void f(View view) {
        launchAboutAction();
    }

    public /* synthetic */ void g(View view) {
        bluetoothAction();
    }

    public /* synthetic */ void h(View view) {
        launchAboutAction();
    }

    public /* synthetic */ void j(View view) {
        this.exposureNotificationViewModel.startExposureNotifications();
    }

    public /* synthetic */ void l(Void r3) {
        View view = getView();
        if (view != null) {
            Snackbar.h(view, R.string.api_update_error_message_text, 0).j();
        }
    }

    public /* synthetic */ void m(final LinearLayout linearLayout, final TextView textView, View view) {
        final e a2 = new e.a(getActivity()).a();
        a2.f(getString(R.string.stop_notif_popup));
        a2.setCancelable(false);
        a2.e(-1, getString(R.string.stop_notif_ok), new DialogInterface.OnClickListener() {
            /* class gov.nc.dhhs.exposurenotification.exposure.ExposureHomeFragment.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                new ExposureNotificationSharedPreferences(ExposureHomeFragment.this.getContext().getApplicationContext()).setDisabledNotifications(true);
                linearLayout.setVisibility(8);
                textView.setVisibility(0);
                a2.dismiss();
            }
        });
        a2.e(-2, getString(R.string.stop_notif_cancel), new DialogInterface.OnClickListener() {
            /* class gov.nc.dhhs.exposurenotification.exposure.ExposureHomeFragment.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                a2.dismiss();
            }
        });
        a2.show();
    }

    public /* synthetic */ void n(View view) {
        z f = getParentFragmentManager().f();
        f.i(R.id.home_fragment, HomeFragment.newInstance(2), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
        f.k(4099);
        f.d();
    }

    public /* synthetic */ void o(View view) {
        z f = getParentFragmentManager().f();
        f.i(R.id.home_fragment, HomeFragment.newInstance(2), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
        f.k(4099);
        f.d();
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
        view.findViewById(R.id.how_it_works).setOnClickListener(new d(this));
        TextView textView = (TextView) view.findViewById(R.id.about_exposure_notifications);
        String string = getString(R.string.onboarding_privacy_policy_link);
        textView.setText(Html.fromHtml(string));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setOnClickListener(new m(this));
        view.findViewById(R.id.bluetooth_body).setOnClickListener(new k(this));
        TextView textView2 = (TextView) view.findViewById(R.id.about_exposure_notifications_bluetooth);
        textView2.setText(Html.fromHtml(string));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setOnClickListener(new g(this));
        this.exposureNotificationViewModel = (ExposureNotificationViewModel) new y(requireActivity()).a(ExposureNotificationViewModel.class);
        y.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        b.n.z viewModelStore = getViewModelStore();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String o = a.o("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            x xVar = viewModelStore.f1427a.get(o);
            if (!ExposureHomeViewModel.class.isInstance(xVar)) {
                xVar = defaultViewModelProviderFactory instanceof y.c ? ((y.c) defaultViewModelProviderFactory).c(o, ExposureHomeViewModel.class) : defaultViewModelProviderFactory.a(ExposureHomeViewModel.class);
                x put = viewModelStore.f1427a.put(o, xVar);
                if (put != null) {
                    put.onCleared();
                }
            } else if (defaultViewModelProviderFactory instanceof y.e) {
                ((y.e) defaultViewModelProviderFactory).b(xVar);
            }
            this.exposureHomeViewModel = (ExposureHomeViewModel) xVar;
            this.exposureNotificationViewModel.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new f(this));
            Button button = (Button) view.findViewById(R.id.start_api_button);
            button.setOnClickListener(new n(this));
            this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new h(button));
            this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new j(this));
            this.exposureHomeViewModel.getAllExposureEntityLiveData().observe(getViewLifecycleOwner(), new d.a.a.a.d.e(this));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
