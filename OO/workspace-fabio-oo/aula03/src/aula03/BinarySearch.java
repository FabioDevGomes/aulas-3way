package aula03;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arrayInt = {1,2,5,9,45,22,3};
		Arrays.sort(arrayInt);
		System.out.println(Arrays.toString(arrayInt));
		
		//da o resultado esperado após a ordenação
		System.out.println(Arrays.binarySearch(arrayInt, 22));
	}

}
