package com.demon.io.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @desc
 * @fileName ReplaceTest.java
 * @date 2023/8/22/0022 14:40
 * @author Dongmo.Wu
 */
public class ReplaceTest {
	public static void main(String[] args) {
		String input = "sb.append(\"'\"+Dsbm()+\"', \");\n" + "\t\tsb.append(\"'\"+Nid()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Dsdm()+\"', \");\n" + "\t\tsb.append(\"'\"+Rkbm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Gmsfhm()+\"', \");\n" + "\t\tsb.append(\"'\"+Xm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+X()+\"', \");\n" + "\t\tsb.append(\"'\"+M()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Hh()+\"', \");\n" + "\t\tsb.append(\"'\"+Yhzgxdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Cym()+\"', \");\n" + "\t\tsb.append(\"'\"+Xbdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Mzdm()+\"', \");\n" + "\t\tsb.append(\"'\"+Csrq()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Cssj()+\"', \");\n" + "\t\tsb.append(\"'\"+CsdGjhdqdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CsdSsxqdm()+\"', \");\n" + "\t\tsb.append(\"'\"+CsdQhnxxdz()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JgGjhdqdm()+\"', \");\n" + "\t\tsb.append(\"'\"+JgSsxqdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JgQhnxxdz()+\"', \");\n" + "\t\tsb.append(\"'\"+HjdzDzbm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+HjdzSsxqdm()+\"', \");\n" + "\t\tsb.append(\"'\"+HjdzQhnxxdz()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+HjdzXzjddm()+\"', \");\n" + "\t\tsb.append(\"'\"+HjdzSqjcwhdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+HjdzCxfldm()+\"', \");\n" + "\t\tsb.append(\"'\"+HjdzRhyzbs()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Xldm()+\"', \");\n" + "\t\tsb.append(\"'\"+Hyzkdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CyzkZagldwbm()+\"', \");\n" + "\t\tsb.append(\"'\"+CyzkDwmc()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CyzkZy()+\"', \");\n" + "\t\tsb.append(\"'\"+CyzkZylbdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Zjxydm()+\"', \");\n" + "\t\tsb.append(\"'\"+Byzkdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Sg()+\"', \");\n" + "\t\tsb.append(\"'\"+Xxdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhryGmsfhm()+\"', \");\n" + "\t\tsb.append(\"'\"+JhryXm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhryCyzjdm()+\"', \");\n" + "\t\tsb.append(\"'\"+JhryZjhm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhryWwx()+\"', \");\n" + "\t\tsb.append(\"'\"+JhryWwm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhryJhgxdm()+\"', \");\n" + "\t\tsb.append(\"'\"+JhryLxdh()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhreGmsfhm()+\"', \");\n" + "\t\tsb.append(\"'\"+JhreXm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhreCyzjdm()+\"', \");\n" + "\t\tsb.append(\"'\"+JhreZjhm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhreWwx()+\"', \");\n" + "\t\tsb.append(\"'\"+JhreWwm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+JhreJhgxdm()+\"', \");\n" + "\t\tsb.append(\"'\"+JhreLxdh()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+FqGmsfhm()+\"', \");\n" + "\t\tsb.append(\"'\"+FqXm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+FqCyzjdm()+\"', \");\n" + "\t\tsb.append(\"'\"+FqZjhm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+FqWwx()+\"', \");\n" + "\t\tsb.append(\"'\"+FqWwm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+MqGmsfhm()+\"', \");\n" + "\t\tsb.append(\"'\"+MqXm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+MqCyzjdm()+\"', \");\n" + "\t\tsb.append(\"'\"+MqZjhm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+MqWwx()+\"', \");\n" + "\t\tsb.append(\"'\"+MqWwm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+PoGmsfhm()+\"', \");\n" + "\t\tsb.append(\"'\"+PoXm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+PoCyzjdm()+\"', \");\n" + "\t\tsb.append(\"'\"+PoZjhm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+PoWwx()+\"', \");\n" + "\t\tsb.append(\"'\"+PoWwm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LbsqkQlrrq()+\"', \");\n" + "\t\tsb.append(\"'\"+LbsqkQyldyydm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LbsqkLzdGjhdqdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LbsqkLzdSsxqdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LbsqkLzdQhnxxdz()+\"', \");\n" + "\t\tsb.append(\"'\"+LkbsqkQlcrq()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LkbsqkQyldyydm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LkbsqkQwdGjhdqdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LkbsqkQwdSsxqdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+LkbsqkQwdQhnxxdz()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CyjmsfzqkQfjgGajgmc()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CyjmsfzqkYxqqsrq()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CyjmsfzqkYxqjzrq()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+CyjmsfzqkDzmc()+\"', \");\n" + "\t\tsb.append(\"'\"+Swrq()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Rkglswyydm()+\"', \");\n" + "\t\tsb.append(\"'\"+Lxdh()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Rkxxjbdm()+\"', \");\n" + "\t\tsb.append(\"'\"+Xmpy()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Rkglzxlbdm()+\"', \");\n" + "\t\tsb.append(\"'\"+Zxsj()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Gxsj()+\"', \");\n" + "\t\tsb.append(\"'\"+Sjgsdwdm()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Sjgsdwmc()+\"', \");\n" + "\t\tsb.append(\"'\"+Rkzt()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+PhotoId()+\"', \");\n" + "\t\tsb.append(\"'\"+Dsbz()+\"', \");\n"
				+ "\t\tsb.append(\"'\"+Scol3()+\"' \");";
		String output = replaceFirstUpperCaseAfterAppend(input);

		System.out.println(output);
	}

	public static String replaceFirstUpperCaseAfterAppend(String input) {
		Pattern pattern = Pattern.compile("sb\\.append\\(\"'\"\\s*\\+\\s*([A-Z])");
		Matcher matcher = pattern.matcher(input);

		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String replacement = matcher.group(1).toLowerCase();
			matcher.appendReplacement(sb, "sb.append(\"'\" + " + replacement);
		}
		matcher.appendTail(sb);

		return sb.toString();
	}
}
