package com.point;


public class ProductString {

        String id;
        String name;
        String type;
        String price;
        String number;
        String product_Date;
        String shelf_life;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getPrice() {
                return price;
        }

        public void setPrice(String price) {
                this.price = price;
        }

        public String getNumber() {
                return number;
        }

        public void setNumber(String number) {
                this.number = number;
        }

        public String getProduct_Date() {
                return product_Date;
        }

        public void setProduct_Date(String product_Date) {
                this.product_Date = product_Date;
        }

        public String getShelf_life() {
                return shelf_life;
        }

        public void setShelf_life(String shelf_life) {
                this.shelf_life = shelf_life;
        }

        @Override
        public String toString() {
                return "ProductString{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", type='" + type + '\'' +
                        ", price='" + price + '\'' +
                        ", number='" + number + '\'' +
                        ", product_Date='" + product_Date + '\'' +
                        ", shelf_life='" + shelf_life + '\'' +
                        '}';
        }
}
