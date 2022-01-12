package androidx.core.content.res;

import androidx.core.provider.FontRequest;

public final class FontResourcesParserCompat$ProviderResourceEntry implements FontResourcesParserCompat$FamilyResourceEntry {
    public final FontRequest mRequest;
    public final int mStrategy;
    public final int mTimeoutMs;

    public FontResourcesParserCompat$ProviderResourceEntry(FontRequest fontRequest, int i, int i2) {
        this.mRequest = fontRequest;
        this.mStrategy = i;
        this.mTimeoutMs = i2;
    }
}
