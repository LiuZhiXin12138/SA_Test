import java.io.*;
import java.util.*;
public class demo4 {
        class Pipe {
        private Scanner pipeReader;
        private PrintWriter pipeWriter;
        Pipe(){
            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader();
            try {
                pipedWriter.connect(pipedReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pipeReader = new Scanner(pipedReader);
            pipeWriter = new PrintWriter(pipedWriter);
        }
        public String readerLine(){
            return pipeReader.nextLine();
        }
        public boolean hashNextLine(){
            return pipeReader.hasNext();
        }
        public void writerLine(String strLine){
            pipeWriter.println(strLine);
        }
        public void closeReader(){
            pipeReader.close();
        }
        public void closeWriter(){
            pipeWriter.close();
        }
    }
    abstract class Filter {
        protected Pipe input;
        protected Pipe output;

        public Filter(Pipe input, Pipe output) {
            this.input = input;
            this.output = output;
        }
        protected abstract void transform() throws IOException;
    }
    class Input extends Filter {
        private File file;
        public Input(File file,Pipe output) {
            super(null, output);
            this.file = file;
        }

        @Override
        protected void transform() throws IOException {
            BufferedReader inputFile = null;
            try {
                inputFile = new BufferedReader(new FileReader(file));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String line;
            try {
                while ((line = inputFile.readLine()) != null) {
                    output.writerLine(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            output.closeWriter();
        }
    }
    class Shift extends Filter {

        public Shift(Pipe input, Pipe output) {
            super(input, output);
        }

        @Override
        protected void transform() throws IOException {
            //???????????????????????????tokens
            while (input.hashNextLine()) {
                StringTokenizer token = new StringTokenizer(input.readerLine());
                ArrayList<String> tokens = new ArrayList<String>();
                int i = 0;
                //??????????????????
                int count = token.countTokens();
                while (i < count) {
                    tokens.add(token.nextToken());
                    i++;
                }

                //display(tokens);
                //???????????????????????????????????????????????????loop???????????????
                for (i = 0; i < count; i++) {
                    StringBuffer lineBuffer = new StringBuffer();
                    int index = i;
                    for (int f = 0; f < count; f++) {
                        //??????????????????
                        if (index >= count)
                            index = 0;
                        //??????StringBuffer
                        lineBuffer.append(tokens.get(index));
                        lineBuffer.append(" ");
                        index++;
                    }
                    String tmp = lineBuffer.toString();
                    output.writerLine(tmp);
                }
            }
            input.closeReader();
            output.closeWriter();
        }
    }
    class Alphabetizer extends Filter {
        private ArrayList<String> kwicList = new ArrayList<>();
        public Alphabetizer(Pipe input, Pipe output) {
            super(input, output);
        }

        @Override
        protected void transform() throws IOException {
            while (input.hashNextLine()){
                kwicList.add(input.readerLine());
            }
            Collections.sort(this.kwicList, new AlphabetizerComparator());
            for (String line:kwicList){
                output.writerLine(line);
            }
            input.closeReader();
            output.closeWriter();
        }
        private class AlphabetizerComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null && o2 == null) {
                    throw new NullPointerException();
                }
                int compareValue = 0;
                char o1c = o1.toLowerCase().charAt(0); //???????????????
                char o2c = o2.toLowerCase().charAt(0); //???????????????
                compareValue = o1c - o2c;
                return compareValue;

            }

        }
    }
    class Output extends Filter {
        private File file;
        public Output(File file,Pipe input) {
            super(input, null);
            this.file = file;
        }

        @Override
        protected void transform() throws IOException {
            BufferedWriter outputFile =null;
            String line;
            try {
                outputFile = new BufferedWriter(new FileWriter(file));
                while (input.hashNextLine()) {
                    outputFile.write(input.readerLine()+"\n");
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    if (outputFile!=null) {
                        outputFile.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            input.closeReader();
        }
    }
    public void foo() throws IOException {
        File inFile = new File("_txt\\input.txt");
        File outFile = new File("_txt\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}
