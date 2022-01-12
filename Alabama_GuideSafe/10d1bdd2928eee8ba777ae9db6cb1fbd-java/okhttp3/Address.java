package okhttp3;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {
    public final CertificatePinner certificatePinner;
    public final List<ConnectionSpec> connectionSpecs;
    public final Dns dns;
    public final HostnameVerifier hostnameVerifier;
    public final List<Protocol> protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String str, int i, Dns dns2, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator, Proxy proxy2, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns2 != null) {
            this.dns = dns2;
            if (socketFactory2 != null) {
                this.socketFactory = socketFactory2;
                if (authenticator != null) {
                    this.proxyAuthenticator = authenticator;
                    if (list != null) {
                        this.protocols = Util.immutableList(list);
                        if (list2 != null) {
                            this.connectionSpecs = Util.immutableList(list2);
                            if (proxySelector2 != null) {
                                this.proxySelector = proxySelector2;
                                this.proxy = proxy2;
                                this.sslSocketFactory = sSLSocketFactory;
                                this.hostnameVerifier = hostnameVerifier2;
                                this.certificatePinner = certificatePinner2;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.url.equals(address.url) && equalsNonHost(address);
        }
    }

    public boolean equalsNonHost(Address address) {
        return this.dns.equals(address.dns) && this.proxyAuthenticator.equals(address.proxyAuthenticator) && this.protocols.equals(address.protocols) && this.connectionSpecs.equals(address.connectionSpecs) && this.proxySelector.equals(address.proxySelector) && Objects.equals(this.proxy, address.proxy) && Objects.equals(this.sslSocketFactory, address.sslSocketFactory) && Objects.equals(this.hostnameVerifier, address.hostnameVerifier) && Objects.equals(this.certificatePinner, address.certificatePinner) && url().port() == address.url().port();
    }

    public int hashCode() {
        int hashCode = this.dns.hashCode();
        int hashCode2 = this.proxyAuthenticator.hashCode();
        int hashCode3 = this.protocols.hashCode();
        int hashCode4 = this.connectionSpecs.hashCode();
        int hashCode5 = this.proxySelector.hashCode();
        int hashCode6 = Objects.hashCode(this.proxy);
        int hashCode7 = Objects.hashCode(this.sslSocketFactory);
        int hashCode8 = Objects.hashCode(this.hostnameVerifier);
        return Objects.hashCode(this.certificatePinner) + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.url.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Address{");
        outline17.append(this.url.host());
        outline17.append(ColorPropConverter.PACKAGE_DELIMITER);
        outline17.append(this.url.port());
        if (this.proxy != null) {
            outline17.append(", proxy=");
            outline17.append(this.proxy);
        } else {
            outline17.append(", proxySelector=");
            outline17.append(this.proxySelector);
        }
        outline17.append("}");
        return outline17.toString();
    }

    public HttpUrl url() {
        return this.url;
    }
}
