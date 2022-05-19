package daybyday;

import java.util.Arrays;

public class plusMinus {


	public static void main(String[] args) {
		int[] nanSu = new int[10]; // 배열의 길이가 10인 저장공간 만들기
		int psum = 0; // 양수의 합을 담을 변수 psum
		int msum = 0; // 음수의 합을 담을 변수 msum
	
		for(int i=0; i<nanSu.length; i++) 
		nanSu[i] = (int)(Math.random()*21)-10; //-10~10 까지의 난수 발생
		
		for(int i =0; i<nanSu.length; i++)
		if (nanSu[i]>0) {
			psum += nanSu[i];
		}else {msum += nanSu[i];
		
		}
		System.out.println("양수합: "+ psum);
		System.out.println("음수합: "+ msum);
		System.out.println(Arrays.toString(nanSu));
	}
}