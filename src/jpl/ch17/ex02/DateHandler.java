package jpl.ch17.ex02;

import java.io.File;
import java.lang.ref.WeakReference;

public class DateHandler {
	private WeakReference<File> lastFile;       // 最後に読んだファイル
	private WeakReference<byte[]> lastData; // (おそらく)最後のデータ

	byte[] readFile(File file) {
		byte[] data;

		// データを記憶しているか調べる
		if (file.equals(lastFile)) {
			data = lastData.get();
			if (data != null)
				return data;
		}

		// 記憶していないので、読み込む
		data = readFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}
}
