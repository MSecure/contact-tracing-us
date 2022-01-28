package androidx.core.text;

import java.util.Locale;

public final class BidiFormatter {
    public static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    public static final String LRM_STRING = Character.toString(8206);
    public static final String RLM_STRING = Character.toString(8207);
    public final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    public final int mFlags;
    public final boolean mIsRtlContext;

    public static class DirectionalityEstimator {
        public static final byte[] DIR_TYPE_CACHE = new byte[1792];
        public int charIndex;
        public final boolean isHtml;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
            r7.charIndex = r0;
            r7.lastChar = '>';
         */
        public byte dirTypeBackward() {
            char charAt;
            char charAt2;
            char charAt3 = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt3;
            if (Character.isLowSurrogate(charAt3)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            char c = this.lastChar;
            byte directionality = c < 1792 ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
            if (!this.isHtml) {
                return directionality;
            }
            char c2 = this.lastChar;
            if (c2 == '>') {
                int i = this.charIndex;
                while (true) {
                    int i2 = this.charIndex;
                    if (i2 <= 0) {
                        break;
                    }
                    CharSequence charSequence = this.text;
                    int i3 = i2 - 1;
                    this.charIndex = i3;
                    char charAt4 = charSequence.charAt(i3);
                    this.lastChar = charAt4;
                    if (charAt4 == '<') {
                        break;
                    } else if (charAt4 == '>') {
                        break;
                    } else if (charAt4 == '\"' || charAt4 == '\'') {
                        char c3 = this.lastChar;
                        do {
                            int i4 = this.charIndex;
                            if (i4 <= 0) {
                                break;
                            }
                            CharSequence charSequence2 = this.text;
                            int i5 = i4 - 1;
                            this.charIndex = i5;
                            charAt2 = charSequence2.charAt(i5);
                            this.lastChar = charAt2;
                        } while (charAt2 != c3);
                    }
                }
            } else if (c2 != ';') {
                return directionality;
            } else {
                int i6 = this.charIndex;
                do {
                    int i7 = this.charIndex;
                    if (i7 <= 0) {
                        break;
                    }
                    CharSequence charSequence3 = this.text;
                    int i8 = i7 - 1;
                    this.charIndex = i8;
                    charAt = charSequence3.charAt(i8);
                    this.lastChar = charAt;
                    if (charAt == '&') {
                    }
                } while (charAt != ';');
                this.charIndex = i6;
                this.lastChar = ';';
                return 13;
            }
            return 12;
        }
    }

    public BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return 1;
     */
    public static int getEntryDir(CharSequence charSequence) {
        byte b;
        char charAt;
        char charAt2;
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence, false);
        directionalityEstimator.charIndex = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = directionalityEstimator.charIndex;
            if (i4 < directionalityEstimator.length && i == 0) {
                char charAt3 = directionalityEstimator.text.charAt(i4);
                directionalityEstimator.lastChar = charAt3;
                if (Character.isHighSurrogate(charAt3)) {
                    int codePointAt = Character.codePointAt(directionalityEstimator.text, directionalityEstimator.charIndex);
                    directionalityEstimator.charIndex = Character.charCount(codePointAt) + directionalityEstimator.charIndex;
                    b = Character.getDirectionality(codePointAt);
                } else {
                    directionalityEstimator.charIndex++;
                    char c = directionalityEstimator.lastChar;
                    b = c < 1792 ? DirectionalityEstimator.DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
                    if (directionalityEstimator.isHtml) {
                        char c2 = directionalityEstimator.lastChar;
                        if (c2 == '<') {
                            int i5 = directionalityEstimator.charIndex;
                            while (true) {
                                int i6 = directionalityEstimator.charIndex;
                                if (i6 < directionalityEstimator.length) {
                                    CharSequence charSequence2 = directionalityEstimator.text;
                                    directionalityEstimator.charIndex = i6 + 1;
                                    char charAt4 = charSequence2.charAt(i6);
                                    directionalityEstimator.lastChar = charAt4;
                                    if (charAt4 != '>') {
                                        if (charAt4 == '\"' || charAt4 == '\'') {
                                            char c3 = directionalityEstimator.lastChar;
                                            do {
                                                int i7 = directionalityEstimator.charIndex;
                                                if (i7 < directionalityEstimator.length) {
                                                    CharSequence charSequence3 = directionalityEstimator.text;
                                                    directionalityEstimator.charIndex = i7 + 1;
                                                    charAt2 = charSequence3.charAt(i7);
                                                    directionalityEstimator.lastChar = charAt2;
                                                }
                                            } while (charAt2 != c3);
                                        }
                                    }
                                } else {
                                    directionalityEstimator.charIndex = i5;
                                    directionalityEstimator.lastChar = '<';
                                    b = 13;
                                }
                            }
                        } else if (c2 == '&') {
                            do {
                                int i8 = directionalityEstimator.charIndex;
                                if (i8 < directionalityEstimator.length) {
                                    CharSequence charSequence4 = directionalityEstimator.text;
                                    directionalityEstimator.charIndex = i8 + 1;
                                    charAt = charSequence4.charAt(i8);
                                    directionalityEstimator.lastChar = charAt;
                                }
                            } while (charAt != ';');
                        }
                        b = 12;
                    }
                }
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                }
                i = i3;
            } else if (i == 0) {
                return 0;
            } else {
                if (i2 != 0) {
                    return i2;
                }
                while (directionalityEstimator.charIndex > 0) {
                    switch (directionalityEstimator.dirTypeBackward()) {
                        case 14:
                        case 15:
                            if (i == i3) {
                                break;
                            }
                            break;
                        case 16:
                        case 17:
                            if (i == i3) {
                                break;
                            }
                            break;
                        case 18:
                            i3++;
                            continue;
                    }
                    i3--;
                }
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return 1;
     */
    public static int getExitDir(CharSequence charSequence) {
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence, false);
        directionalityEstimator.charIndex = directionalityEstimator.length;
        int i = 0;
        while (true) {
            int i2 = i;
            while (directionalityEstimator.charIndex > 0) {
                byte dirTypeBackward = directionalityEstimator.dirTypeBackward();
                if (dirTypeBackward != 0) {
                    if (dirTypeBackward == 1 || dirTypeBackward == 2) {
                        if (i2 != 0) {
                            if (i == 0) {
                                i = i2;
                            }
                        }
                    } else if (dirTypeBackward != 9) {
                        switch (dirTypeBackward) {
                            case 14:
                            case 15:
                                if (i == i2) {
                                    break;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i == i2) {
                                    break;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i != 0) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                        i = i2;
                    } else {
                        continue;
                    }
                } else if (i2 != 0) {
                    if (i == 0) {
                        i = i2;
                    }
                }
            }
            return 0;
        }
        return -1;
    }

    public static BidiFormatter getInstance() {
        boolean z = true;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z = false;
        }
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = DEFAULT_TEXT_DIRECTION_HEURISTIC;
        if (textDirectionHeuristicCompat == DEFAULT_TEXT_DIRECTION_HEURISTIC) {
            return z ? DEFAULT_RTL_INSTANCE : DEFAULT_LTR_INSTANCE;
        }
        return new BidiFormatter(z, 2, textDirectionHeuristicCompat);
    }
}
