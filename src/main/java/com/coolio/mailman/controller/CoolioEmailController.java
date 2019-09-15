package com.coolio.mailman.controller;

import com.coolio.mailman.bo.PostCreationEmailPayload;
import com.coolio.mailman.bo.CoolioMailResponse;
import com.coolio.mailman.bo.ServiceFailureEmailPayload;
import com.coolio.mailman.service.CoolioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aseem Savio
 * <p>
 * Controller class for Coolio Email Services.
 */

@RestController
public class CoolioEmailController {

    @Autowired
    CoolioEmailService coolioEmailService;

    @PostMapping("/sendPostCreationEmail")
    public CoolioMailResponse sendPostCreationEmail(@RequestBody PostCreationEmailPayload mail) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", mail.getName());
        ServiceFailureEmailPayload serviceFailureEmailPayload1 = new ServiceFailureEmailPayload("a", "a", "a", "a", Arrays.asList("a", "b", "c"));
        System.out.println(serviceFailureEmailPayload1.toString());
        return coolioEmailService.sendPostCreatedEmail(mail, model);
    }

    @PostMapping("/sendServiceFailureEmail")
    public CoolioMailResponse sendServiceFailureEmail(@RequestBody ServiceFailureEmailPayload serviceFailureEmailPayload) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", serviceFailureEmailPayload.getFirstName());
        if (serviceFailureEmailPayload.getFailedServices().size() == 1)
            model.put("filler", "service has");
        else
            model.put("filler", "services have");
        model.put("list", serviceFailureEmailPayload.getFailedServices().toString().replace("[", "").replace("]", ""));

        return coolioEmailService.sendServiceFailureEmail(serviceFailureEmailPayload, model);
    }

    @GetMapping("/all/lub")
    public String healthCheck() {
        return "dub";
    }

    public void lifeLineGodFatherService() {

    }

}
