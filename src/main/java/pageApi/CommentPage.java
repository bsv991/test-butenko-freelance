package pageApi;

import entity.Comment;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static pageApi.AuthPage.getToken;

public class CommentPage {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api/comment/";
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static ResponseBody response;
    private static Call call;

    public static Comment createComment(int id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setMessage("Massage 1");
        comment.setUsername("User20011");
        comment.setCommentDate("20.10.2021");
        return comment;
    }

    @Step("Request postCreateComment")
    public static String postCreateComment(int jobId, String jsonObject) throws IOException {
        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", getToken())
                .post(requestBody)
                .url(baseUrl + jobId + "/create")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getCommentById")
    public static String getCommentById(String id) throws IOException {
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + id + "/all")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }
}
