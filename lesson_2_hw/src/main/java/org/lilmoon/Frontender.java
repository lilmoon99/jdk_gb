package org.lilmoon;

public class Frontender extends Developer implements Backendable, Frontendable {
    @Override
    public void doBackendWork() {
        System.out.printf("%s, very bad backend work!!!\n",this.getName());
    }

    @Override
    public void doFrontendWork() {
        System.out.printf("%s, good frontend work!!!\n",this.getName());
    }

    public Frontender(String name, int age) {
        super(name, age);
    }
}