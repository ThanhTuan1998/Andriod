package com.example.myapplication;

import java.io.Serializable;
public class  person {
        private String name;
        private String address;
        private String country;
        private String clickedCountryName;
        private int img;
        private String thongbao;
        public  person(){}
        public  person(String name, String address, String country, int img,String thongbao,String clickedCountryName){
            this.name=name;
            this.address=address;
            this.country =country;
            this.img = img;
            this.thongbao=thongbao;
            this.clickedCountryName=clickedCountryName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }
        public String getclickedCountryName() {
            return clickedCountryName;
        }
        public void setclickedCountryName(String clickedCountryName) {
            this.clickedCountryName = clickedCountryName;
        }
        public String getThongbao() {
            return thongbao;
        }
        public void setThongbao(String thongbao) {
        this.thongbao = thongbao;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Username:" + name + "\nDateTime:" + address + "\nGender:" + country +"\nHobby:"+thongbao+"\nmYCountryList:"+clickedCountryName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}