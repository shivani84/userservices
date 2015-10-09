package com.mk;

import com.mk.services.UserServices;
import com.mk.vo.User;
import org.codehaus.jackson.map.ObjectMapper;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;

import static spark.Spark.before;
import static spark.Spark.post;

/**
 * Created by shivani on 7/29/15.
 */
public class Controller {
    private static UserServices userServices;
    public static void main(String[] args) {
        post(new Route("/authenticate") {
            public Object handle(Request request, Response response) {
                return userServices.authenticateUser(request);
            }
        });
        post(new Route("/userdetails") {
            public Object handle(Request request, Response response) {
                return userServices.getUserDetails(request);
            }
        });
        post(new Route("/adduser") {
            public Object handle(Request request, Response response) {
                return userServices.addUser(request);
            }
        });
        post(new Route("/removeuser") {
            public Object handle(Request request, Response response) {
                return userServices.removeUser(request);
            }
        });

        before(new Filter() {
            @Override
            public void handle(Request request, Response response) {
                if (userServices == null)
                    userServices = new UserServices();
                System.out.println("before!!");
                response.header("Access-Control-Allow-Origin", "*");
            }
        });
    }
}
