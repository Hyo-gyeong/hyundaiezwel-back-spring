package aop_01.com.spring_aop.xml2;

import org.springframework.stereotype.Component;

@Component
public class Circle { // �ٽ� ���
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void showResult() {
		System.out.println("���� : " + Math.PI * Math.pow(radius, 2));
		System.out.println("�ѷ� : " + 2 * Math.PI * radius);
	}

}
