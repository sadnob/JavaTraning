package interpret;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public final class MainPanel extends JPanel implements ActionListener{

/*============================================================================================================
	フィールド
=============================================================================================================*/
    private static final int GAP = 5;
    private String[] allField;
    private String[] allConstructor;// コンストラクタ一覧配列
    private String[][] argumentModel;// コンストラクタ引数対応配列
    private String[] allMethod;// メソッド一覧配列
    private String[][] argumentMethodModel;// メソッド引数対応配列


	private String[] nameList; // フィールド名前
    private String[] typeList; // フィールド型
    private String[] valueList;// フィールド値


    private final JTextField textField1 = new JTextField("interpret.InterpretMain");// クラス検索


    // コンボボックス
    private  JComboBox<String> combo1 = new JComboBox<>(new String[1]);//コンストラクター
    private  JComboBox<String> combo2 = new JComboBox<>(new String[1]);//メソッド

    // ボタン
    private final JButton button1 = new JButton("検索");
    private final JButton button2 = new JButton("生成");
    private final JButton button3 = new JButton("実行");
    private final JButton button4 = new JButton("編集");

    // コンストラクター引数テーブル
    private final String constTableCulumn[] = {"型","値"};
    private String selectConstArgs[][] = new String[10][2];
    private JTable table1 = new JTable(selectConstArgs, constTableCulumn);
    private JScrollPane sp1 = new JScrollPane(table1);

    // メソッド引数テーブル
    private final String methodTableCulumn[] = {"型","値"};
    private String selectMethodArgs[][] = new String[10][2];
    private JTable table2 = new JTable(selectMethodArgs, methodTableCulumn);
    private JScrollPane sp2 = new JScrollPane(table2);

    // フィールドテーブル
    private final String fieldTableCulumn[] = {"型","名前","値", "変更値"};
    private String selectFieldArgs[][] = new String[20][4];
    private JTable table3 = new JTable(selectFieldArgs, fieldTableCulumn);
    private JScrollPane sp3 = new JScrollPane(table3);

	private JTextArea tResult = new JTextArea(3, 25);




    private Class selectClass; // 検索されたクラス
    private Object createObj; // 作成されたインスタンス格納


/*===============================================================================
	コンストラクター
================================================================================*/
    public MainPanel() {
        super(new BorderLayout());
        Box box = Box.createVerticalBox();

        JLabel label1 = new JLabel("お詫び：3割程度の完成度です。申し訳ありません。");
        JLabel label2 = new JLabel("                  次回完成したものを提出しますので今回は大目に見ていただけないでしょうか。。。");
        box.add(createCompButtonPanel1(label1, null, ""));
        box.add(createCompButtonPanel1(label2, null, ""));

        //box.add(Box.createVerticalStrut(15));
        button1.addActionListener(this);
        box.add(createCompButtonPanel1(textField1, button1, " Class :            "));
        box.add(Box.createVerticalStrut(15));

        combo1.addActionListener(this);
        button2.addActionListener(this);
        box.add(createCompButtonPanel1(combo1, null, " Constructor :"));
        box.add(Box.createVerticalStrut(15));

        sp1.setPreferredSize(new Dimension(250, 75));
        box.add(createCompButtonPanel1(sp1, button2, " argument :　"));
        box.add(Box.createVerticalStrut(20));


        combo2.addActionListener(this);
        button3.addActionListener(this);
        box.add(createCompButtonPanel1(combo2, null, " Method :　    "));
        box.add(Box.createVerticalStrut(15));

        sp2.setPreferredSize(new Dimension(250, 75));
        box.add(createCompButtonPanel1(sp2, button3, " argument :    "));

        JLabel label3 = new JLabel("-----------------------------------------------------------------------"
        		+ "------------------------------------------------------------------------------------------------");
        box.add(createCompButtonPanel1(label3, null, ""));


        button4.addActionListener(this);
        sp3.setPreferredSize(new Dimension(250, 100));
        box.add(createCompButtonPanel2(sp3, button4, "Field :              "));
        box.add(Box.createVerticalStrut(20));

        box.add(createCompButtonPanel1(tResult, null, " 結果 :　       "));
        box.add(Box.createVerticalStrut(20));


        add(box, BorderLayout.NORTH);
        setPreferredSize(new Dimension(320, 240));
    }

/*========================================================================
	メソッド
=========================================================================*/

    /**
     *
     * @param cmp
     * @param btn
     * @param str
     * @return
     */
    private static JPanel createCompButtonPanel1(JComponent cmp, JButton btn, String str) {
        JPanel panel = new JPanel(new BorderLayout(GAP, GAP));
        panel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        panel.add(new JLabel(str), BorderLayout.WEST);
        panel.add(cmp);
        if (btn != null)
        	panel.add(btn, BorderLayout.EAST);
        Dimension d = panel.getPreferredSize();
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, d.height));
        return panel;
    }

    /**
     *
     * @param cmp
     * @param btn
     * @param str
     * @return
     */
    public static JPanel createCompButtonPanel2(JComponent cmp, JButton btn, String str) {
        GridBagConstraints c = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());


        c.insets = new Insets(GAP, GAP, GAP, 0);
        c.anchor = GridBagConstraints.LINE_END;
        panel.add(new JLabel(str), c);

        c.weightx = 1d;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cmp, c);

        c.weightx = 0d;
        c.insets = new Insets(GAP, GAP, GAP, GAP);
        panel.add(btn, c);

        return panel;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String className;// 入力クラス名
		String selectConstructor;// 選択されたコンストラクタ名
		String selectMethod;// 選択されたメソッド名
		String[] updateList = new String[20];// 編集されたフィールド

		// "検索ボタン"アクション
		if (e.getActionCommand().equals("検索")) {
			className = (String) textField1.getText();
			riset();
			if (className !=null ) {
				try{
				Refrection.classSerch(className, this);
				}catch (ClassNotFoundException ex) {
					showResult("クラスが見つかりません。");
					return;
				}
			} else {
				showResult("クラスを入力してください。");
			}
		}
		// 選択されているコンストラクタの引数表示
		if (combo1.getSelectedIndex() != -1) {
			//selectConstructor = (String) combo1.getSelectedItem();
			int index = combo1.getSelectedIndex();
				for (int i=0; i<10; i++) {
						table1.setValueAt(argumentModel[index][i], i, 0);
				}
		}
		// "生成ボタン"アクション
		if (e.getActionCommand().equals("生成")) {
			int index = combo1.getSelectedIndex();
			if (checkArgument(index)){

				fieldSet();
			} else {
				try {
					Refrection.generateObject(selectClass, this);
					fieldSet();
					showResult("インスタンスの生成に成功しました。");
				} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e1) {
					e1.printStackTrace();
				}
			}
		}
		// 選択されているメソッドの引数表示
		if (combo2.getSelectedIndex() != -1) {
			selectMethod = (String) combo2.getSelectedItem();
				int index = combo2.getSelectedIndex();
					for (int j=0; j<10; j++) {
						if (argumentMethodModel[index][j] != null)
							table2.setValueAt(argumentMethodModel[index][j], j, 0);
					}
		}
		// "実行ボタン"アクション
		 if (e.getActionCommand().equals("実行")) {}

		// "編集ボタン"アクション
		if (e.getActionCommand().equals("編集")) {
			System.out.println("ok");
			for (int i=0; i<20; i++) {
				updateList[i] = (String) table3.getValueAt(i, 3);
				System.out.println(updateList[i]);
				if (updateList[i]!= null) {
					try {
						Refrection.modelCheck(createObj, nameList[i], updateList[i]);
						Refrection.getAllField(createObj, selectClass, this);
						fieldSet();
					} catch (NoSuchFieldException | SecurityException
							| IllegalArgumentException | IllegalAccessException e1) {
						showResult("フィールドの更新に失敗しました。");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * コンストラクター引数判定
	 * @param index
	 * @return
	 */
	private boolean checkArgument (int index) {
		boolean check = false;
		if (argumentModel[index][0] != null) {
			check = true;
		}

		return check;
	}

	/**
	 *
	 */
	private void fieldSet () {
		for (int i=0; i<nameList.length; i++) {
			table3.setValueAt(nameList[i], i, 0);// フィールド名前
			table3.setValueAt(typeList[i], i, 1);// フィールド型
			table3.setValueAt(valueList[i], i, 2);// フィールド値
		}
	}

	/**
	 * 表示値リセット
	 */
	private void riset () {
		combo1.removeAllItems();
		combo2.removeAllItems();
		for (int i=0; i<10; i++) {
				table1.setValueAt(null, i, 0);
				table1.setValueAt(null, i, 1);
		}
		for (int i=0; i<10; i++) {
			table2.setValueAt(null, i, 0);
			table2.setValueAt(null, i, 1);
		}
		for (int i=0; i<20; i++) {
			table3.setValueAt(null, i, 0);
			table3.setValueAt(null, i, 1);
			table3.setValueAt(null, i, 2);
			table3.setValueAt(null, i, 3);
		}
	}

	/**
	 * 結果を表示
	 * @param message
	 */
	void showResult(String message) {
		tResult.setText("");
		if (message == null)
			return;
		tResult.setText(message);
	}

/*========================================================================
 * セッターゲッター
=========================================================================*/

	public String[] getAllField() {
		return allField;
	}

	public void setAllField(String[] allField) {
		this.allField = allField;
	}

	public String[] getAllConstructor() {
		return allConstructor;
	}

	/**
	 * コンストラクターリストのセッター
	 * コンストラクターのプルダウンリストをリセットし新たにセットする。
	 * @param allConstractor
	 * @param size
	 */
	public void setAllConstructor(String[] allConstructor, int size) {
		this.allConstructor = allConstructor;
		combo1.removeAllItems();
		for(int i=0; i<size; i++ ){
			this.combo1.addItem(allConstructor[i]);
		}

	}

	public String[] getAllMethod() {
		return allMethod;
	}

	/**
	 * メソッドリストのセッター
	 * メソッドのプルダウンリストをリセットし新たにセットする。
	 * @param allConstractor
	 * @param size
	 */
	public void setAllMethod(String[] allMethod, int size) {
		this.allMethod = allMethod;
		combo2.removeAllItems();
		for(int i=0; i<size; i++ ){
			this.combo2.addItem(allMethod[i]);
		}

	}

	public String[][] getArgumentModel() {
		return argumentModel;
	}

	public void setArgumentModel(String[][] argumentModel) {
		this.argumentModel = argumentModel;
	}

    public String[][] getArgumentMethodModel() {
		return argumentMethodModel;
	}

	public void setArgumentMethodModel(String[][] argumentMethodModel) {
		this.argumentMethodModel = argumentMethodModel;
	}

	public Object getCreateObj() {
		return createObj;
	}

	public void setCreateObj(Object createObj) {
		this.createObj = createObj;
	}

	public Class getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(Class selectClass) {
		this.selectClass = selectClass;
	}

	public String[] getNameList() {
		return nameList;
	}

	public void setNameList(String[] nameList) {
		this.nameList = nameList;
	}

	public String[] getTypeList() {
		return typeList;
	}

	public void setTypeList(String[] typeList) {
		this.typeList = typeList;
	}

	public String[] getValueList() {
		return valueList;
	}

	public void setValueList(String[] valueList) {
		this.valueList = valueList;
	}


    /**
     * mainメソッド
     * @param args
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Interpret");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
