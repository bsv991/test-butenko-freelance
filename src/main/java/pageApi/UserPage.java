package pageApi;

import entity.User;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static pageApi.AuthPage.getToken;

public class UserPage {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api/user/";
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static ResponseBody response;
    private static Call call;

    public static User user(int id) {
        User user = new User();
        user.setId(id);
        user.setUsername("User20011");
        user.setName("Sergey");
        user.setLastname("Butenko");
        return user;
    }

    @Step("Request getUser")
    public static String getUser () throws IOException {
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .url(baseUrl)
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getUserId")
    public static String getUserId (int userId) throws IOException {
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + userId)
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request postUpdateUser")
    public static String postUpdateUser (String jsonObject) throws IOException {
        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .post(requestBody)
                .url(baseUrl + "update")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

}
