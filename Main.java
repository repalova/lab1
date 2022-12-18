public class Main {
    public static void main(String[] args) {
        Nuclear nuc =  new Nuclear();

        Thread threadInc = new Thread(new Runnable() {
            @Override
            public void run() {

                while(!nuc.stop)
                {
                    if(nuc.pos||nuc.level>nuc.temp){
                        System.out.println("Thread Increser| temp: "+ nuc.change(true));
                    }else{
                        nuc.pos = nuc.level == nuc.temp?true:false;
                    }
                    if(nuc.getTemp()>=100){
                        nuc.stop = true;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread threadDec = new Thread(new Runnable() {
            @Override
            public void run() {
                    while(!nuc.stop)
                    {
                        if(nuc.pos||nuc.level<nuc.temp)
                        {
                            System.out.println("Thread Decreser| temp: "+nuc.change(false));
                        }else
                        {
                            nuc.pos = nuc.level == nuc.temp?true:false;
                        }
                        if(nuc.getTemp()<=0)
                        {
                            nuc.stop = true;
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

            }
        });

        Thread threadOp = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!nuc.stop)
                {
                    nuc.operator();
                    System.out.println("Thread Operator| temp: " + nuc.level);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        threadDec.start();
        threadInc.start();
        threadOp.start();
    }
}
