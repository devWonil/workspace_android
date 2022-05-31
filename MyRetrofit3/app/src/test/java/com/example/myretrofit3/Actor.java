package com.example.myretrofit3;

public class Actor {

    private String name;
    private int age;
    private String role;
    private boolean isMarried;

    private Actor () {}

    public static class MyBuilder {

        private String name;
        private int age;
        private String role;
        private boolean isMarried;

        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public MyBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public MyBuilder setIsMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        // 핵심
        // 리턴 타입을 outer class 반환하는 메서드를 만들어준다
        public Actor build() {
            Actor actor = new Actor();
            actor.name = name;
            actor.age = age;
            actor.role = role;
            actor.isMarried = isMarried;
            return actor;
        }

        public static void main(String[] args) {
            Actor actor1 = new MyBuilder().setName("Dwayne The Rock Johnson").build();
            Actor actor2 = new MyBuilder().setAge(19).build();
            Actor actor3 = new MyBuilder().setRole("Iron man").setAge(40).build();
            Actor actor4 = new MyBuilder().setIsMarried(true).build();
        }
    }
}
