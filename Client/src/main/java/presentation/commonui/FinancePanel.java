package presentation.commonui;

import presentation.financeui.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class FinancePanel extends CommonPanel{
    @Override
    protected void init() {
        jb_settle = new MyJLabel("结算管理");
        jb_settle.setFont(jb_font);
        jb_settle.setBounds(x, (y - 7 * height) / 2 - 10, width, height);
        jb_settle.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "结算管理");
            }
        });
        left.add(jb_settle);

        jb_cost = new MyJLabel("成本管理");
        jb_cost.setFont(jb_font);
        jb_cost.setBounds(x, (y - 7 * height) / 2 + height - 10, width, height);
        jb_cost.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "成本管理");
            }
        });
        left.add(jb_cost);

        jb_init = new MyJLabel("期初建账");
        jb_init.setFont(jb_font);
        jb_init.setBounds(x, (y - 7 * height) / 2 + 2 * height - 10, width,
                height);
        jb_init.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "期初建账");
            }
        });
        left.add(jb_init);

        jb_statis = new MyJLabel("统计报表");
        jb_statis.setFont(jb_font);
        jb_statis.setBounds(x, (y - 7 * height) / 2 + 3 * height - 10, width,
                height);
        jb_statis.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "统计报表");
            }
        });
        left.add(jb_statis);

        jb_account = new MyJLabel("账户管理");
        jb_account.setFont(jb_font);
        jb_account.setBounds(x, (y - 7 * height) / 2 + 4 * height - 10, width,
                height);
        jb_account.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "账户管理");
            }
        });
        left.add(jb_account);

        jb_log1 = new MyJLabel("查看操作日志");
        jb_log1.setFont(jb_font);
        jb_log1.setBounds(x, (y - 7 * height) / 2 + 5 * height - 10, width,
                height);
        jb_log1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "查看操作日志");
            }
        });
        left.add(jb_log1);

        jb_analy1 = new MyJLabel("查看统计分析");
        jb_analy1.setFont(jb_font);
        jb_analy1.setBounds(x, (y - 7 * height) / 2 + 6 * height - 10, width,
                height);
        jb_analy1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "查看统计分析");
            }
        });
        left.add(jb_analy1);

        cardPanel.add("结算管理", new FinanceSettlePanel());
        cardPanel.add("成本管理", new FinanceCostPanel());
        cardPanel.add("期初建账", new FinanceInitialPanel());
        cardPanel.add("统计报表", new FinanceAnalysisPanel());
        cardPanel.add("账户管理", new FinanceAccountPanel());
        cardPanel.add("查看操作日志", new FinanceOperationLogPanel());
        cardPanel.add("查看统计分析", new FinanceAnalysisPanel());
    }
}
