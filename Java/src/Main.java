import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<City> cities = new DBSConnectionProvider().getCity();
        System.out.println(cities.get(1).getName());

        try {
            FileOutputStream fileOut = new FileOutputStream("List-of-cities.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Cities");

            HSSFRow rowHead = worksheet.createRow((short) 0);
            List<HSSFCell> cellH= new ArrayList<>();

            cellH.add(rowHead.createCell((short) 0));
            cellH.add(rowHead.createCell((short) 1));
            cellH.add(rowHead.createCell((short) 2));
            cellH.add(rowHead.createCell((short) 3));
            cellH.get(0).setCellValue("ID");
            cellH.get(1).setCellValue("Name");
            cellH.get(2).setCellValue("CountryCode");
            cellH.get(3).setCellValue("District");

            HSSFCellStyle cellStyle = workbook.createCellStyle();
            for (HSSFCell cell:cellH) {
                cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cell.setCellStyle(cellStyle);
            }

            for (int i=1; i<cities.size(); i++) {
                HSSFRow row = worksheet.createRow((short) i);

                HSSFCell cellA1 = row.createCell((short) 0);
                cellA1.setCellValue(cities.get(i).getId());

                HSSFCell cellA2 = row.createCell((short) 1);
                cellA2.setCellValue(cities.get(i).getName());

                HSSFCell cellA3 = row.createCell((short) 2);
                cellA3.setCellValue(cities.get(i).getCountryCode());

                HSSFCell cellA4 = row.createCell((short) 3);
                cellA4.setCellValue(cities.get(i).getDistrict());
            }

            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
