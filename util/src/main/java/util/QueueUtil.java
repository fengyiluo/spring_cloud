/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package util;

import util.constant.BasisConstants;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列
 *
 * @author guominqiang
 * @version $Id QueueUtil.java, v 0.1 2018-03-19 12:38 guominqiang Exp $$
 */
public class QueueUtil {

    private BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(BasisConstants.QUEUE_SIZE);


    /**
     * <p>
     * 往队列中放入数据
     * 将指定的元素插入此队列的尾部，如果该队列已满，则一直等到（阻塞）
     * </p>
     *
     * @param clz
     * @throws InterruptedException
     */
    public void produce(Class clz) throws InterruptedException {
        queue.put(clz);
    }

    /**
     * <p>
     * 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量）
     * 在成功时返回 true，如果此队列已满，则抛IllegalStateException
     * </p>
     *
     * @param clz
     * @return
     */
    public boolean add(Class clz) {
        return queue.add(clz);
    }

    /**
     * <p>
     * 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量）
     * 将指定的元素插入此队列的尾部，如果该队列已满，
     * 则在到达指定的等待时间之前等待可用的空间,该方法可中断
     * </p>
     *
     * @param clz
     * @return
     */
    public boolean offer(Class clz) {
        return queue.offer(clz);
    }


    /**
     * <p>
     * 从队列中取数据
     * 获取并移除此队列的头部，如果没有元素则等待（阻塞），
     * 直到有元素将唤醒等待线程执行该操作
     * </p>
     *
     * @return
     * @throws InterruptedException
     */
    public Object consume() throws InterruptedException {
        return queue.take();
    }

    /**
     * <p>
     * 从此队列中移除指定元素的单个实例（如果存在）
     * </p>
     *
     * @param clz
     * @return
     */
    public boolean remove(Class clz) {
        return queue.remove(clz);
    }

    /**
     * <p>
     * 获取并移除此队列的头部，在指定的等待时间前一直等到获取元素，
     * 超过时间方法将结束
     * </p>
     *
     * @return
     * @throws InterruptedException
     */
    public Object poll() throws InterruptedException {
        return queue.poll(BasisConstants.QUEUE_TIMEOUT, BasisConstants.UNIT);
    }

    /**
     * 获取队列
     *
     * @return
     */
    public Object getBlockingQueue() {
        return queue;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}