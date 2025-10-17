package aop_01.com.spring_aop.xml;

// JoinPoint : Ⱦ�� ���ɻ�(cross-cutting concern) �� ���Ե� �� �ִ� ����
// ProceedingJoinPoint�� JoinPoint�� ���� Ÿ������, Around Advice������ �� �� ����
// ��� �޼��带 ���� �����ϰų� �������� ���� �� �ִ� ������� �Ѿ��
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {// ������
	// ���۽ð�, ����ð� �α� ���
	// �ٽ� ��� ���� ��,��
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		// JoinPoint : Ư�� ����Ʈ(�ٽ� ��� �޼��� ȣ�� �� ����)
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
