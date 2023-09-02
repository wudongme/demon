package com.demon.io.model;

import com.huawei.gauss200.jdbc.copy.CopyManager;
import com.huawei.gauss200.jdbc.core.BaseConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TczrkJbxMysql {
	public final static String ch_7000 = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

	public static String getCh_7000() {
		return ch_7000;
	}

	private String dsbm;
	private Long nid;
	private String dsdm;
	private String rkbm;
	private String gmsfhm;
	private String xm;
	private String x;
	private String m;
	private String hh;
	private String yhzgxdm;
	private String cym;
	private String xbdm;
	private String mzdm;
	private Timestamp csrq;
	private String cssj;
	private String csdGjhdqdm;
	private String csdSsxqdm;
	private String csdQhnxxdz;
	private String jgGjhdqdm;
	private String jgSsxqdm;
	private String jgQhnxxdz;
	private String hjdzDzbm;
	private String hjdzSsxqdm;
	private String hjdzQhnxxdz;
	private String hjdzXzjddm;
	private String hjdzSqjcwhdm;
	private String hjdzCxfldm;
	private String hjdzRhyzbs;
	private String xldm;
	private String hyzkdm;
	private String cyzkZagldwbm;
	private String cyzkDwmc;
	private String cyzkZy;
	private String cyzkZylbdm;
	private String zjxydm;
	private String byzkdm;
	private Double sg;
	private String xxdm;
	private String jhryGmsfhm;
	private String jhryXm;
	private String jhryCyzjdm;
	private String jhryZjhm;
	private String jhryWwx;
	private String jhryWwm;
	private String jhryJhgxdm;
	private String jhryLxdh;
	private String jhreGmsfhm;
	private String jhreXm;
	private String jhreCyzjdm;
	private String jhreZjhm;
	private String jhreWwx;
	private String jhreWwm;
	private String jhreJhgxdm;
	private String jhreLxdh;
	private String fqGmsfhm;
	private String fqXm;
	private String fqCyzjdm;
	private String fqZjhm;
	private String fqWwx;
	private String fqWwm;
	private String mqGmsfhm;
	private String mqXm;
	private String mqCyzjdm;
	private String mqZjhm;
	private String mqWwx;
	private String mqWwm;
	private String poGmsfhm;
	private String poXm;
	private String poCyzjdm;
	private String poZjhm;
	private String poWwx;
	private String poWwm;
	private Timestamp lbsqkQlrrq;
	private String lbsqkQyldyydm;
	private String lbsqkLzdGjhdqdm;
	private String lbsqkLzdSsxqdm;
	private String lbsqkLzdQhnxxdz;
	private Timestamp lkbsqkQlcrq;
	private String lkbsqkQyldyydm;
	private String lkbsqkQwdGjhdqdm;
	private String lkbsqkQwdSsxqdm;
	private String lkbsqkQwdQhnxxdz;
	private String cyjmsfzqkQfjgGajgmc;
	private Timestamp cyjmsfzqkYxqqsrq;
	private String cyjmsfzqkYxqjzrq;
	private String cyjmsfzqkDzmc;
	private Timestamp swrq;
	private String rkglswyydm;
	private String lxdh;
	private String rkxxjbdm;
	private String xmpy;
	private String rkglzxlbdm;
	private Timestamp zxsj;
	private Timestamp gxsj;
	private String sjgsdwdm;
	private String sjgsdwmc;
	private String rkzt;
	private String photoId;
	private String dsbz;
	private String scol3;

	public String getDsbm() {
		return dsbm;
	}

	public void setDsbm(String dsbm) {
		this.dsbm = dsbm;
	}

	public Long getNid() {
		return nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}

	public String getDsdm() {
		return dsdm;
	}

	public void setDsdm(String dsdm) {
		this.dsdm = dsdm;
	}

	public String getRkbm() {
		return rkbm;
	}

	public void setRkbm(String rkbm) {
		this.rkbm = rkbm;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getYhzgxdm() {
		return yhzgxdm;
	}

	public void setYhzgxdm(String yhzgxdm) {
		this.yhzgxdm = yhzgxdm;
	}

	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public Timestamp getCsrq() {
		return csrq;
	}

	public void setCsrq(Timestamp csrq) {
		this.csrq = csrq;
	}

	public String getCssj() {
		return cssj;
	}

	public void setCssj(String cssj) {
		this.cssj = cssj;
	}

	public String getCsdGjhdqdm() {
		return csdGjhdqdm;
	}

	public void setCsdGjhdqdm(String csdGjhdqdm) {
		this.csdGjhdqdm = csdGjhdqdm;
	}

	public String getCsdSsxqdm() {
		return csdSsxqdm;
	}

	public void setCsdSsxqdm(String csdSsxqdm) {
		this.csdSsxqdm = csdSsxqdm;
	}

	public String getCsdQhnxxdz() {
		return csdQhnxxdz;
	}

	public void setCsdQhnxxdz(String csdQhnxxdz) {
		this.csdQhnxxdz = csdQhnxxdz;
	}

	public String getJgGjhdqdm() {
		return jgGjhdqdm;
	}

	public void setJgGjhdqdm(String jgGjhdqdm) {
		this.jgGjhdqdm = jgGjhdqdm;
	}

	public String getJgSsxqdm() {
		return jgSsxqdm;
	}

	public void setJgSsxqdm(String jgSsxqdm) {
		this.jgSsxqdm = jgSsxqdm;
	}

	public String getJgQhnxxdz() {
		return jgQhnxxdz;
	}

	public void setJgQhnxxdz(String jgQhnxxdz) {
		this.jgQhnxxdz = jgQhnxxdz;
	}

	public String getHjdzDzbm() {
		return hjdzDzbm;
	}

	public void setHjdzDzbm(String hjdzDzbm) {
		this.hjdzDzbm = hjdzDzbm;
	}

	public String getHjdzSsxqdm() {
		return hjdzSsxqdm;
	}

	public void setHjdzSsxqdm(String hjdzSsxqdm) {
		this.hjdzSsxqdm = hjdzSsxqdm;
	}

	public String getHjdzQhnxxdz() {
		return hjdzQhnxxdz;
	}

	public void setHjdzQhnxxdz(String hjdzQhnxxdz) {
		this.hjdzQhnxxdz = hjdzQhnxxdz;
	}

	public String getHjdzXzjddm() {
		return hjdzXzjddm;
	}

	public void setHjdzXzjddm(String hjdzXzjddm) {
		this.hjdzXzjddm = hjdzXzjddm;
	}

	public String getHjdzSqjcwhdm() {
		return hjdzSqjcwhdm;
	}

	public void setHjdzSqjcwhdm(String hjdzSqjcwhdm) {
		this.hjdzSqjcwhdm = hjdzSqjcwhdm;
	}

	public String getHjdzCxfldm() {
		return hjdzCxfldm;
	}

	public void setHjdzCxfldm(String hjdzCxfldm) {
		this.hjdzCxfldm = hjdzCxfldm;
	}

	public String getHjdzRhyzbs() {
		return hjdzRhyzbs;
	}

	public void setHjdzRhyzbs(String hjdzRhyzbs) {
		this.hjdzRhyzbs = hjdzRhyzbs;
	}

	public String getXldm() {
		return xldm;
	}

	public void setXldm(String xldm) {
		this.xldm = xldm;
	}

	public String getHyzkdm() {
		return hyzkdm;
	}

	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}

	public String getCyzkZagldwbm() {
		return cyzkZagldwbm;
	}

	public void setCyzkZagldwbm(String cyzkZagldwbm) {
		this.cyzkZagldwbm = cyzkZagldwbm;
	}

	public String getCyzkDwmc() {
		return cyzkDwmc;
	}

	public void setCyzkDwmc(String cyzkDwmc) {
		this.cyzkDwmc = cyzkDwmc;
	}

	public String getCyzkZy() {
		return cyzkZy;
	}

	public void setCyzkZy(String cyzkZy) {
		this.cyzkZy = cyzkZy;
	}

	public String getCyzkZylbdm() {
		return cyzkZylbdm;
	}

	public void setCyzkZylbdm(String cyzkZylbdm) {
		this.cyzkZylbdm = cyzkZylbdm;
	}

	public String getZjxydm() {
		return zjxydm;
	}

	public void setZjxydm(String zjxydm) {
		this.zjxydm = zjxydm;
	}

	public String getByzkdm() {
		return byzkdm;
	}

	public void setByzkdm(String byzkdm) {
		this.byzkdm = byzkdm;
	}

	public Double getSg() {
		return sg;
	}

	public void setSg(Double sg) {
		this.sg = sg;
	}

	public String getXxdm() {
		return xxdm;
	}

	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}

	public String getJhryGmsfhm() {
		return jhryGmsfhm;
	}

	public void setJhryGmsfhm(String jhryGmsfhm) {
		this.jhryGmsfhm = jhryGmsfhm;
	}

	public String getJhryXm() {
		return jhryXm;
	}

	public void setJhryXm(String jhryXm) {
		this.jhryXm = jhryXm;
	}

	public String getJhryCyzjdm() {
		return jhryCyzjdm;
	}

	public void setJhryCyzjdm(String jhryCyzjdm) {
		this.jhryCyzjdm = jhryCyzjdm;
	}

	public String getJhryZjhm() {
		return jhryZjhm;
	}

	public void setJhryZjhm(String jhryZjhm) {
		this.jhryZjhm = jhryZjhm;
	}

	public String getJhryWwx() {
		return jhryWwx;
	}

	public void setJhryWwx(String jhryWwx) {
		this.jhryWwx = jhryWwx;
	}

	public String getJhryWwm() {
		return jhryWwm;
	}

	public void setJhryWwm(String jhryWwm) {
		this.jhryWwm = jhryWwm;
	}

	public String getJhryJhgxdm() {
		return jhryJhgxdm;
	}

	public void setJhryJhgxdm(String jhryJhgxdm) {
		this.jhryJhgxdm = jhryJhgxdm;
	}

	public String getJhryLxdh() {
		return jhryLxdh;
	}

	public void setJhryLxdh(String jhryLxdh) {
		this.jhryLxdh = jhryLxdh;
	}

	public String getJhreGmsfhm() {
		return jhreGmsfhm;
	}

	public void setJhreGmsfhm(String jhreGmsfhm) {
		this.jhreGmsfhm = jhreGmsfhm;
	}

	public String getJhreXm() {
		return jhreXm;
	}

	public void setJhreXm(String jhreXm) {
		this.jhreXm = jhreXm;
	}

	public String getJhreCyzjdm() {
		return jhreCyzjdm;
	}

	public void setJhreCyzjdm(String jhreCyzjdm) {
		this.jhreCyzjdm = jhreCyzjdm;
	}

	public String getJhreZjhm() {
		return jhreZjhm;
	}

	public void setJhreZjhm(String jhreZjhm) {
		this.jhreZjhm = jhreZjhm;
	}

	public String getJhreWwx() {
		return jhreWwx;
	}

	public void setJhreWwx(String jhreWwx) {
		this.jhreWwx = jhreWwx;
	}

	public String getJhreWwm() {
		return jhreWwm;
	}

	public void setJhreWwm(String jhreWwm) {
		this.jhreWwm = jhreWwm;
	}

	public String getJhreJhgxdm() {
		return jhreJhgxdm;
	}

	public void setJhreJhgxdm(String jhreJhgxdm) {
		this.jhreJhgxdm = jhreJhgxdm;
	}

	public String getJhreLxdh() {
		return jhreLxdh;
	}

	public void setJhreLxdh(String jhreLxdh) {
		this.jhreLxdh = jhreLxdh;
	}

	public String getFqGmsfhm() {
		return fqGmsfhm;
	}

	public void setFqGmsfhm(String fqGmsfhm) {
		this.fqGmsfhm = fqGmsfhm;
	}

	public String getFqXm() {
		return fqXm;
	}

	public void setFqXm(String fqXm) {
		this.fqXm = fqXm;
	}

	public String getFqCyzjdm() {
		return fqCyzjdm;
	}

	public void setFqCyzjdm(String fqCyzjdm) {
		this.fqCyzjdm = fqCyzjdm;
	}

	public String getFqZjhm() {
		return fqZjhm;
	}

	public void setFqZjhm(String fqZjhm) {
		this.fqZjhm = fqZjhm;
	}

	public String getFqWwx() {
		return fqWwx;
	}

	public void setFqWwx(String fqWwx) {
		this.fqWwx = fqWwx;
	}

	public String getFqWwm() {
		return fqWwm;
	}

	public void setFqWwm(String fqWwm) {
		this.fqWwm = fqWwm;
	}

	public String getMqGmsfhm() {
		return mqGmsfhm;
	}

	public void setMqGmsfhm(String mqGmsfhm) {
		this.mqGmsfhm = mqGmsfhm;
	}

	public String getMqXm() {
		return mqXm;
	}

	public void setMqXm(String mqXm) {
		this.mqXm = mqXm;
	}

	public String getMqCyzjdm() {
		return mqCyzjdm;
	}

	public void setMqCyzjdm(String mqCyzjdm) {
		this.mqCyzjdm = mqCyzjdm;
	}

	public String getMqZjhm() {
		return mqZjhm;
	}

	public void setMqZjhm(String mqZjhm) {
		this.mqZjhm = mqZjhm;
	}

	public String getMqWwx() {
		return mqWwx;
	}

	public void setMqWwx(String mqWwx) {
		this.mqWwx = mqWwx;
	}

	public String getMqWwm() {
		return mqWwm;
	}

	public void setMqWwm(String mqWwm) {
		this.mqWwm = mqWwm;
	}

	public String getPoGmsfhm() {
		return poGmsfhm;
	}

	public void setPoGmsfhm(String poGmsfhm) {
		this.poGmsfhm = poGmsfhm;
	}

	public String getPoXm() {
		return poXm;
	}

	public void setPoXm(String poXm) {
		this.poXm = poXm;
	}

	public String getPoCyzjdm() {
		return poCyzjdm;
	}

	public void setPoCyzjdm(String poCyzjdm) {
		this.poCyzjdm = poCyzjdm;
	}

	public String getPoZjhm() {
		return poZjhm;
	}

	public void setPoZjhm(String poZjhm) {
		this.poZjhm = poZjhm;
	}

	public String getPoWwx() {
		return poWwx;
	}

	public void setPoWwx(String poWwx) {
		this.poWwx = poWwx;
	}

	public String getPoWwm() {
		return poWwm;
	}

	public void setPoWwm(String poWwm) {
		this.poWwm = poWwm;
	}

	public Timestamp getLbsqkQlrrq() {
		return lbsqkQlrrq;
	}

	public void setLbsqkQlrrq(Timestamp lbsqkQlrrq) {
		this.lbsqkQlrrq = lbsqkQlrrq;
	}

	public String getLbsqkQyldyydm() {
		return lbsqkQyldyydm;
	}

	public void setLbsqkQyldyydm(String lbsqkQyldyydm) {
		this.lbsqkQyldyydm = lbsqkQyldyydm;
	}

	public String getLbsqkLzdGjhdqdm() {
		return lbsqkLzdGjhdqdm;
	}

	public void setLbsqkLzdGjhdqdm(String lbsqkLzdGjhdqdm) {
		this.lbsqkLzdGjhdqdm = lbsqkLzdGjhdqdm;
	}

	public String getLbsqkLzdSsxqdm() {
		return lbsqkLzdSsxqdm;
	}

	public void setLbsqkLzdSsxqdm(String lbsqkLzdSsxqdm) {
		this.lbsqkLzdSsxqdm = lbsqkLzdSsxqdm;
	}

	public String getLbsqkLzdQhnxxdz() {
		return lbsqkLzdQhnxxdz;
	}

	public void setLbsqkLzdQhnxxdz(String lbsqkLzdQhnxxdz) {
		this.lbsqkLzdQhnxxdz = lbsqkLzdQhnxxdz;
	}

	public Timestamp getLkbsqkQlcrq() {
		return lkbsqkQlcrq;
	}

	public void setLkbsqkQlcrq(Timestamp lkbsqkQlcrq) {
		this.lkbsqkQlcrq = lkbsqkQlcrq;
	}

	public String getLkbsqkQyldyydm() {
		return lkbsqkQyldyydm;
	}

	public void setLkbsqkQyldyydm(String lkbsqkQyldyydm) {
		this.lkbsqkQyldyydm = lkbsqkQyldyydm;
	}

	public String getLkbsqkQwdGjhdqdm() {
		return lkbsqkQwdGjhdqdm;
	}

	public void setLkbsqkQwdGjhdqdm(String lkbsqkQwdGjhdqdm) {
		this.lkbsqkQwdGjhdqdm = lkbsqkQwdGjhdqdm;
	}

	public String getLkbsqkQwdSsxqdm() {
		return lkbsqkQwdSsxqdm;
	}

	public void setLkbsqkQwdSsxqdm(String lkbsqkQwdSsxqdm) {
		this.lkbsqkQwdSsxqdm = lkbsqkQwdSsxqdm;
	}

	public String getLkbsqkQwdQhnxxdz() {
		return lkbsqkQwdQhnxxdz;
	}

	public void setLkbsqkQwdQhnxxdz(String lkbsqkQwdQhnxxdz) {
		this.lkbsqkQwdQhnxxdz = lkbsqkQwdQhnxxdz;
	}

	public String getCyjmsfzqkQfjgGajgmc() {
		return cyjmsfzqkQfjgGajgmc;
	}

	public void setCyjmsfzqkQfjgGajgmc(String cyjmsfzqkQfjgGajgmc) {
		this.cyjmsfzqkQfjgGajgmc = cyjmsfzqkQfjgGajgmc;
	}

	public Timestamp getCyjmsfzqkYxqqsrq() {
		return cyjmsfzqkYxqqsrq;
	}

	public void setCyjmsfzqkYxqqsrq(Timestamp cyjmsfzqkYxqqsrq) {
		this.cyjmsfzqkYxqqsrq = cyjmsfzqkYxqqsrq;
	}

	public String getCyjmsfzqkYxqjzrq() {
		return cyjmsfzqkYxqjzrq;
	}

	public void setCyjmsfzqkYxqjzrq(String cyjmsfzqkYxqjzrq) {
		this.cyjmsfzqkYxqjzrq = cyjmsfzqkYxqjzrq;
	}

	public String getCyjmsfzqkDzmc() {
		return cyjmsfzqkDzmc;
	}

	public void setCyjmsfzqkDzmc(String cyjmsfzqkDzmc) {
		this.cyjmsfzqkDzmc = cyjmsfzqkDzmc;
	}

	public Timestamp getSwrq() {
		return swrq;
	}

	public void setSwrq(Timestamp swrq) {
		this.swrq = swrq;
	}

	public String getRkglswyydm() {
		return rkglswyydm;
	}

	public void setRkglswyydm(String rkglswyydm) {
		this.rkglswyydm = rkglswyydm;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getRkxxjbdm() {
		return rkxxjbdm;
	}

	public void setRkxxjbdm(String rkxxjbdm) {
		this.rkxxjbdm = rkxxjbdm;
	}

	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	public String getRkglzxlbdm() {
		return rkglzxlbdm;
	}

	public void setRkglzxlbdm(String rkglzxlbdm) {
		this.rkglzxlbdm = rkglzxlbdm;
	}

	public Timestamp getZxsj() {
		return zxsj;
	}

	public void setZxsj(Timestamp zxsj) {
		this.zxsj = zxsj;
	}

	public Timestamp getGxsj() {
		return gxsj;
	}

	public void setGxsj(Timestamp gxsj) {
		this.gxsj = gxsj;
	}

	public String getSjgsdwdm() {
		return sjgsdwdm;
	}

	public void setSjgsdwdm(String sjgsdwdm) {
		this.sjgsdwdm = sjgsdwdm;
	}

	public String getSjgsdwmc() {
		return sjgsdwmc;
	}

	public void setSjgsdwmc(String sjgsdwmc) {
		this.sjgsdwmc = sjgsdwmc;
	}

	public String getRkzt() {
		return rkzt;
	}

	public void setRkzt(String rkzt) {
		this.rkzt = rkzt;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getDsbz() {
		return dsbz;
	}

	public void setDsbz(String dsbz) {
		this.dsbz = dsbz;
	}

	public String getScol3() {
		return scol3;
	}

	public void setScol3(String scol3) {
		this.scol3 = scol3;
	}

	public void generateInsertSqlBatch(StringBuilder sb, TczrkJbxx pojo) {
		sb.append("(");
		/*sb.append("'"+pojo.getDsbm()+"', ");
		sb.append("'"+pojo.getNid()+"', ");
		sb.append("'"+pojo.getDsdm()+"', ");
		sb.append("'"+pojo.getRkbm()+"', ");
		sb.append("'"+pojo.getGmsfhm()+"', ");
		sb.append("'"+pojo.getXm()+"', ");
		sb.append("'"+pojo.getX()+"', ");
		sb.append("'"+pojo.getM()+"', ");
		sb.append("'"+pojo.getHh()+"', ");
		sb.append("'"+pojo.getYhzgxdm()+"', ");
		sb.append("'"+pojo.getCym()+"', ");
		sb.append("'"+pojo.getXbdm()+"', ");
		sb.append("'"+pojo.getMzdm()+"', ");
		sb.append("'"+pojo.getCsrq()+"', ");
		sb.append("'"+pojo.getCssj()+"', ");
		sb.append("'"+pojo.getCsdGjhdqdm()+"', ");
		sb.append("'"+pojo.getCsdSsxqdm()+"', ");
		sb.append("'"+pojo.getCsdQhnxxdz()+"', ");
		sb.append("'"+pojo.getJgGjhdqdm()+"', ");
		sb.append("'"+pojo.getJgSsxqdm()+"', ");
		sb.append("'"+pojo.getJgQhnxxdz()+"', ");
		sb.append("'"+pojo.getHjdzDzbm()+"', ");
		sb.append("'"+pojo.getHjdzSsxqdm()+"', ");
		sb.append("'"+pojo.getHjdzQhnxxdz()+"', ");
		sb.append("'"+pojo.getHjdzXzjddm()+"', ");
		sb.append("'"+pojo.getHjdzSqjcwhdm()+"', ");
		sb.append("'"+pojo.getHjdzCxfldm()+"', ");
		sb.append("'"+pojo.getHjdzRhyzbs()+"', ");
		sb.append("'"+pojo.getXldm()+"', ");
		sb.append("'"+pojo.getHyzkdm()+"', ");
		sb.append("'"+pojo.getCyzkZagldwbm()+"', ");
		sb.append("'"+pojo.getCyzkDwmc()+"', ");
		sb.append("'"+pojo.getCyzkZy()+"', ");
		sb.append("'"+pojo.getCyzkZylbdm()+"', ");
		sb.append("'"+pojo.getZjxydm()+"', ");
		sb.append("'"+pojo.getByzkdm()+"', ");
		sb.append("'"+pojo.getSg()+"', ");
		sb.append("'"+pojo.getXxdm()+"', ");
		sb.append("'"+pojo.getJhryGmsfhm()+"', ");
		sb.append("'"+pojo.getJhryXm()+"', ");
		sb.append("'"+pojo.getJhryCyzjdm()+"', ");
		sb.append("'"+pojo.getJhryZjhm()+"', ");
		sb.append("'"+pojo.getJhryWwx()+"', ");
		sb.append("'"+pojo.getJhryWwm()+"', ");
		sb.append("'"+pojo.getJhryJhgxdm()+"', ");
		sb.append("'"+pojo.getJhryLxdh()+"', ");
		sb.append("'"+pojo.getJhreGmsfhm()+"', ");
		sb.append("'"+pojo.getJhreXm()+"', ");
		sb.append("'"+pojo.getJhreCyzjdm()+"', ");
		sb.append("'"+pojo.getJhreZjhm()+"', ");
		sb.append("'"+pojo.getJhreWwx()+"', ");
		sb.append("'"+pojo.getJhreWwm()+"', ");
		sb.append("'"+pojo.getJhreJhgxdm()+"', ");
		sb.append("'"+pojo.getJhreLxdh()+"', ");
		sb.append("'"+pojo.getFqGmsfhm()+"', ");
		sb.append("'"+pojo.getFqXm()+"', ");
		sb.append("'"+pojo.getFqCyzjdm()+"', ");
		sb.append("'"+pojo.getFqZjhm()+"', ");
		sb.append("'"+pojo.getFqWwx()+"', ");
		sb.append("'"+pojo.getFqWwm()+"', ");
		sb.append("'"+pojo.getMqGmsfhm()+"', ");
		sb.append("'"+pojo.getMqXm()+"', ");
		sb.append("'"+pojo.getMqCyzjdm()+"', ");
		sb.append("'"+pojo.getMqZjhm()+"', ");
		sb.append("'"+pojo.getMqWwx()+"', ");
		sb.append("'"+pojo.getMqWwm()+"', ");
		sb.append("'"+pojo.getPoGmsfhm()+"', ");
		sb.append("'"+pojo.getPoXm()+"', ");
		sb.append("'"+pojo.getPoCyzjdm()+"', ");
		sb.append("'"+pojo.getPoZjhm()+"', ");
		sb.append("'"+pojo.getPoWwx()+"', ");
		sb.append("'"+pojo.getPoWwm()+"', ");
		sb.append("'"+pojo.getLbsqkQlrrq()+"', ");
		sb.append("'"+pojo.getLbsqkQyldyydm()+"', ");
		sb.append("'"+pojo.getLbsqkLzdGjhdqdm()+"', ");
		sb.append("'"+pojo.getLbsqkLzdSsxqdm()+"', ");
		sb.append("'"+pojo.getLbsqkLzdQhnxxdz()+"', ");
		sb.append("'"+pojo.getLkbsqkQlcrq()+"', ");
		sb.append("'"+pojo.getLkbsqkQyldyydm()+"', ");
		sb.append("'"+pojo.getLkbsqkQwdGjhdqdm()+"', ");
		sb.append("'"+pojo.getLkbsqkQwdSsxqdm()+"', ");
		sb.append("'"+pojo.getLkbsqkQwdQhnxxdz()+"', ");
		sb.append("'"+pojo.getCyjmsfzqkQfjgGajgmc()+"', ");
		sb.append("'"+pojo.getCyjmsfzqkYxqqsrq()+"', ");
		sb.append("'"+pojo.getCyjmsfzqkYxqjzrq()+"', ");
		sb.append("'"+pojo.getCyjmsfzqkDzmc()+"', ");
		sb.append("'"+pojo.getSwrq()+"', ");
		sb.append("'"+pojo.getRkglswyydm()+"', ");
		sb.append("'"+pojo.getLxdh()+"', ");
		sb.append("'"+pojo.getRkxxjbdm()+"', ");
		sb.append("'"+pojo.getXmpy()+"', ");
		sb.append("'"+pojo.getRkglzxlbdm()+"', ");
		sb.append("'"+pojo.getZxsj()+"', ");
		sb.append("'"+pojo.getGxsj()+"', ");
		sb.append("'"+pojo.getRkzt()+"', ");
		sb.append("'"+pojo.getPhotoId()+"', ");
		sb.append("'"+pojo.getDsbz()+"', ");
		sb.append("'"+pojo.getScol3()+"' ");
*/
		sb.append("), ");

	}

	public TczrkJbxMysql() {
		long currentTimeMillis = System.currentTimeMillis();
		this.dsbm ="dsbm";
		this.dsdm ="dsdm";
		this.rkbm ="asdf";
		this.gmsfhm ="asdfasdf";
		this.xm ="asdfasdf";
		this.x ="asdf";
		this.m ="asdf";
		this.hh =getCh_7000();
		this.yhzgxdm =getCh_7000();
		this.cym =getCh_7000();
		this.xbdm =getCh_7000();
		this.mzdm =getCh_7000();
		this.csrq =new Timestamp(currentTimeMillis);
		this.cssj =getCh_7000();
		this.csdGjhdqdm =getCh_7000();
		this.csdSsxqdm =getCh_7000();
		this.csdQhnxxdz =getCh_7000();
		this.jgGjhdqdm =getCh_7000();
		this.jgSsxqdm =getCh_7000();
		this.jgQhnxxdz =getCh_7000();
		this.hjdzDzbm ="123123";
		this.hjdzSsxqdm ="123456";
		this.hjdzQhnxxdz =getCh_7000();
		this.hjdzXzjddm ="123213";
		this.hjdzSqjcwhdm ="12312";
		this.hjdzCxfldm ="123";
		this.hjdzRhyzbs ="1";
		this.xldm ="11";
		this.hyzkdm ="11";
		this.cyzkZagldwbm ="1231231";
		this.cyzkDwmc =getCh_7000();
		this.cyzkZy ="csd_q";
		this.cyzkZylbdm ="12";
		this.zjxydm ="12";
		this.byzkdm ="1";
		this.sg =111.1;
		this.xxdm ="1";
		this.jhryGmsfhm ="jhryGmsfhm";
		this.jhryXm ="jhryXm";
		this.jhryCyzjdm ="123";
		this.jhryZjhm ="jhryZjhm";
		this.jhryWwx ="jhryWwx";
		this.jhryWwm ="jhryWwm";
		this.jhryJhgxdm ="12";
		this.jhryLxdh ="jhryLxdh";
		this.jhreGmsfhm ="jhreGmsfhm";
		this.jhreXm ="jhreXm";
		this.jhreCyzjdm ="123";
		this.jhreZjhm ="jhreZjhm";
		this.jhreWwx ="jhreWwx";
		this.jhreWwm ="jhreWwm";
		this.jhreJhgxdm ="12";
		this.jhreLxdh ="csd_q";
		this.fqGmsfhm ="fqGmsfhm";
		this.fqXm ="fqXm";
		this.fqCyzjdm ="123";
		this.fqZjhm ="fqZjhm";
		this.fqWwx ="fqWwx";
		this.fqWwm ="fqWwm";
		this.mqGmsfhm ="mqGmsfhm";
		this.mqXm ="mqXm";
		this.mqCyzjdm ="123";
		this.mqZjhm ="mqZjhm";
		this.mqWwx ="mqWwx";
		this.mqWwm ="mqWwm";
		this.poGmsfhm ="poGmsfhm";
		this.poXm ="poXm";
		this.poCyzjdm ="123";
		this.poZjhm ="poZjhm";
		this.poWwx ="poWwx";
		this.poWwm ="poWwm";
		this.lbsqkQlrrq =new Timestamp(System.currentTimeMillis());
		this.lbsqkQyldyydm ="123";
		this.lbsqkLzdGjhdqdm ="123";
		this.lbsqkLzdSsxqdm ="123221";
		this.lbsqkLzdQhnxxdz ="csd_q";
		this.lkbsqkQlcrq =new Timestamp(currentTimeMillis);
		this.lkbsqkQyldyydm ="1";
		this.lkbsqkQwdGjhdqdm ="12";
		this.lkbsqkQwdSsxqdm ="123";
		this.lkbsqkQwdQhnxxdz ="csd_q";
		this.cyjmsfzqkQfjgGajgmc ="123456";
		this.cyjmsfzqkYxqqsrq =new Timestamp(currentTimeMillis);
		this.cyjmsfzqkYxqjzrq ="12345678";
		this.cyjmsfzqkDzmc ="1234567";
		this.swrq =new Timestamp(currentTimeMillis);
		this.rkglswyydm ="123";
		this.lxdh ="lxdh";
		this.rkxxjbdm =getCh_7000();
		this.xmpy =getCh_7000();
		this.rkglzxlbdm =getCh_7000();
		this.zxsj =new Timestamp(currentTimeMillis);
		this.gxsj =new Timestamp(currentTimeMillis);
		this.sjgsdwdm =getCh_7000();
		this.sjgsdwmc =getCh_7000();
		this.rkzt =getCh_7000();
		this.photoId =getCh_7000();
		this.dsbz =getCh_7000();
		this.scol3 =getCh_7000();
	}

}