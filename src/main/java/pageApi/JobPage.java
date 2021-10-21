package pageApi;

import entity.Job;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static pageApi.AuthPage.getToken;

public class JobPage {
    private static String baseUrl = "https://freelance.lsrv.in.ua/api/job/";
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static ResponseBody response;
    private static Call call;

    public static Job jobCreate(int id) {
        Job job = new Job();
        job.setId(id);
        job.setTitle("Title 1");
        job.setDescription("Description 1");
        job.setPrice("1000");
        job.setUser("Sergey Butenko");
        job.setNoOfComments(0);
        return job;
    }

    @Step("Request postCreateJob")
    public static String postDeleteJob (String id) throws IOException {
        requestBody = RequestBody.create(null, new byte[0]);
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + "delete/" + id)
                .post(requestBody)
                .build();
        System.out.println("url - " + baseUrl + "delete/" + id);
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request postCreateJob")
    public static String postCreateJob (String jsonObject) throws IOException {
        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .post(requestBody)
                .url(baseUrl + "create")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getJobId")
    public static String getJobId (int id) throws IOException {
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + id)
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getJobUserJobs")
    public static String getJobUserJobs () throws IOException {
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + "user/jobs")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }

    @Step("Request getJobAll")
    public static String getJobAll () throws IOException {
        request = new Request.Builder()
                .header("Content-Type" , "application/json")
                .header("Authorization", getToken())
                .url(baseUrl + "all")
                .build();
        client = new OkHttpClient();
        call = client.newCall(request);
        response = call.execute().body();
        return response.string();
    }
}