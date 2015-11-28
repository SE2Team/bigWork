package businesslogic.commoditybl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidInput;
import businesslogic.listbl.List;
import businesslogicservice.CommodityblService;
import vo.StockInVO;

/**
 * tester生成一个PO过来，主要测试content内容是否符合
 *
 * @author Administrator
 */
public class MockList extends List {


    public static void main(String[] args) {
        CommodityblService commodity=new CommodityController();
        StockInVO vo=new StockInVO("121","121","121","121","121","121","121");
        try {
            commodity.stockIn(vo);
        } catch (DateException e) {
            System.out.print(e.getMessage());
        } catch (InvalidInput invalidInput) {
            System.out.print(invalidInput.getMessage());

        }
    }

    
}
