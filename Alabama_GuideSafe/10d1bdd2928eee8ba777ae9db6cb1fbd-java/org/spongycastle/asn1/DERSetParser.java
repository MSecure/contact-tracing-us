package org.spongycastle.asn1;

import java.io.IOException;

public class DERSetParser implements ASN1SetParser {
    public ASN1StreamParser _parser;

    public DERSetParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DERSet(this._parser.readVector(), false);
    }

    @Override // org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return new DERSet(this._parser.readVector(), false);
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
