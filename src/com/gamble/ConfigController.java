package com.gamble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.util.Arrays;


public class ConfigController {
    public static final String BASE_URL = "config";
    @FXML
    public TextField email;
    @FXML
    public TextField lostThreshold;
    @FXML
    public Text message;


    public void handleConfigChange(ActionEvent actionEvent) {
        int code = HttpUtil.doPost(BASE_URL + "/email", "email=" + email.getText());
        int code1 = HttpUtil.doPost(BASE_URL + "/lost_threshold", "lost_threshold=" + lostThreshold.getText());
        if (code == 200 && code1 == 200) {
            message.setText("设置成功");
        } else {
            message.setText("设置失败");
        }
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                message.setText("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
