package aop_01.com.spring_aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class Gugudan { // ÇÙ½É ±â´É
	private int dan;

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void showResult() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}
}
