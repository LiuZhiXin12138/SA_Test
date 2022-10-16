import java.io.IOException;

public class demo {
    public int url = 0;
    public void setUrl(int url) {
        this.url = url;
    }
    public demo(int x){
        setUrl(x);
    }
    public void doo() throws IOException {
        if(url==1){
           demo1 f = new demo1();
           f.foo();
        }
        else if(url==2){
           demo2 f = new demo2();
           f.foo();
        }
        else if(url==3){
           demo3 f = new demo3();
           f.foo();
        }
        else {
            demo4 f = new demo4();
            f.foo();
        }
    }
}
