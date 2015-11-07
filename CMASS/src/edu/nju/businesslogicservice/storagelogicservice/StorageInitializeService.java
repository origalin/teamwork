package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.po.RecordPO;

public interface StorageInitializeService {
	public void clear();
	public void addNewStorageItem(RecordPO recordPO);

}
