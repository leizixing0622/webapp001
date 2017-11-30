package com.myorg.common.jspTag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class RadioTag extends TagSupport {
	//��ǩ����value
	private String value;
	//��ǩ����styleClass
	private String styleClass = null;
	//��ǩ����value
	private String type = null;
	//��ǩ����id
	private String id = null;
	//��ǩ����name
	private String name = null;
	
	//��ǩ��ʼ����
	@SuppressWarnings("static-access")
	public int doStartTag() throws JspTagException{
		return super.EVAL_BODY_INCLUDE;
	}
	
	//��ǩ��������
	@SuppressWarnings("static-access")
	public int doEndTag() throws JspTagException{
		return super.SKIP_BODY;
	}
	
}
