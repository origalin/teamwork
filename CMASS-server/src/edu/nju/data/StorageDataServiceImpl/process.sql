UPDATE 仓库存储货物 
SET StorageItem_ID='0025010010',入库日期='2015-11-25',目的地='北京'
WHERE StorageItem_ID IS NULL &&区='货运区'
LIMIT 1;
