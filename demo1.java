import java.io.*;
import java.util.*;

//1.
//public class demo1 {
//    private ArrayList<String> kwicList = new ArrayList<String>();
//    private ArrayList<String> lineTxt = new ArrayList<String>();
//    private BufferedReader inputFile;
//    private BufferedWriter outputFile;
//
//    public static void main(String[] args) {
//
//        demo1 kwic = new demo1();
//        kwic.input("input.txt");
//        kwic.shift();
//        kwic.alphabetizer();
//        kwic.output("output.txt");
//    }
//
//
//    public void input(String fileName) {
//        try {
//            inputFile = new BufferedReader(new FileReader(fileName));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String line;
//        try {
//            while ((line = inputFile.readLine()) != null) {
//                lineTxt.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void output(String filename){
//        Iterator<String> it = kwicList.iterator();
//        try {
//            outputFile = new BufferedWriter(new FileWriter(filename));
//            while (it.hasNext()) {
//                outputFile.write(it.next()+"\n");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (outputFile!=null) {
//                    outputFile.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void shift() {
//        //获取每个单词，存入tokens
//        Iterator<String> it = lineTxt.iterator();
//        while (it.hasNext()) {
//            StringTokenizer token = new StringTokenizer(it.next());
//            ArrayList<String> tokens = new ArrayList<String>();
//            int i = 0;
//            //循环添加单词
//            int count = token.countTokens();
//            while (i < count) {
//                tokens.add(token.nextToken());
//                i++;
//            }
//
//            //display(tokens);
//            //切割各个单词，不断改变起始值和利用loop实现位移。
//            for (i = 0; i < count; i++) {
//                StringBuffer lineBuffer = new StringBuffer();
//                int index = i;
//                for (int f = 0; f < count; f++) {
//                    //从头继续位移
//                    if (index >= count)
//                        index = 0;
//                    //存入StringBuffer
//                    lineBuffer.append(tokens.get(index));
//                    lineBuffer.append(" ");
//                    index++;
//                }
//                String tmp = lineBuffer.toString();
//                kwicList.add(tmp);
//            }
//        }
//
//    }
//
//
//    public void alphabetizer() {
//        Collections.sort(this.kwicList, new AlphabetizerComparator());
//    }
//
//    private class AlphabetizerComparator implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            if (o1 == null && o2 == null) {
//                throw new NullPointerException();
//            }
//            int compareValue = 0;
//            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
//            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
//            compareValue = o1c - o2c;
//            return compareValue;
//
//        }
//
//    }
//}

//2.
//class Input {
//    private ArrayList<String> lineTxt = new ArrayList<String>();
//
//    public ArrayList<String> getLineTxt() {
//        return lineTxt;
//    }
//
//    public void input(String fileName) {
//        BufferedReader inputFile = null;
//        try {
//            inputFile = new BufferedReader(new FileReader(fileName));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String line;
//        try {
//            while ((line = inputFile.readLine()) != null) {
//                lineTxt.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//class Shift {
//    private ArrayList<String> kwicList = new ArrayList<String>();
//    private ArrayList<String> lineTxt;
//
//    public Shift( ArrayList<String> lineTxt) {
//        this.lineTxt = lineTxt;
//    }
//
//    public ArrayList<String> getKwicList() {
//        return kwicList;
//    }
//
//
//    public ArrayList<String> getLineTxt() {
//        return lineTxt;
//    }
//
//
//    public void shift() {
//        //获取每个单词，存入tokens
//        Iterator<String> it = lineTxt.iterator();
//        while (it.hasNext()) {
//            StringTokenizer token = new StringTokenizer(it.next());
//            ArrayList<String> tokens = new ArrayList<String>();
//            int i = 0;
//            //循环添加单词
//            int count = token.countTokens();
//            while (i < count) {
//                tokens.add(token.nextToken());
//                i++;
//            }
//
//            //display(tokens);
//            //切割各个单词，不断改变起始值和利用loop实现位移。
//            for (i = 0; i < count; i++) {
//                StringBuffer lineBuffer = new StringBuffer();
//                int index = i;
//                for (int f = 0; f < count; f++) {
//                    //从头继续位移
//                    if (index >= count)
//                        index = 0;
//                    //存入StringBuffer
//                    lineBuffer.append(tokens.get(index));
//                    lineBuffer.append(" ");
//                    index++;
//                }
//                String tmp = lineBuffer.toString();
//                kwicList.add(tmp);
//            }
//        }
//
//    }
//}
//class Alphabetizer {
//    private ArrayList<String> kwicList;
//
//    public Alphabetizer(ArrayList<String> kwicList) {
//        this.kwicList = kwicList;
//    }
//
//    public ArrayList<String> getKwicList() {
//        return kwicList;
//    }
//
//    public void sort() {
//        Collections.sort(this.kwicList, new AlphabetizerComparator());
//    }
//
//    private class AlphabetizerComparator implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            if (o1 == null && o2 == null) {
//                throw new NullPointerException();
//            }
//            int compareValue = 0;
//            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
//            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
//            compareValue = o1c - o2c;
//            return compareValue;
//
//        }
//
//    }
//}
//class Output {
//    private ArrayList<String> kwicList;
//    private BufferedWriter outputFile;
//
//    public Output(ArrayList<String> kwicList) {
//        this.kwicList = kwicList;
//    }
//
//    public void output(String filename){
//        Iterator<String> it = kwicList.iterator();
//        try {
//            outputFile = new BufferedWriter(new FileWriter(filename));
//            while (it.hasNext()) {
//                outputFile.write(it.next()+"\n");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (outputFile!=null) {
//                    outputFile.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//class Main {
//    public static void main(String[] args) {
//        Input input = new Input();
//        input.input("input.txt");
//        Shift shift = new Shift(input.getLineTxt());
//        shift.shift();
//        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
//        alphabetizer.sort();
//        Output output = new Output(alphabetizer.getKwicList());
//        output.output("output.txt");
//
//    }
//}

//3.

//class Subject {
//
//    //观察者数组
//    private List<Observer> vector = new LinkedList<>();
//
//
//    //增加一个观察者
//    public void addObserver(Observer observer) {
//        vector.add(observer);
//    }
//
//    //删除一个观察者
//    public void deleteObserver(Observer observer) {
//        vector.remove(observer);
//    }
//
//    //通知所有观察者
//    public void notifyAllObserver() {
//        for(Observer observer : vector) {
//            observer.toDo();
//        }
//    }
//
//    // 通知特定观察者
//    public void notifyOneObserver(int i) {
//        vector.get(i).toDo();
//    }
//
//}
//class KWICSubject extends Subject{
//    public void startKWIC(){
//        for (int i = 0;i<3;i++){
//            super.notifyOneObserver(i);
//        }
//    }
//}
//interface Observer {
//    void toDo();
//}
//class Input implements Observer{
//
//    private ArrayList<String> lineTxt = new ArrayList<String>();
//
//    public ArrayList<String> getLineTxt() {
//        return lineTxt;
//    }
//    private String fileName;
//
//    public Input(String fileName) {
//        this.fileName = fileName;
//    }
//
//    @Override
//    public void toDo() {
//        BufferedReader inputFile = null;
//        try {
//            inputFile = new BufferedReader(new FileReader(fileName));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String line;
//        try {
//            while ((line = inputFile.readLine()) != null) {
//                lineTxt.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//class Shift implements Observer {
//    private ArrayList<String> kwicList = new ArrayList<String>();
//    private ArrayList<String> lineTxt;
//
//    public Shift( ArrayList<String> lineTxt) {
//        this.lineTxt = lineTxt;
//    }
//
//    public ArrayList<String> getKwicList() {
//        return kwicList;
//    }
//
//
//    public ArrayList<String> getLineTxt() {
//        return lineTxt;
//    }
//
//    @Override
//    public void toDo() {
//        //获取每个单词，存入tokens
//        Iterator<String> it = lineTxt.iterator();
//        while (it.hasNext()) {
//            StringTokenizer token = new StringTokenizer(it.next());
//            ArrayList<String> tokens = new ArrayList<String>();
//            int i = 0;
//            //循环添加单词
//            int count = token.countTokens();
//            while (i < count) {
//                tokens.add(token.nextToken());
//                i++;
//            }
//
//            //display(tokens);
//            //切割各个单词，不断改变起始值和利用loop实现位移。
//            for (i = 0; i < count; i++) {
//                StringBuffer lineBuffer = new StringBuffer();
//                int index = i;
//                for (int f = 0; f < count; f++) {
//                    //从头继续位移
//                    if (index >= count)
//                        index = 0;
//                    //存入StringBuffer
//                    lineBuffer.append(tokens.get(index));
//                    lineBuffer.append(" ");
//                    index++;
//                }
//                String tmp = lineBuffer.toString();
//                kwicList.add(tmp);
//            }
//        }
//
//    }
//
//}
//class Alphabetizer implements Observer {
//    private ArrayList<String> kwicList;
//
//    public Alphabetizer(ArrayList<String> kwicList) {
//        this.kwicList = kwicList;
//    }
//
//    public ArrayList<String> getKwicList() {
//        return kwicList;
//    }
//
//    @Override
//    public void toDo() {
//        Collections.sort(this.kwicList, new AlphabetizerComparator());
//    }
//
//    private class AlphabetizerComparator implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            if (o1 == null && o2 == null) {
//                throw new NullPointerException();
//            }
//            int compareValue = 0;
//            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
//            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
//            compareValue = o1c - o2c;
//            return compareValue;
//
//        }
//
//    }
//
//}
//class Output implements Observer {
//    private ArrayList<String> kwicList;
//    private BufferedWriter outputFile;
//    private String filename;
//    public Output(ArrayList<String> kwicList,String filename) {
//        this.kwicList = kwicList;
//        this.filename = filename;
//    }
//
//    @Override
//    public void toDo(){
//        Iterator<String> it = kwicList.iterator();
//        try {
//            outputFile = new BufferedWriter(new FileWriter(filename));
//            while (it.hasNext()) {
//                outputFile.write(it.next()+"\n");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (outputFile!=null) {
//                    outputFile.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
//class Main {
//    public static void main(String[] args) {
//        //创建主题
//        KWICSubject kwicSubject = new KWICSubject();
//        //创建观察者
//        Input input = new Input("input.txt");
//        Shift shift = new Shift(input.getLineTxt());
//        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
//        Output output = new Output(alphabetizer.getKwicList(), "output.txt");
//
//        // 将观察者加入主题
//        kwicSubject.addObserver(input);
//        kwicSubject.addObserver(shift);
//        kwicSubject.addObserver(alphabetizer);
//        kwicSubject.addObserver(output);
//        // 逐步调用各个观察者
//        kwicSubject.startKWIC();
//    }
//}

//4.

//class Pipe {
//    private Scanner pipeReader;
//    private PrintWriter pipeWriter;
//    Pipe(){
//        PipedWriter pipedWriter = new PipedWriter();
//        PipedReader pipedReader = new PipedReader();
//        try {
//            pipedWriter.connect(pipedReader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        pipeReader = new Scanner(pipedReader);
//        pipeWriter = new PrintWriter(pipedWriter);
//    }
//    public String readerLine(){
//        return pipeReader.nextLine();
//    }
//    public boolean hashNextLine(){
//        return pipeReader.hasNext();
//    }
//    public void writerLine(String strLine){
//        pipeWriter.println(strLine);
//    }
//    public void closeReader(){
//        pipeReader.close();
//    }
//    public void closeWriter(){
//        pipeWriter.close();
//    }
//}
//abstract class Filter {
//    protected Pipe input;
//    protected Pipe output;
//
//    public Filter(Pipe input, Pipe output) {
//        this.input = input;
//        this.output = output;
//    }
//    protected abstract void transform() throws IOException;
//}
//class Input extends Filter {
//    private File file;
//    public Input(File file,Pipe output) {
//        super(null, output);
//        this.file = file;
//    }
//
//    @Override
//    protected void transform() throws IOException {
//        BufferedReader inputFile = null;
//        try {
//            inputFile = new BufferedReader(new FileReader(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String line;
//        try {
//            while ((line = inputFile.readLine()) != null) {
//                output.writerLine(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        output.closeWriter();
//    }
//}
//class Shift extends Filter {
//
//    public Shift(Pipe input, Pipe output) {
//        super(input, output);
//    }
//
//    @Override
//    protected void transform() throws IOException {
//        //获取每个单词，存入tokens
//        while (input.hashNextLine()) {
//            StringTokenizer token = new StringTokenizer(input.readerLine());
//            ArrayList<String> tokens = new ArrayList<String>();
//            int i = 0;
//            //循环添加单词
//            int count = token.countTokens();
//            while (i < count) {
//                tokens.add(token.nextToken());
//                i++;
//            }
//
//            //display(tokens);
//            //切割各个单词，不断改变起始值和利用loop实现位移。
//            for (i = 0; i < count; i++) {
//                StringBuffer lineBuffer = new StringBuffer();
//                int index = i;
//                for (int f = 0; f < count; f++) {
//                    //从头继续位移
//                    if (index >= count)
//                        index = 0;
//                    //存入StringBuffer
//                    lineBuffer.append(tokens.get(index));
//                    lineBuffer.append(" ");
//                    index++;
//                }
//                String tmp = lineBuffer.toString();
//                output.writerLine(tmp);
//            }
//        }
//        input.closeReader();
//        output.closeWriter();
//    }
//}
//class Alphabetizer extends Filter {
//    private ArrayList<String> kwicList = new ArrayList<>();
//    public Alphabetizer(Pipe input, Pipe output) {
//        super(input, output);
//    }
//
//    @Override
//    protected void transform() throws IOException {
//        while (input.hashNextLine()){
//            kwicList.add(input.readerLine());
//        }
//        Collections.sort(this.kwicList, new AlphabetizerComparator());
//        for (String line:kwicList){
//            output.writerLine(line);
//        }
//        input.closeReader();
//        output.closeWriter();
//    }
//    private class AlphabetizerComparator implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            if (o1 == null && o2 == null) {
//                throw new NullPointerException();
//            }
//            int compareValue = 0;
//            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
//            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
//            compareValue = o1c - o2c;
//            return compareValue;
//
//        }
//
//    }
//}
//class Output extends Filter {
//    private File file;
//    public Output(File file,Pipe input) {
//        super(input, null);
//        this.file = file;
//    }
//
//    @Override
//    protected void transform() throws IOException {
//        BufferedWriter outputFile =null;
//        String line;
//        try {
//            outputFile = new BufferedWriter(new FileWriter(file));
//            while (input.hashNextLine()) {
//                outputFile.write(input.readerLine()+"\n");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (outputFile!=null) {
//                    outputFile.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        input.closeReader();
//    }
//}
//class Main {
//    public static void main(String[] args) throws IOException {
//        File inFile = new File("input.txt");
//        File outFile = new File("output.txt");
//        Pipe pipe1 = new Pipe();
//        Pipe pipe2 = new Pipe();
//        Pipe pipe3 = new Pipe();
//        Input input = new Input(inFile, pipe1);
//        Shift shift = new Shift(pipe1, pipe2);
//        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
//        Output output = new Output(outFile,pipe3);
//        input.transform();
//        shift.transform();
//        alphabetizer.transform();
//        output.transform();
//
//    }
//}
//

