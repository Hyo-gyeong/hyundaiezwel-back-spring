package aop_01.com.spring_aop.annotation;

// JoinPoint : 횡단 관심사(cross-cutting concern) 가 삽입될 수 있는 지점
// ProceedingJoinPoint는 JoinPoint의 하위 타입으로, Around Advice에서만 쓸 수 있음
// 대상 메서드를 직접 실행하거나 실행하지 않을 수 있는 제어권이 넘어옴
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Proxy에 해당, <aop:config> 역할
public class PerformanceAspect {// 공통기능
	// <aop:pointcut> 역할
	// where : 어디에 적용(패키지 내의 모든 메서드에 적용)
	// @Pointcut 메서드는 실행 코드가 없는 빈 껍데기고, AspectJ 표현식을 이름으로 등록하는 용도
	@Pointcut("within(aop_01.com.spring_aop.annotation.*)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()") // 위에 정의된 within 범위 참조
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Signature s = joinPoint.getSignature(); // 핵심 기능에 대한 정보 추출
		String methodName = s.getName(); // 핵심 기능 메서드 명

		Object result = null; // 반환결과 저장 변수
		
		// 공통작업 코드
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] Before : " + methodName + "() 실행 시작");
		System.out.println("-----------------------------------------------------------------");
		
		long startTime = System.nanoTime();
		try {
			joinPoint.proceed(); // 핵심 기능 수행
		} catch(Exception e) {
			System.out.println("[Log] Exception : " + methodName);
		}
		
		long endTime = System.nanoTime();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] After : " + methodName + "() 실행 종료");
		System.out.println("[Log] After : " + methodName + "() 실행 시간 : " + (endTime - startTime)+"ns");
		System.out.println("-----------------------------------------------------------------");
		
		return result;
	}
	

}
