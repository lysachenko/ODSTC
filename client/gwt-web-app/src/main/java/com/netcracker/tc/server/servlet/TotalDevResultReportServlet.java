package com.netcracker.tc.server.servlet;

import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.api.XlsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.exception.SessionExpiredException;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TotalDevResultReportServlet extends AutoinjectingRemoteServiceServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(TotalDevResultReportServlet.class);

    @Autowired
    XlsService xlsService;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.info("Invoked InterviewResultServlet");

        try {
            downloadTotalDevResultReport(resp);
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

    private void downloadTotalDevResultReport(HttpServletResponse response) throws IOException, ServiceException, SessionExpiredException {
        Long userId = Session.getExistUserId();

        UserDTO user = userService.getUser(userId);
        RoleDTO role = user.getRole();

        if (role.isStudent()) {
            throw new SessionExpiredException("Current user is student", userId);
        }

        if (userDao.getAllStudents().isEmpty()) {
            response.setContentType("text/html; charset=UTF-8");

            // language=html
            response.getWriter().println("<body>" +
                    "<h1>Ни одного студента не зарегистрировано, нет данных для отчета.</h1></body>");

            response.getWriter().flush();
            response.getWriter().close();
        } else {
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=users.xlsx");

            xlsService.createTotalDevReport(response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
        }

        LOGGER.info("Xls file sent");
    }
}
