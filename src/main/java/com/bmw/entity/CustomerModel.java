package com.bmw.entity;

public class CustomerModel {
	    private String magic;
	    private String title;
	    private String surname;
	    private String salute;
	    private String phone;
	    private String address1;
	    private String address2;
	    private String address3;
	    private String address4;
	    private String postcode;
	    public void setMagic(String magic) {
	         this.magic = magic;
	     }
	     public String getMagic() {
	         return magic;
	     }

	    public void setTitle(String title) {
	         this.title = title;
	     }
	     public String getTitle() {
	         return title;
	     }

	    public void setSurname(String surname) {
	         this.surname = surname;
	     }
	     public String getSurname() {
	         return surname;
	     }

	    public void setSalute(String salute) {
	         this.salute = salute;
	     }
	     public String getSalute() {
	         return salute;
	     }

	    public void setPhone(String phone) {
	         this.phone = phone;
	     }
	     public String getPhone() {
	         return phone;
	     }

	    public void setAddress1(String address1) {
	         this.address1 = address1;
	     }
	     public String getAddress1() {
	         return address1;
	     }

	    public void setAddress2(String address2) {
	         this.address2 = address2;
	     }
	     public String getAddress2() {
	         return address2;
	     }

	    public void setAddress3(String address3) {
	         this.address3 = address3;
	     }
	     public String getAddress3() {
	         return address3;
	     }

	    public void setAddress4(String address4) {
	         this.address4 = address4;
	     }
	     public String getAddress4() {
	         return address4;
	     }

	    public void setPostcode(String postcode) {
	         this.postcode = postcode;
	     }
	     public String getPostcode() {
	         return postcode;
	     }
		public CustomerModel() {
			super();
		}
		public CustomerModel(String magic, String title, String surname, String salute, String phone, String address1,
				String address2, String address3, String address4, String postcode) {
			super();
			this.magic = magic;
			this.title = title;
			this.surname = surname;
			this.salute = salute;
			this.phone = phone;
			this.address1 = address1;
			this.address2 = address2;
			this.address3 = address3;
			this.address4 = address4;
			this.postcode = postcode;
		}

	

}
