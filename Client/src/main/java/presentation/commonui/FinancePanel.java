package presentation.commonui;

import presentation.commodityui.CheckStockPanel;
import presentation.financeui.*;

import javax.swing.*;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class FinancePanel extends CommonPanel{
    @Override
    protected void init() {
        jb_settle = new JButton("结算管理");
        jb_settle.setFont(jb_font);
        jb_settle.setBounds(x, (y - 7 * height) / 2 - 10, width, height);
        jb_settle.addActionListener(this);
        left.add(jb_settle);

        jb_cost = new JButton("成本管理");
        jb_cost.setFont(jb_font);
        jb_cost.setBounds(x, (y - 7 * height) / 2 + height - 10, width, height);
        jb_cost.addActionListener(this);
        left.add(jb_cost);

        jb_init = new JButton("期初建账");
        jb_init.setFont(jb_font);
        jb_init.setBounds(x, (y - 7 * height) / 2 + 2 * height - 10, width,
                height);
        jb_init.addActionListener(this);
        left.add(jb_init);

        jb_statis = new JButton("统计报表");
        jb_statis.setFont(jb_font);
        jb_statis.setBounds(x, (y - 7 * height) / 2 + 3 * height - 10, width,
                height);
        jb_statis.addActionListener(this);
        left.add(jb_statis);

        jb_account = new JButton("账户管理");
        jb_account.setFont(jb_font);
        jb_account.setBounds(x, (y - 7 * height) / 2 + 4 * height - 10, width,
                height);
        jb_account.addActionListener(this);
        left.add(jb_account);

        jb_log1 = new JButton("查看操作日志");
        jb_log1.setFont(jb_font);
        jb_log1.setBounds(x, (y - 7 * height) / 2 + 5 * height - 10, width,
                height);
        jb_log1.addActionListener(this);
        left.add(jb_log1);

        jb_analy1 = new JButton("查看统计分析");
        jb_analy1.setFont(jb_font);
        jb_analy1.setBounds(x, (y - 7 * height) / 2 + 6 * height - 10, width,
                height);
        jb_analy1.addActionListener(this);
        left.add(jb_analy1);

        cardPanel.add("结算管理", new FinanceSettlePanel());
        cardPanel.add("成本管理", new FinanceCostPanel());
        cardPanel.add("期初建账", new CheckStockPanel());
        cardPanel.add("统计报表", new FinanceAnalysisPanel());
        cardPanel.add("账户管理", new FinanceAccountPanel());
        cardPanel.add("查看操作日志", new FinanceOperationLogPanel());
        cardPanel.add("查看统计分析", new FinanceAnalysisPanel());
    }
}
