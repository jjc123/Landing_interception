package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //判断是否为登陆请求（跟登陆相关的网址都放行）
        if(!(url.contains("login")||url.contains("Login"))){
            if(request.getSession().getAttribute("user")!=null){
                //有登陆状态
                return true;
            }else{
                //没有登陆状态
                response.sendRedirect(request.getContextPath()+"/toLogin.action");
            }
        }else{
            //登陆请求直接放行
            return true;
        }
        //默认拦截
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { }
}
