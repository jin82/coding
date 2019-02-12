package cn.jin.spring.bean.simple;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by jin on 2019/1/31.
 */
@AllArgsConstructor
@Getter
public abstract class Language {

    private boolean type;

    private boolean staticLanguage;

    abstract public String name();
}
