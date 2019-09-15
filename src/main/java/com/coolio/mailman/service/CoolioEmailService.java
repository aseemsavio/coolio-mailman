package com.coolio.mailman.service;

import com.coolio.mailman.bo.CoolioConstants;
import com.coolio.mailman.bo.PostCreationEmailPayload;
import com.coolio.mailman.bo.CoolioMailResponse;
import com.coolio.mailman.bo.ServiceFailureEmailPayload;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Aseem Savio
 * <p>
 * Service class for this API.
 */

@Service
public class CoolioEmailService {

    public Logger log = LoggerFactory.getLogger(CoolioEmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration configuration;

    @Value("${spring.mail.username}")
    private String emailId;

    @Value("${spring.mail.password}")
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public CoolioMailResponse sendPostCreatedEmail(PostCreationEmailPayload postCreationEmailPayload, Map<String, Object> model) {
        return constructEmail("postCreationEmailTemplate.ftl", postCreationEmailPayload.getFromAddress(), postCreationEmailPayload.getToAddress(), postCreationEmailPayload.getSubject(), model);
    }

    public CoolioMailResponse sendServiceFailureEmail(ServiceFailureEmailPayload serviceFailureEmailPayload, Map<String, Object> model) {
        return constructEmail("serviceFailedEmailTemplate.ftl", serviceFailureEmailPayload.getFrom(), serviceFailureEmailPayload.getTo(), serviceFailureEmailPayload.getSubject(), model);
    }

    protected CoolioMailResponse constructEmail(String templateName, String from, String to, String subject, Map<String, Object> model) {
        CoolioMailResponse coolioMailResponse = new CoolioMailResponse();
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = configuration.getTemplate(templateName);
            String stringTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(stringTemplate, true);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(from);
            javaMailSender.send(mimeMessage);

            coolioMailResponse.setMessage("Email to: " + to + " SUCCESSFUL");
            coolioMailResponse.setStatus(CoolioConstants.BOOLEAN_SUCCESS);
            log.info("Email to: " + to + " SUCCESSFUL");
            return coolioMailResponse;
        } catch (Exception e) {
            coolioMailResponse.setMessage("Email to: " + to + " FAILED");
            coolioMailResponse.setStatus(CoolioConstants.BOOLEAN_FAILURE);
            log.error("Email to: " + to + " FAILED" + e);
            return coolioMailResponse;
        }
    }


}
