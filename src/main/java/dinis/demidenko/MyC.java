package dinis.demidenko;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dende on 12.11.2016.
 */
@Controller
@RequestMapping("/")
public class MyC {

    public ArrayList<String > message = new ArrayList<String>();
    public Map<String, String > ipLog = new HashMap<String, String>();

    public String login;
    public String ip;

    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    @RequestMapping("/work2")
    public String Inde(@RequestParam("login") String login) {
        this.login = login;
        return "test";
    }


    @RequestMapping(value = "/work", method = RequestMethod.POST)
    public String onIndex(Model model, @RequestParam("mes") String mes) {
        String temp = login + ": " + mes;
        message.add(temp);
        model.addAttribute("arr", message);


        return "test";
    }


}
