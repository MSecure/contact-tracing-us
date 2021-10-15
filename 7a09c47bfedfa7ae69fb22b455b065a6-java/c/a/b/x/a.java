package c.a.b.x;

import c.a.b.h;
import c.a.b.o;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class a {
    public abstract e executeRequest(o<?> oVar, Map<String, String> map);

    @Deprecated
    public final HttpResponse performRequest(o<?> oVar, Map<String, String> map) {
        e executeRequest = executeRequest(oVar, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), executeRequest.f2881a, ""));
        ArrayList arrayList = new ArrayList();
        for (h hVar : Collections.unmodifiableList(executeRequest.f2882b)) {
            arrayList.add(new BasicHeader(hVar.f2820a, hVar.f2821b));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStream = executeRequest.f2884d;
        if (inputStream != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStream);
            basicHttpEntity.setContentLength((long) executeRequest.f2883c);
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
