package businesslogic.financebl;

import businesslogic.listbl.List;
import po.ListPO;

import java.rmi.RemoteException;

/**
 * tester生成一个PO过来，主要测试content内容是否符合
 *
 * @author Administrator
 */
public class MockList extends List {


    /**
     * The Po.
     */
    ListPO po;

    /**
     * Instantiates a new List.
     *
     * @throws RemoteException the remote exception
     */
    public MockList() throws RemoteException {
    }

    /**
     * Add list.
     *
     * @param po the po
     */
    public void addList(ListPO po) {
        this.po = po;
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public ListPO getList() {
        return this.po;
    }
}
