package freelance.lsrv.in.api;

import com.google.gson.Gson;
import entity.User;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static pageApi.UserPage.*;
import static pageApi.UserPage.getUserId;

public class UserControllerTest {

    @Test
    public void testUpdateUser() throws IOException {
        User userUpdate = user(166);
        String jsonObject = new Gson().toJson(userUpdate);
        JSONObject responseJson = new JSONObject(postUpdateUser(jsonObject));
        System.out.println("Response - " + responseJson);
        int id = responseJson.getInt("id");
        String username = responseJson.getString("username");
        String name = responseJson.getString("name");
        String lastname = responseJson.getString("lastname");
        Assert.assertEquals(id, 166, "id true");
        Assert.assertEquals(username, "User20011", "username true");
        Assert.assertEquals(name, "Sergey", "name true");
        Assert.assertEquals(lastname, "Butenko", "lastname true");
    }

    @Test
    public void testGetUserId() throws IOException {
        JSONObject responseJson = new JSONObject(getUserId(166));
        String username = responseJson.getString("username");
        Assert.assertEquals(username, "User20011", "User get success");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void testGetUserId2() throws IOException {
        JSONObject responseJson = new JSONObject(getUserId(165));
        String username = responseJson.getString("username");
        Assert.assertEquals(username, "User2001", "User get success");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void testGetUser() throws IOException {
        JSONObject responseJson = new JSONObject(getUser());
        String username = responseJson.getString("username");
        Assert.assertEquals(username, "User20011", "User get success");
        System.out.println("Response - " + responseJson);
    }
}