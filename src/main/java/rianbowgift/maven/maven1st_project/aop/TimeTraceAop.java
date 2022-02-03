package rianbowgift.maven.maven1st_project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //aop로쓸려면 필요함
@Component
public class TimeTraceAop {


    @Around("execution(* rianbowgift.maven.maven1st_project..*(..))")//타겟팅 패키지 하위에는 모두적용

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
   //     System.out.println("Start = " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }   finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
     //       System.out.println("end: = " + joinPoint.toString()+" " + timeMs + "ms");
        }


    }

}
