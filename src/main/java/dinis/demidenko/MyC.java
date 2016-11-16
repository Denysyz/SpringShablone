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
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dende on 12.11.2016.
 */
@Controller
@RequestMapping("/")
public class MyC {

    DataBase db = new DataBase();

    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    @RequestMapping("/page1")
    public String page(Model model, @RequestParam("login") String login, @RequestParam("password") String password) {

        String res ="index";
        try {
            PreparedStatement ps = db.createCon().prepareStatement("SELECT * FROM idPass");
            PreparedStatement ps2 = db.createCon().prepareStatement("SELECT * FROM param");
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            while (rs.next()) {
                System.out.println(1);
                if (rs.getString(1).equals(login) & rs.getString(2).equals(password)){
                    System.out.println(2);
                    while (rs2.next()){
                        System.out.println(3);
                        if(rs2.getString(1).equals(login)){
                            System.out.println(4);
                            model.addAttribute("namefull", rs2.getString(3) + " " + rs2.getString(2));
                            res = "page";
                        }
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping("/registration")
    public String registr() {
        return "registration";
    }

    @RequestMapping("/registration2")
    public String registr2(@RequestParam("login") String login, @RequestParam("password") String password,
                           @RequestParam("name") String name, @RequestParam("surname") String surname,
                           @RequestParam("age") String age, @RequestParam("country") String country) {
        db.addLogin(login, password);
        db.addParam(login, name, surname, age, country);
        return "index";


    }
}
