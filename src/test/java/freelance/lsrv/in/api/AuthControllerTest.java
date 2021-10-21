package freelance.lsrv.in.api;

import com.google.gson.Gson;
import entity.Auth;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static pageApi.AuthPage.*;
import static pageApi.AuthPage.postSignup;

public class AuthControllerTest {

    @Test
    public void testSignin() throws IOException {
        Auth authSignin = signin("User20011", "User200011");
        String jsonObject = new Gson().toJson(authSignin);
        JSONObject responseJson = new JSONObject(postSignin(jsonObject));
        boolean success = responseJson.getBoolean("success");
        Assert.assertTrue(success, "Signin true");
        System.out.println("Response - " + responseJson);
    }

    @Test
    public void testSignup() throws IOException {
        Auth authSignup = signup("User20011", "User200011");
        String jsonObject = new Gson().toJson(authSignup);
        JSONObject responseJson = new JSONObject(postSignup(jsonObject));
        String message = responseJson.getString("message");
        Assert.assertEquals(message, "User registered successfully", "User registered successfully");
        System.out.println("Response - " + responseJson);
    }
}
