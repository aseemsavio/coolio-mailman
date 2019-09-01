package com.coolio.mailman.service;

import com.coolio.mailman.bo.PostCreationEmailPayload;
import com.coolio.mailman.bo.CoolioMailResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aseem Savio
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CoolioEmailService.class)
@TestPropertySource("Classpath:/CoolioEmailServiceTest.properties")
public class CoolioEmailServiceTest {


    @Autowired
    CoolioEmailService coolioEmailService;

    private PostCreationEmailPayload gimmeCoolioMail() {
        PostCreationEmailPayload postCreationEmailPayload = new PostCreationEmailPayload();
        postCreationEmailPayload.setName("Aseem");
        postCreationEmailPayload.setFromAddress(coolioEmailService.getEmailId());
        postCreationEmailPayload.setToAddress("aseemsavio@gmail.com");
        postCreationEmailPayload.setSubject("my subject");
        return postCreationEmailPayload;
    }

    @Test
    public void sendPostCreatedEmailTest(){
        PostCreationEmailPayload postCreationEmailPayload = gimmeCoolioMail();
        Map<String, Object> model = new HashMap<>();
        model.put("name", postCreationEmailPayload.getName());

        System.out.println(postCreationEmailPayload.getName() + postCreationEmailPayload.getFromAddress() + coolioEmailService.getEmailId() + coolioEmailService.getPassword());
        CoolioMailResponse coolioMailResponse = coolioEmailService.sendPostCreatedEmail(postCreationEmailPayload, model);
        Assert.assertEquals(coolioMailResponse.getMessage(), "Post Creation Email to: savio@gmail.com SUCCESSFUL");
        Assert.assertTrue(coolioMailResponse.isStatus());
    }
}
