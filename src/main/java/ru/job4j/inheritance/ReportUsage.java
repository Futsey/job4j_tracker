package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        JSONReport jsonReport = new JSONReport();
        String text = jsonReport.generate("name", "body");
        System.out.println(text);

        HtmlReport htmlReport = new HtmlReport();
        String htmlText = htmlReport.generate("Report's name", "Report's body");
        System.out.println(System.lineSeparator() + htmlText);
    }
}
