package aop_01.com.spring_aop.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// ������ �����̳� ��ü ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config2.xml");
		
		// �ٽ� ��� bean ��ϵǾ� �־�����
		Rect rect = context.getBean("rect", Rect.class);
		// xml���� setting
//		rect.setHeight(1);
//		rect.setWidth(2);
		rect.showRectResult();
		
		Gugudan gg = context.getBean("gugudan", Gugudan.class);
		// xml���� setting
//		gg.setDan(3);
		gg.showResult();
		

	}

}
