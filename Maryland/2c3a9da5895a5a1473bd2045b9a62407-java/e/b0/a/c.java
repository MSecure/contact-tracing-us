package e.b0.a;

import androidx.viewpager2.adapter.FragmentStateAdapter;

public class c implements Runnable {
    public final /* synthetic */ FragmentStateAdapter b;

    public c(FragmentStateAdapter fragmentStateAdapter) {
        this.b = fragmentStateAdapter;
    }

    public void run() {
        FragmentStateAdapter fragmentStateAdapter = this.b;
        fragmentStateAdapter.f293i = false;
        fragmentStateAdapter.r();
    }
}
