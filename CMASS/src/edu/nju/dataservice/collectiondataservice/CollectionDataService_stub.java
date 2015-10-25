package edu.nju.dataservice.collectiondataservice;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.nju.po.HistoryPO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;

public class CollectionDataService_stub implements CollectionDataService {

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getDistance(String city) {
		// TODO 自动生成的方法存根
		return 33;
	}

	@Override
	public int getSequence() {
		// TODO 自动生成的方法存根
		return 10086;
	}

	@Override
	public void changeSequence(int sequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveHistory(HistoryPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public List<PositionPO> QueryGoodsInfo(int SendDocID) {
		// TODO 自动生成的方法存根
		List<PositionPO> theList = new List<PositionPO>() {

			@Override
			public boolean add(PositionPO e) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public void add(int index, PositionPO element) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public boolean addAll(Collection<? extends PositionPO> c) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public boolean addAll(int index, Collection<? extends PositionPO> c) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public void clear() {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public boolean contains(Object o) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public PositionPO get(int index) {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public int indexOf(Object o) {
				// TODO 自动生成的方法存根
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public Iterator<PositionPO> iterator() {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO 自动生成的方法存根
				return 0;
			}

			@Override
			public ListIterator<PositionPO> listIterator() {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public ListIterator<PositionPO> listIterator(int index) {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public PositionPO remove(int index) {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO 自动生成的方法存根
				return false;
			}

			@Override
			public PositionPO set(int index, PositionPO element) {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public int size() {
				// TODO 自动生成的方法存根
				return 0;
			}

			@Override
			public List<PositionPO> subList(int fromIndex, int toIndex) {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO 自动生成的方法存根
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO 自动生成的方法存根
				return null;
			}
		};
		return the;
	}

	@Override
	public List<SendDocPO> getAllSendDoc() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int getCourierMoney(String courier) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO 自动生成的方法存根
		return null;
	}

}
