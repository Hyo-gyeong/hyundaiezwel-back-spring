package aop_01.com.spring_aop.xml2;

import org.springframework.stereotype.Component;

@Component
public class Circle { // 핵심 기능
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void showResult() {
		System.out.println("면적 : " + Math.PI * Math.pow(radius, 2));
		System.out.println("둘레 : " + 2 * Math.PI * radius);
	}

}
