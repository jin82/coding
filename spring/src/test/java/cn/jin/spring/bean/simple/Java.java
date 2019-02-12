package cn.jin.spring.bean.simple;

/**
 * Created by jin on 2019/1/31.
 */
public class Java extends Language {
    public Java() {
        super(true, true);
    }

    @Override
    public String name() {
        return "JAVA";
    }
}
