package cn.jin.spi;

import java.util.ServiceLoader;

/**
 * Created by jin on 2019/2/6.
 */
public class Main {

    public static void main(String[] args) {
        String testValue = "test";
        ServiceLoader<Repository> repositories = ServiceLoader.load(Repository.class);
        for (Repository repository : repositories) {
            repository.store(testValue);
            Object o = repository.get();
            System.out.println(repository.getClass().getName() + "return value : " + o);
        }
    }
}
