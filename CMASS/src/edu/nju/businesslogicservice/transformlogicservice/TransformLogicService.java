package edu.nju.businesslogicservice.transformlogicservice;

import edu.nju.po.SendDocPO;
import edu.nju.vo.SendDocVO;

public interface TransformLogicService {
	public SendDocPO createSendDocPO(SendDocVO vo);
}
