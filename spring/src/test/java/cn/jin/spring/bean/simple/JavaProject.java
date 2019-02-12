package cn.jin.spring.bean.simple;

/**
 * Created by jin on 2019/2/1.
 */
public class JavaProject {

    private Java java;

    private Member leader;


    public JavaProject(Java java) {
        this.java = java;
    }

    public String useLanguageName() {
        return this.java.name();
    }

    public void setLeader(Member leader) {
        this.leader = leader;
    }
}
