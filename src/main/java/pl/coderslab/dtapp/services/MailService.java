package pl.coderslab.dtapp.services;

import freemarker.template.TemplateException;
import pl.coderslab.dtapp.domain.entities.embedable.EmailMessage;

import java.io.IOException;

public interface MailService {
    void sendEmail(String from, String to, String subject, String text) throws IOException, TemplateException;
}
