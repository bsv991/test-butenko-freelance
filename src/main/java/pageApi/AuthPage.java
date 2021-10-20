package pageApi;

import com.google.gson.Gson;
import entity.Auth;
import io.qameta.allure.Step;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AuthPage {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api/auth";
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static ResponseBody response;
    private static Call call;


    public static Auth signin(String username, String password) {
        Auth auth = new Auth();
        auth.setUsername(username);
        auth.setPassword(password);
        return auth;
    }

    public static Auth signup(String username, String password) {
        Auth auth = new Auth();
        auth.setUsername(username);
        auth.setPassword(password);
        auth.setConfirmPassword(password);
        return auth;
    }

    @Step("Request getToken")
    public static String getToken() throws IOException {
        Auth authSignin = signin("User20011", "User200011");
        String jsonObject = new Gson().toJson(authSignin);
        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(baseUrl + "/signin")
                .post(requestBody)
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        JSONObject responseJson = new JSONObject(response.string());
        return responseJson.getString("token");
    }

    @Step("Request postSignin")
    public static String postSignin(String jsonObject) throws IOException {
        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(baseUrl + "/signin")
                .post(requestBody)
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request postSignup")
    public static String postSignup(String jsonObject) throws IOException {
        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .post(requestBody)
                .url(baseUrl + "/signup")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }
}
