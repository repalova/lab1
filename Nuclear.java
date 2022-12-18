import java.util.Scanner;

public class Nuclear {
    public boolean pos;
    float level;
    float temp;
    boolean stop;

    Nuclear(){
        this.temp = 50;
        this.level = this.temp;
        this.stop = false;
        this.pos = true;
    }

    public synchronized float inc(){
        this.temp++;
        return this.temp;
    }

    public synchronized float dec(){
        this.temp--;
        return this.temp;
    }

    public synchronized float change(boolean op){
        if(op){
            this.temp++;
        }else{
            this.temp--;
        }
        return this.temp;
    }

    public void operator(){
        try (Scanner scanner = new Scanner(System.in)) {
            this.level = scanner.nextFloat();
        }
        this.pos = false;
        this.stop = temp>=100?true:false;
        if(!this.stop){
            this.stop = temp<=0?true:false;
        }

    }

    public synchronized float getTemp(){
        return this.temp;
    }
}