package com.netcracker.tc.server.servlet;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by unconsionable on 22.08.2014.
 */
public class AutoinjectingRemoteServiceServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(config.getServletContext());
        AutowireCapableBeanFactory beanFactory = ctx
                .getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }
}