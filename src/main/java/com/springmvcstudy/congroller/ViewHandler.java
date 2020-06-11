package com.springmvcstudy.congroller;

import com.springmvcstudy.entity.Address;
import com.springmvcstudy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/view")
@SessionAttributes(value = {"user", "address"})
// @SessionAttributes(types = {User.class, Address.class})
public class ViewHandler {

    @RequestMapping("/map")
    public String map(Map<String,User> map) {
        User user = new User();
        user.setId(1L);
        user.setName("张三(map)");
        map.put("user", user);
        return "view";
    }

    @RequestMapping("/model")
    public String model(Model model) {
        User user = new User();
        user.setId(1L);
        user.setName("张三(model)");
        model.addAttribute("user", user);
        return "view";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView)");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView2)");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        View view = new InternalResourceView("/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView3)");
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView4)");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView5)");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        ModelAndView modelAndView = new ModelAndView("view", map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView6)");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        View view = new InternalResourceView("/view.jsp");
        return new ModelAndView(view, map);
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView7)");
        return new ModelAndView("view", "user",user);
    }

    @RequestMapping("/modelAndView8")
    public ModelAndView modelAndView8() {
        User user = new User();
        user.setId(1L);
        user.setName("张三(ModelAndView8)");
        View view = new InternalResourceView("/view.jsp");
        return new ModelAndView(view, "user",user);
    }

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        User user = new User();
        user.setId(1L);
        user.setName("张三(request)");
        request.setAttribute("user", user);
        return "view";
    }

//    @ModelAttribute
//    public User getUser() {
//        User user = new User();
//        user.setId(1L);
//        user.setName("张三(modelAttribute)");
//        return user;
//    }

//    @ModelAttribute
//    public void getUser(Map<String,User> map) {
//        User user = new User();
//        user.setId(1L);
//        user.setName("张三(modelAttribute2)");
//        map.put("user",user);
//    }

    @ModelAttribute
    public void getUser(Model model) {
        User user = new User();
        user.setId(1L);
        user.setName("张三(modelAttribute3)");
        model.addAttribute("user",user);
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute() {
        return "view";
    }

    @RequestMapping("/session")
    public String session(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = new User();
        user.setId(1L);
        user.setName("张三(session)");
        session.setAttribute("user", user);
        return "view";
    }

    @RequestMapping("/session2")
    public String session2(HttpSession session) {
        User user = new User();
        user.setId(1L);
        user.setName("张三(session)");
        session.setAttribute("user", user);
        return "view";
    }

    @RequestMapping("/application")
    public String application(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        User user = new User();
        user.setId(1L);
        user.setName("张三(application)");
        application.setAttribute("user",user);
        return "view";
    }
}
