import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder{
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        String filename = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (String item : items) {
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    @Override
    public void makeText(String text){
        writer.println("<p>");
        writer.println(text);
        writer.println("</p>");
    }
}
