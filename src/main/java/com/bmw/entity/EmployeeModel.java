package com.bmw.entity;


import java.util.List;

import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employee模型")
public class EmployeeModel {
	@ApiModelProperty(notes = "组号", example = "A1", required = true, dataType = "java.lang.String")
	@NotNull
	private String groupid;
	@ApiModelProperty(notes = "code号", example = "01SERV", required = true, dataType = "java.lang.String")
	@NotNull
    private String Code;
	@ApiModelProperty(notes = "名字", example = "张江(Serv-1)", required = true, dataType = "java.lang.String")
	@NotNull
    private String Desc;
	
    private List<Skills> skills;
    public void setGroupid(String groupid) {
         this.groupid = groupid;
     }
     public String getGroupid() {
         return groupid;
     }

    public void setCode(String Code) {
         this.Code = Code;
     }
     public String getCode() {
         return Code;
     }

    public void setDesc(String Desc) {
         this.Desc = Desc;
     }
     public String getDesc() {
         return Desc;
     }


    public void setSkills(List<Skills> skills) {
         this.skills = skills;
     }
     public List<Skills> getSkills() {
         return skills;
     }
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeModel(@NotNull String groupid, @NotNull String code, @NotNull String desc, List<Skills> skills) {
		super();
		this.groupid = groupid;
		Code = code;
		Desc = desc;
		this.skills = skills;
	}
     
    

}
