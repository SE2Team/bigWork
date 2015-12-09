package presentation.commonui;
/**
 * 清空文本框内容
 */
import javax.swing.JTextField;

public class Empty {

	public Empty(JTextField[] jtf) {
		for(int i=0;i<jtf.length;i++){
				jtf[i].setText("");
		}

	}

}
