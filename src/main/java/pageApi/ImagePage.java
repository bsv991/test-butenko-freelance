package pageApi;

import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;

import static pageApi.AuthPage.getToken;

public class ImagePage {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api/image/";
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static ResponseBody response;
    private static Call call;

    @Step("Request postUploadImage")
    public static String postUploadImage() throws IOException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", "image.png",
                        RequestBody.create(MediaType.parse("png"), "src/test/resources/image.png")).build();
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", getToken())
                .post(requestBody)
                .url(baseUrl + "upload")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getImageProfile")
    public static String getImageProfile() throws IOException {
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + "profile")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getImageProfileUserId")
    public static Response getImageProfileUserId(int id) throws IOException {
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + id)
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        Response response = call.execute();
        return response;
    }
}
