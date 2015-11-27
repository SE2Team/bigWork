package po;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public class OperationLogPO implements Serializable {
	private static final long serialVersionUID = 1L;// 序列化ID

	private String time;// 操作时间
	private String human;// 操作人员
	private String type;// 操作类型

	/**
	 * 构造函数
	 * 
	 * @param time
	 *            操作时间
	 * @param human
	 *            操作人员
	 * @param type
	 *            操作类型
	 */
	public OperationLogPO(String time, String human, String type) {
		this.time = time;
		this.human = human;
		this.type = type;
	}

	/**
	 * 获得操作时间
	 * 
	 * @return 操作时间
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * 返回操作人员
	 * @return 操作人员
	 */
	public String getHuman(){
		return human;
	}
	/**
	 * 返回操作内容
	 * @return
	 */
	public String getType(){
		return type;
	}

}
