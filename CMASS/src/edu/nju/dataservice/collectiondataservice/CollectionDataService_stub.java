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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getDistance(String city) {
		// TODO �Զ����ɵķ������
		return 33;
	}

	@Override
	public int getSequence() {
		// TODO �Զ����ɵķ������
		return 10086;
	}

	@Override
	public void changeSequence(int sequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void saveHistory(HistoryPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public List<PositionPO> QueryGoodsInfo(int SendDocID) {
		// TODO �Զ����ɵķ������
		List<PositionPO> theList = new List<PositionPO>() {

			@Override
			public boolean add(PositionPO e) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public void add(int index, PositionPO element) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public boolean addAll(Collection<? extends PositionPO> c) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public boolean addAll(int index, Collection<? extends PositionPO> c) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public void clear() {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public boolean contains(Object o) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public PositionPO get(int index) {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public int indexOf(Object o) {
				// TODO �Զ����ɵķ������
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public Iterator<PositionPO> iterator() {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO �Զ����ɵķ������
				return 0;
			}

			@Override
			public ListIterator<PositionPO> listIterator() {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public ListIterator<PositionPO> listIterator(int index) {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public PositionPO remove(int index) {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO �Զ����ɵķ������
				return false;
			}

			@Override
			public PositionPO set(int index, PositionPO element) {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public int size() {
				// TODO �Զ����ɵķ������
				return 0;
			}

			@Override
			public List<PositionPO> subList(int fromIndex, int toIndex) {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO �Զ����ɵķ������
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO �Զ����ɵķ������
				return null;
			}
		};
		return the;
	}

	@Override
	public List<SendDocPO> getAllSendDoc() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public int getCourierMoney(String courier) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
