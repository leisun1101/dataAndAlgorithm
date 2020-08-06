package com.ginkgo.datastruct.queue;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArrayQueueTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldPopAndPush() {
		ArrayQueue arrayQueue = new ArrayQueue(2);
		arrayQueue.push(1);
		arrayQueue.push(2);

		Assert.assertEquals(1, arrayQueue.pop());
		Assert.assertEquals(2, arrayQueue.pop());
	}

	@Test
	public void shouldThrowExceptionForPopIfQueueIsEmpty() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("队列已空");
		ArrayQueue arrayQueue = new ArrayQueue(1);
		arrayQueue.pop();
	}

	@Test
	public void shouldThrowExceptionForPushIfQueueIsFull() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("队列已满");

		ArrayQueue arrayQueue = new ArrayQueue(1);
		arrayQueue.push(1);
		arrayQueue.push(1);
	}

	@Test
	public void shouldPushAfterPop() {
		ArrayQueue arrayQueue = new ArrayQueue(1);
		arrayQueue.push(1);
		arrayQueue.pop();

		arrayQueue.push(2);
		Assert.assertEquals(2, arrayQueue.peak());
	}

}
