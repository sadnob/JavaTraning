package interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Refrection {

	private static Class<?> cls;


	/**
	 * 指定クラスを検索しコンストラクター取得します
	 *
	 * @param c
	 */
	public static void classSerch(String c, MainPanel panel)
			throws ClassNotFoundException {

		cls = Class.forName(c);
		panel.setSelectClass(cls);
		getAllConstractor(cls, panel);// コンストラクタ情報をセット
	}

	/**
	 * フィールドを取得し表示する。
	 *
	 * @param object            生成されたオブジェクト
	 * @param c            指定クラス
	 */
	public static void getAllField(Object object, Class c, MainPanel panel)
			throws ClassNotFoundException, IllegalArgumentException,
			IllegalAccessException {

		Field[] fields = c.getDeclaredFields();
		if (fields == null || fields.length == 0) {
			return;
		}
		String[] nameList = new String[fields.length]; // フィールド名前
		String[] typeList = new String[fields.length]; // フィールド型
		String[] valueList = new String[fields.length];// フィールド値

		// 取得したフィールドを型・名前・値に分けて配列に格納
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			nameList[i] = f.getName();
			Class<?> fieldType = f.getType();
			typeList[i] = fieldType.getCanonicalName();
			Object value = f.get(object);
			if (value != null) {
				valueList[i] = value.toString();
			}
		}

		// パネルにセット
		panel.setNameList(nameList);
		panel.setTypeList(typeList);
		panel.setValueList(valueList);

		/*
		 * for (int i=0; i<nameList.length; i++) {
		 * System.out.println(nameList[i]); System.out.println(typeList[i]);
		 * System.out.println(valueList[i]); }
		 */

	}

	/**
	 * 表示用コンストラクターのリストを取得
	 *
	 * @param c
	 */
	public static void getAllConstractor(Class c, MainPanel panel) {

		Constructor<?>[] constructors = c.getDeclaredConstructors();
		if (constructors == null || constructors.length == 0) {
			return;
		}
		String[] list = new String[constructors.length];
		String[][] argument = new String[constructors.length][10];

		// スーパークラスのコンストラクターリスト取得
		// Constructor<?>[] constructors = c.getConstructors();
		// if (constructors == null || constructors.length == 0)
		// return null;

		// 表示用のコンストラクタリスト作成
		for (int i = 0; i < constructors.length; i++) {
			list[i] = constructors[i].getName() + "(";
			Class[] params = constructors[i].getParameterTypes();
			if (params != null && params.length != 0) {
				for (int j = 0; j < params.length; j++) {
					if (j != 0) {
						list[i] += ",";
					}
					list[i] += params[j].getCanonicalName();
					argument[i][j] = params[j].getCanonicalName();
				}
			}
			list[i] += ")";
		}

		/*
		 * for (int i=0; i< constructors.length; i++){
		 * System.out.println(list[i]); for (int j=0; j<10; j++){
		 * if(argument[i][j] !=null) System.out.println(argument[i][j]); } }
		 */

		panel.setArgumentModel(argument);
		panel.setAllConstructor(list, list.length);

	}

	/**
	 * メソッドを取得する。
	 *
	 * @param
	 */
	public static void getAllMethod(Class c, MainPanel panel) {
		Method[] methods = c.getDeclaredMethods();
		String[][] argument = new String[methods.length][10];

		if (methods == null || methods.length == 0) {
			return;
		}
		String[] list = new String[methods.length];

		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i];
			list[i] = m.getName() + "(";
			Class[] params = m.getParameterTypes();
			if (params == null || params.length == 0) {

			} else {
				for (int j = 0; j < params.length; j++) {
					if (j != 0)
						list[i] += ",";
					list[i] += params[j].getCanonicalName();
					argument[i][j] = params[j].getCanonicalName();
				}
			}
			list[i] += ")";
		}

		// パネルにセット
		panel.setArgumentMethodModel(argument);
		panel.setAllMethod(list, list.length);

	}

	/**
	 * コンストラクター呼び出し（引数なし）
	 *
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void generateObject(Class cls, MainPanel panel)
			throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		Object obj = cls.newInstance();
		panel.setCreateObj(obj);
		getAllMethod(cls, panel);// メソッドリスト設定
		getAllField(obj, cls, panel);// フィールドリスト設定
	}

	/**
	 * コンストラクタ引数ありで生成
	 *
	 * @param className
	 * @param params
	 * @param paramValues
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
/*	public static Object generateObject(String className, String[] params,
			String[] paramValues) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException,
			NoSuchMethodException, InvocationTargetException {


		return con.newInstance(values);
	}*/

	/**
	 *
	 * @param obj
	 * @param panel
	 * @param name
	 * @param update
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void modelCheck(Object obj, String name, String update)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field f = null;
		// フィールド値編集
		f = obj.getClass().getDeclaredField(name);
		f.setAccessible(true);
		f.set(obj, modelChange(update));
	}

	public static Object modelChange (String str) {
		Object obj = str;
		switch (str) {
		case "int" : obj = Integer.parseInt(str); break;
		case "double" : obj = Double.parseDouble(str); break;
		case "byte" : obj = Byte.parseByte(str); break;
		case "float" : obj = Float.parseFloat(str); break;
		}
		return obj;
	}

	/**
	 * 確認用mainメソッド
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String className = "Interpret.Super";

		/*
		 * try { Class cls = Class.forName(className); Object obj =
		 * generateObject(className); getAllField(obj, cls); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); } catch
		 * (IllegalAccessException e) { e.printStackTrace(); } catch
		 * (InstantiationException e) { e.printStackTrace(); }
		 *
		 *
		 *
		 * }
		 */
	}
}
