package queue;

import java.util.PriorityQueue;

public class UnBlockingQueueTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		UnBlockingQueueTest test = new UnBlockingQueueTest();
		//内部类
		Producer p = test.new Producer();
		Customer c = test.new Customer();

		p.start();
		c.start();
	}

	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

	//生产者（如果队列填满，则wait，一旦有空位，则用notify线程）
	class Producer extends Thread{
		@Override
		public void run() {
			produce();
		}

		private void produce() {
			while(true) {
				synchronized(queue) {
					while(queue.size()==queueSize) {
						System.out.println("队列已满，需要等待。。。");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//加入数据
					queue.offer(1);
					//
					queue.notify();
					System.out.println("向队列中插入一个数据，剩余空间为: "+(queueSize-queue.size()));
				}
			}
		}
	}

	//消费者（如果队列为空，需要等待，否则取数据）
	class Customer extends Thread{
		@Override
		public void run() {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void consume() throws InterruptedException{
			while(true) {
				//队列同步
				synchronized (queue) {
					while(queue.size()==0) {
						System.out.println("队列为空，等待数据。。。");
						queue.wait();
					}
					queue.poll();
					//提醒队列
					queue.notify();
					System.out.println("从队列取出一个元素，队列剩余："+queue.size()+"个元素");

				}
			}
		}
	}

}
