/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.filter.login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.entities.ImsUser;

/**
 *
 * @author Administrator
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig = null;

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = (session != null) && (session.getAttribute("user") != null);

        //     System.out.println("登录名是"+session.getAttribute("name"));// 如果为空该语句要报警
        if (!isLoggedIn) {
            System.out.println("用户未登录，在此转向");
            // res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");

            //如果使用response.sendRedirect(),会报session为空的异常，所以使用RequestDispather.forward()
            req.getRequestDispatcher("/faces/login.xhtml").forward(req, res);
            //如果登录，但用户权限是normal，并且访问的不是他权限内的页面，就让他去index页面
        } else if ((req.getRequestURI().startsWith("/CsIms/faces/imsUser")||req.getRequestURI().startsWith("/CsIms/faces/userGroup"))&&((ImsUser) session.getAttribute("user")).getUserGroup().getGroupName().equals("normal")) {
            //System.out.println("组别是" + ((ImsUser) session.getAttribute("user")).getUserGroup().getGroupName());
            System.out.println(req.getRequestURI().startsWith("/CsIms/faces/imsUser"));
            req.getRequestDispatcher("/faces/index.xhtml").forward(req, res);
        }
        chain.doFilter(request, response);

    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

}
