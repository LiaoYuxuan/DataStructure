package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueTrst {

	public static void main(String[] args) {
		//InterSort();
		objectSort();
	}

	//插入interger数据，自动排序并打印
	public static void InterSort() {
		Queue<Integer> inteq = new PriorityQueue<Integer>(7);
		Random rand = new Random();
		for(int i = 0; i < 7 ; i++) {
			inteq.add(new Integer( rand.nextInt(100) ) );
		}
		for(int i = 0; i < 7 ; i++) {
			Integer integer  = inteq.poll();
			System.out.println(integer);
		}
	}

	//对象排序

	//插入对象
	public static void objectSort() {
		//传入对象和比较器
		Queue<Customer> inteq = new	 PriorityQueue<Customer>(7,idComparator);
		Random rand = new Random();
		for(int i = 0; i < 7 ; i++) {
			int id = rand.nextInt(100);
			inteq.add(new Customer(id,"name"+i ) );
		}
		while (true) {
			Customer customer =inteq.poll();
			if(customer == null) {
				break;
			}
			System.out.println(customer.getId() + "  " + customer.getName());
		}
	}

	//建立比较器，将对象的属性进行比较
	public static Comparator<Customer> idComparator = new Comparator<Customer>() {
		@Override
		public int compare(Customer o1,Customer o2) {
			//o2-o1是降序
			return (int)(o1.getId()-o2.getId());
		}
	};

}

class Customer{
	private int id;
	private String name;

	public Customer(int id , String name) {
		this.id=id;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
