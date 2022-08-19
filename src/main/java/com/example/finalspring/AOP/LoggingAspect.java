package com.example.finalspring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Pointcut("execution(* delete*(..))")
	private void deleteAllMethods(){};

	@Before("execution(public * getTeacher(..))")
	public void beforeGetAllTeacher() {
		System.out.println("beforeGetAllTeacher:подготовка к получению всех работников");
	}

	@Around("execution(* com.example.finalspring.repository.*.*(..))")
	public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
		String methodName = methodSignature.getName();
		System.out.println("Begin with " + methodName);
		Object targetMethodResult = proceedingJoinPoint.proceed();
		System.out.println("End of "+ methodName);
		return targetMethodResult;
	}


	@After("deleteAllMethods()")
	public void AfterDeleteMethod() {
		System.out.println("Удаление прошло успешно");
	}


	@AfterReturning("execution(* getStudent(..))")
	public void afterReturningGetStudentLoggingAdvice() {
		System.out.println("afterReturning:логируем получение" + " списка студентов после вызова");
	}


	@AfterThrowing(value = "execution(* getStudent(..))",throwing = "exception")
	public void afterThrowingGetStudentLogging(Throwable exception) {
		System.out.println("afterThrowingGetStudentLogging "+"исключения "+ exception);
	}
}
