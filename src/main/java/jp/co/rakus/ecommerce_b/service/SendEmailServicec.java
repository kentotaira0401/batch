package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Order;


@Service
//FIXME:javadoc漏れ
public class SendEmailServicec {


    
    @Autowired
    private MailSender sender;

    public void sendMail(Order order) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("kento.taira.0401@gmail.com");
        msg.setTo(order.getDestinationEmail());
        msg.setSubject("要注意！！"); //タイトルの設定
        msg.setText("注文が完了しました！ありがとうございました！ クーポンが発行されました。次回ご注文時にご使用ください！クーポン番号 :11111"
        		/*String.valueOf(order.getOrderItemList())*/); //本文の設定

        this.sender.send(msg);
    }
    
    public void sendMailForRePass(String email) {
    	// FIXME:2とか3とかというのは極力変数名には入れないようにする。スコープが違うのでここはmsgで問題ない
        SimpleMailMessage msg2 = new SimpleMailMessage();

        msg2.setFrom("kento.taira.0401@gmail.com");
        msg2.setTo(email);
        msg2.setSubject("[ラクラクピザ]パスワード設定用URLのお知らせ"); //タイトルの設定
        msg2.setText("いつもラクラクピザ公式サイトをご利用いただき、ありがとうございます。\r\n" + 
        		"下記URLをクリックして、パスワードを再設定してください。\r\n" + 
        		"\r\n" + 
        		"▼パスワード設定用ページ▼\r\n" + 
        		"・PC／スマートフォン用\r\n"
        		+ "http://localhost:8080/register/toUpdatePass"); //本文の設定

        this.sender.send(msg2);
    }
    
}
	

