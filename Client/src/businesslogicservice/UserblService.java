package businesslogicservice;

import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface UserblService {

		//��¼����
		public boolean login(String userID,String password);
		//��ɾ�Ĳ����
		public boolean add(ArrayList<String> userinfo);
		public boolean delete(String userID);
		public boolean modify(ArrayList<String> userinfo);
		public UserVO edit(String clue);
}