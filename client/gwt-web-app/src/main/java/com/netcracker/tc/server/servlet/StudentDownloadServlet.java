package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.service.api.PDFService;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentDownloadServlet extends AutoinjectingRemoteServiceServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResumeDownloadServlet.class);

    @Autowired
    PDFService pdfService;

    @Autowired
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            downloadFile(req, resp);
        } catch (ServiceException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (SessionExpiredException e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

            LOGGER.error("Attempt to user access system [userId={}]", e.getUserId());
        }
    }

    private void downloadFile(HttpServletRequest req, HttpServletResponse response) throws IOException, ServiceException, SessionExpiredException {
        Long userId = Session.getExistUserId();

        UserDTO user = userService.getUser(userId);
        RoleDTO role = user.getRole();

        if (role.isStudent()) {
            throw new SessionExpiredException("Current user is student", userId);
        }

        Long userIdFromRequest = Long.valueOf(req.getParameter("user"));

        pdfService.createActiveInterviewDevResumePDF(userIdFromRequest, response.getOutputStream());

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + "userResume.pdf");
    }
}