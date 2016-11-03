
package jpl.ch01.ex10;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	/**
	 * フィボナッチ数列の最初の方の要素を表示する
	 */
	public static void main(String[] args) {
        int lo = 1;
        int hi = 1;

        SequenceElement[] fibonacci = new SequenceElement[MAX_INDEX];
        fibonacci[0] = new SequenceElement(lo);
        fibonacci[1] = new SequenceElement(hi);

        for (int i = 2; i < MAX_INDEX; i++) {
        	fibonacci[i] = new SequenceElement(fibonacci[i-2].element+fibonacci[i-1].element);
        }
        for (int i=0; i<MAX_INDEX; i++) {
        	if(fibonacci[i].even_number_check){
        		System.out.println(i+1 +": " + fibonacci[i].element + " *");
        	}else{
        		System.out.println(i+1 +": " + fibonacci[i].element);
        	}
        }
	}
}
