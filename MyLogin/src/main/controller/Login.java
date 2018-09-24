package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import user.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {

    @RequestMapping("toLogin")
    public String toLogin(){
        return "/userLogin";
    }
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
    @RequestMapping("outLogin")
    public String outLogin(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("user")!=null){
            request.getSession().removeAttribute("user");
        }else{
            model.addAttribute("error","注销失败");
        }
        return "/userLogin";
    }
    @RequestMapping("other")
    public String other(){
       return "/other";
    }
    private boolean checkUser(User user){
        if("jjc".equals(user.getName())&&"123456".equals(user.getPwd())){
            return true;
        }
        return false;
    }
}
