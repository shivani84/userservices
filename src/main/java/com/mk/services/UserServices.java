package com.mk.services;

import com.mk.utils.JsonUtils;
import com.mk.vo.User;
import com.mk.vo.UserDetails;
import spark.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shivani on 7/30/15.
 */
public class UserServices {
    private static final String ERROR = "error";

    private Map<String, UserDetails> usersMap = new HashMap<String, UserDetails>();
    private List<UserDetails> users = new ArrayList<UserDetails>();

    public UserServices() {
        users.add(new UserDetails("shivanik", "shivani", "Kotadiya", "Admin", 30));
        users.add(new UserDetails("shivaniv", "Shivani", "Viradia", "Admin", 30));
        users.add(new UserDetails("ramp", "Ram", "Patel", "Resricted", 8));
        users.add(new UserDetails("aaryap", "Aarya", "Patel", "Resricted", 6));
        users.add(new UserDetails("anjalip", "Anjali", "Patel", "Resricted", 36));

        for (UserDetails user:users) {
            usersMap.put(user.getUsername(), user);

        }
    }


    public String authenticateUser(Request request) {
        String body = request.body();
        if (body.length() == 0) {
            return ERROR;
        }
        User user = null;
        user = JsonUtils.jsonToPojo(body, User.class);
        if (user == null)
            return "Error while parsing body";
        System.out.println("Authenticating " + user.getUserid());
        if (user.getUserid().toLowerCase().equals("shivani")){// && user.getPassword().equals("Shivani")) {
            String json = JsonUtils.pojoToJson(getAllUsers());
            return json;
        }
        else
            return ERROR;
    }

    private List<UserDetails> getAllUsers() {

        return users;
    }

    public String getUserDetails(Request request) {
        String username = request.body();
        UserDetails userDetails = usersMap.get(username);
        return JsonUtils.pojoToJson(userDetails);
    }

    public String addUser(Request request) {
        try {
            String body = request.body();
            UserDetails userDetails = JsonUtils.jsonToPojo(body, UserDetails.class);
            usersMap.put(userDetails.getUsername(), userDetails);
            users.add(userDetails);
            return JsonUtils.pojoToJson(getAllUsers());
        } catch (Exception e) {
            return ERROR;
        }
    }

    public Object removeUser(Request request) {
        try {
            String username = request.body();
            UserDetails userDetails = usersMap.get(username);
            users.remove(userDetails);
            removeUser(username);
            return JsonUtils.pojoToJson(getAllUsers());
        } catch (Exception e) {
            return ERROR;
        }
    }

    private void removeUser(String username) {
        for (UserDetails UserDetails:users) {
            if (UserDetails.getUsername().equals(username)) {
                users.remove(UserDetails);
                return;
            }
        }
    }
}
