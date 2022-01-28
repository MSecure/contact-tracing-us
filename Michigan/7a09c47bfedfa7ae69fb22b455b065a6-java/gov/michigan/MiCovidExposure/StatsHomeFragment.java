package gov.michigan.MiCovidExposure;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

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
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(1);
        webView.loadUrl(BuildConfig.STATS_URL);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ((TextView) view.findViewById(R.id.stats_body)).setMovementMethod(LinkMovementMethod.getInstance());
        ((WebView) view.findViewById(R.id.webview_covid_status)).setOnKeyListener(new View.OnKeyListener() {
            /* class gov.michigan.MiCovidExposure.StatsHomeFragment.AnonymousClass1 */

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                WebView webView = (WebView) view;
                if (!webView.canGoBack()) {
                    return false;
                }
                webView.goBack();
                return true;
            }
        });
    }
}
