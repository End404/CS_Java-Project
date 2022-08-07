
//  2.8 条件注解


package org.javaboy.ioc;

public class LinuxShowCmd implements ShowCmd {
    public String showCmd() {
        return "ls";
    }
}
