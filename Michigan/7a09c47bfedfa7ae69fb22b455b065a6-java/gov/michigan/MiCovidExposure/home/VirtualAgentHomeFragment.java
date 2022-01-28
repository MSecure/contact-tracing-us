package gov.michigan.MiCovidExposure.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import gov.michigan.MiCovidExposure.R;
import java.util.Locale;

public class VirtualAgentHomeFragment extends Fragment {
    public static final String TAG = "VirtualFragment";

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_virtual_agent_home, viewGroup, false);
        WebView webView = (WebView) inflate.findViewById(R.id.webview_home);
        webView.getSettings().setJavaScriptEnabled(true);
        Locale locale = Locale.getDefault();
        webView.loadUrl(getString(R.string.virtual_agent_uri) + "?locale=" + locale.getLanguage());
        return inflate;
    }
}
