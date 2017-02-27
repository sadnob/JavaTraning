package gui.ex14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyDialog extends Dialog implements ActionListener,
		ItemListener {

	Panel topPanel = new Panel();
	Panel bottomPanel = new Panel();

	Choice choiceFontType = new Choice();
	Choice choiceFontSize = new Choice();
	Choice choiceFontColor = new Choice();
	Choice choiceBackgroundColor = new Choice();

	// 色ColorのSring
	public String strFontColor;
	public String strBackGroundColor;

	// 変更後の値
	String newFontType = "TimesRoman";
	int newFontSize = 40;
	Color newFontColor = Color.BLACK;
	Color newBackgroundColor = Color.WHITE;

	// ボタン
	Button OKButton = new Button("OK");
	Button CancelButton = new Button("キャンセル");

	// Color ⇔ String
	private static final Color colorList[] = { Color.BLACK, Color.RED, Color.green, Color.BLUE, Color.WHITE };
	private static final String colorStrList[] = { "black", "red", "green", "blue", "white" };

	DigitalClock digitalClock;

	public PropertyDialog(Frame owner) {

		super(owner);

		digitalClock = (DigitalClock) owner;

		// 現在の時計の設定を取得する
		newFontType = digitalClock.getFontType();
		newFontSize = digitalClock.getFontSize();
		newFontColor = digitalClock.getFontColor();
		newBackgroundColor = digitalClock.getBackgroundColor();

		setLayout(new BorderLayout());
		setTitle("Property");// タイトル
		setSize(300, 180);// ウィンドウサイズ
		setResizable(false);// 大きさ固定

		topPanel.setLayout(new GridLayout());

		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);

		topPanel.setLayout(new GridLayout(4, 2));

		// リスナー登録
		choiceFontType.addItemListener(this);
		choiceFontSize.addItemListener(this);
		choiceFontColor.addItemListener(this);
		choiceBackgroundColor.addItemListener(this);
		OKButton.addActionListener(this);
		CancelButton.addActionListener(this);

		// フォントタイプ
		topPanel.add(new Label("Font Type: "));
		choiceFontType.add("TimesRoman");
		choiceFontType.add("Serif");
		choiceFontType.add("Monospaced");

		choiceFontType.select(digitalClock.getFontType());
		topPanel.add(choiceFontType);

		// フォントサイズ
		topPanel.add(new Label("Font Size: "));
		choiceFontSize.add("36");
		choiceFontSize.add("48");
		choiceFontSize.add("60");
		choiceFontSize.add("72");
		choiceFontSize.add("96");
		choiceFontSize.add("120");
		choiceFontSize.select(digitalClock.getFontSize().toString());
		topPanel.add(choiceFontSize);

		// フォントカラーの初期選択値をStringで取得する
		if (Color.black == digitalClock.getFontColor()) {
			strFontColor = "black";
		} else if (Color.red == digitalClock.getFontColor()) {
			strFontColor = "red";
		} else if (Color.green == digitalClock.getFontColor()) {
			strFontColor = "green";
		} else if (Color.blue == digitalClock.getFontColor()) {
			strFontColor = "blue";
		} else {
			strFontColor = "black";
		}

		// フォントカラー
		topPanel.add(new Label("Font Color: "));
		choiceFontColor.add("black");
		choiceFontColor.add("red");
		choiceFontColor.add("green");
		choiceFontColor.add("blue");
		choiceFontColor.select(strFontColor);
		topPanel.add(choiceFontColor);

		// 背景色の初期選択値をStringで取得する
		if (Color.white == digitalClock.getBackgroundColor()) {
			strBackGroundColor = "white";
		} else if (Color.black == digitalClock.getBackgroundColor()) {
			strBackGroundColor = "black";
		} else if (Color.orange == digitalClock.getBackgroundColor()) {
			strBackGroundColor = "orange";
		} else {
			strBackGroundColor = "white";
		}

		// 背景色
		topPanel.add(new Label("Background Color: "));
		choiceBackgroundColor.add("white");
		choiceBackgroundColor.add("black");
		choiceBackgroundColor.add("orange");
		choiceBackgroundColor.select(strBackGroundColor);
		topPanel.add(choiceBackgroundColor);

		// ボタン
		bottomPanel.add(OKButton);
		bottomPanel.add(CancelButton);

		// ダイアログボックスを閉じるとき
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("OK" == e.getActionCommand()) {
			digitalClock.setFontType(newFontType);
			digitalClock.setFontSize(newFontSize);
			digitalClock.setFontColor(newFontColor);
			digitalClock.setBackgroundColor(newBackgroundColor);
			digitalClock.setStrFontColor(colorToString(newFontColor));
			digitalClock.setStrBackGroundColor(colorToString(newBackgroundColor));
			setVisible(false);
		} else if ("キャンセル" == e.getActionCommand()) {
			digitalClock.setBounds(0, 0, 200, 100);
			setVisible(false);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// フォントタイプが選択された場合
		if (choiceFontType == e.getSource()) {
			newFontType = e.getItem().toString();
		}
		// フォントサイズが選択された場合
		else if (choiceFontSize == e.getSource()) {
			newFontSize = Integer.parseInt(e.getItem().toString());
		}
		// フォントカラーが選択された場合
		else if (choiceFontColor == e.getSource()) {
			if ("black" == e.getItem()) {
				newFontColor = Color.black;
			} else if ("red" == e.getItem()) {
				newFontColor = Color.red;
			} else if ("green" == e.getItem()) {
				newFontColor = Color.green;
			} else if ("blue" == e.getItem()) {
				newFontColor = Color.blue;
			} else {
				newFontColor = Color.black;
			}
		}
		// 背景色が選択された場合
		else if (choiceBackgroundColor == e.getSource()) {
			if ("white" == e.getItem()) {
				newBackgroundColor = Color.white;
			} else if ("black" == e.getItem()) {
				newBackgroundColor = Color.black;
			} else if ("orange" == e.getItem()) {
				newBackgroundColor = Color.orange;
			} else {
				newBackgroundColor = Color.white;
			}
		}
	}

	// 受け取ったColorの文字列をColorオブジェクトに変換します。
	public static String colorToString(Color color) {
		for (int i = 0; i < colorList.length; i++) {
			if (color.equals(colorList[i])) {
				return colorStrList[i];
			}
		}
		return colorStrList[0];
	}
	// 受け取ったColorの文字列をColorオブジェクトに変換します。
	public static Color stringToColor(String colorStr) {
		for (int i = 0; i < colorStrList.length; i++) {
			if (colorStr.equals(colorStrList[i])) {
				return colorList[i];
			}
		}
		return colorList[0];
	}
}