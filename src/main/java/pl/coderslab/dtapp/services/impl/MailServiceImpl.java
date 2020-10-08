package pl.coderslab.dtapp.services.impl;

import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pl.coderslab.dtapp.domain.entities.embedable.EmailMessage;
import pl.coderslab.dtapp.services.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String from, String to, String subject, EmailMessage emailMessage) throws IOException, TemplateException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);

        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/mail/templates");
        Configuration config = freeMarkerConfigurer.createConfiguration();
        Template mailTemplate = config.getTemplate("invitation-mail.ftl");
        String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, emailMessage);
        message.setText(mailBody);


        javaMailSender.send(message);

    }




}
