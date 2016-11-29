package jpl.ch05.ex02;



public class BankAccount {
	private long number;        // 講座番号
	private long balance;        // 現在の残高（単位は、 セント）
	private Action lastAct;  // 最後に行われた処理
	private History history = new History();  // 最後の10個の処理

	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
			history.set(this);
		}
		public String  toString() {
			// identify our enclosing account
			return number + ": " + " " + amount;
		}
	}

	public class History {
		private final int size = 10; // 履歴保存件数
		private Action[] historyList = new Action[size]; //10件の履歴保存用配列
		private int nextIndex = 10; // 現在の履歴閲覧

		// Actionインスタンスが生成される度に履歴オブジェクトに追加するためのメソッド
		private void set(Action act) {
			for (int i = 1; i<size; i++) {
				if (historyList[i] == null) {
					historyList[i] = act;
					break;
				}
			}
			for (int i = 1; i<size-1; i++) {
				historyList[i] = historyList[i+1];
			}
			historyList[size] = act;
		}
		// 次の履歴を取得します。
		public Action next() {
			Action next = historyList[nextIndex];
			if(nextIndex == 0) {
				nextIndex =10; // 10件前の履歴まで行ったら10件目の履歴までリセット
			} else {
				nextIndex -=1;
			}
			return next;
		}
	}

	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw",  amount);
	}

	public History history () {
		return this.history();
	}

}
