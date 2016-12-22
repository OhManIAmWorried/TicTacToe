package Graphics.CS;

import java.awt.*;

public class CS_Coffee extends ColorScheme{
    public CS_Coffee(){
        BUTTON_BG = new Color(143,188,143);//кнопка ready return menu
        BUTTON_FG = new Color(0,0,0);//слово ready
        BUTTON_PRIMARY_BG = new Color(218,165,32);//основные кнопки
        BUTTON_PRIMARY_FG = new Color(0,0,0);//слова в основных кнопкаъ
        BACKPANEL_BG = new Color(139,69,19);//верх низ
        WIDEPANEL_BG = new Color(0,128,128);//фон
        CONTPANEL_BG = new Color(218,165,32);//окошки
        FIELDCELL_BG = new Color(40,40,40);//ячейки крестиков ноликов
        FIELDCELLWIN_BG = new Color(143,188,143);//выиграшная комбинация
        FIELDCELL_BORDER = new Color(139,69,19);//решетки
        TEXTFIELD_BG = new Color(255,255,255);//не трогать
        TEXTFIELD_FG = new Color(40,40,40);//вводимые имена
        TEXTFIELD_CARET = new Color(241,232,198);//?
        RADIOBUTTON_BG = new Color(218,165,32);//фон кнопок
        RADIOBUTTON_FG = new Color(241,232,198);//слова около кнопок
        LABEL_FG = new Color(0,0,0);// тик так тое и игроки
        X_ICONDIR = "X_White.png";
        O_ICONDIR = "O_White.png";
    }
}

