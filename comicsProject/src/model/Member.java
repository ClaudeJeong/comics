package model;

public class Member {
	//Instance	
		private String id;
		private String password;
		private String name;
		private String nickname;
		private String email1;
		private String email2;
		private String birth;
		private String gender;
		private String phone1;
		private String phone2;
		private String phone3;
		private String zipcode;
		private String address1;
		private String address2;
		private String regDate;
		
	//Method
		@Override
		public String toString() {
			return "MemberDao [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
					+ ", email1=" + email1 + ", email2=" + email2 + ", birth=" + birth + ", gender=" + gender + ", phone1="
					+ phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", zipcode=" + zipcode + ", address1="
					+ address1 + ", address2=" + address2 + ", regDate=" + regDate + "]";
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getEmail1() {
			return email1;
		}
		public void setEmail1(String email1) {
			this.email1 = email1;
		}
		public String getEmail2() {
			return email2;
		}
		public void setEmail2(String email2) {
			this.email2 = email2;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhone1() {
			return phone1;
		}
		public void setPhone1(String phone1) {
			this.phone1 = phone1;
		}
		public String getPhone2() {
			return phone2;
		}
		public void setPhone2(String phone2) {
			this.phone2 = phone2;
		}
		public String getPhone3() {
			return phone3;
		}
		public void setPhone3(String phone3) {
			this.phone3 = phone3;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getRegDate() {
			return regDate;
		}
		public void setRegDate(String regDate) {
			this.regDate = regDate;
		}
}
