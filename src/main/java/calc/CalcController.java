package calc;

import javafx.event.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static calc.Calculator.*;


public class CalcController {

    @FXML     private GridPane mainGrid;
    @FXML    private Text textMain;
    @FXML    private Text textPrev;
    @FXML    private Text textPrev1;
    @FXML    private Text textPrev2;
    @FXML    private Text textPrev3;
    @FXML    private Text textPrev4;
    @FXML    private Text textPrev5;
    @FXML    private Text textPrev6;
    @FXML    private Text textPrev7;
    @FXML    private Text textPrev8;
    @FXML    private Button buttonMC;
    @FXML    private Button buttonMR;
    @FXML    private Button buttonMS;
    @FXML    private Button buttonMplus;
    @FXML    private Button buttonMminus;
    @FXML    private Button buttonBack;
    @FXML    private Button buttonCE;
    @FXML    private Button buttonC;
    @FXML    private Button buttonSQRT;
    @FXML    private Button button7;
    @FXML    private Button button8;
    @FXML    private Button button9;
    @FXML    private Button buttonDiv;
    @FXML    private Button buttonPercent;
    @FXML    private Button button4;
    @FXML    private Button button5;
    @FXML    private Button button6;
    @FXML    private Button buttonMulti;
    @FXML    private Button button1;
    @FXML    private Button button2;
    @FXML    private Button button3;
    @FXML    private Button buttonMinus;
    @FXML    private Button button0;
    @FXML    private Button buttonDot;
    @FXML    private Button buttonPlus;
    @FXML    private Button buttonResult;

    @FXML
    public void initialize() {

        buttonMC.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setMemory("0"); //установить памяти значение 0
            }
        });

        buttonMR.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(getMemory()));
            } //достать из памяти число и вывести на главную строку
        });

        buttonMS.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setMemory(getFirstStr()); // установить в память число из главной строки
            }
        });

        buttonMplus.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setMemory(Mplus()); //прибавить к числу из памяти число из главной строки и результат записать в память
                printMainString(setFirstStr("0")); //установить на главной строке 0 и отобразить
            }
        });

        buttonMminus.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setMemory(Mminus()); //отнять от числа из памяти число из главной строки и результат записать в память
                printMainString(setFirstStr("0")); //установить на главной строке 0 и отобразить
            }
        });

        buttonBack.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(Backspace()));
            } //вызов из Калькулятора метода Backspase
        });

        buttonCE.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr("0"));
            }
        });

        buttonC.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printSecString(setSecondStr(""));
                printMainString(setFirstStr("0"));
            }
        });


        buttonSQRT.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(SQRT()));
            }
        });

        button7.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('7')));
            }
        });

        button8.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('8')));
            }
        });

        button9.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('9')));
            }
        });

        buttonDiv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ClickArithmeticButton("/");

            }
        });

        buttonPercent.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(Percent()));

            }
        });

        button4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('4')));
            }
        });

        button5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('5')));
            }
        });

        button6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('6')));
            }
        });

        buttonMulti.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ClickArithmeticButton("*");

            }
        });


        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('1')));
            }
        });

        button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('2')));
            }
        });

        button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('3')));
            }
        });

        buttonMinus.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ClickArithmeticButton("-");

            }
        });

        buttonResult.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!getSecondStr().equals("")) {
                    addHistory(getSecondStr());
                    addHistory(getFirstStr());
                    addHistory("=");
                    printMainString(setFirstStr(Result()));
                    addHistory(getFirstStr());
                    printHistory();
                }
                printSecString(getSecondStr());
            }
        });

        button0.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('0')));
            }
        });

        buttonDot.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                printMainString(setFirstStr(AddNum('.')));
            }
        });

        buttonPlus.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ClickArithmeticButton("+");

            }
        });

        mainGrid.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Event mouseClick = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
                        MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null);
                //MouseEvent(EventType<? extends MouseEvent> eventType, double x, double y, double screenX, double screenY, MouseButton button, int clickCount - кол-во кликов, boolean shiftDown, boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown, boolean secondaryButtonDown, boolean synthesized, boolean popupTrigger, boolean stillSincePress, PickResult pickResult)

                if (event.getCode() == KeyCode.NUMPAD0) {
                    button0.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD1) {
                    button1.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD2) {
                    button2.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD3) {
                    button3.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD4) {
                    button4.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD5) {
                    button5.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD6) {
                    button6.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD7) {
                    button7.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD8) {
                    button8.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.NUMPAD9) {
                    button9.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.ENTER) { //не работает на клавиатуре
                    buttonResult.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.DECIMAL) {
                    buttonDot.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.BACK_SPACE) {
                    buttonBack.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.ADD) {
                    buttonPlus.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.SUBTRACT) {
                    buttonMinus.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.MULTIPLY) {
                    buttonMulti.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.DIVIDE) {
                    buttonDiv.fireEvent(mouseClick);
                }
                if (event.getCode() == KeyCode.DELETE) {
                    buttonC.fireEvent(mouseClick);
                }
            }
        });
    }


    private void ClickArithmeticButton(String arg) {
        if (!getSecondStr().equals("")) { //если верхняя строка не пустая
            printSecString(setSecondStr(Result() + " " + arg));
            printMainString(setFirstStr("0"));

        } else {
            printSecString(setSecondStr(getFirstStr() + " " + arg));
            printMainString(setFirstStr("0"));

        }

    }

    private void printMainString(String value) {
        int len = value.length();
        if (len <= 12) textMain.setFont(Font.font("Arial", 28));
        if (len > 12) textMain.setFont(Font.font("Arial", 22));
        if (len > 15) textMain.setFont(Font.font("Arial", 18));
        if (len > 18) textMain.setFont(Font.font("Arial", 14));
        textMain.setText(value);

    }

    private void printSecString(String value) {
        int len = value.length();
        if (len <= 16) textPrev.setFont(Font.font("Arial", 18));
        if (len > 17) textPrev.setFont(Font.font("Arial", 14));
        if (len > 22) textPrev.setFont(Font.font("Arial", 10));
        textPrev.setText(value);

    }

    private ArrayList<String> history = new ArrayList<>();



    private void addHistory(String value) {
        history.add(value);
    }

    private void printHistory() {

        JavaRestActivator restAct = new JavaRestActivator();
        String res = "";
        String res1 = "";
        String res2 = "";
        String res3 = "";
        String res4 = "";
        String res5 = "";


        for (int i = 0; i < 4; i++) {
            res += history.get(i);
        }

        if (history.size() == 4) {
            textPrev1.setText(res);
            restAct.putToDBJournal(res);
        }

        if (history.size() == 8) {
            textPrev2.setText(res);
            for (int i = 4; i < 8; i++) {
                res1 += history.get(i);
            }
            textPrev1.setText(res1);
            restAct.putToDBJournal(res1);
        }

        if (history.size() == 12) {
            textPrev3.setText(res);
            for (int i = 4; i < 8; i++) {
                res1 += history.get(i);
            }
            textPrev2.setText(res1);
            for (int i = 8; i < 12; i++) {
                res2 += history.get(i);
            }
            textPrev1.setText(res2);
            restAct.putToDBJournal(res2);
        }

        if (history.size() == 16) {
            textPrev4.setText(res);
            for (int i = 4; i < 8; i++) {
                res1 += history.get(i);
            }
            textPrev3.setText(res1);
            for (int i = 8; i < 12; i++) {
                res2 += history.get(i);
            }
            textPrev2.setText(res2);
            for (int i = 12; i < 16; i++) {
                res3 += history.get(i);
            }
            textPrev1.setText(res3);
            restAct.putToDBJournal(res3);
        }
        if (history.size() == 20) {
            textPrev5.setText(res);
            for (int i = 4; i < 8; i++) {
                res1 += history.get(i);
            }
            textPrev4.setText(res1);
            for (int i = 8; i < 12; i++) {
                res2 += history.get(i);
            }
            textPrev3.setText(res2);
            for (int i = 12; i < 16; i++) {
                res3 += history.get(i);
            }
            textPrev2.setText(res3);
            for (int i = 16; i < 20; i++) {
                res4 += history.get(i);
            }
            textPrev1.setText(res4);
            restAct.putToDBJournal(res4);
        }
        if (history.size() == 24) {
            textPrev6.setText(res);
            for (int i = 4; i < 8; i++) {
                res1 += history.get(i);
            }
            textPrev5.setText(res1);
            for (int i = 8; i < 12; i++) {
                res2 += history.get(i);
            }
            textPrev4.setText(res2);
            for (int i = 12; i < 16; i++) {
                res3 += history.get(i);
            }
            textPrev3.setText(res3);
            for (int i = 16; i < 20; i++) {
                res4 += history.get(i);
            }
            textPrev2.setText(res4);
            for (int i = 20; i < 24; i++) {
                res5 += history.get(i);
            }
            textPrev1.setText(res5);
            restAct.putToDBJournal(res5);
        }



    }


}