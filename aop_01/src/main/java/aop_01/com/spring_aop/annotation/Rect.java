package aop_01.com.spring_aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class Rect { // �ٽ� ���
	private int width;
	private int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// �ٽɱ�� : �簢���� ������ ���ؼ� ���
	public void showRectResult() {
		System.out.println("���� : " + (width * height));
		System.out.println("�ѷ� : " + (2 * (width + height)));
	}

}
