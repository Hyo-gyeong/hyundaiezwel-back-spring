package aop_01.com.spring_aop.xml;

// JoinPoint : 횡단 관심사(cross-cutting concern) 가 삽입될 수 있는 지점
// ProceedingJoinPoint는 JoinPoint의 하위 타입으로, Around Advice에서만 쓸 수 있음
// 대상 메서드를 직접 실행하거나 실행하지 않을 수 있는 제어권이 넘어옴
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {// 공통기능
	// 시작시간, 종료시간 로그 출력
	// 핵심 기능 수행 전,후
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		// JoinPoint : 특정 포인트(핵심 기능 메서드 호출 시 삽입)
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
