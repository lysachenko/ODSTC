package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.service.exception.ServiceException;

import java.io.OutputStream;

public interface PDFService {

    void createActiveInterviewDevResumePDF(Long userID, OutputStream outputStream) throws ServiceException;
}