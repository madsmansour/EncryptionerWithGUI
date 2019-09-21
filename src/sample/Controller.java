package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Base64;


public class Controller {

    static final byte KEY = 2;

  @FXML TextArea ta;
  @FXML TextField tf;

    public void decrypt(ActionEvent actionEvent) {

        String input = tf.getText();

        byte[] bytes = input.getBytes();

        byte[] returnBytes = Base64.getDecoder().decode(bytes);

        for (int i = 0; i < bytes.length; i++) {

            bytes[i] -= KEY;

        }
        input = new String(returnBytes);
        ta.appendText(input +"\n");
        System.out.println("Decrypted " + input);
    }



    public void encrypt(ActionEvent actionEvent) {

            String input = tf.getText();

            byte[] bytes = input.getBytes();

        byte[] returnBytes = Base64.getEncoder().encode(bytes);

            for (int i = 0; i < bytes.length; i++) {

                bytes[i] += KEY;

            }
            input = new String(returnBytes);

            ta.appendText(input + "\n");
        System.out.println("Encrypted " + input );
        }
}

