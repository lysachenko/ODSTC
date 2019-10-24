package com.netcracker.tc.server.util.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

public class AcroFieldsWrapper {

    private AcroFields acroFields;

    public AcroFieldsWrapper(AcroFields acroFields) {
        this.acroFields = acroFields;
    }

    public void setField(String field, String value) throws IOException, DocumentException {
        acroFields.setField(field, value == null ? "" : value);
    }
}
