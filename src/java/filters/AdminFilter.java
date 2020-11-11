package filters;

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

public class AdminFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        // This code will execute before the servlet
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session =  httpRequest.getSession();
        
        String userrole = (String) session.getAttribute("userrole");
        
        if ( !userrole.equals("system admin") ) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("notes");
            return;
        }
        
        // Execute the servlet, or next filter in the chain
        chain.doFilter(request, response);
        
        
        // This code will execute after the servlet
        
    }    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    
}
