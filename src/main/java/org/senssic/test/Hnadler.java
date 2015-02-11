package org.senssic.test;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

public class Hnadler {
	public static void main(String[] args)throws Exception {
       Handlebars handlebars=new Handlebars();
       Template template=handlebars.compileInline("hello{{this}}");
       System.out.println(template.apply("啊哈哈"));
       
       
	}
}
