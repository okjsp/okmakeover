package net.okjsp.user.service;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.ELRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: langerhans
 * Date: 2014. 1. 14.
 * Time: 오후 4:07
 * Description : CustomAwareLoginUrlAuthenticationEntryPoint
 */
public class CustomAwareLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private static final RequestMatcher requestMatcher = new ELRequestMatcher("hasHeader('Content-Type','application/json')");

    public CustomAwareLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
        if(isPreflight(request)){
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else if (isRestRequest(request)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } else {
            super.commence(request, response, authException);
        }
    }

    /**
     * Checks if this is a X-domain pre-flight request.
     * @param request
     * @return
     */
    private boolean isPreflight(HttpServletRequest request) {
        return "OPTIONS".equals(request.getMethod());
    }

    /**
     * Checks if it is a rest request
     * @param request
     * @return
     */
    protected boolean isRestRequest(HttpServletRequest request) {
        return requestMatcher.matches(request);
    }
}
