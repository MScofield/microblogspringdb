package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by scofieldservices on 12/21/16.
 */

@Controller
public class MicroblogSpringDBController {
    @Autowired
    MicroblogRepository microblog;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session)
    {
        model.addAttribute("messages", microblog.findAll());
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }//end of home/"slash"route

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String message(HttpSession session, String userName)
    {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }//end of route "login"

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String message(String messageText)
    {
        Message msg = new Message(messageText);
        microblog.save(msg);
        return "redirect:/";
    }//end of route "add"

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(int messageId)
    {
        microblog.delete(messageId);
        return "redirect:/";
    }//end of route "delete"

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String edit(int messageId, String messageText) {
        Message msg = microblog.findOne(messageId);
        msg.messageText = messageText;
        microblog.save(msg);
        return "redirect:/";
    }// end of route "edit"
}// end public class microblogcontroller