package HW10;

import java.io.*;
public class TransformerInputStream extends FilterInputStream {
    private char from, to;
    protected TransformerInputStream(InputStream in, char from, char to) {

        super(in);
        this.from = from;
        this.to = to;
    }
    @Override
    public int read() throws IOException {
        int s = super.read();
        if (s == from) {
            s = to;
        }
        return s;
    }

    public static void main(String[] args) {
        try (TransformerInputStream tis = new TransformerInputStream(new TransformerInputStream(new TransformerInputStream(System.in, 'q', 'w'), 'z', 'x'),'v','p')) {
            int read;
            while ((read = tis.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}


