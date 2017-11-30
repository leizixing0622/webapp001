package com.myorg.common.jspTag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class RadioTag extends TagSupport {
	//标签属性value
	private String value;
	//标签属性styleClass
	private String styleClass = null;
	//标签属性value
	private String type = null;
	//标签属性id
	private String id = null;
	//标签属性name
	private String name = null;
	
	//标签初始方法
	@SuppressWarnings("static-access")
	public int doStartTag() throws JspTagException{
		return super.EVAL_BODY_INCLUDE;
	}
	
	//标签结束方法
	@SuppressWarnings("static-access")
	public int doEndTag() throws JspTagException{
		return super.SKIP_BODY;
	}
	
}
