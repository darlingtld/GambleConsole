package com.gamble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SMPController {
    public static final String BASE_URL = "smp";

    List<Integer> chipLevel = Arrays.asList(2, 4, 9, 20, 42, 90);

    @FXML
    public ComboBox smpLevel;
    @FXML
    public ComboBox smpChip;
    @FXML
    public Text enableStatusText;
    @FXML
    public ToggleButton smpDisable;
    @FXML
    public ToggleButton smpEnable;
    @FXML
    public TextField smpChip1;
    @FXML
    public TextField smpChip2;
    @FXML
    public TextField smpChip3;
    @FXML
    public TextField smpChip4;
    @FXML
    public TextField smpChip5;
    @FXML
    public TextField smpChip6;
    @FXML
    public TextField smpChip7;
    @FXML
    public TextField smpChip8;
    @FXML
    public TextField smpChip9;
    @FXML
    public TextField smpChip10;
    @FXML
    public Text message;
    @FXML
    public CheckBox smpDaXiao;
    @FXML
    public CheckBox smpDanShuang;
    @FXML
    public Text modeStatus;
    @FXML
    public ComboBox smpMode;

    public void handleSMPEnable(ActionEvent actionEvent) {
        if (smpEnable.isSelected()) {
            smpEnable.setSelected(true);
            smpDisable.setSelected(false);
            enableStatusText.setText("正在下注");
        }
        HttpUtil.doPost(BASE_URL + "/enable", "");
    }

    public void handleSMPDisable(ActionEvent actionEvent) {
        if (smpDisable.isSelected()) {
            smpDisable.setSelected(true);
            smpEnable.setSelected(false);
            enableStatusText.setText("停止下注");
        }
        HttpUtil.doPost(BASE_URL + "/disable", "");
    }

    public void handleChipChange(ActionEvent actionEvent) {
        HttpUtil.doPost(BASE_URL + "/chip", "chip=" + smpChip.getValue());
    }

    public void handleLevelChange(ActionEvent actionEvent) {
        HttpUtil.doPost(BASE_URL + "/level", "level=" + smpLevel.getValue());
    }

    public void submitLevelChips(ActionEvent actionEvent) {
        int code = HttpUtil.doPost(BASE_URL + "/level_chip", "level_chip=" + String.join(",",
                Arrays.asList(smpChip1.getText().trim(), smpChip2.getText().trim(), smpChip3.getText().trim(),
                        smpChip4.getText().trim(), smpChip5.getText().trim(), smpChip6.getText().trim(),
                        smpChip7.getText().trim(), smpChip8.getText().trim(), smpChip9.getText().trim(),
                        smpChip10.getText().trim())));
        String levelChips = "当前:" + String.join(" - ",
                Arrays.asList(smpChip1.getText().trim(), smpChip2.getText().trim(), smpChip3.getText().trim(), smpChip4.getText().trim(), smpChip5.getText().trim())) +
                "\r\n" +
                "        " + String.join(" - ", smpChip6.getText().trim(), smpChip7.getText().trim(), smpChip8.getText().trim(), smpChip9.getText().trim(), smpChip10.getText().trim());
        if (code == 200) {
            message.setText("设置成功");
        } else {
            message.setText("设置失败");
        }
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                if (code == 200) {
                    message.setText(levelChips);
                } else {
                    message.setText("");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void handleSMPCategoryChange(ActionEvent actionEvent) {
        if (smpDaXiao.isSelected()) {
            HttpUtil.doPost(BASE_URL + "/enable/category/daxiao", "");
        } else {
            HttpUtil.doPost(BASE_URL + "/disable/category/daxiao", "");
        }

        if (smpDanShuang.isSelected()) {
            HttpUtil.doPost(BASE_URL + "/enable/category/danshuang", "");
        } else {
            HttpUtil.doPost(BASE_URL + "/disable/category/danshuang", "");
        }
    }

    public void handleSMPModeChange(ActionEvent actionEvent) {
        if ("傻瓜模式".equals(smpMode.getValue())) {
            HttpUtil.doPost(BASE_URL + "/enable/dumb_mode", "");
            toggleChipDisable(true);
        } else {
            HttpUtil.doPost(BASE_URL + "/disable/dumb_mode", "");
            toggleChipDisable(false);
        }
        modeStatus.setText(String.valueOf(smpMode.getValue()));
    }

    private void toggleChipDisable(boolean enable) {
        smpChip2.setDisable(enable);
        smpChip3.setDisable(enable);
        smpChip4.setDisable(enable);
        smpChip5.setDisable(enable);
        smpChip6.setDisable(enable);
        smpChip7.setDisable(enable);
        smpChip8.setDisable(enable);
        smpChip9.setDisable(enable);
        smpChip10.setDisable(enable);
    }

    public void handleDumbChipChange(javafx.scene.input.KeyEvent keyEvent) {
        if ("傻瓜模式".equals(smpMode.getValue()) && smpChip1.getText().matches("\\d+")) {
            double chip = Double.parseDouble(smpChip1.getText());
            smpChip2.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(1)).intValue()));
            smpChip3.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(2)).intValue()));
            smpChip4.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(3)).intValue()));
            smpChip5.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(4)).intValue()));
            smpChip6.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(5)).intValue()));
        }
    }
}
