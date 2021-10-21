package freelance.lsrv.in.api;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static pageApi.ImagePage.*;

public class ImageControllerTest {

    @Test
    public void testImageUpload() throws IOException {
        JSONObject responseJson = new JSONObject(postUploadImage());
        System.out.println("Response - " + responseJson);
        String message = responseJson.getString("message");
        Assert.assertEquals(message, "User image was uploaded", "User image was uploaded");
    }

    @Test
    public void testGetImageProfile() throws IOException {
        JSONObject responseJson = new JSONObject(getImageProfile());
        System.out.println("Response - " + responseJson);
        String name = responseJson.getString("name");
        Assert.assertEquals(name, "image.png", "name success");
    }

    @Test
    public void testGetImageProfileUserId() throws IOException {
        int code = getImageProfileUserId(38).code();
        Assert.assertEquals(code, 200, "code success");
    }
}