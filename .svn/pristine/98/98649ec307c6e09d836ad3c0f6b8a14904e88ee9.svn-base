package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.service.api.ImageService;
import com.netcracker.tc.server.service.api.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FileUploadServlet extends AutoinjectingRemoteServiceServlet {

    public static final long UPLOAD_FILE_MAX_SIZE = 409600;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadServlet.class);

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {

            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(req);
                if (items.size() == 1) {
                    FileItem item = items.get(0);
                    if (item.getSize() > UPLOAD_FILE_MAX_SIZE){
                        response.setContentType("text/html; charset=cp1251");
                        response.getWriter().print("Невозможно загрузить фото. Максимальный размер файла - 400 КБ");
                        response.flushBuffer();
                        return;
                    }
                    String imagePath = imageService.saveUserPhoto(item);

                    response.setContentType("text/html; charset=cp1251");
                    response.getWriter().print(imagePath);
                    response.flushBuffer();
                }
            } catch (Exception e) {
                LOGGER.error("Error processing FileUploadServlet", e);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        "An error occurred while creating the file : " + e.getMessage());
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    "Request contents type is not supported by the servlet.");
            return;
        }
    }
}