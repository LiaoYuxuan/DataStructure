package queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列实现消费生产模型
 *    打印结果有一定问题，因为不完全是一个线程
 * @author Lenovo
 *
 */

public class BlockingTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BlockingTest test = new BlockingTest();
		//内部类
		Producer p = test.new Producer();
		Customer c = test.new Customer();

		p.start();
		c.start();
	}

	private int queueSize=10;
	private ArrayBlockingQueue<Integer> queue
			= new ArrayBlockingQueue<Integer>(queueSize);

	//生产者
	class Producer extends Thread{
		@Override
		public void run() {
			//生产数据
			producer();
		}
		private void producer() {
			while( true ) {
				try {
					//数据源
					queue.put(1);
					System.out.println("向队列中添加元素，队列的剩余空间："+(queueSize-queue.size()));
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
		}
	}
	//消费者
	class Customer extends Thread{
		@Override
		public void run() {
			customer();
		}
		private void customer()  {
			while(true) {
				try {
					queue.take();
					System.out.println("从队列中取走一个元素，队列的剩余"+queue.size()+"个元素");
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
}
