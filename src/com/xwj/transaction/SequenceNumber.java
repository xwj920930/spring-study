package com.xwj.transaction;

public class SequenceNumber {
	private static ThreadLocal<Integer> seqNum=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	public int getNextNum() {
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	private static class TestClient extends Thread{
		private SequenceNumber sn;
		public TestClient(SequenceNumber sn) {
			this.sn=sn;
		}
		@Override
		public void run() {
			for(int i=0;i<3;i++){
				System.out.println(Thread.currentThread().getName()+"  "+sn.getNextNum());
			}
		}
	}
	public static void main(String[] args) {
		SequenceNumber number=new SequenceNumber();
		TestClient client1=new TestClient(number);
		TestClient client2=new TestClient(number);
		TestClient client3=new TestClient(number);
		client1.start();
		client2.start();
		client3.start();
	}
}
