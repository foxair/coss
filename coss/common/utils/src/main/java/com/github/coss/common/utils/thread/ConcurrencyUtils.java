package com.github.coss.common.utils.thread;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.github.coss.common.utils.lang.StringUtils;
import com.github.coss.common.utils.thread.threadPool.TerminativeTaskConstant.RejectPolicy;

public abstract class ConcurrencyUtils {

    private final static Map<String, RejectedExecutionHandler> rejectHandlerMap = new HashMap<String, RejectedExecutionHandler>();

    public static final String                                 EQUAL_CHAR       = "=";

    /**
     * 关闭线程池
     * 
     * @param executor
     * @return
     */
    public static List<Runnable> closeExecutor(ExecutorService executor, long sleepTime,
                                               long tryCloseTime) {
        if (executor != null && !(executor.isTerminated() || executor.isShutdown())) {
            executor.shutdown();
            int times = 0;
            while (!(executor.isTerminated()) && times < tryCloseTime) {
                sleep(sleepTime);
                times++;
            }
            return executor.shutdownNow();
        }
        return null;
    }

    /**
     * @param sleepTime
     */
    public static void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }
    }

    public static <T> List<T> waitAllTaskFinished(List<Future<T>> futures) {
        return waitAllTaskFinished(futures, 0);
    }

    public static <T> List<T> waitAllTaskFinished(List<Future<T>> futures, long sleepTime) {
        List<T> resultList = new ArrayList<T>();
        boolean[] isDown = new boolean[futures.size()];
        for (int i = 0; i < isDown.length; i++) {
            isDown[i] = false;
        }
        int index = 0;
        boolean isFinished = false;
        T t = null;
        while (!isFinished) {
            for (Future<T> future : futures) {
                index = (++index) % futures.size();
                if (future.isDone() && !isDown[index]) {
                    isDown[index] = true;
                    try {
                        t = future.get();
                        if (t != null) {
                            resultList.add(t);
                        }
                    } catch (Exception e) {
                        isDown[index] = true;
                    }
                }
            }
            boolean finished = false;
            for (int i = 0; i < isDown.length; i++) {
                finished = isDown[i];
                if (!finished) {
                    break;
                }
            }
            isFinished = finished;
            sleep(sleepTime);
        }
        return resultList;
    }

    public static <M> List<List<M>> divideGroup(List<M> workItems, int perSize) {

        if (workItems == null) {
            return null;
        }
        List<List<M>> workItemsList = new ArrayList<List<M>>();
        int idx = 0, size = workItems.size(), num = workItems.size() / perSize
                + (workItems.size() % perSize > 0 ? 1 : 0);

        while (idx < num) {
            int toSize = perSize * (idx + 1);
            if (toSize > size) {
                toSize = size;
            }
            workItemsList.add(workItems.subList(idx * perSize, toSize));
            idx++;
        }
        return workItemsList;
    }

    public static boolean overTime(long overTime) {
        return new Date().getTime() > overTime;
    }

    public static boolean overTime(Date overTime) {
        return new Date().compareTo(overTime) > 0;
    }

    /**
     * @return
     */
    public static ExecutorService generateExecutorService(int runThreadSize, int threadPoolSize,
                                                          long aliveSecond,
                                                          RejectedExecutionHandler handler) {
        ExecutorService executorService = new ThreadPoolExecutor(runThreadSize, threadPoolSize,
                aliveSecond, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), handler);
        return executorService;
    }

    public static RejectedExecutionHandler getRejectedExecutionHandler(String rejectHandlerName) {
        return rejectHandlerMap.get(rejectHandlerName);
    }

    public static <V> List<V> mergeList(List<List<V>> splitList) {
        if (splitList == null) {
            return null;
        }
        List<V> mergeList = new ArrayList<V>();
        for (List<V> item : splitList) {
            mergeList.addAll(item);
        }
        return mergeList;
    }

    public static boolean isSameDay(Date now, Date to, int[] compareField) {
        if (now == null || to == null) {
            return false;
        }
        GregorianCalendar nowCalendar = new GregorianCalendar();
        nowCalendar.setTime(now);
        GregorianCalendar craeteCalendar = new GregorianCalendar();
        craeteCalendar.setTime(to);
        return isSameDay(nowCalendar, craeteCalendar, compareField);
    }

    /**
     * @param nowCalendar
     * @param craeteCalendar
     * @param i
     * @param j
     * @return
     */
    private static boolean isSameDay(Calendar nowCalendar, Calendar craeteCalendar, int[] fields) {
        if (fields == null) {
            return false;
        }
        for (int field : fields) {
            if (nowCalendar.get(field) != craeteCalendar.get(field)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param <T>
     * @return
     */
    public static <T> boolean hasFuturesOccurException(List<Future<T>> futures) {
        if (futures != null && !futures.isEmpty()) {
            for (Future<T> future : futures) {
                if (!future.isCancelled()) {
                    try {
                        future.get();
                    } catch (Exception e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param parameters
     * @return
     */
    public static Map<String, String> getParameterMap(String parameters) {
        return getParameterMap(parameters, ";");
    }

    /**
     * @param parameterStr
     * @param string
     * @return
     */
    public static Map<String, String> getParameterMap(String parameterStr, String split) {
        Map<String, String> paramters = null;
        if (StringUtils.isBlank(parameterStr)) {
            return paramters;
        }
        paramters = new HashMap<String, String>();
        StringTokenizer tokenizer = new StringTokenizer(parameterStr, split);
        while (tokenizer.hasMoreTokens()) {
            String[] keyValue = tokenizer.nextToken().split(EQUAL_CHAR);
            if (keyValue != null && keyValue.length == 2) {
                paramters.put(keyValue[0], keyValue[1]);
            }
        }
        return paramters;
    }

    public static String getParametersAsString(Map<String, String> mapParameters, String join) {
        List<String> parameters = new ArrayList<String>();
        if (mapParameters != null) {
            for (Entry<String, String> entry : mapParameters.entrySet()) {
                parameters.add(entry.getKey() + EQUAL_CHAR + entry.getValue());
            }
        }
        return StringUtils.join(parameters, join);
    }

    public static <T, R> List<R> concurrentExecute(List<T> list, int runTreads,
                                                   Processer<T, R> processor) {
        return new Executor<T, R>().execute(runTreads, list, processor);
    }

    public static class Executor<T, R> {
        public List<R> execute(int runTreadCount, List<T> list, Processer<T, R> processor) {
            ArrayBlockingQueue<T> queue = new ArrayBlockingQueue<T>(list.size());
            queue.addAll(list);
            ExecutorService executor = getExcetorService(runTreadCount);
            CountDownLatch countLantch = new CountDownLatch(queue.size());
            List<Future<List<R>>> futures = new ArrayList<Future<List<R>>>();
            List<Worker> workers = new ArrayList<Worker>();
            for (int i = 0; i < runTreadCount; i++) {
                Worker worker = new Worker(queue, countLantch, processor);
                workers.add(worker);
                futures.add(executor.submit(worker));
            }
            try {
                countLantch.await();
            } catch (Exception e) {
                for (Worker worker : workers) {
                    worker.cancel();
                }
            }
            List<List<R>> allResult = ConcurrencyUtils.waitAllTaskFinished(futures);
            List<R> result = ConcurrencyUtils.mergeList(allResult);
            ConcurrencyUtils.closeExecutor(executor, 100L, 3);
            return result;
        }

        class Worker implements Callable<List<R>> {
            Processer<T, R>          processor;
            BlockingQueue<T>         queue;
            CountDownLatch           countLantch;
            private volatile boolean isCancel = false;

            public Worker(BlockingQueue<T> queue, CountDownLatch countLantch,
                          Processer<T, R> processor) {
                this.queue = queue;
                this.countLantch = countLantch;
                this.processor = processor;
            }

            public boolean isCancel() {
                return isCancel;
            }

            public void cancel() {
                this.isCancel = true;
            }

            @Override
            public List<R> call() throws Exception {
                T t = null;
                List<R> list = new ArrayList<R>();
                while (!isCancel() && (t = queue.poll()) != null) {
                    R v = null;
                    try {
                        v = processor.process(t);
                    } catch (Exception e) {
                    } finally {
                        countLantch.countDown();
                    }
                    if (v != null) {
                        list.add(v);
                    }
                }
                return list;
            }

        }

        private ExecutorService getExcetorService(int runTreadCount) {
            RejectedExecutionHandler handler = ConcurrencyUtils
                    .getRejectedExecutionHandler(RejectPolicy.DISCARD);
            ExecutorService executorService = ConcurrencyUtils.generateExecutorService(
                    runTreadCount, runTreadCount, 0, handler);
            return executorService;
        }

    }

    public static interface Processer<T, R> {
        R process(T t);

    }

}
