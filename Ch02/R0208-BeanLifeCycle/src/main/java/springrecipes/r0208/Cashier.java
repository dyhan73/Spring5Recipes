package springrecipes.r0208;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;

@Component
public class Cashier {

    @Value("checkout")
    private String fileName;

    @Value("/tmp/cashier")
    private String path;

    private BufferedWriter writer;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @PostConstruct
    public void openFile() throws IOException {
        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }

        File checkoutFile = new File(path, fileName + ".txt");
        if (!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
        System.out.println(checkoutFile + " is opened");
    }

    public void checkout(ShoppingCart cart) throws IOException {
        writer.write(new Date() + "\t" + cart.getItems() + "\n");
        writer.flush();
    }

    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
        System.out.println("file closed");
    }
}
