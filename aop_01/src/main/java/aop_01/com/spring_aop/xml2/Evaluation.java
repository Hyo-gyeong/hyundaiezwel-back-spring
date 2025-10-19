package aop_01.com.spring_aop.xml2;

import org.springframework.stereotype.Component;

@Component
public class Evaluation { // ÇÙ½É ±â´É
	private int kor;
	private int eng;
	private int math;

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void showResult() {
		System.out.println("±¹, ¿µ, ¼ö ÃÑÁ¡ : " + (kor + eng + math));
		System.out.println("±¹, ¿µ, ¼ö Æò±Õ : " + (kor + eng + math) / 3.0);
	}
}
