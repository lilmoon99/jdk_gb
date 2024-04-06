package org.lilmoon;

public class Fullstack extends Developer implements Backendable, Frontendable {
    @Override
    public void doBackendWork() {
        System.out.printf("%s, good backend work!!!\n",this.getName());
    }

    @Override
    public void doFrontendWork() {
        System.out.printf("%s, good frontend work!!!\n",this.getName());
    }

    public Fullstack(String name, int age) {
        super(name, age);
    }
}
