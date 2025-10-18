package aop_01.com.spring_aop.annotation;

// JoinPoint : Ⱦ�� ���ɻ�(cross-cutting concern) �� ���Ե� �� �ִ� ����
// ProceedingJoinPoint�� JoinPoint�� ���� Ÿ������, Around Advice������ �� �� ����
// ��� �޼��带 ���� �����ϰų� �������� ���� �� �ִ� ������� �Ѿ��
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Proxy�� �ش�, <aop:config> ����
public class PerformanceAspect {// ������
	// <aop:pointcut> ����
	// where : ��� ����(��Ű�� ���� ��� �޼��忡 ����)
	// @Pointcut �޼���� ���� �ڵ尡 ���� �� �������, AspectJ ǥ������ �̸����� ����ϴ� �뵵
	@Pointcut("within(aop_01.com.spring_aop.annotation.*)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()") // ���� ���ǵ� within ���� ����
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Signature s = joinPoint.getSignature(); // �ٽ� ��ɿ� ���� ���� ����
		String methodName = s.getName(); // �ٽ� ��� �޼��� ��

		Object result = null; // ��ȯ��� ���� ����
		
		// �����۾� �ڵ�
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] Before : " + methodName + "() ���� ����");
		System.out.println("-----------------------------------------------------------------");
		
		long startTime = System.nanoTime();
		try {
			joinPoint.proceed(); // �ٽ� ��� ����
		} catch(Exception e) {
			System.out.println("[Log] Exception : " + methodName);
		}
		
		long endTime = System.nanoTime();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] After : " + methodName + "() ���� ����");
		System.out.println("[Log] After : " + methodName + "() ���� �ð� : " + (endTime - startTime)+"ns");
		System.out.println("-----------------------------------------------------------------");
		
		return result;
	}
	

}
