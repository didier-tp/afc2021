package fr.afcepf.al35.injection.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyPerfLogAspect {
	
	@Around("execution(* fr.afcepf.al35.injection.trad.*.*(..))")
	public Object doXxxLogAroundTrad(ProceedingJoinPoint pjp) throws Throwable {
		return doXxxLog(pjp);
	}
	
	@Around("execution(* fr.afcepf.al35.injection.gui.*.*(..))")
	public Object doXxxLogAroundGui(ProceedingJoinPoint pjp) throws Throwable {
		return doXxxLog(pjp);
	}
	
	
	public Object doXxxLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("<< trace == debut == " + pjp.getSignature().toLongString() + " <<");
		long td = System.nanoTime();
		Object objRes = pjp.proceed();
		long tf = System.nanoTime();
		System.out.println(
				">> trace == fin == " + pjp.getSignature().toShortString() + " [" + (tf - td) / 1000000.0 + " ms] >>");
		return objRes;
	}
}
