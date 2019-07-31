package ro.msg.edu.jbugs.model.interceptors;


import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    @AroundInvoke
    private Object doLog(InvocationContext ic)
    {
        Object obj = null;
        try{
            System.out.println("Entering method "+ic.getTarget().toString()+" "+ic.getMethod().getName()+".");
            obj= ic.proceed();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Entering method "+ic.getTarget().toString()+" "+ic.getMethod().getName()+".");
        }
        return obj;

    }
}
