package presentation.commonui;

import presentation.financeui.FinanceAnalysisPanel;
import presentation.financeui.FinanceOperationLogPanel;
import presentation.manageui.CityStrategyPanel;
import presentation.manageui.EmpAndInsPanel;
import presentation.manageui.ListApprovalPanel;
import presentation.manageui.SalaryStrategyPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by MYK on 2015/12/9 0009.
 */
public class ManagerPanel extends CommonPanel{
    @Override
    protected void init() {
        jb_empAndIns = new MyJLabel("人员机构管理");
        jb_empAndIns.setFont(jb_font);
        jb_empAndIns.setBounds(x, (y - 6 * height) / 2 - 10, width, height);
        jb_empAndIns.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "人员机构管理");
            }
        });
        left.add(jb_empAndIns);

        jb_approval = new MyJLabel("审批单据");
        jb_approval.setFont(jb_font);
        jb_approval.setBounds(x, (y - 6 * height) / 2 + height - 10, width,
                height);
        jb_approval.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "审批单据");
            }
        });
        left.add(jb_approval);

        jb_salary = new MyJLabel("制定薪水策略");
        jb_salary.setFont(jb_font);
        jb_salary.setBounds(x, (y - 6 * height) / 2 + 2 * height - 10, width,
                height);
        jb_salary.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "制定薪水策略");
            }
        });
        left.add(jb_salary);

        jb_city = new MyJLabel("城市距离、价格等");
        jb_city.setFont(jb_font);
        jb_city.setBounds(x, (y - 6 * height) / 2 + 3 * height - 10, width,
                height);
        jb_city.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "制定城市距离、价格等常量");
            }
        });
        left.add(jb_city);

        jb_log2 = new MyJLabel("查看操作日志");
        jb_log2.setFont(jb_font);
        jb_log2.setBounds(x, (y - 6 * height) / 2 + 4 * height - 10, width,
                height);
        jb_log2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "查看操作日志1");
            }
        });
        left.add(jb_log2);

        jb_analy2 = new MyJLabel("查看统计分析");
        jb_analy2.setFont(jb_font);
        jb_analy2.setBounds(x, (y - 6 * height) / 2 + 5 * height - 10, width,
                height);
        jb_analy2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                smallCard.show(cardPanel, "查看统计分析1");
            }
        });
        left.add(jb_analy2);

        cardPanel.add("人员机构管理", new EmpAndInsPanel());
        cardPanel.add("审批单据", new ListApprovalPanel());
        cardPanel.add("制定薪水策略", new SalaryStrategyPanel());
        cardPanel.add("制定城市距离、价格等常量", new CityStrategyPanel());
        cardPanel.add("查看操作日志1", new FinanceOperationLogPanel());
        cardPanel.add("查看统计分析1", new FinanceAnalysisPanel());
    }
}
