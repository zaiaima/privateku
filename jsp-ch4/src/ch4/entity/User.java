package ch4.entity;

public class User {
        private String name;
        private int age;
        private boolean isVip;   // ÊÇ·ñÎªvip
        
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public int getAge() {
                return age;
        }
        public void setAge(int age) {
                this.age = age;
        }
        public boolean isVip() {
                return isVip;
        }
        public void setVip(boolean isVip) {
                this.isVip = isVip;
        }
        
        
}