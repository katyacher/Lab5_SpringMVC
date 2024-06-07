package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** Класс  Jewel - основная сущность приложения. Содержит поля для хранения информации о размере, цене,
 * типе ювелироного изделия, материалов для изготовления изделий: метал и вставка из камня, а также идентификатор
 * 
 *  в классе реализованы конструкторы по-умолчанию и с параметрами, геттеры и сеттеры, соответсвующих полей класса, 
 *  переопределен метод toString для вывода на печать информации, хранящейся в объекте данного класса.
 *  
 * */

@Entity
@Table(name = "jewel") // Specify the table name here
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int size;
    private int price;
    private String type;
    private String metal;
    private String stone;

    // Constructors, getters, and setters
    public Jewel(){}
	public Jewel(int size, int price, String type, String metal, String stone) {
		this.size = size;
		this.price = price;
		this.type = type;
		this.metal = metal;
		this.stone = stone;
	}
	/** */
	 public Long getId() {
	    return id;
	 }
	 
	/** */
	public void setId(Long id) {
		this.id = id;
	}
	/** */
	public int getSize() {
		return size;
	}
	/** */
	public void setSize(int size) {
		this.size = size;
	}
	/** */
	public int getPrice() {
		return price;
	}
	/** */
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	/** */
	public void setType(String type) {
		this.type = type;
	}
	/** */
	public String getMetal() {
		return metal;
	}
	/** */
	public void setMetal(String metal) {
		this.metal = metal;
	}
	/** */
	public String getStone() {
		return stone;
	}
	/** */
	public void setStone(String stone) {
		this.stone = stone;
	}
	/** */
	@Override
	public String toString() {
		return "Jewel [id=" + id + ", size=" + size + ", price=" + price + ", type=" + type + ", metal=" + metal
				+ ", stone=" + stone + "]";
	}
}