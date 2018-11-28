package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;


@Service
public class SendEmailServicec {


    
    @Autowired
    private MailSender sender;

    public void sendMail(Order order) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("kento.taira.0401@gmail.com");
        msg.setTo(order.getDestinationEmail());
        msg.setSubject("要注意！！"); //タイトルの設定
        msg.setText(/*"Spring Boot より本文送信"
        		+ "やったー"*/
        		String.valueOf(order.getOrderItemList())); //本文の設定

        this.sender.send(msg);
    }
}
	

