package presentation.commonui;

import javax.swing.JTextField;

public class isAllEntered {

	public static boolean isEntered(JTextField[] jtf) {
		for(int i=0;i<jtf.length;i++){
			if("".equalsIgnoreCase(jtf[i].getText().trim())){
				return false;				
			}
		}
		return true;
	}

}
