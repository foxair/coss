package com.github.coss.common.utils.thread.threadPool;

public interface TerminativeTaskConstant {

    String TERMINATIVE_HANDLER_NAME = "terminativeHandlerName";
    String TERMINATIVE_TASK_NAME    = "terminative";
    String TASK_DISABLE             = "taskDisable";
    String CONCURRENT_MODE_JSON     = "concurrentModeJson";
    String MAX_RUN_TIME_ONE_DAY     = "maxRunTimeOneDay";
    String CURRENT_RUN_TIME         = "currentRunTime";

    public interface ConcurrencyModeConfig {

        String IS_SERIAL                    = "isSerial";                 //如果ISTERMINATED = TRUE,ISSERIAL:TRUE表示按串行执行,FALSE表示并发执行(不用等待上一次执行结束)
        String IS_TERMINATED                = "isTerminated";             //一次任务调度,执行所有要执行的任务(TRUE:终结所有,FALSE:只执行一次调度的任务)
        String THREAD_POOL_SIZE             = "threadPoolSize";
        String RUN_THREAD_SIZE              = "runThreadSize";
        String SLEEP_TIME                   = "sleepTime";
        String IS_NEED_DEAL_WITH_RETURN     = "isNeedDealWithReturn";     //是否处理CALLALE返回的值.可以把重试的TASK返回让另一个别的线程池执行,也可以在CALLALE中重试,即不用返回
        String IS_NEED_CHECK_RUN_TIME       = "isNeedCheckRunTime";
        String MAX_RUN_MINUTES              = "maxRunMinutes";            //运行时间(分)
        String SINGLE_TASK_RUN_SECOND       = "singleTaskRunSecond";      //单个任务执行的时长
        String EXECUTOR_SHUTDOWN_SLEEP_TIME = "executorShutDownSleepTime"; //关闭任务睡眠时间      
        String EXECUTOR_REJECT_HANDLER      = "executorRejectHandler";    //线程池reject等待超时或线程池已满时拒绝模式
        String SIZE_PER_PAGE                = "sizePerPage";
        String RUN_DATE                     = "runDate";
    }

    public interface WorkMode {
        String NEED_CHECK_OVERTIME = "workerNeedCheckOverTime";
        String IS_SERIAL           = "workerIsSerial";
        String SINGLE_RUN_SECOND   = "workerSingleRunSecond";
        String THEAD_POOL_SIZE     = "workerTheadPoolSize";
        String RUN_THREAD_SIZE     = "workerRunThreadSize";
        String ITEM_SIZE           = "workerItemSize";

    }

    public interface RejectPolicy {
        String ABORT         = "abort";
        String DISCARD       = "discard";
        String CALLERRUNS    = "callerRuns";
        String DISCARDOLDEST = "discardOldest";
    }

}
