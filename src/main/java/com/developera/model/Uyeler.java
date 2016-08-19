package com.developera.model;

public class Uyeler 
{
	private int uyeId;
	private String uyeAdi;
	private String uyeSoyadi;
	private String uyeMeslegi;
	private String uyeDogumYili;
	
	public int getUyeId() {
		return uyeId;
	}
	public void setUyeId(int uyeId) {
		this.uyeId = uyeId;
	}
	public String getUyeAdi() {
		return uyeAdi;
	}
	public void setUyeAdi(String uyeAdi) {
		this.uyeAdi = uyeAdi;
	}
	public String getUyeSoyadi() {
		return uyeSoyadi;
	}
	public void setUyeSoyadi(String uyeSoyadi) {
		this.uyeSoyadi = uyeSoyadi;
	}
	public String getUyeMeslegi() {
		return uyeMeslegi;
	}
	public void setUyeMeslegi(String uyeMeslegi) {
		this.uyeMeslegi = uyeMeslegi;
	}
	public String getUyeDogumYili() {
		return uyeDogumYili;
	}
	public void setUyeDogumYili(String uyeDogumYili) {
		this.uyeDogumYili = uyeDogumYili;
	}
	
	@Override
	public String toString() 
	{
		return "Adi: "+uyeAdi+" Soyadi: "+uyeSoyadi +" Mesleği: "+uyeMeslegi+" DogumYili: "+ uyeDogumYili;
	}
	

}
