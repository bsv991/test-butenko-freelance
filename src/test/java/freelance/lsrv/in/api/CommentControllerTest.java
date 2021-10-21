package freelance.lsrv.in.api;

import com.google.gson.Gson;
import entity.Comment;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static pageApi.CommentPage.*;

public class CommentControllerTest {

    @Test
    public void testCreateComment() throws IOException {
        Comment comment = createComment(392);
        String jsonObject = new Gson().toJson(comment);
        JSONObject responseJson = new JSONObject(postCreateComment(392, jsonObject));
        System.out.println("Response - " + responseJson);
        String username = responseJson.getString("username");
        Assert.assertEquals(username, "User20011", "Username success");
    }

    @Test
    public void testGetComment() throws IOException {
        System.out.println("Response - " + getCommentById("392"));
    }
}
