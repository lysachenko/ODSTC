package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.api.XlsService;
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

public class InterviewResultServlet extends AutoinjectingRemoteServiceServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResumeDownloadServlet.class);

    @Autowired
    XlsService xlsService;

    @Autowired
    UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Invoked InterviewResultServlet");

        try {
            downloadInterviewResults(req, resp);
        } catch (ServiceException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (SessionExpiredException e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

            LOGGER.error("Attempt to user access system [userId={}]", e.getUserId());
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());

            LOGGER.error("Can't create xlsx document. ", e);
        }
    }

    private void downloadInterviewResults(HttpServletRequest req, HttpServletResponse response) throws IOException, ServiceException, SessionExpiredException {
        Long userId = Session.getExistUserId();

        UserDTO user = userService.getUser(userId);
        RoleDTO role = user.getRole();

        if (role.isStudent()) {
            throw new SessionExpiredException("Current user is student", userId);
        }

        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment; filename=users.xlsx");

        xlsService.createInterviewResultXls(userId, response.getOutputStream());

        LOGGER.info("xls file sent");
    }
}
