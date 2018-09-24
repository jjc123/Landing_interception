package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import user.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
    /*
    跳转到登陆界面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "/userLogin";
    }

    /*
    判断登陆的用户是否存在，这里没有数据库，就用一个jjc 123456代替
     */
    @RequestMapping("login")
    public String login(Model model, HttpServletRequest request, User user){
        if(checkUser(user)){
            request.getSession().setAttribute("user",user);
        }else{
            model.addAttribute("error","账号或者密码错误");
            return "/userLogin";
        }
        return "/loginSuccess";
    }
    /*
    注销session中的用户信息
     */
    @RequestMapping("outLogin")
    public String outLogin(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("user")!=null){
            request.getSession().removeAttribute("user");
        }else{
            model.addAttribute("error","注销失败");
        }
        return "/userLogin";
    }

    /*
    其他资源 只有带着session信息的浏览器可以访问
   */
    @RequestMapping("other")
    public String other(){
       return "/other";
    }

    /*
    判断是否存在用户
     */
    private boolean checkUser(User user){
        if("jjc".equals(user.getName())&&"123456".equals(user.getPwd())){
            return true;
        }
        return false;
    }
}
