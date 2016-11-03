package jpl.ch01.ex16;

import java.io.FileInputStream;
import java.io.IOException;

public class BadDataSetException extends Exception{
	      String dataName;
	      IOException ioException;
}

	class MyUtilities {
		public double [] getDateSet (String setName) throws BadDataSetException {
			String file = setName + ".dset";
			FileInputStream in = null;
			try {
				in = new FileInputStream(file);
				return readDateSet(in);
			} catch (IOException e) {
				BadDataSetException catchException =new BadDataSetException();
				catchException.dataName = setName;
				catchException.ioException = e;
				throw  catchException;
			} finally {
				try {
					if (in != null)
						in.close();
				}	catch (IOException e) {
					; // 無視：データの読み込みは成功しているか、あるいは、
					  // BatDateSetExceptionをスローしようとしている
				}
			}
		}

		private double[] readDateSet(FileInputStream in) {

			return null;
		}



}
