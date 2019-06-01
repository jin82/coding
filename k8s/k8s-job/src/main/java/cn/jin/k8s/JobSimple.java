package cn.jin.k8s;

/**
 * Created by jin on 2019-05-22.
 */
public class JobSimple {

    public static void main(String[] args) throws Exception{
        for (int i = 1; i <= 15; i++) {
            Thread.sleep(1000);
            System.out.println("运行了" + i + "秒！");
        }
        System.out.println("运行结束！");
    }
}
