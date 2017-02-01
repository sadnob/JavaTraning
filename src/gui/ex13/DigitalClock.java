package gui.ex13;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends Window implements Runnable, ActionListener
{
    private static final long serialVersionUID = 1L;

    private Date currentDate;
    private SimpleDateFormat simpleDataFormat = new SimpleDateFormat("HH:mm:ss");

    private String stringCurrentTime = " --:--:--";

    private Thread th;
    private Image imageBuffer;
    private Graphics graphicBuffer;

    private String fontType = "Broadway BT";
    private int fontStyle = Font.PLAIN;
    private Integer fontSize = 60;
    private Color fontColor = Color.white;
    private Color backgroundColor = Color.black;

    private int windowSizeX = 100;
    private int windowSizeY = 200;

    public PopupMenu popup = new PopupMenu();

    private Menu property = new Menu("Property");
    private MenuItem menuItemExit = new MenuItem("Exit");

    //private Menu menuFontType = new Menu("Font Type");
    private Menu menuFontStyle = new Menu("Font Style");
    private Menu menuFontSize = new Menu("Font Size");
    private Menu menuFontColor = new Menu("Font Color");
    private Menu menuBackgroundColor = new Menu("BackgroundColor");

    static private String stringFontStyle[] =   { "Plain", "Bold", "Italic", "Bold and Italic" };
    static private int intFontStyle[] =  { Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC };

    static private String stringColor[] =
    { "Black", "White", "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow",
            "Orange" };
    static private Color colorColor[] =
    { Color.black, Color.white, Color.red, Color.green, Color.blue, Color.cyan,
            Color.magenta, Color.yellow, Color.orange };

    private RightClickMenu mouse;

    // フォントのデフォルトの設定
    private Font fontSetting = new Font(fontType, fontStyle, fontSize);

    // コンストラクタ
    public DigitalClock()
    {
        super(null);

        // 時刻用変数の初期化
        currentDate = new Date();

        property.add(menuFontStyle);
        {
            for (int i = 0; i < stringFontStyle.length; i++)
            {
                menuFontStyle.add(stringFontStyle[i]);
            }
        }
        property.add(menuFontSize);
        {
            for (Integer i = 10; i < 300; i += 30)
            {
                menuFontSize.add(i.toString());
            }
        }
        property.add(menuFontColor);
        {
            for (int i = 0; i < stringColor.length; i++)
            {
                menuFontColor.add(new MenuItem(stringColor[i]));
            }
        }
        property.add(menuBackgroundColor);
        {
            for (int i = 0; i < stringColor.length; i++)
            {
                menuBackgroundColor.add(new MenuItem(stringColor[i]));
            }
        }
        popup.add(property);
        popup.add(menuItemExit);

        menuFontStyle.addActionListener(this);
        menuFontSize.addActionListener(this);
        menuFontColor.addActionListener(this);
        menuBackgroundColor.addActionListener(this);
        menuItemExit.addActionListener(this);

        add(popup);

        mouse = new RightClickMenu(this);

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public void paint(Graphics g)
    {
        // 現在時刻の更新
        currentDate = new Date();

        // 時刻用文字列の生成
        stringCurrentTime =  simpleDataFormat.format(currentDate);

        if (null != graphicBuffer)
        {
            // ウィンドウサイズの計算
            windowSizeX =  graphicBuffer.getFontMetrics().stringWidth(stringCurrentTime);

            windowSizeX += getInsets().left;
            windowSizeX += getInsets().right;

            windowSizeY = graphicBuffer.getFontMetrics().getAscent();
            windowSizeY += graphicBuffer.getFontMetrics().getDescent();
            windowSizeY += graphicBuffer.getFontMetrics().getLeading();
            windowSizeY += getInsets().top;
        }
        setSize(windowSizeX, windowSizeY);

        imageBuffer = createImage(windowSizeX, windowSizeY);
        graphicBuffer = imageBuffer.getGraphics();

        // 背景を色つきで塗りつぶす
        graphicBuffer.setColor(backgroundColor);
        graphicBuffer.fillRect(0, 0, windowSizeX, windowSizeY);

        // 時刻の描画
        fontSetting = new Font(fontType, fontStyle, fontSize);
        graphicBuffer.setFont(fontSetting); // フォントの設定
        graphicBuffer.setColor(fontColor); // 文字色の設定

        graphicBuffer.drawString(stringCurrentTime, 0, graphicBuffer
                .getFontMetrics().getAscent()
                + getInsets().top
                - getInsets().bottom);

        // バッファのコピー
        g.drawImage(imageBuffer, 0, 0, this);
    }

    public int getFontStyle()
    {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle)
    {
        this.fontStyle = fontStyle;
    }

    @Override
    public void update(Graphics g)
    {
        // ちらつき防止のため、updateメソッドからそのままpaintメソッドにつなぐ
        // (画面がクリアされないようにする)
        paint(g);
    }

    @Override
    public void run()
    {
        while (true)
        {
            // 再描画
            repaint();

            try
            {
                Thread.sleep(10); // スリープ1秒
            }
            catch (InterruptedException e)
            {
                ; // 何もしない
            }
        }
    }

    public String getFontType()
    {
        return fontType;
    }

    public void setFontType(String fontType)
    {
        this.fontType = fontType;
    }

    public Integer getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(int fontSize)
    {
        this.fontSize = fontSize;
    }

    public Color getFontColor()
    {
        return fontColor;
    }

    public void setFontColor(Color fontColor)
    {
        this.fontColor = fontColor;
    }

    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    public Font getFontSetting()
    {
        return fontSetting;
    }

    public void setFontSetting(Font fontSetting)
    {
        this.fontSetting = fontSetting;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        DigitalClock window = new DigitalClock();

        window.th = new Thread(window);

        window.setSize(220, 150);
        window.setLocation(100, 100);
        window.setVisible(true);

        window.imageBuffer = window.createImage(220, 150);
        window.graphicBuffer = window.imageBuffer.getGraphics();
        window.setAlwaysOnTop(true);

        window.th.start(); // スレッドスタート

    }

    @Override
    public void actionPerformed(ActionEvent e)  {

        if (menuFontStyle == e.getSource()) {
            for (int i = 0; i < stringFontStyle.length; i++)  {
                if (e.getActionCommand() == stringFontStyle[i]) {
                    setFontStyle(intFontStyle[i]);
                }
            }
        }
        else if (menuFontSize == e.getSource())
        {
            setFontSize(Integer.valueOf(e.getActionCommand()));
        }
        else if (menuFontColor == e.getSource())
        {
            setFontColor(changeStringToColor(e.getActionCommand()));
        }
        else if (menuBackgroundColor == e.getSource())
        {
            setBackgroundColor(changeStringToColor(e.getActionCommand()));
        }
        else if ("Exit" == e.getActionCommand())
        {
            System.exit(0);
        }
        else
        {
            System.out.println(e.getSource());
            System.out.println("This action is not implemented!");
        }
    }

    public Color changeStringToColor(String colorString)
    {
        for (int i = 0; i < stringColor.length; i++)
        {
            if (colorString == stringColor[i])
            {
                return colorColor[i];
            }
        }
        return Color.black;
    }

    public void setWindowLocation(int x, int y)
    {
        setLocation(x, y);
    }

    public String calculateErapsedTime(Date start, Date end)
    {
        Long diffAsSecond = (end.getTime() - start.getTime()) / 1000;
        Long diffHour = diffAsSecond / (60 * 60);
        Long diffMinute = (diffAsSecond - diffHour * 60 * 60) / 60;
        Long diffSecond = (diffAsSecond - diffHour * 60 * 60 - diffMinute * 60);

        String stringHour;
        String stringMinute;
        String stringSecond;

        if (diffHour < 10)
        {
            stringHour = "0" + diffHour;
        }
        else if (diffHour >= 100)
        {
            stringHour = "00";
        }
        else
        {
            stringHour = diffHour.toString();
        }

        if (diffMinute < 10)
        {
            stringMinute = "0" + diffMinute;
        }
        else
        {
            stringMinute = diffMinute.toString();
        }

        if (diffSecond < 10)
        {
            stringSecond = "0" + diffSecond;
        }
        else
        {
            stringSecond = diffSecond.toString();
        }

        return stringHour + ":" + stringMinute + ":" + stringSecond;
    }
}