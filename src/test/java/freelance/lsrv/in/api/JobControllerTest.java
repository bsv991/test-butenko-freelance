package freelance.lsrv.in.api;

import com.google.gson.Gson;
import entity.Job;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

import static pageApi.JobPage.*;

public class JobControllerTest {
    private int id;

    @Test(priority = 10)
    public void testCreateJob() throws IOException {
        Job job = jobCreate(100);
        String jsonObject = new Gson().toJson(job);
        JSONObject responseJson = new JSONObject(postCreateJob(jsonObject));
        System.out.println("Response - " + responseJson);
        String user = responseJson.getString("user");
        String title = responseJson.getString("title");
        String description = responseJson.getString("description");
        int price = responseJson.getInt("price");
        id = responseJson.getInt("id");
        Assert.assertEquals(user, "Sergey Butenko", "User success");
        Assert.assertEquals(title, "Title 1", "Title success");
        Assert.assertEquals(description, "Description 1", "Description success");
        Assert.assertEquals(price, 1000, "price success");
    }

    @Test(priority = 20)
    public void testGetJobId() throws IOException {
        JSONObject responseJson = new JSONObject(getJobId(id));
        String user = responseJson.getString("user");
        System.out.println("Response - " + responseJson);
        Assert.assertEquals(user, "Sergey Butenko", "User success");
    }

    @Test(priority = 30)
    public void testGetJobUser() throws IOException {
        System.out.println("Response - " + getJobUserJobs());
    }

    @Test(priority = 40)
    public void testGetJobAll() throws IOException {
        System.out.println("Response - " + getJobAll());
    }

    @Test(priority = 60)
    public void testDeleteJobId() throws IOException {
        System.out.println("Response - " + getJobId(id));
        JSONObject responseJson = new JSONObject(postDeleteJob(String.valueOf(id)));
        System.out.println("Response - " + responseJson);
        String message = responseJson.getString("message");
        Assert.assertEquals(message, "Job is deleted", "Job is deleted");
    }
}