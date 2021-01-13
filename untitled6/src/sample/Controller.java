package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Controller extends logic {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane MainPanel;

    @FXML
    private TextField UserID;

    @FXML
    private PasswordField PassField;

    @FXML
    private Button EnterBTN;

    @FXML
    private Button RegisterBTN;

    @FXML
    private Label VxodError;

    @FXML
    private Pane PasswordPanel;

    @FXML
    private PasswordField NewPass1;

    @FXML
    private Button ConfirnBTN;

    @FXML
    private PasswordField NewPass2;

    @FXML
    private PasswordField NewPass0;

    @FXML
    private Button BackBTN1;

    @FXML
    private Label ChangeError;

    @FXML
    private Pane VxodPanel;

    @FXML
    private TextField UserID1;

    @FXML
    private Button ChangeBTN;

    @FXML
    private Button ExitBTN;

    @FXML
    private TextField Namefield;

    @FXML
    private TextField SecondNamefield;

    @FXML
    private TextField otchefield;

    @FXML
    private TextField datafield;

    @FXML
    private TextField bornfield;

    @FXML
    private TextField phonefield;

    @FXML
    private Pane RegisterPanel;

    @FXML
    private TextField UserID11;

    @FXML
    private PasswordField PassField1;

    @FXML
    private Button RegBTN;

    @FXML
    private Button ExitBTN1;

    @FXML
    private TextField Namefield1;

    @FXML
    private TextField SecondNamefield1;

    @FXML
    private TextField otchefield1;

    @FXML
    private TextField datafield1;

    @FXML
    private TextField bornfield1;

    @FXML
    private TextField phonefield1;

    @FXML
    private Pane ErrorPane;

    @FXML
    private Pane ErrorPane2;

    @FXML
    private Label ErrorReg;

    @FXML
    void initialize() {


        EnterBTN.setOnAction(actionEvent -> {
            try {
                enter(UserID.getText(),PassField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(ent){
                try {
                    fillent(UserID.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainPanel.setVisible(false);
                VxodPanel.setVisible(true);
                ErrorPane.setVisible(false);
                UserID1.setText(UserID.getText());
                Namefield.setText(dataQ[0]);
                SecondNamefield.setText(dataQ[1]);
                otchefield.setText(dataQ[2]);
                datafield.setText(dataQ[3]);
                bornfield.setText(dataQ[4]);
                phonefield.setText(dataQ[5]);

            }else{
                ErrorPane.setVisible(true);
            }

        });

        RegisterBTN.setOnAction(actionEvent -> {
                UserID11.setText("");
                PassField1.setText("");
                Namefield1.setText("");
                SecondNamefield1.setText("");
                otchefield1.setText("");
                datafield1.setText("");
                bornfield1.setText("");
                phonefield1.setText("");
                MainPanel.setVisible(false);
                RegisterPanel.setVisible(true);
                ErrorReg.setVisible(false);
        });

        ExitBTN1.setOnAction(actionEvent -> {
            RegisterPanel.setVisible(false);
            MainPanel.setVisible(true);
            UserID.setText("");
            PassField.setText("");
            ErrorPane.setVisible(false);
            ErrorPane2.setVisible(false);
        });

        ExitBTN.setOnAction(actionEvent -> {
            VxodPanel.setVisible(false);
            MainPanel.setVisible(true);
            UserID.setText("");
            PassField.setText("");
            ErrorPane.setVisible(false);
            ErrorPane2.setVisible(false);
        });

        ChangeBTN.setOnAction(actionEvent -> {
            NewPass0.setText("");
            NewPass1.setText("");
            NewPass2.setText("");
            VxodPanel.setVisible(false);
            PasswordPanel.setVisible(true);
        });

        RegBTN.setOnAction(actionEvent -> {
            if (UserID11.getText().length() > 0 && PassField1.getText().length() > 0 && Namefield1.getText().length() > 0
                    && SecondNamefield1.getText().length() > 0 && otchefield1.getText().length() > 0 && datafield1.getText().length()>0
                    && bornfield1.getText().length() > 0 && phonefield1.getText().length() > 0){
                String dat[] = {"","",""};
                String dataa = "";
                try {
                    logincheck(UserID11.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (datafield1.getText().replaceAll("\\p{Punct}|\\d","").length()==0){
                    dat = datafield1.getText().split("\\.|/");
                    //если дата правильно
                }else{
                    ErrorReg.setText("Неправильная дата");
                    ErrorReg.setVisible(true);
                    log = false;
                }
                if (dat[0].length()==4){
                    dataa = dat[0];
                    dat[0] = dat[2];
                    dat[2] = dataa;
                }
                if (dat[2].length() == 4){
                    dat[2] = dat[2].substring(2);
                }
                if(Integer.parseInt(dat[0]) > 31){
                    ErrorReg.setText("Не может быть больше 31 дня");
                    ErrorReg.setVisible(true);
                    log = false;
                }
                if(Integer.parseInt(dat[1]) > 12){
                    ErrorReg.setText("Не может быть больше 12 месяцев");
                    ErrorReg.setVisible(true);
                    log = false;
                }
                dataa = dat[0] +"."+ dat[1] +"."+ dat[2];
                boolean isP = false;
                if(ispass(PassField1.getText(),dataa)){
                    isP = true;
                }
                else{
                    ErrorReg.setText("Пароль не подходит по условию");
                    ErrorReg.setVisible(true);
                    log = false;
                }

                if (isP && log){
                    try {
                        reg(UserID11.getText(),PassField1.getText(),Namefield1.getText(),SecondNamefield1.getText(),
                                otchefield1.getText(),dataa,bornfield1.getText(),phonefield1.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    RegisterPanel.setVisible(false);
                    MainPanel.setVisible(true);
                }
                log = true;

            }
        });

        ConfirnBTN.setOnAction(actionEvent -> {
                    if (NewPass1.getText().equals(NewPass2.getText())) {
                        try {
                            smena(UserID1.getText(), NewPass0.getText(), NewPass1.getText());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(!errsmena2){
                            if (errsmena) {
                                ChangeError.setText("Пароль не подходит под условие");
                                ChangeError.setVisible(true);
                            } else {
                                ChangeError.setVisible(false);
                                UserID.setText("");
                                PassField.setText("");
                                PasswordPanel.setVisible(false);
                                MainPanel.setVisible(true);
                            }
                        } else {
                            ChangeError.setText("Текущий пароль не совпадает");
                            ChangeError.setVisible(true);
                            }
                    }else {
                            ChangeError.setText("Пароли не совпадают");
                            ChangeError.setVisible(true);
                    }
        });
        BackBTN1.setOnAction(actionEvent -> {
            PasswordPanel.setVisible(false);
            ChangeError.setVisible(false);
            NewPass0.setText("");
            NewPass1.setText("");
            NewPass2.setText("");
            VxodPanel.setVisible(true);
        });
    }
}
