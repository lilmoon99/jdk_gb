package org.lilmoon;

public class Backender extends Developer implements Backendable,Frontendable{

    public Backender(String name, int age) {
        super(name, age);
    }

    @Override
    public void doBackendWork() {
        System.out.printf("%s, good backend work!!!\n",this.getName());
    }

    @Override
    public void doFrontendWork() {
        System.out.printf("%s, can't do frontend work!\n",this.getName());
    }
}
