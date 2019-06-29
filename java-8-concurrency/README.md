#java-8-concurrency

##Life cycle of a Thread (Thread States)
A thread state. A thread can be in one of the following states:

    Oracle Docs
    NEW
    A thread that has not yet started is in this state.
    RUNNABLE
    A thread executing in the Java virtual machine is in this state.
    BLOCKED
    A thread that is blocked waiting for a monitor lock is in this state.
    WAITING
    A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
    TIMED_WAITING
    A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
    TERMINATED
    A thread that has exited is in this state.  
    ---
    Notes
    Running - The thread is in running state if the thread scheduler has selected it. 

##How to create thread

    1. By extending Thread class
    2. By implementing Runnable interface.

##Thread Scheduler in Java

    Thread scheduler in java is the part of the JVM that decides which thread should run.
    There is no guarantee that which runnable thread will be chosen to run by the thread scheduler.
    Only one thread at a time can run in a single process.
    The thread scheduler mainly uses preemptive or time slicing scheduling to schedule the threads.
    ---
    Notes
    Difference between preemptive scheduling and time slicing
    Under preemptive scheduling, the highest priority task executes until it enters the waiting or dead states or 
    a higher priority task comes into existence. Under time slicing, a task executes for a predefined slice of time 
    and then reenters the pool of ready tasks. The scheduler then determines which task should execute next, based on 
    priority and other factors. 

##Sleep method in java

    If you sleep a thread for the specified time,the thread shedular picks up another thread and so on.

##What if we call run() method directly instead start() method?
    
    1. Each thread starts in a separate call stack.
    2. Invoking the run() method from main thread, the run() method goes onto the current call stack rather than 
    at the beginning of a new call stack.
    3. There is no context-switching because here t1 and t2 will be treated as normal object not thread object

##The join() method

    The join() method waits for a thread to die. In other words, it causes the currently running threads to 
    stop executing until the thread it joins with completes its task.

##Thread Priority

    Each thread have a priority. Priorities are represented by a number between 1 and 10. In most cases, thread 
    schedular schedules the threads according to their priority (known as preemptive scheduling). But it is not 
    guaranteed because it depends on JVM specification that which scheduling it chooses.
    Default priority of a thread is 5 (NORM_PRIORITY). The value of MIN_PRIORITY is 1 and the value of 
    MAX_PRIORITY is 10.
    ---
    Notes
    If number of CPU's Core > Thread nnumber prority may not work as expected.
    
##Daemon Thread in Java

    When a Java Virtual Machine starts up, there is usually a single non-daemon thread (which typically calls the
    method named main of some designated class). The Java Virtual Machine continues to execute threads until either
    of the following occurs:

     1. The exit method of class Runtime has been called and the security manager has permitted the exit operation
     to take place.
     2. All threads that are not daemon threads have died, either by returning from the call to the run method or
     by throwing an exception that propagates beyond the run method.

##Java Thread Pool

    Java Thread pool represents a group of worker threads that are waiting for the job and reuse many times.
    
    In case of thread pool, a group of fixed size threads are created. A thread from the thread pool is pulled out 
    and assigned a job by the service provider. After completion of the job, thread is contained in the thread pool 
    again.
    Better performance It saves time because there is no need to create new thread.
    It is used in Servlet and JSP where container creates a thread pool to process the request.

##ThreadGroup in Java

    Java provides a convenient way to group multiple threads in a single object. In such way, we can suspend, 
    resume or interrupt group of threads by a single method call.
    
    Java thread group is implemented by java.lang.ThreadGroup class.
    
    A ThreadGroup represents a set of threads. A thread group can also include the other thread group. The thread group 
    creates a tree in which every thread group except the initial thread group has a parent.
    
    A thread is allowed to access information about its own thread group, but it cannot access the information about 
    its thread group's parent thread group or any other thread groups.

###References
1. https://www.javatpoint.com/multithreading-in-java
2. https://docs.oracle.com/javase/6/docs/api/java/lang/Thread.html
3. https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html