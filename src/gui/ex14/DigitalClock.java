package gui.ex14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.Preferences;

public class DigitalClock extends Frame implements Runnable, ActionListener {

        private Thread th;
        private PropertyDialog dialog;
        private Menu menuMenu;
        private MenuItem menuProperty;
        private Image imageBuffer;
        private Graphics graphicBuffer;

        // 時・分・秒
        private Integer hourInteger;
        private Integer minuteInteger;
        private Integer secondInteger;

        // 表示時間文字列
        private String hourString;
        private String minuteString;
        private String secondString;


        // 設定値(フォント、背景)
        private String fontType = "TimesRoman";
        private Integer fontSize = 40;
        private Color fontColor = Color.black;
        private Color backgroundColor = Color.white;
        private String strFontColor = "black";
        private String strBackGroundColor = "white";

        // ウィンドウのサイズ
        private int windowSizeX = 0;
        private int windowSizeY = 0;

        // 表示時間の文字列
        private String timeString;

        // メニューバー
        private MenuBar menuBar;

        // フォントの設定
        private Font fontSetting;

        // 保存用キー値
        private Preferences prefs;
        private final String KEY1 = "fontSize";
        private final String KEY2 = "fontType";
        private final String KEY3 = "fontColor";
        private final String KEY4 = "backGround";

        // ウィンドウ起動時座標
        private int positionX;
        private int positionY;
        private final String KEY_X = "X";
        private final String KEY_Y = "Y";


        // コンストラクタ
        public DigitalClock(String title) {
                // タイトルバーにタイトルを登録する
                super(title);

                prefs = Preferences.userNodeForPackage(this.getClass());

                // メニューバーを作成する
                menuBar = new MenuBar();

                // [Menu]
                menuMenu = new Menu("Menu");
                menuMenu.addActionListener(this);
                menuBar.add(menuMenu);

                // [Menu] - [Property]
                menuProperty = new MenuItem("Property");
                menuMenu.add(menuProperty);

                // メニューバーにセットする
                setMenuBar(menuBar);

                // ダイアログを生成する
                dialog = new PropertyDialog(this);

                // 現在時刻用変数の初期化
                hourInteger = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                minuteInteger = Calendar.getInstance().get(Calendar.MINUTE);
                secondInteger = Calendar.getInstance().get(Calendar.SECOND);

                // ウィンドウを閉じられるようにする
                addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                // 現在のウィンドウの情報を保存
                                prefs.putInt(KEY1, getFontSize());
                                prefs.put(KEY2, getFontType());
                                prefs.put(KEY3, PropertyDialog.colorToString(fontColor));
                                prefs.put(KEY4, PropertyDialog.colorToString(backgroundColor));

                                // 現在の表示位置を保存
                                prefs.putInt(KEY_X, getX());
                                prefs.putInt(KEY_Y, getY());

                                System.exit(0);
                        }
                });

                // 最後に閉じた状態を復元
                fontSize = prefs.getInt(KEY1, fontSize);
                fontType = prefs.get(KEY2, fontType);
                fontColor = PropertyDialog.stringToColor(prefs.get(KEY3, "black"));
                backgroundColor = PropertyDialog.stringToColor(prefs.get(KEY4, strBackGroundColor));
                positionX = prefs.getInt(KEY_X, 0);
                positionY = prefs.getInt(KEY_Y, 0);
                setBounds(positionX, positionY, 200, 100);

        }

        public void paint(Graphics g) {
                // 時・分・秒が一桁の時、0で二桁目を埋める
                if (hourInteger < 10) {
                        hourString = "0" + hourInteger;
                } else {
                        hourString = hourInteger.toString();
                }

                if (minuteInteger < 10) {
                        minuteString = "0" + minuteInteger;
                } else {
                        minuteString = minuteInteger.toString();
                }

                if (secondInteger < 10) {
                        secondString = "0" + secondInteger;
                } else {
                        secondString = secondInteger.toString();
                }
                timeString = hourString + ":" + minuteString + ":" + secondString;

                // ウィンドウサイズの計算
                windowSizeX = graphicBuffer.getFontMetrics().stringWidth(timeString) + 20;
                windowSizeX += getInsets().left;
                windowSizeX += getInsets().right;

                windowSizeY = graphicBuffer.getFontMetrics().getAscent();
                windowSizeY += graphicBuffer.getFontMetrics().getDescent();
                windowSizeY += graphicBuffer.getFontMetrics().getLeading();
                windowSizeY += getInsets().top;


                // ウィンドウ情報（位置・サイズ）設定
                setSize(windowSizeX, windowSizeY);


                imageBuffer = createImage(windowSizeX, windowSizeY);
                graphicBuffer = imageBuffer.getGraphics();

                // 背景を色つきで塗りつぶす
                graphicBuffer.setColor(backgroundColor);
                graphicBuffer.fillRect(0, 0, windowSizeX, windowSizeY);

                // 時刻の描画
                fontSetting = new Font(fontType, Font.PLAIN, fontSize);
                graphicBuffer.setFont(fontSetting); // フォントの設定
                graphicBuffer.setColor(fontColor); // 文字色の設定
                graphicBuffer.drawString(timeString, 10, graphicBuffer.getFontMetrics()
                                .getAscent() + getInsets().top - getInsets().bottom);

                // バッファのコピー
                g.drawImage(imageBuffer, 0, 0, this);
        }

        @Override
        public void update(Graphics g) {
                // ちらつき防止のため、updateメソッドからそのままpaintメソッドにつなぐ
                // (画面がクリアされないようにする)
                paint(g);
        }

        @Override
        public void run() {
                while (true) {
                        // 現在時刻の獲得
                        hourInteger = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                        minuteInteger = Calendar.getInstance().get(Calendar.MINUTE);
                        secondInteger = Calendar.getInstance().get(Calendar.SECOND);


                        // 再描画
                        repaint();

                        try {
                                Thread.sleep(10); // スリープ1秒
                        } catch (InterruptedException e) {
                                ; // 何もしない
                        }
                }
        }

        public String getFontType() {
                return fontType;
        }

        public void setFontType(String fontType) {
                this.fontType = fontType;
        }

        public Integer getFontSize() {
                return fontSize;
        }

        public void setFontSize(int fontSize) {
                this.fontSize = fontSize;
        }

        public Color getFontColor() {
                return fontColor;
        }

        public void setFontColor(Color fontColor) {
                this.fontColor = fontColor;
        }

        public Color getBackgroundColor() {
                return backgroundColor;
        }

        public void setBackgroundColor(Color backgroundColor) {
                this.backgroundColor = backgroundColor;
        }

        public Font getFontSetting() {
                return fontSetting;
        }

        public void setFontSetting(Font fontSetting) {
                this.fontSetting = fontSetting;
        }

        public String getStrFontColor() {
                return strFontColor;
        }

        public void setStrFontColor(String strFontColor) {
                this.strFontColor = strFontColor;
        }

        public String getStrBackGroundColor() {
                return strBackGroundColor;
        }

        public void setStrBackGroundColor(String strBackGroundColor) {
                this.strBackGroundColor = strBackGroundColor;
        }

        public int getPositionX() {
                return positionX;
        }

        public void setPositionX(int positionX) {
                this.positionX = positionX;
        }

        public int getPositionY() {
                return positionY;
        }

        public void setPositionY(int positionY) {
                this.positionY = positionY;
        }

        /**
         * mainメソッド
         * @param args
         */
        public static void main(String[] args) {
                DigitalClock window = new DigitalClock("Digital Clock");

                window.setSize(200, 100);
                window.setResizable(false);
                window.setVisible(true);

                window.imageBuffer = window.createImage(200, 100);
                window.graphicBuffer = window.imageBuffer.getGraphics();

                window.th = new Thread(window);
                window.th.start(); // スレッドスタート

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // propertyクリック時アクション
                if (e.getActionCommand() == "Property") {
                        dialog.setBounds(getX()+20, getY()+20, 300, 180); // ダイアログの表示位置設定
                        dialog.setVisible(true);
                }
        }

}