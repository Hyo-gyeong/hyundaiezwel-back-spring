package aop_01.com.spring_aop.xml2;

import java.text.SimpleDateFormat;

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

		Object result = null; // ��ȯ ��� ���� ����
		
//		long startTime = System.nanoTime(); // ����ð����� ��� ����. ����ð� ��꿡 ���(���� Ȯ�ο�)
		long currTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSSS");
		// �����۾� �ڵ�
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] Before : " + methodName + "() ���� ���� �ð� :"+sdf.format(currTime));
		System.out.println("-----------------------------------------------------------------");
		
		try {
			joinPoint.proceed(); // �ٽ� ��� ����
		} catch(Exception e) {
			System.out.println("[Log] Exception : " + methodName);
		}
		
		currTime = System.currentTimeMillis();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] After : " + methodName + "() ���� ���� �ð� : "+ sdf.format(currTime));
		System.out.println("-----------------------------------------------------------------");
		
		return result;
	}
	

}
