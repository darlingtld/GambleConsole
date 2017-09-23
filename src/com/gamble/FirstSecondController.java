package com.gamble;

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


public class FirstSecondController {
    private static final String BASE_URL = "first_second";

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

    private List<Integer> smpNumbersToExclude = new ArrayList<Integer>();

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
        HttpUtil.doPost(BASE_URL + "/enable", "");
    }

    public void handleChipChange(ActionEvent actionEvent) {
        System.out.println(chip.getText());
        HttpUtil.doPost(BASE_URL + "/chip", "chip=" + chip.getText());
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
        if(code == 200){
            message.setText("设置成功");
        } else {
            message.setText("设置失败");
        }
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            message.setText("");
        }).start();

    }
}
