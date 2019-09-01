package com.coolio.mailman.bo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aseem Savio
 */

public class PostCreationEmailPayloadTest {

    private PostCreationEmailPayload gimmePopulatedConstructor() {
        return new PostCreationEmailPayload("Aseem", "aseem@gmail.com", "savio@gmail.com", "my subject");
    }

    private PostCreationEmailPayload gimmeEmptyConstructor() {
        return new PostCreationEmailPayload();
    }

    private PostCreationEmailPayload gimmeSettedCoolioMail() {
        PostCreationEmailPayload postCreationEmailPayload = new PostCreationEmailPayload();
        postCreationEmailPayload.setName("Aseem");
        postCreationEmailPayload.setFromAddress("aseem@gmail.com");
        postCreationEmailPayload.setToAddress("savio@gmail.com");
        postCreationEmailPayload.setSubject("my subject");
        return postCreationEmailPayload;
    }

    @Test
    public void testConstructors() {
        Assert.assertNotNull(gimmePopulatedConstructor());
        Assert.assertNotNull(gimmeEmptyConstructor());
    }

    @Test
    public void testGettersSetters() {
        PostCreationEmailPayload postCreationEmailPayload = new PostCreationEmailPayload();
        postCreationEmailPayload = gimmeSettedCoolioMail();
        Assert.assertEquals(postCreationEmailPayload.getName(), "Aseem");
        Assert.assertEquals(postCreationEmailPayload.getFromAddress(), "aseem@gmail.com");
        Assert.assertEquals(postCreationEmailPayload.getToAddress(), "savio@gmail.com");
        Assert.assertEquals(postCreationEmailPayload.getSubject(), "my subject");
    }


}
