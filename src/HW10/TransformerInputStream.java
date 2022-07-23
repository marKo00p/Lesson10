package HW10;

import java.io.*;

public class TransformerInputStream extends FilterInputStream {
    private static class Variables {

        private static char from;
        private static char to;

        public static char getFrom() {
            return from;
        }
        public static char getTo(){
            return to;
        }
    }

    protected TransformerInputStream(InputStream in, char from, char to) {
        super(in);
        Variables.from = from;
        Variables.to = to;
    }
    @Override
    public int read() throws IOException {
        int s = super.read();
        if(s == -1){
            return s;
        }
        if (s == Variables.getFrom()) {
            s = Variables.getTo();
        }
        return s;
    }

    public static void main(String[] args) {
        try (TransformerInputStream tis = new TransformerInputStream(new TransformerInputStream(System.in, 'q', 'w'), 'z', 'x')) {
            int read;
            while ((read = tis.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}


