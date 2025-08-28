package Code;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
/**
 * This method reads an Excel file, loads all numeric values into a 2D array,
 * rounds each value to the nearest integer, and writes the rounded values
 * back to a new Excel file. It assumes the input file contains a single sheet
 * and preserves the original structure of rows and columns.
 */
public class RoundExcelMatrixFromFile {
    public static void main(String[] args) {
        String inputFile = "File.xlsx";
        String outputFile = "rounded.xlsx";

        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = 0;
            for (Row row : sheet) {
                cols = Math.max(cols, row.getPhysicalNumberOfCells());
            }

            double[][] matrix = new double[rows][cols];
            int i = 0;
            for (Row row : sheet) {
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        matrix[i][j] = cell.getNumericCellValue();
                    } else {
                        matrix[i][j] = 0;
                    }
                }
                i++;
            }

            int[][] roundedMatrix = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    roundedMatrix[r][c] = (int) Math.round(matrix[r][c]);
                }
            }

            i = 0;
            for (Row row : sheet) {
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) cell = row.createCell(j);
                    cell.setCellValue(roundedMatrix[i][j]);
                }
                i++;
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook.write(fos);
            }

            System.out.println("Data in File.xlsx has been rounded.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
