package aop_01.com.spring_aop.xml2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// ������ �����̳� ��ü ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config1-2.xml");
		
		// �ٽ� ��� bean ��ϵǾ� �־�����
		Circle circle = context.getBean("circle", Circle.class);
		circle.showResult();
		
		// Object getBean(String name)�� Object Ÿ���� ��ȯ�ؼ� ����ȯ �ʿ�
		// �� ��° ���ڷ� Ÿ���� ����ϸ� �������� ���������� Ÿ�� ���� �� ��ȯ
		// Ÿ�� ĳ������ ��Ÿ�� ������ �߻���Ű�� Ÿ���� ����ϸ� �����̳� �ʱ�ȭ ������ ���� �߻����Ѽ� �� ������.
		// ��, ������ ĳ������ �����ϱ� ���ؼ� ���
		Evaluation evaluation = context.getBean("evaluation", Evaluation.class);
		evaluation.showResult();
		

	}

}
