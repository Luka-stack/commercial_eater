package com.commercialeater.utilities;

import be.quodlibet.boxable.*;
import be.quodlibet.boxable.line.LineStyle;
import com.commercialeater.persistance.entity.RestaurantEntity;
import com.commercialeater.persistance.entity.UserEntity;
import com.commercialeater.persistance.service.RestaurantService;
import com.commercialeater.persistance.service.UserService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.PrintService;
import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

public class PDFGenerator {

    private final RestaurantService restaurantService = new RestaurantService();
    private final UserService userService = new UserService();

    public PDFGenerator() {}

    public void generateTable(String entity) throws Exception {

        //String outputFileName = entity + ".pdf";
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;

        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        // PDRectangle.LETTER and others are also possible
        PDRectangle rect = page.getMediaBox();
        // rect can be used to get the page width and height
        document.addPage(page);

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream cos = new PDPageContentStream(document, page);

        //Dummy Table
        float margin = 10;
        // starting y position is whole page height subtracted by top and bottom margin
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        // we want table across whole page width (subtracted by left and right margin ofcourse)
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        boolean drawContent = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        // y position is your coordinate of top left corner of the table
        float yPosition = 800;

        BaseTable table = new BaseTable(yPosition, yStartNewPage,
                bottomMargin, tableWidth, margin, document, page, true, drawContent);

        // the parameter is the row height
        Row<PDPage> headerRow = table.createRow(50);
        // the first parameter is the cell width
        Cell<PDPage> cell = headerRow.createCell(100, entity);
        cell.setFont(fontBold);
        cell.setFontSize(22);
        // vertical alignment
        cell.setValign(VerticalAlignment.MIDDLE);
        // border style
        cell.setTopBorderStyle(new LineStyle(Color.BLACK, 10));
        table.addHeaderRow(headerRow);

        if (entity.equalsIgnoreCase("Restaurants")) {
            createRestaurantsRows(table, cell);
        }
        else if (entity.equalsIgnoreCase("Users")) {
            createUsersRows(table, cell);
        }

        table.draw();

        // close the content stream
        cos.close();

        PrintService printService = choosePrinter();
        if (printService != null) {
            printPDF(document, printService);
        }

        document.close();
    }

    private PrintService choosePrinter() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        if(printJob.printDialog()) {
            return printJob.getPrintService();
        }
        else {
            return null;
        }
    }

    private void printPDF(PDDocument document, PrintService printer) throws PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(printer);
        job.setPageable(new PDFPageable(document));
        job.print();
    }

    private void createRestaurantsRows(BaseTable table, Cell<PDPage> cell) {

        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        Row<PDPage> row = table.createRow(20);

        cell = row.createCell(20, "Name");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        cell = row.createCell(30, "Address");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        cell = row.createCell(50, "Description");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        row = table.createRow(20);

        List<RestaurantEntity> restaurants = restaurantService.getRestaurants();

        for (var restaurant : restaurants) {

            cell = row.createCell(20, restaurant.getName());
            cell.setFontSize(15);
            cell = row.createCell(30, restaurant.getAddress());
            cell.setFontSize(15);
            cell = row.createCell(50, restaurant.getDescription());
            cell.setFontSize(15);
            row = table.createRow(20);
        }
    }

    private void createUsersRows(BaseTable table, Cell<PDPage> cell) {

        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        Row<PDPage> row = table.createRow(20);

        cell = row.createCell(20, "First Name");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        cell = row.createCell(20, "Last Name");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        cell = row.createCell(20, "Email");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        cell = row.createCell(20, "City");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        cell = row.createCell(20, "Role");
        cell.setFontSize(17);
        cell.setFont(fontBold);
        row = table.createRow(20);

        List<UserEntity> users = userService.getUsers();

        for (var user : users) {

            cell = row.createCell(20, user.getFirstName());
            cell.setFontSize(15);
            cell = row.createCell(20, user.getLastName());
            cell.setFontSize(15);
            cell = row.createCell(20, user.getEmail());
            cell.setFontSize(15);
            cell = row.createCell(20, user.getCity().getName());
            cell.setFontSize(15);
            cell = row.createCell(20, user.getRole().getType());
            cell.setFontSize(15);
            row = table.createRow(20);
        }
    }
}
