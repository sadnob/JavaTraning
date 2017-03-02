package gui.ex14;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

	private GridBagLayout gbl = new GridBagLayout();

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
	int xPosition;
	int yPosition;

	// ボタン
	Panel bottom = new Panel();
	Button OKButton = new Button("OK");
	Button CancelButton = new Button("キャンセル");

	// Color ⇔ String
	private static final Color colorList[] = { Color.BLACK, Color.RED, Color.green, Color.BLUE, Color.WHITE , Color.ORANGE};
	private static final String colorStrList[] = { "black", "red", "green", "blue", "white" , "orange"};

	DigitalClock digitalClock;

	public PropertyDialog(Frame owner) {

		super(owner);

		digitalClock = (DigitalClock) owner;

		// 現在の時計の設定を取得する
		newFontType = digitalClock.getFontType();
		newFontSize = digitalClock.getFontSize();
		newFontColor = digitalClock.getFontColor();
		newBackgroundColor = digitalClock.getBackgroundColor();

		setLayout(gbl);
		setTitle("Property");// タイトル
		setSize(300, 180);// ウィンドウサイズ
		setResizable(false);// 大きさ固定

		// リスナー登録
		choiceFontType.addItemListener(this);
		choiceFontSize.addItemListener(this);
		choiceFontColor.addItemListener(this);
		choiceBackgroundColor.addItemListener(this);
		OKButton.addActionListener(this);
		CancelButton.addActionListener(this);

		// 種類追加
		choiceFontType.add("TimesRoman");
		choiceFontType.add("Serif");
		choiceFontType.add("Monospaced");
		choiceFontType.select(digitalClock.getFontType());

		// フォントサイズ追加
		choiceFontSize.add("36");
		choiceFontSize.add("48");
		choiceFontSize.add("60");
		choiceFontSize.add("72");
		choiceFontSize.add("96");
		choiceFontSize.add("120");
		choiceFontSize.select(digitalClock.getFontSize().toString());

		// フォントカラー追加
		choiceFontColor.add("black");
		choiceFontColor.add("red");
		choiceFontColor.add("green");
		choiceFontColor.add("blue");
		strFontColor = colorToString(digitalClock.getFontColor()); // フォントカラーの初期選択値をStringで取得する
		choiceFontColor.select(strFontColor);

		// 背景色
		choiceBackgroundColor.add("white");
		choiceBackgroundColor.add("orange");
		choiceBackgroundColor.add("red");
		choiceBackgroundColor.add("blue");
		strBackGroundColor = colorToString(digitalClock.getBackgroundColor()); // 背景色の初期選択値をStringで取得する
		choiceBackgroundColor.select(strBackGroundColor);

		// 属性配置
		addComponent(new Label("Font Type: "), 0, 0, 1, 1,
				GridBagConstraints.EAST);
		addComponent(choiceFontType, 1, 0, 1, 1, GridBagConstraints.WEST);
		addComponent(new Label("Font Size: "), 0, 1, 1, 1,
				GridBagConstraints.EAST);
		addComponent(choiceFontSize, 1, 1, 1, 1, GridBagConstraints.WEST);
		addComponent(new Label("Font Color: "), 0, 2, 1, 1,
				GridBagConstraints.EAST);
		addComponent(choiceFontColor, 1, 2, 1, 1, GridBagConstraints.WEST);
		addComponent(new Label("Background Color: "), 0, 3, 1, 1,
				GridBagConstraints.EAST);
		addComponent(choiceBackgroundColor, 1, 3, 1, 1, GridBagConstraints.WEST);
		// ボタン
		addComponent(OKButton, 0, 4, 1, 1, GridBagConstraints.EAST);
		addComponent(CancelButton, 1, 4, 1, 1, GridBagConstraints.WEST);

		/*
		 * gbc.gridx = 2; gbc.gridy = 4; gbc.gridwidth = 1; gbc.gridheight = 1;
		 * gbc.weightx = 1.0d; gbc.weighty = 1.0d; gbl.setConstraints(OKButton,
		 * gbc); this.add(OKButton);
		 */

		/*
		 * gbc.gridx = 3; gbc.gridy = 4; gbc.gridwidth = 1; gbc.gridheight = 1;
		 * gbc.weightx = 1.0d; gbc.weighty = 1.0d;
		 * gbl.setConstraints(CancelButton, gbc); this.add(CancelButton);
		 */

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
			digitalClock
					.setStrBackGroundColor(colorToString(newBackgroundColor));
			//System.out.println(digitalClock.getStrFontColor());
			//System.out.println(digitalClock.getStrBackGroundColor());
			setVisible(false);
		} else if ("キャンセル" == e.getActionCommand()) {
			digitalClock.setBounds(digitalClock.getPositionX(),
					digitalClock.getPositionY(), 200, 100);
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
			} else if ("orange" == e.getItem()) {
				newBackgroundColor = Color.orange;
			} else if ("green" == e.getItem()) {
				newBackgroundColor = Color.green;
			} else if ("blue" == e.getItem()) {
				newBackgroundColor = Color.blue;
			} else if ("red" == e.getItem()) {
				newBackgroundColor = Color.red;
			} else {
				newBackgroundColor = Color.black;
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

	// レイアウト設定用メソッド
	protected void addComponent(Component c, int x, int y, int w, int h, int anchor) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = anchor;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.weightx = 1.0d;
		gbc.weighty = 1.0d;

		gbl.setConstraints(c, gbc);
		this.add(c);
	}
}