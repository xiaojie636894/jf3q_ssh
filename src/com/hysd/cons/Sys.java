package com.hysd.cons;

public class Sys {
	/*静态内部类，来标志系统状态常量，方便修改*/
	
	
	public static class Common{
		/*1,启用*/
		public static Integer IS_USE=1;
		/*0,禁用*/
		public static Integer UN_USE=0;
		/*默认一页几条数据*/
		public static Integer PGGESIZE=4;
		/*图片上传路径*/
		public static String FILEPATH="/upImgs";
	}
	
	public static class CmgLog{
		/*日志操作类型：0,创建*/
		public static Integer CREATE=0;
		/*日志操作类型：1,修改*/
		public static Integer UPDATE=1;
		/*日志操作类型：2,删除*/
		public static Integer DEL=2;
		/*日志操作类型：3,登录*/
		public static Integer LOGIN=3; 
		/*日志操作类型：4,其它*/
		public static Integer OTHER=4; 
	}
}
