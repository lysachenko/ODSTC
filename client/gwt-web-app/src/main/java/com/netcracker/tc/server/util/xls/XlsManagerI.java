package com.netcracker.tc.server.util.xls;

import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface XlsManagerI
{
    public abstract void initWorkbook();

    public abstract void loadTemplate(String paramString);

    public abstract void writeWorkbook(List paramList);

    public abstract void writeToFile(String paramString)
            throws IOException;

    public abstract void writeToStream(OutputStream paramOutputStream)
            throws IOException;
}
