package gov.nc.dhhs.exposurenotification.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import gov.nc.dhhs.exposurenotification.R;

public class StatsHomeFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public String mParam2;

    public static StatsHomeFragment newInstance(String str, String str2) {
        StatsHomeFragment statsHomeFragment = new StatsHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        statsHomeFragment.setArguments(bundle);
        return statsHomeFragment;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_stats_home, viewGroup, false);
        WebView webView = (WebView) inflate.findViewById(R.id.webview_covid_status);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        webView.setInitialScale(1);
        settings.setCacheMode(1);
        webView.loadUrl("https://files.nc.gov/covid/slowcovidnc.html");
        return inflate;
    }
}
