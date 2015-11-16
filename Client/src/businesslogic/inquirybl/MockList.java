package src.businesslogic.inquirybl;

import src.businesslogic.listbl.List;
import src.po.ListPO;

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
