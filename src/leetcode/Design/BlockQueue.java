package leetcode.Design;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Yang
 * @Date 2021/4/10 9:33
 * @Description 有界队列
 * 队列为空的时，获取元素将被阻塞， 队列满时，添加元素将被阻塞。
 */
public class BlockQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    // 初始化队列数组的长度
    public BlockQueue(int size){
        items = new Object[size];
    }
    public void add(T t){
        lock.lock();
        try{
            // 如果数组已满
            while(count == items.length){
                notFull.await();
            }
            // 将当前下标处进行赋值
            items[addIndex] = t;
            // 如果到达了数组的最大长度就返回初始位置
            if(++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            // 唤醒notEmpty线程
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public Object remove(){
        lock.lock();
        try{
            // 如果数组为空
            while(count == 0){
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if(++removeIndex == items.length){
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return  x;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

}
