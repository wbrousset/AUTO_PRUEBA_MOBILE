package com.igs.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;

public class WordDocument {
    private static XWPFDocument document;
    private static String fileName;

    /**
     * Crea los estilos de los párrafos
     *
     * @param run
     * @param colorRGB
     * @param text
     * @param bold
     * @param addBreak
     */
    private static void setRun(XWPFRun run, String colorRGB, String text, boolean bold, boolean addBreak) {
        run.setFontFamily("Consolas");
        run.setFontSize(12);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) run.addBreak();
    }

    /**
     * Crea los estilos de los párrafos, bold es por defecto TRUE.
     *
     * @param run
     * @param colorRGB
     * @param text
     */
    private static void setRun(XWPFRun run, String colorRGB, String text) {
        run.setFontFamily("Consolas");
        run.setFontSize(12);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(true);
    }

    /**
     * Aplica estilos a las celdas de la tabla
     *
     * @param cell
     */
    private static void applyCellStyle(XWPFTableCell cell) {
        cell.getParagraphArray(0).setSpacingBefore(120);
        cell.getParagraphArray(0).setSpacingAfter(120);
        cell.getParagraphArray(0).setSpacingBetween(1.2);
        cell.getParagraphArray(0).setAlignment(ParagraphAlignment.BOTH);
    }

    /**
     * Constructor de la clase
     */
    public WordDocument() {
        String template = System.getProperty("user.dir") + "\\src\\test\\resources\\templates\\plantilla-evidencia.docx";
        File output = new File(System.getProperty("user.dir") + "\\reportes\\word");
        output.mkdir();

        try {
            document = new XWPFDocument(OPCPackage.open(template));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        fileName = output + "\\" + new TestUtils().dateTime() + ".docx";
    }

    public void addNewScenario(String escenario, String estado, byte[] screenshot) {
        try {
            XWPFTable table = document.createTable(4, 2);

            table.setWidth("100%");
            table.setBottomBorder(XWPFTable.XWPFBorderType.DOT_DASH, 6, 0, "A6A6A6");
            table.setTopBorder(XWPFTable.XWPFBorderType.DOT_DASH, 6, 0, "A6A6A6");
            table.setLeftBorder(XWPFTable.XWPFBorderType.DOT_DASH, 6, 0, "A6A6A6");
            table.setRightBorder(XWPFTable.XWPFBorderType.DOT_DASH, 6, 0, "A6A6A6");
            table.setInsideHBorder(XWPFTable.XWPFBorderType.DOT_DASH, 6, 0, "A6A6A6");
            table.setInsideVBorder(XWPFTable.XWPFBorderType.DOT_DASH, 6, 0, "A6A6A6");
            table.setCellMargins(0, 120, 0, 120);

            XWPFTableCell cell1, cell2;

            cell1 = table.getRow(0).getCell(0);
            cell1.removeParagraph(0);
            cell1.setWidth("20%");
            setRun(cell1.addParagraph().createRun(), "000080", "Escenario:");
            cell2 = table.getRow(0).getCell(1);
            setRun(cell2.addParagraph().createRun(), "777777", escenario, false, false);
            applyCellStyle(cell1);
            applyCellStyle(cell2);

            cell1 = table.getRow(1).getCell(0);
            //cell1.setWidth("20%");
            setRun(cell1.addParagraph().createRun(), "000080", "Ejecución: ");
            cell2 = table.getRow(1).getCell(1);
            setRun(cell2.addParagraph().createRun(), "777777", new TestUtils().dateTimeAmPm(), false, false);
            applyCellStyle(cell1);
            applyCellStyle(cell2);

            cell1 = table.getRow(2).getCell(0);
            //cell1.setWidth("20%");
            setRun(cell1.addParagraph().createRun(), "000080", "Estado: ");
            cell2 = table.getRow(2).getCell(1);
            setRun(cell2.addParagraph().createRun(), "777777", estado, false, false);
            switch (estado) {
                case "PASSED":
                    cell2.getParagraphArray(0).getRuns().get(0).setColor("00B050");
                    break;
                case "FAILED":
                    cell2.getParagraphArray(0).getRuns().get(0).setColor("FF0000");
                    break;
                case "SKIPPED":
                    cell2.getParagraphArray(0).getRuns().get(0).setColor("00B0F0");
                    break;
                case "PENDING":
                    cell2.getParagraphArray(0).getRuns().get(0).setColor("FFC000");
                    break;
                case "UNDEFINED":
                    cell2.getParagraphArray(0).getRuns().get(0).setColor("CC00CC");
                    break;
            }
            applyCellStyle(cell1);
            applyCellStyle(cell2);

            cell1 = table.getRow(3).getCell(0);
            //cell1.setWidth("20%");
            setRun(cell1.addParagraph().createRun(), "000080", "Evidencia: ", true, true);
            cell2 = table.getRow(3).getCell(1);
            setRun(cell2.addParagraph().createRun(), "777777", "${executionAttach}", false, false);
            applyCellStyle(cell1);
            applyCellStyle(cell2);

            // Agregamos un párrafo en la última celda
            cell1.addParagraph();

            // Creamos un run para el párrafo creado
            XWPFRun run = cell1.getParagraphArray(1).createRun();
            cell1.getParagraphArray(1).setAlignment(ParagraphAlignment.CENTER);

            // Convertimos el archivo de imágen tipo Byte a ByteArrayInputStream
            // para poder anexarlo al documento word.
            ByteArrayInputStream bis = new ByteArrayInputStream(screenshot);

            // Se crea una instancia en buffer para obtener las dimensiones de ancho y alto.
            BufferedImage bImage = ImageIO.read(new ByteArrayInputStream(screenshot));

            run.addPicture(bis, XWPFDocument.PICTURE_TYPE_PNG,
                    "", Units.toEMU(bImage.getWidth() * 0.15),
                    Units.toEMU(bImage.getHeight() * 0.15));

            // Se combina la última fila de la evidencia y se elimina la segunda celda.
            cell1.getCTTc().addNewTcPr();
            cell1.getCTTc().getTcPr().addNewGridSpan();
            cell1.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2));
            //KEVIN:se cambio el 3 a 4
            table.getRow(3).removeCell(1);

            document.createParagraph();

            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                document.write(outputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}