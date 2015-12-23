package util;

/**
 * Created by MYK on 2015/12/23 0023.
 */
public class DynamicData {

    private static DynamicData itselft=null;

    private UserType userType;

    private DynamicData() {

    }

    public static DynamicData getInstance(){
        if(itselft==null){
            return new DynamicData();
        }else{
            return itselft;
        }

    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
