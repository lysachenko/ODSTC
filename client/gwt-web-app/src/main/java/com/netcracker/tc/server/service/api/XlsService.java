package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.service.exception.ServiceException;

import javax.servlet.ServletOutputStream;

public interface XlsService {
    public void createInterviewResultXls(Long paramLong, ServletOutputStream paramServletOutputStream) throws ServiceException;
    public void createTotalDevReport(ServletOutputStream outputStream) throws ServiceException;
}
