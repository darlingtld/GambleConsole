package com.gamble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class FifthSixthController {
    private static final String BASE_URL = "fifth_sixth";

    private List<Integer> chipLevel = Arrays.asList(2, 4, 9, 20, 42, 90);
    @FXML
    public ComboBox gambleMode;
    @FXML
    public Text smartModeStatus;
    @FXML
    public Text exText;
    @FXML
    public ComboBox smartSwitch;
    @FXML
    public ComboBox smartDetectRoundNumber;
    @FXML
    public ComboBox maxBetCount;
    @FXML
    public Label maxBetCountLabel;
    @FXML
    private CheckBox ex1;
    @FXML
    private CheckBox ex2;
    @FXML
    private CheckBox ex3;
    @FXML
    private CheckBox ex4;
    @FXML
    private CheckBox ex5;
    @FXML
    private CheckBox ex6;
    @FXML
    private CheckBox ex7;
    @FXML
    private CheckBox ex8;
    @FXML
    private CheckBox ex9;
    @FXML
    private CheckBox ex10;
    @FXML
    private Text enableStatusText;
    @FXML
    private ToggleButton disable;
    @FXML
    private ToggleButton enable;
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

    private List<Integer> smpNumbersToExclude = new ArrayList<>();
    private Pattern pattern = Pattern.compile("(\\d)");

    public void handleEnable(ActionEvent actionEvent) {
        if (enable.isSelected()) {
            enable.setSelected(true);
            disable.setSelected(false);
            enableStatusText.setText("正在下注");
        }
        HttpUtil.doPost(BASE_URL + "/enable", "");
    }

    public void handleDisable(ActionEvent actionEvent) {
        if (disable.isSelected()) {
            disable.setSelected(true);
            enable.setSelected(false);
            enableStatusText.setText("停止下注");
        }
        HttpUtil.doPost(BASE_URL + "/disable", "");
    }

    public void handleNumExEvent(ActionEvent actionEvent) {
        if (ex1.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex1.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex1.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex1.getText()) == num);
        }

        if (ex2.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex2.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex2.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex2.getText()) == num);
        }

        if (ex3.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex3.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex3.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex3.getText()) == num);
        }

        if (ex4.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex4.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex4.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex4.getText()) == num);
        }

        if (ex5.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex5.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex5.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex5.getText()) == num);
        }

        if (ex6.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex6.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex6.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex6.getText()) == num);
        }

        if (ex7.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex7.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex7.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex7.getText()) == num);
        }

        if (ex8.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex8.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex8.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex8.getText()) == num);
        }

        if (ex9.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex9.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex9.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex9.getText()) == num);
        }

        if (ex10.isSelected()) {
            if (!smpNumbersToExclude.contains(Integer.parseInt(ex10.getText()))) {
                smpNumbersToExclude.add(Integer.parseInt(ex10.getText()));
            }
        } else {
            smpNumbersToExclude.removeIf(num -> Integer.parseInt(ex10.getText()) == num);
        }

        HttpUtil.doPost(BASE_URL + "/exclude", "nums=" + smpNumbersToExclude.stream().map(Object::toString).collect(Collectors.joining(",")));
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

    public void handleModeChange(ActionEvent actionEvent) {
        if ("傻瓜模式".equals(gambleMode.getValue())) {
            smartModeStatus.setText("傻瓜模式");
            HttpUtil.doPost(BASE_URL + "/enable/dumb_mode", "");
            toggleDisable(true, true);
            toggleChipDisable(true);
        } else if ("普通模式".equals(gambleMode.getValue())) {
            smartModeStatus.setText("普通模式");
            HttpUtil.doPost(BASE_URL + "/disable/dumb_mode", "");
            HttpUtil.doPost(BASE_URL + "/disable/smart_mode", "");
            HttpUtil.doPost(BASE_URL + "/disable/reverse_mode", "");
            toggleDisable(false, true);
            toggleChipDisable(false);
        } else if ("普通模式(反)".equals(gambleMode.getValue())) {
            smartModeStatus.setText("普通模式(反)");
            HttpUtil.doPost(BASE_URL + "/disable/dumb_mode", "");
            HttpUtil.doPost(BASE_URL + "/disable/smart_mode", "");
            HttpUtil.doPost(BASE_URL + "/enable/reverse_mode", "");
            toggleDisable(false, true);
            toggleChipDisable(false);
        } else if ("探测模式".equals(gambleMode.getValue())) {
            smartModeStatus.setText("探测模式");
            HttpUtil.doPost(BASE_URL + "/disable/dumb_mode", "");
            HttpUtil.doPost(BASE_URL + "/enable/smart_mode", "");
            toggleDisable(true, false);
            toggleChipDisable(false);
        }
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
        if ("傻瓜模式".equals(gambleMode.getValue()) && smpChip1.getText().matches("\\d+")) {
            double chip = Double.parseDouble(smpChip1.getText());
            smpChip2.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(1)).intValue()));
            smpChip3.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(2)).intValue()));
            smpChip4.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(3)).intValue()));
            smpChip5.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(4)).intValue()));
            smpChip6.setText(String.valueOf(Double.valueOf(chip / 2.0 * chipLevel.get(5)).intValue()));
        }
    }

    private void toggleDisable(boolean enable, boolean isDumbMode) {
        smartSwitch.setVisible(enable && !isDumbMode);
        smartDetectRoundNumber.setVisible(enable && !isDumbMode);
        maxBetCount.setVisible(!enable);
        maxBetCountLabel.setVisible(!enable);
        ex1.setDisable(enable);
        ex2.setDisable(enable);
        ex3.setDisable(enable);
        ex4.setDisable(enable);
        ex5.setDisable(enable);
        ex6.setDisable(enable);
        ex7.setDisable(enable);
        ex8.setDisable(enable);
        ex9.setDisable(enable);
        ex10.setDisable(enable);
    }

    public void handleSmartSwitchChange(ActionEvent actionEvent) {
        String value = String.valueOf(smartSwitch.getValue());
        String steps = value.split("\\s+")[0];
        if (steps.split("-").length > 2) {
            smartDetectRoundNumber.setVisible(false);
        } else {
            smartDetectRoundNumber.setVisible(true);
        }
        HttpUtil.doPost(BASE_URL + "/smart_switch", String.format("steps=%s", steps));
    }

    public void handleSmartDetectRoundNumberChange(ActionEvent actionEvent) {
        Matcher matcher = pattern.matcher(String.valueOf(smartDetectRoundNumber.getValue()));
        if (matcher.find()) {
            HttpUtil.doPost(BASE_URL + "/smart_mode_detect_round", "round=" + matcher.group(1));
        }
    }

    public void handleMaxBetCountChange(ActionEvent actionEvent) {
        HttpUtil.doPost(BASE_URL + "/max_bet_count", "count=" + maxBetCount.getValue());
    }
}