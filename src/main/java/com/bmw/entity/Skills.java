package com.bmw.entity;

import io.swagger.annotations.ApiModelProperty;

public class Skills {
	@ApiModelProperty(notes = "技能名字", example = "A", required = true,dataType = "java.lang.String")
	private String skill;
	@ApiModelProperty(notes = "工作效率", example = "100 125", required = true,dataType = "java.lang.String")
	private String Ability;
	public void setSkill(String skill) {
		 this.skill = skill;
		 }
	     public String getSkill() {
	         return skill;
	     }

	    public void setAbility(String Ability) {
	         this.Ability = Ability;
	     }
	     public String getAbility() {
	         return Ability;
	     }
		public Skills() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Skills(String skill, String ability) {
			super();
			this.skill = skill;
			Ability = ability;
		}
	     

}
