package src.businesslogic.financebl;

import src.businesslogic.listbl.List;
import src.po.ListPO;
import src.util.ResultMessage;

/**
 * tester生成一个PO过来，主要测试content内容是否符合
 *
 * @author Administrator
 */
public class MockList extends List {


    ListPO po;

    public void addList(ListPO po) {
        this.po = po;
    }

    public ListPO getList() {
        return this.po;
    }
}
