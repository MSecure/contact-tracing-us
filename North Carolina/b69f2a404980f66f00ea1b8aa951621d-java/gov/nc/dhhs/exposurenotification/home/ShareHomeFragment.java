package gov.nc.dhhs.exposurenotification.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.i.d.m;
import d.a.a.a.e.l;
import gov.nc.dhhs.exposurenotification.BuildConfig;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class ShareHomeFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public final Handler handler = new Handler();
    public Runnable handlerTask;
    public String mParam1;
    public String mParam2;
    public int numberOfDownloads;

    public final class newTotalDownloads extends AsyncTask<Void, Void, String> {
        public newTotalDownloads() {
        }

        public String doInBackground(Void... voidArr) {
            try {
                totaldownloads();
                return "ok";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "ok";
            }
        }

        public void totaldownloads() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(((HttpsURLConnection) new URL(BuildConfig.TOTAL_DOWNLOADS_URL).openConnection()).getInputStream())));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    new ExposureNotificationSharedPreferences(ShareHomeFragment.this.getActivity().getApplicationContext()).setTotalDownloads(sb.toString());
                    return;
                }
            }
        }
    }

    public static ShareHomeFragment newInstance(String str, String str2) {
        ShareHomeFragment shareHomeFragment = new ShareHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        shareHomeFragment.setArguments(bundle);
        return shareHomeFragment;
    }

    public /* synthetic */ void d(View view) {
        m.b(getActivity()).e("text/plain").d(getResources().getString(R.string.share_app_message)).c(getResources().getString(R.string.share_app_subject)).f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString("param1");
            this.mParam2 = getArguments().getString("param2");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.handler.removeCallbacks(this.handlerTask);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.handler.postDelayed(this.handlerTask, 0);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(R.id.share_app_button).setOnClickListener(new l(this));
        final TextView textView = (TextView) view.findViewById(R.id.total_downloads);
        this.handlerTask = new Runnable() {
            /* class gov.nc.dhhs.exposurenotification.home.ShareHomeFragment.AnonymousClass1 */

            public void run() {
                new newTotalDownloads().execute(new Void[0]);
                textView.setText(new ExposureNotificationSharedPreferences(ShareHomeFragment.this.getActivity().getApplicationContext()).getTotalDownloads(""));
                ShareHomeFragment shareHomeFragment = ShareHomeFragment.this;
                shareHomeFragment.handler.postDelayed(shareHomeFragment.handlerTask, 3000);
            }
        };
    }
}
