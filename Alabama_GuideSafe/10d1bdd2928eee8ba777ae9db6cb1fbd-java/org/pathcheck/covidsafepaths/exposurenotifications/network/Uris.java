package org.pathcheck.covidsafepaths.exposurenotifications.network;

import android.net.Uri;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.base.CommonPattern;
import com.google.common.base.JdkPattern;
import com.google.common.base.Platform;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;

public class Uris {
    public static final Splitter WHITESPACE_SPLITTER;
    public final Uri baseDownloadUri = Uri.parse(BuildConfig.DOWNLOAD_BASE_URL);

    static {
        CommonPattern compilePattern = Platform.compilePattern("\\s+");
        Matcher matcher = ((JdkPattern) compilePattern).pattern.matcher("");
        if (matcher != null) {
            ReactYogaConfigProvider.checkArgument(!matcher.matches(), "The pattern may not match the empty string: %s", compilePattern);
            Splitter.AnonymousClass3 r1 = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: CONSTRUCTOR  (r1v6 'r1' com.google.common.base.Splitter$3) = (r0v1 'compilePattern' com.google.common.base.CommonPattern) call: com.google.common.base.Splitter.3.<init>(com.google.common.base.CommonPattern):void type: CONSTRUCTOR in method: org.pathcheck.covidsafepaths.exposurenotifications.network.Uris.<clinit>():void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.common.base.Splitter, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                */
            /*
                java.lang.String r0 = "\\s+"
                com.google.common.base.CommonPattern r0 = com.google.common.base.Platform.compilePattern(r0)
                r1 = r0
                com.google.common.base.JdkPattern r1 = (com.google.common.base.JdkPattern) r1
                java.util.regex.Pattern r1 = r1.pattern
                java.lang.String r2 = ""
                java.util.regex.Matcher r1 = r1.matcher(r2)
                r2 = 0
                if (r1 == 0) goto L_0x0036
                boolean r1 = r1.matches()
                r3 = 1
                r1 = r1 ^ r3
                java.lang.String r4 = "The pattern may not match the empty string: %s"
                com.facebook.react.uimanager.ReactYogaConfigProvider.checkArgument(r1, r4, r0)
                com.google.common.base.Splitter$3 r1 = new com.google.common.base.Splitter$3
                r1.<init>()
                com.google.common.base.CharMatcher$None r0 = com.google.common.base.CharMatcher.None.INSTANCE
                r0 = 2147483647(0x7fffffff, float:NaN)
                com.google.common.base.CharMatcher$Whitespace r4 = com.google.common.base.CharMatcher.Whitespace.INSTANCE
                if (r4 == 0) goto L_0x0035
                com.google.common.base.Splitter r2 = new com.google.common.base.Splitter
                r2.<init>(r1, r3, r4, r0)
                org.pathcheck.covidsafepaths.exposurenotifications.network.Uris.WHITESPACE_SPLITTER = r2
                return
            L_0x0035:
                throw r2
            L_0x0036:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.pathcheck.covidsafepaths.exposurenotifications.network.Uris.<clinit>():void");
        }

        public static /* synthetic */ void lambda$null$2(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, VolleyError volleyError) {
            Log.e("Uris", "Error getting keyfile index.");
            callbackToFutureAdapter$Completer.setCancelled();
        }

        public final int getStartIndex(List<String> list, String str) {
            int indexOf = list.indexOf(str);
            if (indexOf == -1) {
                return 0;
            }
            return indexOf + 1;
        }

        public Object lambda$getIndexFileContent$3$Uris(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) throws Exception {
            callbackToFutureAdapter$Completer.getClass();
            $$Lambda$zEKQ2PTVrbn4c1EtcY1_tvd2BM r0 = new Response.Listener() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$zEKQ2PTVrbn4c1EtcY1_tvd2BM */

                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    CallbackToFutureAdapter$Completer.this.set((String) obj);
                }
            };
            $$Lambda$Uris$JQ2wFz8PzyRH4qC5a0coG0W1ZEI r1 = new Response.ErrorListener() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.network.$$Lambda$Uris$JQ2wFz8PzyRH4qC5a0coG0W1ZEI */

                @Override // com.android.volley.Response.ErrorListener
                public final void onErrorResponse(VolleyError volleyError) {
                    Uris.lambda$null$2(CallbackToFutureAdapter$Completer.this, volleyError);
                }
            };
            Uri build = this.baseDownloadUri.buildUpon().appendEncodedPath("v1/index.txt").build();
            String str = "Getting index file from " + build;
            StringRequest stringRequest = new StringRequest(build.toString(), r0, r1);
            stringRequest.mShouldCache = false;
            MoreExecutors.get().add(stringRequest);
            return stringRequest;
        }

        public /* synthetic */ ImmutableList lambda$getKeyFileBatches$1$Uris(String str) {
            List<String> splitToList = WHITESPACE_SPLITTER.splitToList(str);
            splitToList.size();
            ArrayList arrayList = new ArrayList();
            splitToList.size();
            for (int startIndex = getStartIndex(splitToList, RealmSecureStorageBte.INSTANCE.getLastProcessedKeyZipFileName()); startIndex < splitToList.size(); startIndex++) {
                arrayList.add(this.baseDownloadUri.buildUpon().appendEncodedPath(splitToList.get(startIndex)).build());
            }
            ImmutableList.Builder builder = ImmutableList.builder();
            builder.add(KeyFileBatch.ofUris("regionCode", 1, arrayList));
            String.format("Batches: %s", builder.build());
            return builder.build();
        }
    }
