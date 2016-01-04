package presentation.commonui.swing;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.ArrayList;


public class exportExcel {

	/**
	 * 成本收益表
	 *
	 * @author dell1
	 */
	@SuppressWarnings("deprecation")
	public static void importCostExcel(ArrayList<String> list) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("成本收益表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("总收入");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("总支出");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("总利润");
		cell.setCellStyle(style);

		row = sheet.createRow(1);

		// 第四步，创建单元格，并设置值
		row.createCell((short) 0).setCellValue((String) list.get(0));
		row.createCell((short) 1).setCellValue((String) list.get(1));
		row.createCell((short) 2).setCellValue((String) list.get(2));

		String string = GetDate.getDay() + GetDate.getTime();
		try {
			FileOutputStream fout = new FileOutputStream("成本收益表/" + string + "成本收益表" + ".xls", false);
			wb.write(fout);
			fout.close();
			System.out.println("导出成本收益表成功");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 成本收益表
	 *
	 * @author dell1
	 */
	@SuppressWarnings("deprecation")
	public static void importBussingExcel(ArrayList<String> list) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("经营情况表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("总收入");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("总支出");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("总利润");
		cell.setCellStyle(style);

		row = sheet.createRow(1);

		// 第四步，创建单元格，并设置值
		row.createCell((short) 0).setCellValue((String) list.get(0));
		row.createCell((short) 1).setCellValue((String) list.get(1));
		row.createCell((short) 2).setCellValue((String) list.get(2));

		String string = GetDate.getDay();
		try {
			FileOutputStream fout = new FileOutputStream("经营情况表/" + string + "经营情况表" + ".xls");
			wb.write(fout);
			fout.close();
			System.out.println("导出经营情况表成功");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
