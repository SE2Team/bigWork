package po;

import java.io.Serializable;


/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ConstantPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 两个城市，价格，距离
	 */
	private String city1;
	private String city2;
	private String price;
	private String distance;
	
	
	public ConstantPO(String city1, String city2, 
			String price, String distance){
		this.city1=city1;
		this.city2=city2;
		this.price=price;
		this.distance=distance;
	}
	
	public void setCity1(String city1){
		this.city1=city1;
	}
	
	public String getCity1(){
		return city1;
	}
	
	public void setCity2(String city2){
		this.city2=city2;
	}
	
	public String getCity2(){
		return city2;
	}
	
	
	public void setPrice(String price){
		this.price=price;
	}
	
	public String getPrice(){
		return price;
	}
	
	
	public void setDistance(String distance){
		this.distance=distance;
	}
	
	public String getDistance(){
		return distance;
	}
	

}
