package aop_01.com.spring_aop.xml2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// 스프링 컨테이너 객체 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config1-2.xml");
		
		// 핵심 기능 bean 등록되어 있어있음
		Circle circle = context.getBean("circle", Circle.class);
		circle.showResult();
		
		// Object getBean(String name)은 Object 타입을 반환해서 형변환 필요
		// 두 번째 인자로 타입을 명시하면 스프링이 내부적으로 타입 검증 후 반환
		// 타입 캐스팅은 런타임 에러를 발생시키고 타입을 명시하면 컨테이너 초기화 시점에 에러 발생시켜서 더 안전함.
		// 즉, 안전한 캐스팅을 보장하기 위해서 사용
		Evaluation evaluation = context.getBean("evaluation", Evaluation.class);
		evaluation.showResult();
		

	}

}
