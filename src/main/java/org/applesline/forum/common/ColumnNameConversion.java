/**
 * 
 */
package org.applesline.forum.common;

import org.beetl.sql.core.NameConversion;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author liuyaping
 *
 * 创建时间：2018年3月3日
 */
public class ColumnNameConversion extends NameConversion {

	@Override
	public String getTableName(Class<?> c) {
		Table table = (Table)c.getAnnotation(Table.class);
		if(table!=null){
			return table.name();
		}
		return c.getSimpleName();
	}

	@Override
	public String getColName(Class<?> c, String attrName) {
		char[] chars = attrName.toCharArray();
		int index = 0;
		for(int i=0;i<chars.length;i++) {
			if(chars[i] >= 65 && chars[i] <=90) {
				index = i;
			}
		}
		System.out.println(attrName.substring(0,index) + "_" + attrName.substring(index,index+1).toLowerCase() + attrName.substring(index+1,attrName.length()));
		return attrName.substring(0,index) + "_" + attrName.substring(index,index+1).toLowerCase() + attrName.substring(index+1,attrName.length());
	}

	/**
	 * 实现数据库字段到属性的映射   create_time ==> createTime
	 */
	@Override
	public String getPropertyName(Class<?> c, String colName) {
		if(colName.indexOf("_") < 0 ) {
			return colName;
		}
		String suffix = colName.substring(0,colName.indexOf("_"));
		String c1 = colName.substring(colName.indexOf("_")+1,colName.indexOf("_")+2);
		String cc = colName.substring(colName.indexOf("_")+2,colName.length());
//		System.out.println(suffix + c1.toUpperCase() + cc);
		return suffix + c1.toUpperCase() + cc;
	}

}
