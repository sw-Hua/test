package com.asd.demo.portfolio;
import com.asd.demo.vip.UserNotFoundException;


import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;


@Service
public class PortfolioService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private PortfolioRepository repo;



    public List<Portfolio> listAll(){
        return (List<Portfolio>) repo.findAll();
    }

    public Portfolio get(Integer id) throws UserNotFoundException {
        Optional<Portfolio> result = repo.findById(id);
        if(result.isPresent()){
            return  result.get();
        }throw new UserNotFoundException("Could Not Find Any User " + id);
    }

    public void save(Portfolio portfolio) {
        repo.save(portfolio);
    }

    public Portfolio editCustomer(Portfolio customer) throws UnsupportedEncodingException, MessagingException {
        String randomCode = RandomString.make(64);
        customer.setVerificationCode(randomCode);
        customer.setEnabled(false);

        return repo.save(customer);
    }

    public void sendVerificationEmail(Portfolio customer, String siteURL)throws MessagingException, UnsupportedEncodingException {
        String toAddress = customer.getUserEmail();
        String fromAddress = "Alfred0449500032Hua@gmail.com";
        String senderName = "Restaurant Verification System";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", customer.getUserName());
        String verifyURL = siteURL + "/verify?code=" + customer.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        emailSender.send(message);

    }

    public boolean verify(String verificationCode) {
        Portfolio portfolio = repo.findByVerificationCode(verificationCode);

        System.out.println("验证码: " + verificationCode);
        System.out.println("测试: "+ portfolio);
        if (portfolio == null || portfolio.isEnabled()) {
            return false;
        } else {
            portfolio.setVerificationCode(null);
            portfolio.setEnabled(true);
            repo.save(portfolio);

            return true;
        }

    }
}
