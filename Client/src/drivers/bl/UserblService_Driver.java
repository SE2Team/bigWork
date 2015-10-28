package src.drivers.bl;

import java.util.ArrayList;

import src.businesslogicservice.UserblService;
import src.vo.UserVO;


public class UserblService_Driver {
	private String userID;
	private String password;
	UserVO userVO;
	String clue;
		public void driver(UserblService userblService){
			boolean isLogin=userblService.login(userID, password);
			if(isLogin==true){
				System.out.println("Success!");
			}
			
			boolean isAdd=userblService.add(userVO);
			if(isAdd==true){
				System.out.println("Success!");
			}
			
			boolean isDel=userblService.delete(userVO);
			if(isDel==true){
				System.out.println("Success!");
			}
			
			boolean isModify=userblService.modify(userVO,userVO);
			if(isModify==true){
				System.out.println("Success!");
			}
			
			
		}
}
