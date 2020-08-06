package com.ginkgo.datastruct.queue;

/**
 * 环形数组模拟队列
 * 两个指针front 代表最开始的指针，rear代表尾部指针。front指向头元素，rear代表尾部元素+1(下一个元素)
 * 添加元素，用rear，然后(rear++)%size
 * 取出元素，用front，取完以后 (front++)%size
 * 有效个数 (rear+size-front)%size
 * 是否为空 rear == front
 * 是否已满 (rear+size-front)%size == size
 */
public class ArrayQueue {

	private int size;
	private int front;
	private int rear;
	private int[] arrQueue;

	public ArrayQueue(int size) {
		this.size = size + 1;
		this.arrQueue = new int[size + 1];
		front = 0;
		rear = 0;
	}

	public void push(int n) {
		if (isFull()) {
			throw new RuntimeException("队列已满");
		}

		arrQueue[rear] = n;
		rear = (rear + 1) % size;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("队列已空");
		}

		int res =  arrQueue[front];
		front = (front + 1) % size;
		return res;
	}

	public int peak() {
		if (isEmpty()) {
			throw new RuntimeException("队列已空");
		}

		return arrQueue[front];
	}


	public boolean isFull() {
		return (rear + 1) % size == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

}
