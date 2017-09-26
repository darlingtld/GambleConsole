package com.gamble;

import com.gamble.HttpUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SeventhEighthController {
    private static final String BASE_URL = "seventh_eighth";
    @FXML
    public ToggleButton smartMode;
    @FXML
    public Text smartModeStatus;
    @FXML
    public ComboBox smartSwitch;
    @FXML
    private TextField chip;
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

    private List<Integer> numbersToExclude = new ArrayList<Integer>();

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

    public void handleChipChange(ActionEvent actionEvent) {
        System.out.println(chip.getText());
        HttpUtil.doPost(BASE_URL + "/chip", "chip=" + chip.getText());
    }

    public void handleNumExEvent(ActionEvent actionEvent) {
        if (ex1.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex1.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex1.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex1.getText()) == num);
        }

        if (ex2.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex2.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex2.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex2.getText()) == num);
        }

        if (ex3.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex3.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex3.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex3.getText()) == num);
        }

        if (ex4.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex4.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex4.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex4.getText()) == num);
        }

        if (ex5.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex5.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex5.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex5.getText()) == num);
        }

        if (ex6.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex6.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex6.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex6.getText()) == num);
        }

        if (ex7.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex7.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex7.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex7.getText()) == num);
        }

        if (ex8.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex8.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex8.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex8.getText()) == num);
        }

        if (ex9.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex9.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex9.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex9.getText()) == num);
        }

        if (ex10.isSelected()) {
            if (!numbersToExclude.contains(Integer.parseInt(ex10.getText()))) {
                numbersToExclude.add(Integer.parseInt(ex10.getText()));
            }
        } else {
            numbersToExclude.removeIf(num -> Integer.parseInt(ex10.getText()) == num);
        }

        HttpUtil.doPost(BASE_URL + "/exclude", "nums=" + numbersToExclude.stream().map(Object::toString).collect(Collectors.joining(",")));
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

    public void handleSmartModeChange(ActionEvent actionEvent) {
        if (smartMode.isSelected()) {
            smartMode.setSelected(true);
            toggleDisable(true);
            smartModeStatus.setText("当前为自动探测");
            HttpUtil.doPost(BASE_URL + "/enable/smart_mode", "");
        } else {
            smartModeStatus.setText("当前为普通模式");
            smartMode.setSelected(false);
            toggleDisable(false);
            HttpUtil.doPost(BASE_URL + "/disable/smart_mode", "");
        }
    }

    private void toggleDisable(boolean enable){
        smartSwitch.setVisible(enable);
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
        String[] steps = value.split("\\s+")[0].split("-");
        HttpUtil.doPost(BASE_URL + "/smart_switch", String.format("step1=%s&step2=%s", steps[0], steps[1]));
    }
}
