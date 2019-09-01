package com.coolio.mailman.service;

import com.coolio.mailman.bo.CoolioConstants;
import com.coolio.mailman.bo.CoolioMail;
import com.coolio.mailman.bo.CoolioMailResponse;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    Logger log = LoggerFactory.getLogger(CoolioEmailService.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration configuration;

    public CoolioMailResponse sendPostCreatedEmail(CoolioMail mail, Map<String, Object> model) {
        CoolioMailResponse coolioMailResponse = new CoolioMailResponse();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            // Adding attachments if needed. Commented out as there is no need for attachments here.
            //mimeMessageHelper.addAttachment("aseem.png", new ClassPathResource("aseem.png"));

            Template template = configuration.getTemplate("postCreationEmailTemplate.ftl");
            String stringTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setTo(mail.getToAddress());
            mimeMessageHelper.setText(stringTemplate, true);
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setFrom(mail.getFromAddress());
            javaMailSender.send(mimeMessage);

            coolioMailResponse.setMessage("Post Creation Email to: " + mail.getToAddress() + " SUCCESSFUL");
            coolioMailResponse.setStatus(CoolioConstants.BOOLEAN_SUCCESS);
            log.info("Post Creation Email to: " + mail.getToAddress() + " SUCCESSFUL");
        } catch (Exception e) {
            coolioMailResponse.setMessage("Post Creation Email to: " + mail.getToAddress() + " FAILED");
            coolioMailResponse.setStatus(CoolioConstants.BOOLEAN_FAILURE);
            log.info("Post Creation Email to: " + mail.getToAddress() + " FAILED");
            log.error("Post Creation Exception failed as: " + e);
        }
        return coolioMailResponse;
    }
}
